package actions;

import elements.DiagramDevice;
import elements.DiagramElement;
import gui.Frame;
import gui.InternalFrame;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Iterator;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public class Rotate90CounterClockwiseAction extends AbstractAction {

	public Rotate90CounterClockwiseAction() {
        ClassLoader cl = this.getClass().getClassLoader();
		
		
		putValue(NAME, "Rotate90CounterClockwise");
		putValue(SMALL_ICON, new ImageIcon(cl.getResource("counterclockwise.png")));
        //putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
        putValue(ACTION_COMMAND_KEY, "Rotate90CounterClockwise");
        putValue(SHORT_DESCRIPTION, "Rotate 90° CounterClockwise");
		
    }

    public void actionPerformed(ActionEvent e) {
       // System.out.println("Action [" + e.getActionCommand() + "] performed!");
    
    	InternalFrame med = (InternalFrame)Frame.getInstance().getDesk().getSelectedFrame();
    	if (med == null) return;
    	
    	DiagramDevice dev = null;
		if(med.getDiagram().getSelectionModel().getSelectionListSize()==1) {
			dev = (DiagramDevice)((InternalFrame)Frame.getInstance().getDesk().getSelectedFrame()).getDiagram().getSelectionModel().getSelectionList().get(0);
    	
    				
			DiagramElement element = dev;
			
			DiagramDevice device=(DiagramDevice) element;
			device.setRotation(device.getRotation()-Math.PI/2);
			
		} else {
			return;
		}
		((InternalFrame)(Frame.getInstance().getDesk().getSelectedFrame())).updatePerformed(null);
    
    }
}