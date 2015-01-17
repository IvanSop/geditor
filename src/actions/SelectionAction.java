package actions;

import gui.Frame;
import gui.InternalFrame;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

public class SelectionAction extends AbstractAction {

	public SelectionAction() {
        ClassLoader cl = this.getClass().getClassLoader();
		
		
		putValue(NAME, "Select");
		putValue(SMALL_ICON, new ImageIcon(cl.getResource("hand.png")));
        //putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl Z"));
        putValue(ACTION_COMMAND_KEY, "Select");
        putValue(SHORT_DESCRIPTION, "Select");
		
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("Action [" + e.getActionCommand() + "] performed!");
        // nek zasad linija bvude select
        if (((InternalFrame)Frame.getInstance().getDesk().getSelectedFrame())!=null) // bez ovoga hover preko neselektovanih frameova daje null pointer exc
        	((InternalFrame)Frame.getInstance().getDesk().getSelectedFrame()).startSelectState();
    }
}