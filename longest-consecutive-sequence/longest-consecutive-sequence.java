class Node{
    int left , right;
    Node(int left , int right){
        this.left = left;
        this.right = right;
    }
    
}

class Solution {
    public int longestConsecutive(int[] nums) {
        
        // HashMap<Integer , Integer> map = new HashMap<>();
        // int res = 0;
        // for(int x : nums){
        //     if(!map.containsKey(x)){
        //         int sum = 1;
        //         int left = map.containsKey(x-1)? map.get(x-1) : 0;
        //         int right = map.containsKey(x+1)? map.get(x+1) : 0;
        //         sum += left + right;
        //         map.put(x ,sum);
        //         map.put(x - left , sum);
        //         map.put(x + right , sum);
        //         res = Math.max(res , sum);
        //     }
        // }
        // return res;
        
        
        HashMap<Integer , Node> map = new HashMap<>();
        
        for(Integer x : nums){
            if(map.containsKey(x))
                continue;
            else{
                
                if(map.containsKey(x-1) && map.containsKey(x+1)){
                    // System.out.println(x);
                    Node leftMost = map.get(map.get(x-1).left) , rightMost = map.get(map.get(x+1).right);
                    leftMost.right = rightMost.right;
                    rightMost.left = leftMost.left;
                    map.put(x , new Node(leftMost.left , rightMost.right));
                    
                }
                else if(map.containsKey(x-1)){
                    Node leftVal = map.get(map.get(x-1).left);
                    leftVal.right = x;
                    map.put(x , new Node(leftVal.left , x));
                }
                else if(map.containsKey(x+1)){
                    Node rightVal = map.get(map.get(x+1).right);
                    rightVal.left = x;
                    map.put(x , new Node(x , rightVal.right));
                }
                else {
                    map.put(x , new Node(x,x));
                }
            }
            
            
//             for(Map.Entry<Integer , Node> entry : map.entrySet()){
//             System.out.println(entry.getKey() +" " +entry.getValue().left + " " +entry.getValue().right );
//             }
            
//             System.out.println("______");
        }
        
        // System.out.println(map);
        int res =0 ;
        for(Map.Entry<Integer , Node> entry : map.entrySet()){
            // System.out.println(entry.getKey() +" " +entry.getValue().left + " " +entry.getValue().right );
            res = Math.max(res ,1 +entry.getValue().right - entry.getValue().left );
        }
        
        
        return res;
    }
}