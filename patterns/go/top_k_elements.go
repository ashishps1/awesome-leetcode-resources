package main

import (
	"container/heap"
	"sort"
)

// ********** K Largest Elements **********
// K Largest Elements using Sorting
func kLargestElementsSortingApproach(nums []int, k int) []int {
	sort.Sort(sort.Reverse(sort.IntSlice(nums)))
	return nums[:k]
}

// K Largest Elements using Max Heap
func kLargestElementsMaxHeapApproach(nums []int, k int) []int {
	h := &MaxHeap{}
	heap.Init(h)
	for _, num := range nums {
		heap.Push(h, num)
	}
	result := make([]int, k)
	for i := 0; i < k; i++ {
		result[i] = heap.Pop(h).(int)
	}
	return result
}

// K Largest Elements using Min Heap
func kLargestElementsMinHeapApproach(nums []int, k int) []int {
	h := &MinHeap{}
	heap.Init(h)
	for i := 0; i < k; i++ {
		heap.Push(h, nums[i])
	}
	for i := k; i < len(nums); i++ {
		heap.Push(h, nums[i])
		if h.Len() > k {
			heap.Pop(h)
		}
	}
	result := make([]int, k)
	for i := 0; i < k; i++ {
		result[i] = heap.Pop(h).(int)
	}
	return result
}

// ********** Helper Structures **********

type MaxHeap []int
type MinHeap []int

func (h MaxHeap) Len() int            { return len(h) }
func (h MaxHeap) Less(i, j int) bool  { return h[i] > h[j] } // Max heap
func (h MaxHeap) Swap(i, j int)       { h[i], h[j] = h[j], h[i] }
func (h *MaxHeap) Push(x interface{}) { *h = append(*h, x.(int)) }
func (h *MaxHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

func (h MinHeap) Len() int            { return len(h) }
func (h MinHeap) Less(i, j int) bool  { return h[i] < h[j] } // Min heap
func (h MinHeap) Swap(i, j int)       { h[i], h[j] = h[j], h[i] }
func (h *MinHeap) Push(x interface{}) { *h = append(*h, x.(int)) }
func (h *MinHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

// ********** Main **********

func main() {
	// Example test cases
	nums := []int{3, 2, 1, 5, 6, 4}
	k := 2

	// Sorting Approach
	result := kLargestElementsSortingApproach(nums, k)
	fmt.Println("K Largest Elements (Sorting Approach):", result)

	// Max Heap Approach
	result = kLargestElementsMaxHeapApproach(nums, k)
	fmt.Println("K Largest Elements (Max Heap Approach):", result)

	// Min Heap Approach
	result = kLargestElementsMinHeapApproach(nums, k)
	fmt.Println("K Largest Elements (Min Heap Approach):", result)
}