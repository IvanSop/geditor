package actions;

import gui.Frame;
import gui.InternalFrame;

import java.awt.event.ActionEvent;
import java.beans.PropertyVetoException;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.tree.TreePath;

import tree.Diagram;
import tree.Project;
import tree.Workspace;

public class DeleteAction extends AbstractAction {
	public DeleteAction() {
        ClassLoader cl = this.getClass().getClassLoader();
		
		
		putValue(NAME, "Delete");
		putValue(SMALL_ICON, new ImageIcon(cl.getResource("delete.png")));
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl R"));
        putValue(ACTION_COMMAND_KEY, "Delete");
        putValue(SHORT_DESCRIPTION, "Delete");
		setEnabled(false);
    }

	protected void deleteSingleDiagram(Project p) {
	       int x=-1;
	        ArrayList<Project> projekti = ((Workspace)(Frame.getInstance().getWorkspaceModel().getRoot())).getProjects();
	        //Project currSelP =(Project)Frame.getInstance().getTree().getSelectionPath().getParentPath().getLastPathComponent();
	        Project currSelP = p;
	        Diagram currSelD = (Diagram)Frame.getInstance().getTree().getLastSelectedPathComponent();
	        
	        // nadjem koji je u nizu svih projekata
	        for (int i = 0;i < projekti.size();i++)
	        	if (projekti.get(i).toString().equals(currSelP.toString()))
	        		x = i;
	   
	        
	        for (int i = 0; i < currSelP.getDiagramCount(); i++) {	// prolazim kroz sve diagrame u tekucem projektu
	        	if (currSelD.toString().equals(currSelP.getDiagram(i).toString())) {
	        		
	        		for (int j = 0; j<Frame.getInstance().getInternalframes().size();j++) { // j kroz sve frameove u desku tj u private fieldu
	        			if ((Frame.getInstance().getInternalframes().get(j).getName()).equals(projekti.get(x).getDiagrams().get(i).toString())) {
	        				//System.out.println(j);
	        				Frame.getInstance().getTree().setSelectionPath(null); 
	        				ActionManager.getAction().getNewDiaAction().setEnabled(false);
	        				ActionManager.getAction().getDeleteAction().setEnabled(false);
	        				ActionManager.getAction().getSaveAction().setEnabled(false); //
	        				try {
								Frame.getInstance().getInternalframes().get(j).setClosed(true);
							} catch (PropertyVetoException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	        					
	        				Frame.getInstance().getInternalframes().remove(j);
	        					
	        					
	        			    InternalFrame.setOpenFrameCount((InternalFrame.getOpenFrameCount())-1);
	        			    
	        			}
	        		}
	        		
	        		
	        		
	        		
	        		projekti.get(x).getDiagrams().remove(i); // uso gde treba, sad jos treba i iframe ugasiti => premesteno gore gasnje framea
	        		
	        	
	        		
	        	}
	        }
	}
	
    public void actionPerformed(ActionEvent e) {
      
        
    	// 	AKO JE SELEKTOVANA STAVKA U STABLU DIAGRAM
        if (Frame.getInstance().getTree().getLastSelectedPathComponent() instanceof Diagram) {
	 
	     deleteSingleDiagram((Project)Frame.getInstance().getTree().getSelectionPath().getParentPath().getLastPathComponent());
	                
    		SwingUtilities.updateComponentTreeUI(Frame.getInstance().getTree());
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        // AKO JE SELEKTOVANA STAVKA U STABLU PROJEKAT
        if (Frame.getInstance().getTree().getLastSelectedPathComponent() instanceof Project) {
        	
        	ArrayList<Project> projekti = ((Workspace)(Frame.getInstance().getWorkspaceModel().getRoot())).getProjects();
        	Project currSelP = (Project)Frame.getInstance().getTree().getLastSelectedPathComponent(); // selektovani projekat
        	int x = -1;
        	for (int i = 0; i < projekti.size(); i++)
        	if (currSelP.toString().equals((projekti.get(i)).toString()))
        			x = i; 
        	ArrayList<Diagram> diagramiUTomProj = projekti.get(x).getDiagrams();
        	int n = diagramiUTomProj.size();
        	
        	// trebaju mi putanje svih diagrama
        	Object put[] = new Object[3];
        	put[0] = Frame.getInstance().getWorkspaceModel().getRoot(); // workspace
        	put[1] = currSelP;	// projekat
        
        	
        	// ovaj for brise jedan po jedan diagram iz projekta
        	for (int i=0;i<n;i++) {
        		        		        		
        		put[2] = diagramiUTomProj.get(0); // pa to su plakanja, ne ide i, posto ih brisem i onda ....
        	
        
        		TreePath putBeznadnja = new TreePath(put);
        		Frame.getInstance().getTree().setSelectionPath(putBeznadnja);
        		
        		
        		deleteSingleDiagram((Project)put[1]);
        		      		
        		
        		
        		
        	}
        	
        	// sad samo taj projekat samog za sebe izbaciti iz treea
        	//((Workspace)Frame.getInstance().getWorkspaceModel().getRoot()).setMaxLen(((Workspace)Frame.getInstance().getWorkspaceModel().getRoot()).getMaxLen()-1);
        	((Workspace)Frame.getInstance().getWorkspaceModel().getRoot()).removeProject(x);
        	Frame.getInstance().getTree().setSelectionPath(null);
        	ActionManager.getAction().getDeleteAction().setEnabled(false);
        	ActionManager.getAction().getNewDiaAction().setEnabled(false); // dodano u 17h - zadnje
        	ActionManager.getAction().getSaveAction().setEnabled(false); //
        	SwingUtilities.updateComponentTreeUI(Frame.getInstance().getTree());
        	
        }
        
        
        
        
        
        
       
    }
}