class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> s = new Stack<>();
        for(String token : tokens){
            
            if(!isOperator(token)){
                s.push(toInt(token));
                continue;
            }
            if(s.size() > 1){
                int b = s.pop() , a = s.pop();
                s.push(operation( a, b , token));
                
            }
        }
        return s.peek();
    }
    
    
    public boolean isOperator(String s){
        
        if(s.equals("+") || s.equals("*") ||s.equals("-") ||s.equals("/"))
            return true;
        return false;
    }
    
    public int toInt(String s){
        return Integer.parseInt(s);
    }
    
    public int operation(int a , int b , String s){
        
        if(s.equals("+"))
            return a+b;
        if(s.equals("-"))
            return a-b;
        if(s.equals("*"))
            return a*b;
        if(s.equals("/"))
            return a/b;
        
        return -1;
    }
}