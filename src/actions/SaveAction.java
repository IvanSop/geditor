package actions;

import gui.Frame;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.KeyStroke;

import models.DiagramFileFilter;
import tree.Diagram;
import tree.Project;

public class SaveAction extends AbstractAction {

	public SaveAction() {
        ClassLoader cl = this.getClass().getClassLoader();
		
		
		putValue(NAME, "Save Project");
		putValue(SMALL_ICON, new ImageIcon(cl.getResource("saveProj.png")));
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl shift S"));
        putValue(ACTION_COMMAND_KEY, "Save Project");
        putValue(SHORT_DESCRIPTION, "Save project");
        setEnabled(false);
		
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("Action [" + e.getActionCommand() + "] performed!");
        
        JFileChooser jfc = new JFileChooser();
		jfc.setFileFilter(new DiagramFileFilter());
		
		//Project project=Frame.getInstance().getTree().getCurrentProject();
		Project project = null;
		if (Frame.getInstance().getTree().getLastSelectedPathComponent() instanceof Diagram) {
			System.out.println("sssss "+ (Project)Frame.getInstance().getTree().getSelectionPath().getParentPath().getPathComponent(1));
			project = (Project)Frame.getInstance().getTree().getSelectionPath().getParentPath().getPathComponent(1);
		}
		
		if (Frame.getInstance().getTree().getLastSelectedPathComponent() instanceof Project) {
			project = (Project)Frame.getInstance().getTree().getLastSelectedPathComponent();
		}
		// -- 
	/*	for (int i = 0; i<project.getDiagramCount();i++) {
			
			for (int j = 0; j<Frame.getInstance().getInternalframes().size();j++) { // j kroz sve frameove u desku tj u private fieldu
				if ((Frame.getInstance().getInternalframes().get(j).getName()).equals(project.getDiagrams().get(i).toString())) {
					System.out.println("smack that: " + Frame.getInstance().getInternalframes().get(j).getName());
					Frame.getInstance().getInternalframes().get(j).getTransformation().setToIdentity();
				}
			}
		}
	*/	
		// --
		File projectFile=project.getProjectFile();
        
		if (!project.isChanged()){
			System.out.println("ksssssss");
			return;
		}
		
		if (project.getProjectFile()==null){
	         if(jfc.showSaveDialog(Frame.getInstance())==JFileChooser.APPROVE_OPTION){
	                   projectFile=jfc.getSelectedFile();           	 
	        	 
	         }else{
	        	return; 
	         }
	         
		} 
		
		ObjectOutputStream os;
		try {
			os = new ObjectOutputStream(new FileOutputStream(projectFile));
			os.writeObject(project);
			project.setProjectFile(projectFile);
			project.setChanged(false);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		
        
    }
}
