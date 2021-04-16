class Solution {
    public int[] countBits(int num) {
        
        if(num == 0) return new int[]{0};
        if(num == 1) return new int[]{0 , 1};
        
        int[] res = new int[num + 1];
        res[0] = 0;
        res[1] = 1;
        int j =0;
        for(int i = 2 ; i<= num ;i++){
            if((i & i-1) == 0) // checks perfect square
                j = i;
           res[i] =  res[i-j] + 1;
        }
        return res;
    }
}