package actions;

import gui.Frame;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import javax.swing.tree.TreePath;

import tree.Diagram;
import tree.Project;
import tree.Workspace;

public class NewProjAction extends AbstractAction {

	public NewProjAction() {
        ClassLoader cl = this.getClass().getClassLoader();
		
		
		putValue(NAME, "New Project");
		putValue(SMALL_ICON, new ImageIcon(cl.getResource("newProj.png")));
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl shift P"));
        putValue(ACTION_COMMAND_KEY, "New Project");
        putValue(SHORT_DESCRIPTION, "Create new project");
		
    }

    public void actionPerformed(ActionEvent e) {
       // System.out.println("Action [" + e.getActionCommand() + "] performed!");
        
        
        Project p = new Project(" ");
        Frame.getInstance().getTree().addProject(p);
        ((Workspace)Frame.getInstance().getWorkspaceModel().getRoot()).setMaxLen(((Workspace)Frame.getInstance().getWorkspaceModel().getRoot()).getMaxLen()+1);      
         
        
    }
}