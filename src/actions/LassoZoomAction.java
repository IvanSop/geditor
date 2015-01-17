package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public class LassoZoomAction extends AbstractAction {

	public LassoZoomAction() {
        ClassLoader cl = this.getClass().getClassLoader();
		
		
		putValue(NAME, "Lasso Zoom");
		putValue(SMALL_ICON, new ImageIcon(cl.getResource("lassoZoom.png")));
        //putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_SUBTRACT, ActionEvent.CTRL_MASK));
        putValue(ACTION_COMMAND_KEY, "Lasso Zoom");
        putValue(SHORT_DESCRIPTION, "Lasso Zoom");
		
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("Action [" + e.getActionCommand() + "] performed!");
    }
}