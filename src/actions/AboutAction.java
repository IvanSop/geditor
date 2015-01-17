package actions;

import gui.AboutDialog;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public class AboutAction extends AbstractAction {

	public AboutAction() {
        ClassLoader cl = this.getClass().getClassLoader();
		
		
		putValue(NAME, "About");
		putValue(SMALL_ICON, new ImageIcon(cl.getResource("about.png")));
       // putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_SUBTRACT, ActionEvent.CTRL_MASK));
        putValue(ACTION_COMMAND_KEY, "About");
        putValue(SHORT_DESCRIPTION, "About");
		
    }

    public void actionPerformed(ActionEvent e) {
        //System.out.println("Action [" + e.getActionCommand() + "] performed!");
        AboutDialog ad = new AboutDialog();
        ad.setVisible(true);
    }
}