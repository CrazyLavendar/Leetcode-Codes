class Freq{
    String s;
    int count;
    public Freq(String s , int count){
        this.s = s;
        this.count = count;
    }
    
}


class Solution {    
    public List<String> topKFrequent(String[] words, int k) {
        
        
        Map<String , Integer> map = new HashMap<>();
        
        for(String x : words){
         if(!map.containsKey(x))
            map.put(x,0);
        map.put(x , (map.get(x) + 1));
        }
        
        
        List<Freq> list = new ArrayList<>();
        for(String key : map.keySet()){
            list.add(new Freq(key , map.get(key)));
        }
        
        Collections.sort(list , (a,b)-> a.count==b.count? alphabetical(a,b)  : b.count - a.count );
        
        List<String> res = new ArrayList<>();
        for(int i =0 ; i <k ; i++)
            res.add(list.get(i).s);
        
        // Collections.sort(res);
        
        return res;
        
    }
    
    public int alphabetical(Freq A , Freq B){
        
        String a = A.s , b = B.s;
        int lena = a.length() , lenb = b.length(); 
        int i =0;
        
        while(i < lena && i< lenb){
            
            if((int)a.charAt(i) > (int)b.charAt(i))
                return 1;
            else if((int)a.charAt(i) < (int)b.charAt(i))
                return -1;
            else
                i++;
        }
        
        return lena > lenb ? 1 : -1;        
        
    }
}