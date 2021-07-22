class Solution {
    int n , ans;
    public int countArrangement(int n) {
        this.n = n;
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res , new ArrayList<>());
        return res.size();
    }
    public void backtrack(List<List<Integer>> res , List<Integer> curr    ){
        if(curr.size() ==n){
            res.add(new ArrayList<>(curr));
        }
        for(int i =1; i <= n ; i++){
            if(!curr.contains(i) && ((curr.size()+1) % i == 0 || (i % (curr.size()+1)) == 0)){
                curr.add(i);
            }
            else
                continue;
            backtrack(res , curr);
            curr.remove(curr.size() -1);
        }
    }
    

    
}