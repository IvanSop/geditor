package actions;

import gui.Frame;
import gui.InternalFrame;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public class PutStar extends AbstractAction {

	public PutStar() {
        ClassLoader cl = this.getClass().getClassLoader();
		
		
		putValue(NAME, "PutStar");
		putValue(SMALL_ICON, new ImageIcon(cl.getResource("star.png")));
        //putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl Z"));
        putValue(ACTION_COMMAND_KEY, "PutStar");
        putValue(SHORT_DESCRIPTION, "Place star");
		
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("Action [" + e.getActionCommand() + "] performed!");
        if (((InternalFrame)Frame.getInstance().getDesk().getSelectedFrame())!=null) // bez ovoga hover preko neselektovanih frameova daje null pointer exc
        	((InternalFrame)Frame.getInstance().getDesk().getSelectedFrame()).startStarState();
    }
}