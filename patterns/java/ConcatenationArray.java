//1929. Concatenation of Array
class Solution {
    public int[] getConcatenation(int[] nums) {
        int b = nums.length;  
        int [] numeros = new int[b*2];
        int j = 0;
        for(int i = 0; i< b *2; i++){
            
            if(i<b){
            numeros[i] = nums[j];
            j++;
            continue;
            }
            if(j == b){
                j = 0;
            }
                numeros[i] = nums[j];
                j++;
                continue;
            
            
    }
    return numeros;
}
}
