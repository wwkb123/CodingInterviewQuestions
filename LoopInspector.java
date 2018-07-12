/*
You are given a node that is the beginning of a linked list. This list always contains a tail and a loop.

Your objective is to determine the length of the loop.

Use the `getNext()` method to get the following node.

node.getNext()

*/



import java.util.HashMap;
public class LoopInspector {

  public int loopSize(Node node) {
    int position = 0;
    HashMap<Node,Integer> map = new HashMap<Node,Integer>();
    while(node!=null){
      if(map.containsKey(node)) return position-map.get(node);
      
      map.put(node,position);
      position++;
      
      node = node.getNext();
    }
    
    return 1;
  
  }

}