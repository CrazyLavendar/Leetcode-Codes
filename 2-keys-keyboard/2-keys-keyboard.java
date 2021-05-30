class Solution {
    public int minSteps(int n) {
        
        if(n==1)
            return 0;
        
        List<Integer> list = new ArrayList<>();
         while(n%2 ==0){
             list.add(2);
             n /= 2;
         }
        
        for(int i =3 ; i<= n; i++){
            
              // System.out.println("hi");
            while(n%i == 0){
              
                list.add(i);
                n /= i;
            }
        }
        int res = 0;
        for(int x  : list)
            res += x;
        
        // System.out.println(list);
        return res;
    }
}