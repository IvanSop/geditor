package tree;


import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.TreePath;

public class Tree extends JTree  {

	public Tree() {
		setRootVisible(false);
		addTreeSelectionListener(new TreeController());
	    addMouseListener(new TreeController());
		setCellRenderer(new TreeCellRender());
	    
	}

	

	public void addProject(Project project){
		((TreeModel)getModel()).addProject(project);
		SwingUtilities.updateComponentTreeUI(this);
	}


	public Project getCurrentProject() {
		TreePath path = getSelectionPath();
		for(int i=0; i<path.getPathCount(); i++){
			if(path.getPathComponent(i) instanceof Project){
				return (Project)path.getPathComponent(i);
			}
		}
		return null;
	}


	
}
