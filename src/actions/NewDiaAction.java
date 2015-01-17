package actions;

import gui.Frame;
import gui.InternalFrame;

import java.awt.event.ActionEvent;
import java.beans.PropertyVetoException;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.tree.TreePath;

import tree.Diagram;
import tree.Project;



public class NewDiaAction extends AbstractAction {

	public NewDiaAction() {
        ClassLoader cl = this.getClass().getClassLoader();
		
		
		putValue(NAME, "New Diagram");
		putValue(SMALL_ICON, new ImageIcon(cl.getResource("newDia.png")));
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl shift D"));
        putValue(ACTION_COMMAND_KEY, "New Diagram");
        putValue(SHORT_DESCRIPTION, "Create new diagram");
        setEnabled(false);
		
    }

    public void actionPerformed(ActionEvent e) {
        //System.out.println("Action [" + e.getActionCommand() + "] performed!");
        //Frame.getInstance().createDiagram();
        
    
        Object p = Frame.getInstance().getTree().getLastSelectedPathComponent();
        // ako je selektovan projekat, u taj projekat se dodaje novi diagram
        if (p  instanceof Project) {
        	
        	// auto expand pri dodavanju novog diagrama -- mozda i ne treba
        	TreePath trp = Frame.getInstance().getTree().getLeadSelectionPath();
        	Frame.getInstance().getTree().expandPath(trp);
        	// ****
        	
        	Frame.getInstance().getTree().setSelectionPath(trp); // zbog ovoga
        	
        	
        	Diagram d = new Diagram("New Diagram");
        	
        	((Project)p).addDiagram(d);
        	((Project)p).setMaxLen(((Project)p).getMaxLen()+1);
        	SwingUtilities.updateComponentTreeUI(Frame.getInstance().getTree());
        	
        	InternalFrame iframe = new InternalFrame();
        	iframe.setDiagram(d);
        	Frame.getInstance().getDesk().add(iframe);
        	Frame.getInstance().getInternalframes().add(iframe);
        	
        	try {
				iframe.setSelected(true);
			} catch (PropertyVetoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	
        }
        
        
        // Ako je selektovan diagram, novi diagram se dodaje u isti projekat
        if (p instanceof Diagram) {
        	
        	Object op = Frame.getInstance().getTree().getSelectionPath().getParentPath().getLastPathComponent();
        	        	       	
        	
        	Diagram d = new Diagram("New Diagram");
        	
        	((Project)op).addDiagram(d);
        	((Project)op).setMaxLen(((Project)op).getMaxLen()+1);
        	SwingUtilities.updateComponentTreeUI(Frame.getInstance().getTree());
        	
        	InternalFrame iframe = new InternalFrame();
        	iframe.setDiagram(d);
        	Frame.getInstance().getDesk().add(iframe);
        	Frame.getInstance().getInternalframes().add(iframe);
    
            	
        	try {
				iframe.setSelected(true);
			} catch (PropertyVetoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
        
        
        
    }
}