class Solution {
    public int distributeCandies(int[] candyType) {
        
        int n = candyType.length/2;
        
        Set<Integer> set = new HashSet<>();
        
        for(int x : candyType ){
            
            set.add(x);
            if(set.size() == n)
            break;
        }
        
        // System.out.println(set); System.out.println(n);
        
        return set.size();
        
    }
}