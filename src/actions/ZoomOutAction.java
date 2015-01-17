package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public class ZoomOutAction extends AbstractAction {

	public ZoomOutAction() {
        ClassLoader cl = this.getClass().getClassLoader();
		
		
		putValue(NAME, "Zoom Out");
		putValue(SMALL_ICON, new ImageIcon(cl.getResource("zoomOut.png")));
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_SUBTRACT, ActionEvent.CTRL_MASK));
        putValue(ACTION_COMMAND_KEY, "Zoom Out");
        putValue(SHORT_DESCRIPTION, "Zoom Out");
		
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("Action [" + e.getActionCommand() + "] performed!");
    }
}