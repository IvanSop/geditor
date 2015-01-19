package actions;

import java.awt.event.ActionEvent;
import java.util.Iterator;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import elements.DiagramDevice;
import elements.DiagramElement;
import gui.Frame;
import gui.InternalFrame;

public class Rotate90ClockwiseAction extends AbstractAction {

	public Rotate90ClockwiseAction() {
        ClassLoader cl = this.getClass().getClassLoader();
		
		
		putValue(NAME, "Rotate90Clockwise");
		putValue(SMALL_ICON, new ImageIcon(cl.getResource("clockwise.png")));
        //putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
        putValue(ACTION_COMMAND_KEY, "Rotate90Clockwise");
        putValue(SHORT_DESCRIPTION, "Rotate 90° Clockwise");
		
    }

    public void actionPerformed(ActionEvent e) {
        //System.out.println("Action [" + e.getActionCommand() + "] performed!");
    	InternalFrame med = (InternalFrame)Frame.getInstance().getDesk().getSelectedFrame();
    	if (med == null) return;
    	
    	DiagramDevice dev = null;
		if(med.getDiagram().getSelectionModel().getSelectionListSize()==1) {
			dev = (DiagramDevice)((InternalFrame)Frame.getInstance().getDesk().getSelectedFrame()).getDiagram().getSelectionModel().getSelectionList().get(0);
    	
    				
			DiagramElement element = dev;
			
			DiagramDevice device=(DiagramDevice) element;
			device.setRotation(device.getRotation()+Math.PI/2);
			
		} else {
			return;
		}
		((InternalFrame)(Frame.getInstance().getDesk().getSelectedFrame())).updatePerformed(null);
        
        
    }
}