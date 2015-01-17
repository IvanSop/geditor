package actions;

import gui.Frame;
import gui.InternalFrame;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.geom.AffineTransform;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.KeyStroke;

import models.DiagramFileFilter;
import tree.Project;
import tree.Workspace;

public class LoadAction extends AbstractAction {

	public LoadAction() {
        ClassLoader cl = this.getClass().getClassLoader();
		
		
		putValue(NAME, "Load Project");
		putValue(SMALL_ICON, new ImageIcon(cl.getResource("loadProj.png")));
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl shift L"));
        putValue(ACTION_COMMAND_KEY, "Load Project");
        putValue(SHORT_DESCRIPTION, "Load project");
		
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("Action [" + e.getActionCommand() + "] performed!");
        
        JFileChooser jfc = new JFileChooser();
		jfc.setFileFilter(new DiagramFileFilter());
		
		if(jfc.showOpenDialog(Frame.getInstance())==JFileChooser.APPROVE_OPTION){
			try {
				ObjectInputStream os = new ObjectInputStream(new FileInputStream(jfc.getSelectedFile()));
				  
				Project p=null;
				try {
					p = (Project) os.readObject();
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			      //p.setName("jebosebe");
			      //System.out.println("=> " + p.getName());
			      
			      Frame.getInstance().getTree().addProject(p);
			      ((Workspace)Frame.getInstance().getWorkspaceModel().getRoot()).setMaxLen(((Workspace)Frame.getInstance().getWorkspaceModel().getRoot()).getMaxLen()+1); // 
			      
			      int brProj = ((Workspace)Frame.getInstance().getWorkspaceModel().getRoot()).getProjectsCount(); // broj projekata
			      int mLen = ((Workspace)Frame.getInstance().getWorkspaceModel().getRoot()).getMaxLen();
			      --mLen;
			      System.out.println("brProj: " + brProj);
			      System.out.println("mLen: " + mLen);
			      ((Workspace)Frame.getInstance().getWorkspaceModel().getRoot()).getProject(brProj-1).setName("Project " + mLen); // promena imena da bde zadnji, mozda i ne treba ali..
			      
			      int diaCount = ((Workspace)Frame.getInstance().getWorkspaceModel().getRoot()).getProject(brProj-1).getDiagramCount(); // broj diagrama
				  System.out.println("diaCount: " + diaCount);
				  
				  
				  
				  // ** za cursore
				  	ClassLoader cl = this.getClass().getClassLoader();
			    	Cursor rect;
			        Toolkit toolkit = Toolkit.getDefaultToolkit();
			        //ImageIcon imgic = new ImageIcon(cl.getResource("rectangle.png"));
			        //Image image = imgic.getImage();
			        Point hotspot = new Point(15,15);
			        //rect = toolkit.createCustomCursor(image, hotspot, "Stone");
				  // ---
				  
				  
				  
				  
				  
				  
				  
				  
				  
				  
				  
				  for (int i = 0; i < diaCount; i++) {
					  ((Workspace)Frame.getInstance().getWorkspaceModel().getRoot()).getProject(brProj-1).getDiagram(i).setName("Project " + mLen + " - Diagram - " + (i+1));
					  
					 
					 /* 
					  // ** Ponovno pravljenje cursora posto nisu serijalizovani zbog imagea
					  ImageIcon imgic = new ImageIcon(cl.getResource("rectangle.png"));
				      Image image = imgic.getImage();				  
				      rect = toolkit.createCustomCursor(image, hotspot, "Stone");
				      ((Workspace)Frame.getInstance().getWorkspaceModel().getRoot()).getProject(brProj-1).getDiagram(i).getStateManager().getRectangleState().setStoneCursor(rect);
				  	  			      
				      
				  	  imgic = new ImageIcon(cl.getResource("circle.png"));
				      image = imgic.getImage();				  
				      rect = toolkit.createCustomCursor(image, hotspot, "Stone");
				      ((Workspace)Frame.getInstance().getWorkspaceModel().getRoot()).getProject(brProj-1).getDiagram(i).getStateManager().getCircleState().setStoneCursor(rect);
				      
				      imgic = new ImageIcon(cl.getResource("triangle.png"));
				      image = imgic.getImage();				  
				      rect = toolkit.createCustomCursor(image, hotspot, "Stone");
				      ((Workspace)Frame.getInstance().getWorkspaceModel().getRoot()).getProject(brProj-1).getDiagram(i).getStateManager().getTriangleState().setStoneCursor(rect);
				      
				      imgic = new ImageIcon(cl.getResource("star.png"));
				      image = imgic.getImage();				  
				      rect = toolkit.createCustomCursor(image, hotspot, "Stone");
				      ((Workspace)Frame.getInstance().getWorkspaceModel().getRoot()).getProject(brProj-1).getDiagram(i).getStateManager().getStarState().setStoneCursor(rect);
				      // **
				  	*/
				  
				  
				  }
				  
				  
			      for (int i=0;i<p.getDiagramCount();i++){
				    InternalFrame view=new InternalFrame();
				   // AffineTransform af = view.getTransformation();
				   // af.setToIdentity();
				    //view.setTransformation(af);
				    p.getDiagram(i).getModel().addUpdateListener(p);
				    view.setDiagram(p.getDiagram(i));
				    
				    	    	    
				    
				    // ---  Ponovno pravljenje cursora posto nisu serijalizovani zbog imagea
				    ImageIcon imgic = new ImageIcon(cl.getResource("rectangle.png"));
				    Image image = imgic.getImage();				  
				    rect = toolkit.createCustomCursor(image, hotspot, "Stone");
				    view.getStateManager().getRectangleState().setStoneCursor(rect);
				
				    imgic = new ImageIcon(cl.getResource("circle.png"));
				    image = imgic.getImage();				  
				    rect = toolkit.createCustomCursor(image, hotspot, "Stone");
				    view.getStateManager().getCircleState().setStoneCursor(rect);
				    
				    imgic = new ImageIcon(cl.getResource("triangle.png"));
				    image = imgic.getImage();				  
				    rect = toolkit.createCustomCursor(image, hotspot, "Stone");
				    view.getStateManager().getTriangleState().setStoneCursor(rect);
				    
				    imgic = new ImageIcon(cl.getResource("star.png"));
				    image = imgic.getImage();				  
				    rect = toolkit.createCustomCursor(image, hotspot, "Stone");
				    view.getStateManager().getStarState().setStoneCursor(rect);
				    // ---
				    
				    
				   Frame.getInstance().getDesk().add(view);
				   Frame.getInstance().getInternalframes().add(view);
				   int ifrSize = Frame.getInstance().getInternalframes().size();
				   System.out.println("ifrSize: " + ifrSize);
				   
				   
				   
				}
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} 
			
		
		
	}
        
        
    }
}
