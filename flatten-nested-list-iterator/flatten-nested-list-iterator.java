/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
// public class NestedIterator implements Iterator<Integer> {

//     public Queue<Integer>  q = new LinkedList();
//     public NestedIterator(List<NestedInteger> nestedList) {
       
//         helper(nestedList);
//     }

//     public void helper(List<NestedInteger> nestedList){
//         if(nestedList == null)
//             return;
        
//         for(NestedInteger in : nestedList){
//         if(in.isInteger()){
//             q.add(in.getInteger());
//         }else{
//             helper(in.getList());
//         }
//         }
//     }
    
//     @Override
//     public Integer next(List<NestedInteger> nestedList) {
//         if (hasNext()){
//             return q.poll();
//         }
//         else
//             return -1;
//     }

//     @Override
//     public boolean hasNext() {
//         if (!queue.isEmpty())
//             return true;
//         else
//             return false;

//     }
// }


public class NestedIterator implements Iterator<Integer> {
    Deque<NestedInteger> s;

    public NestedIterator(List<NestedInteger> nestedList) {
        s = new ArrayDeque<>(nestedList == null ? Arrays.asList() : nestedList);
    }
    
    @Override
    public Integer next() {
        return s.pollFirst().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!s.isEmpty() && !s.peekFirst().isInteger()) {
            List<NestedInteger> list = s.pollFirst().getList();
            for (int i=list.size()-1; i>=0; i--) s.addFirst(list.get(i));
        }
        return !s.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */