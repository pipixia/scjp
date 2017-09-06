package scjp.designpattern.composite;

public class TreeNodeDemo {
	public static void main(String[] args){
		TreeNode root = new TreeNode("Root");
		TreeNode n1 = new TreeNode("1");
		TreeNode n2 = new TreeNode("2");
		
		TreeNode n1a = new TreeNode("a");
		TreeNode n1b = new TreeNode("b");
		
		n1.addNode(n1a);
		n1.addNode(n1b);
		
		root.addNode(n1);
		root.addNode(n2);
		
		root.list();
		
		System.out.println();
		
		n1.list();
		System.out.println();
	}
}
