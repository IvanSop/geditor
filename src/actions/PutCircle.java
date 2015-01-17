package actions;

import gui.Frame;
import gui.InternalFrame;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public class PutCircle extends AbstractAction {

	public PutCircle() {
        ClassLoader cl = this.getClass().getClassLoader();
		
		
		putValue(NAME, "PutCircle");
		putValue(SMALL_ICON, new ImageIcon(cl.getResource("circle.png")));
        //putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl Z"));
        putValue(ACTION_COMMAND_KEY, "PutCircle");
        putValue(SHORT_DESCRIPTION, "Place circle");
		
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("Action [" + e.getActionCommand() + "] performed!");
        if (((InternalFrame)Frame.getInstance().getDesk().getSelectedFrame())!=null) // bez ovoga hover preko neselektovanih frameova daje null pointer exc
        ((InternalFrame)Frame.getInstance().getDesk().getSelectedFrame()).startCircleState();
    }
}