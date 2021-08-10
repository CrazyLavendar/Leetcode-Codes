class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        
        // Arrays.sort(boxTypes , ( a , b) -> a[1] < b[1]? (a[0] < b[0] ? -1 : 1 ): -1);
        
        Arrays.sort(boxTypes , ( int[] a , int[] b) -> {
            
            if(a[1] < b[1])
                return 1;
            else if(a[1] > b[1])
                return -1;
            else
                return 0;
            
        } );
        
// if (value < other.value)
//   return -1;
// else if (value >= other.value)
//   return 1;
// else
//   return 0;
        
        int currBox = 0 , units = 0;
        
        
        for(int[] box : boxTypes){
            
            int totalBoxes = box[0] , totalUnits = box[1];
            
            if(currBox +  totalBoxes <= truckSize){
                currBox += totalBoxes;
                units += totalBoxes * totalUnits;
                
            }else{
                
                int bal = truckSize - currBox;
                currBox += bal;
                units += bal * totalUnits;
            }
            
            // System.out.println(totalBoxes + "  " + totalUnits + " " + currBox + " " + units);
        }
        return units;
    }
}