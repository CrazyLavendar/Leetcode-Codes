class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
       
        int l = nums.length, b = maximumBit;
        int[][] binary = new int[l][b];
        
        for(int i =0 ; i< l ; i++){
            binary[i] =  binaryy(nums[i] , b);
        
        }
        
         int[] totalBit = new int[b];
        for(int i =0 ; i< b ; i++){
            for(int j =0 ; j<l ; j++){
                totalBit[i] += binary[j][i];
            }
        }
        
        // for(int i =0 ; i<b ; i++)
        //     System.out.print(totalBit[i] + " "); 
        int[] res = new int[l];
        
        for(int i =0 ; i < l; i++){
            res[i] = generate(totalBit , b); 
            for(int j =0 ; j<b ; j++){
                totalBit[j] -= binary[l-1-i][j];
            }
        }
        
        
        return res;
        
    }
    
    public int[] binaryy (int num , int b){
        int[] bin= new int[b];
        
        int i = 0;
        
        while (num > 0){
            bin[i++] = num % 2;
            num /=2;
        }
        return bin;
    }
    
    public int generate(int[] total , int b){
        int[] ans = new int[b];
        for(int i =0 ; i<b;i++){
            if(total[i] % 2 == 1)
                ans[i] = 0;
            else
                ans[i] = 1;
        }
        
        int num = 0;
        for(int i=0 ; i<b; i++){
            if(ans[i] == 1){
            int temp = (int)Math.pow(2, i);
            // System.out.println( " Temp " + temp);
            num += temp;
            }
            
        }
        
        return num;
    }
}