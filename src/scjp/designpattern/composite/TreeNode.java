package scjp.designpattern.composite;

import java.util.ArrayList;
import java.util.List;

/*
 * Tree Structure
 */

public class TreeNode {
	private String name;
	
	private List<TreeNode> subNodes = new ArrayList<TreeNode>();

	public TreeNode(String name) {
		this.name = name;
	}
	
	public void addNode(TreeNode n){
		subNodes.add(n);
	}
	
	public void removeNode(TreeNode n){
		subNodes.remove(n);
	}

	public void list() {
		System.out.println("list node - " + name);
		for(int i=0;i<subNodes.size();i++){
			TreeNode node = subNodes.get(i);
			node.list();
		}
	}
}

