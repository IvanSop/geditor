package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public class ZoomInAction extends AbstractAction {

	public ZoomInAction() {
        ClassLoader cl = this.getClass().getClassLoader();
		
		
		putValue(NAME, "Zoom In");
		putValue(SMALL_ICON, new ImageIcon(cl.getResource("zoomIn.png")));
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_ADD, ActionEvent.CTRL_MASK));
        putValue(ACTION_COMMAND_KEY, "Zoom In");
        putValue(SHORT_DESCRIPTION, "Zoom In");
		
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("Action [" + e.getActionCommand() + "] performed!");
    }
}