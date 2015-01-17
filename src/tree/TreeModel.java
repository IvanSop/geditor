package tree;






import javax.swing.tree.DefaultTreeModel;

public class TreeModel extends DefaultTreeModel {

	public TreeModel() {
		super(new Workspace());
		
		
	}

	public void addProject(Project project){
		((Workspace)getRoot()).addProject(project);
	}
	
	
}
