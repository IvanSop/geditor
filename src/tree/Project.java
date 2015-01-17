package tree;





import event.UpdateEvent;
import event.UpdateListener;
import gui.Frame;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.SwingUtilities;
import javax.swing.tree.TreeNode;


public class Project implements TreeNode,Serializable,UpdateListener{

	//kolekcija dijagrama u okviru jednog projekta
	private ArrayList<Diagram> diagrams = new ArrayList<Diagram>();
	private String name;
	
	private int maxLen = 1;
	
	private transient boolean changed; 
	private File projectFile;
	
	
	
	public Project(String projectName) {
		this.name=projectName;
		this.changed=false;
		this.projectFile=null;
	}
	
	

	public int getMaxLen() {
		return maxLen;
	}



	public void setMaxLen(int maxLen) {
		this.maxLen = maxLen;
	}



	public ArrayList<Diagram> getDiagrams() {
		return diagrams;
	}



	public void addDiagram(Diagram diagram){
		diagram.getModel().addUpdateListener(this); // jebo sebe sliku svoju
		diagrams.add(diagram);
		diagram.setName( this.name+" - Diagram - "+String.valueOf(maxLen));
		diagram.setParent(this);
		
	}	


	public void setProjectFile(File projectFile) {
		this.projectFile = projectFile;
	}



	public File getProjectFile() {
		return projectFile;
	}



	public boolean isChanged() {
		
		return changed;
		
	}
	public void updatePerformed(UpdateEvent e) {
		System.out.println("mrnjauuuu");
		setChanged(true);
		
	}

	public void setChanged(boolean changed) {
		//System.out.println("mrnjauuuu");
		if (this.changed!=changed){
			
		     this.changed=changed;
		     SwingUtilities.updateComponentTreeUI(Frame.getInstance().getTree());
		}
	}
	

	
	
	public String toString(){
		return ((changed?"* ":"")+ name);
	}
	
	public Diagram getDiagram(int index) {
		return diagrams.get(index);
	}
	
	public int getDiagramIndex(Diagram diagram) {
		return diagrams.indexOf(diagram);
	}
	
	public int getDiagramCount() {
		return diagrams.size();
	}	
	
	public boolean isLeaf() {
		return false;
	}	
	
	public void setName(String name){
		this.name=name;
	}


	public String getName() {
		return name;
	}



	public TreeNode getChildAt(int arg0) {
		return getDiagram(arg0);
	}


	public int getChildCount() {
		return getDiagramCount();
	}


	public TreeNode getParent() {
		// TODO Auto-generated method stub
		return null;
	}


	public int getIndex(TreeNode arg0) {
		return getDiagramIndex((Diagram)arg0);
	}


	public boolean getAllowsChildren() {
		// TODO Auto-generated method stub
		return false;
	}


	public Enumeration children() {
		// TODO Auto-generated method stub
		return (Enumeration) diagrams;
	}
}
