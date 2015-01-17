package tree;

import gui.Frame;
import gui.InternalFrame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyVetoException;

import javax.swing.SwingUtilities;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

import actions.ActionManager;

public class TreeController implements TreeSelectionListener,MouseListener {

	@Override
	public void valueChanged(TreeSelectionEvent e) {
		
		TreePath path = e.getPath();
		
		// postavljanje new diagram akcije na enabled kad treba
		//System.out.println(path);
		if (path.getLastPathComponent() instanceof Project) {
			ActionManager.getAction().getNewDiaAction().setEnabled(true);
			ActionManager.getAction().getDeleteAction().setEnabled(true);
			ActionManager.getAction().getSaveAction().setEnabled(true);
		} else if (path.getLastPathComponent() instanceof Diagram) {
			ActionManager.getAction().getNewDiaAction().setEnabled(true);
			ActionManager.getAction().getDeleteAction().setEnabled(true);
			ActionManager.getAction().getSaveAction().setEnabled(true);
		} else {
			ActionManager.getAction().getNewDiaAction().setEnabled(false);
			ActionManager.getAction().getDeleteAction().setEnabled(false);
			ActionManager.getAction().getSaveAction().setEnabled(false);
		}
		// *****************
		
		
		// Kad se selektuje u stablu da se selektuje i internal frame
		if (path.getLastPathComponent() instanceof Diagram) {
			
			
			Object tajFrm = path.getLastPathComponent();
		
			for (InternalFrame ifrm : Frame.getInstance().getInternalframes()) {
		
				if (ifrm.getName().equals(tajFrm.toString()))
					try {
						ifrm.setSelected(true);
					} catch (PropertyVetoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				else
					try {
						ifrm.setSelected(false);	// ovo sluzi da fokus ne ostane na tamo nekom iframeu kad selektujes zatvoren iframe
					} catch (PropertyVetoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
			
		}
		// *****************
		
		
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getButton() == MouseEvent.BUTTON1 && arg0.getClickCount() == 2) {
			
			if (Frame.getInstance().getTree().getLastSelectedPathComponent() instanceof Diagram) {
						
				Object kliknutiDiagram =  Frame.getInstance().getTree().getLastSelectedPathComponent();
						
						int n = Frame.getInstance().getInternalframes().size();
						for (int i=0;i<n;i++) {
							if (Frame.getInstance().getInternalframes().get(i).isClosed() && Frame.getInstance().getInternalframes().get(i).getName().equals(kliknutiDiagram.toString()) ) {
							
								Frame.getInstance().getDesk().add(Frame.getInstance().getInternalframes().get(i));
								Frame.getInstance().getInternalframes().get(i).setVisible(true);
								
								try {
									Frame.getInstance().getInternalframes().get(i).setClosed(false);
								} catch (PropertyVetoException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								try {
									Frame.getInstance().getInternalframes().get(i).setSelected(true);
								} catch (PropertyVetoException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								SwingUtilities.updateComponentTreeUI(Frame.getInstance().getInternalframes().get(i)); // ako menjas LaF dok je iframe zatvoren
							}
								
						}
						
						
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
