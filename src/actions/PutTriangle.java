package actions;

import gui.Frame;
import gui.InternalFrame;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public class PutTriangle extends AbstractAction {

	public PutTriangle() {
        ClassLoader cl = this.getClass().getClassLoader();
		
		
		putValue(NAME, "PutTriangle");
		putValue(SMALL_ICON, new ImageIcon(cl.getResource("triangle.png")));
        //putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl Z"));
        putValue(ACTION_COMMAND_KEY, "PutTriangle");
        putValue(SHORT_DESCRIPTION, "Place triangle");
		
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("Action [" + e.getActionCommand() + "] performed!");
        if (((InternalFrame)Frame.getInstance().getDesk().getSelectedFrame())!=null) // bez ovoga hover preko neselektovanih frameova daje null pointer exc
        	((InternalFrame)Frame.getInstance().getDesk().getSelectedFrame()).startTriangleState();
    }
}