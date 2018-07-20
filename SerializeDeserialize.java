/*
 * This problem was asked by Google.

Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, 

and deserialize(s), which deserializes the string back into the tree.

For example, given the following Node class

class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
The following test should pass:

node = Node('root', Node('left', Node('left.left')), Node('right'))
assert deserialize(serialize(node)).left.left.val == 'left.left'
 */

public class SerializeDeserialize {

	public static void main(String[] args) {
		Node root = new Node("A");
		root.left = new Node("B");
		root.right = new Node("C");
		root.left.right = new Node("D");
		root.right.right = new Node("E");
		System.out.println(serialize(root));
		System.out.println(serialize(deserialize(serialize(root))));
	}

	
	public static class Node{
		Node left,right;
		String val;
		
		public Node(String val){
			this.val = val;
			left = null;
			right = null;
		}
	}
	
	
	
	public static String serialize(Node root){
		StringBuilder s=new StringBuilder();
		return serializeRec(root, s);
		
	}
	
	
	public static String serializeRec(Node node,StringBuilder s){
		s.append(node.val);
		if(!(node.left==null)){
			serializeRec(node.left,s);
		}else{
			s.append(" ");
		}
		if(!(node.right==null)){
			serializeRec(node.right,s);
		}else{
			s.append(" ");
		}
		return s.toString();
	}
	
	
	
	public static Node deserialize(String s){
		if(s.length() == 0) return null;
		String[] arr = s.split("");
		int arrIndex[] = {0};
		
		return deserializeRec(arr,arrIndex);
	}
	
	public static Node deserializeRec(String[] arr,int[] arrIndex){
		if(arr[arrIndex[0]].equals(" ")) return null;
		
		Node node = new Node(arr[arrIndex[0]]);
		
		arrIndex[0] = arrIndex[0]+1;
		node.left = deserializeRec(arr,arrIndex);
		arrIndex[0] = arrIndex[0]+1;
		node.right = deserializeRec(arr,arrIndex);
		
		return node;
		
	}
}
