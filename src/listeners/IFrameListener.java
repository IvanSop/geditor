package listeners;

import elements.DiagramDevice;
import gui.Frame;
import gui.InternalFrame;

import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.tree.TreePath;

public class IFrameListener implements InternalFrameListener {

		
	
	
	@Override
	public void internalFrameOpened(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameClosing(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameClosed(InternalFrameEvent e) {
		// TODO Auto-generated method stub
	
		
	}

	@Override
	public void internalFrameIconified(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameDeiconified(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameActivated(InternalFrameEvent e) {
	// ovo je selekcija nodea u drvetu kad se selektuje iframe	****************
		//System.out.println(Frame.getInstance().getWorkspaceModel().getRoot()); // dobili smo workspace
		Object put[] = new Object[3];
		put[0] = Frame.getInstance().getWorkspaceModel().getRoot();	// workspace
		put[1] = ((InternalFrame)Frame.getInstance().getDesk().getSelectedFrame()).getDiagram().getParent();	// projekat
		put[2] = ((InternalFrame)Frame.getInstance().getDesk().getSelectedFrame()).getDiagram();		// diagram
		//System.out.println(put[0]+" "+put[1]+" "+put[2]+"==");
		
						
		TreePath putBeznadnja = new TreePath(put);
		Frame.getInstance().getTree().setSelectionPath(putBeznadnja);
		
	// ********************************
	
	String cs = ((InternalFrame)Frame.getInstance().getDesk().getSelectedFrame()).getStateManager().getCurrentState().getName();
	System.out.println("CURRSTATE: " + ((InternalFrame)Frame.getInstance().getDesk().getSelectedFrame()).getStateManager().getCurrentState().getName()); 
	Frame.getInstance().getStatusBar().setState(cs);
	
		if ( ((InternalFrame)Frame.getInstance().getDesk().getSelectedFrame()).getDiagram().getSelectionModel().getSelectionListSize()==1) {
			System.out.println(((InternalFrame)Frame.getInstance().getDesk().getSelectedFrame()).getDiagram().getSelectionModel().getSelectionList().get(0));
			DiagramDevice tempdev = (DiagramDevice)((InternalFrame)Frame.getInstance().getDesk().getSelectedFrame()).getDiagram().getSelectionModel().getSelectionList().get(0);
			
			Frame.getInstance().getStatusBar().setDim("W:" + tempdev.getSize().width + " - H:" + tempdev.getSize().height);
			Frame.getInstance().getStatusBar().setElType(tempdev.getClass().getSimpleName());
			Frame.getInstance().getStatusBar().setElName(tempdev.getName());
			Frame.getInstance().getStatusBar().setPos("x: " + tempdev.getPosition().getX() + " , y: " + tempdev.getPosition().getY());
			
		} else {
			Frame.getInstance().getStatusBar().setDim("//");
			Frame.getInstance().getStatusBar().setElType("//");
			Frame.getInstance().getStatusBar().setElName("//");
			Frame.getInstance().getStatusBar().setPos("//");
		}
	}

	@Override
	public void internalFrameDeactivated(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

}
