class Solution {
    public boolean isPalindrome(String s) {
        
        int left = 0, right = s.length()-1;
        s = s.toLowerCase();
        
        while(left < right){
            
            int leftVal = isNumber(s.charAt(left))? s.charAt(left) - '0' : isAlphabet(s.charAt(left)) ? s.charAt(left) - 'a' + 10 : -1; 
            int rightVal = isNumber(s.charAt(right))? s.charAt(right) - '0' : isAlphabet(s.charAt(right)) ? s.charAt(right) - 'a' + 10 : -1; 
            
            // System.out.println(leftVal + " " + rightVal);

           if(leftVal == rightVal){
                left++;
                right--;
            }
            else if(leftVal < 0 || leftVal > 35)
                left++;
            else if(rightVal < 0 || rightVal >35)
                right--;
            else
                return false;
        }
        
        return true;
        
    }
    
    
    public boolean isNumber(char c){
        return c-'0' <=9 && c-'0' >=0 ? true : false;
    }
    public boolean isAlphabet(char c){
        return c-'a' <=25 && c-'a' >=0 ? true : false;
    }

    
}