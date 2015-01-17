package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public class UndoAction extends AbstractAction {

	public UndoAction() {
        ClassLoader cl = this.getClass().getClassLoader();
		
		
		putValue(NAME, "Undo");
		putValue(SMALL_ICON, new ImageIcon(cl.getResource("undo.png")));
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl Z"));
        putValue(ACTION_COMMAND_KEY, "Undo");
        putValue(SHORT_DESCRIPTION, "Undo");
		
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("Action [" + e.getActionCommand() + "] performed!");
    }
}