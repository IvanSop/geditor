package tree;





import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.tree.TreeNode;


public class Workspace  implements TreeNode{

	//kolekcija projekata
	private ArrayList<Project> projects = new ArrayList<Project>();
	private int maxLen = 1;
	
	
	
	
	public int getMaxLen() {
		return maxLen;
	}

	public void setMaxLen(int maxLen) {
		this.maxLen = maxLen;
	}

	public ArrayList<Project> getProjects() {
		return projects;
	}

	public Workspace() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String toString(){
		return "Workspace";
	}
	
	
	public TreeNode getChildAt(int arg0) {
		return getProject(arg0);
		
	}

	public int getChildCount() {
		return getProjectsCount();
	}

	public TreeNode getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getIndex(TreeNode arg0) {
		return getProjectIndex((Project) arg0);
	}

	public boolean getAllowsChildren() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return false;
	}

	public Enumeration<Diagram> children() {
		// TODO Auto-generated method stub
		return (Enumeration<Diagram>) projects;
	}

	public void addProject(Project project){
		projects.add(project);
		project.setName("Project "+ maxLen);
	}
	
	public Project getProject(int index) {
		return projects.get(index);
	}	
	
	public int getProjectIndex(Project project) {
		return projects.indexOf(project);
	}
	public int getProjectsCount() {
		return projects.size();
	}
	
	public void removeProject(int i) {
		projects.remove(i);
	}
	
}