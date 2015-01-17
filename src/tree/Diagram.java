package tree;

import java.io.Serializable;
import java.util.Enumeration;

import javax.swing.tree.TreeNode;

import models.DiagramModel;
import models.DiagramSelectionModel;







public class Diagram implements TreeNode,Serializable{
	private String name;
	private Project parent;
	private DiagramModel model=new DiagramModel();

	private DiagramSelectionModel selectionModel;

	public Diagram(String diagramName) {
		name=diagramName;
		
	}
	

	
	
	public DiagramModel getModel() {
		return model;
	}




	public void setModel(DiagramModel model) {
		this.model = model;
	}




	public void setParent(Project parent) {
		this.parent = parent;
	}

	public String toString(){
		return name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DiagramSelectionModel getSelectionModel() {
		if(selectionModel == null)
			selectionModel = new DiagramSelectionModel();
		return selectionModel;
	}

		
	
	public TreeNode getChildAt(int arg0) {
		return null;
	}

	public int getChildCount() {
		return 0;
	}

	public TreeNode getParent() {
		return parent;
	}

	public int getIndex(TreeNode arg0) {
		return -1;
	}

	public boolean getAllowsChildren() {
		return false;
	}

	public boolean isLeaf() {
		return true;
	}

	public Enumeration children() {
		return null;
	}

 

}
