class Solution {
    public int[] constructArray(int n, int k) {
        
        int i = 1 , j = n;
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        boolean toggle = true;
        while(k--  > 0){
            if(toggle){
           list.add(i++);
                toggle = false;
            }
            else{
                list.add(j--);
                toggle  = true;
            }
        }
        
        while(i <= j)
            if(toggle)
            list.add(j--);
        else
            list.add(i++);

        int[] res = new int[n];
        for(int x =0 ; x < n; x++){
            res[x] = list.get(x);
        }
           
        return res;
    }
}