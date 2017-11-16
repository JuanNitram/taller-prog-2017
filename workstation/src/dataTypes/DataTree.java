package dataTypes;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

public class DataTree {
	private DefaultMutableTreeNode tree = new DefaultMutableTreeNode();
	
	public DataTree(){}
	
	public DefaultMutableTreeNode getTree(){
		return tree;
	}
	
	public void setTree(DefaultMutableTreeNode tree){
		this.tree = tree;
	}
}
