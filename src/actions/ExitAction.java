package actions;

import gui.Frame;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public class ExitAction extends AbstractAction {
	public ExitAction() {
        ClassLoader cl = this.getClass().getClassLoader();
		
		
		putValue(NAME, "Exit");
		putValue(SMALL_ICON, new ImageIcon(cl.getResource("exit.png")));
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl C"));
        putValue(ACTION_COMMAND_KEY, "Exit");
        putValue(SHORT_DESCRIPTION, "Exit Application");
		
    }

    public void actionPerformed(ActionEvent e) {
        //System.out.println("Action [" + e.getActionCommand() + "] performed!");
        //System.exit(0);
        Frame.getInstance().dispatchEvent(new WindowEvent(Frame.getInstance(), WindowEvent.WINDOW_CLOSING));
       
    }
}
