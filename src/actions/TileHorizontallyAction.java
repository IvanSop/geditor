package actions;

import gui.Frame;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public class TileHorizontallyAction extends AbstractAction {

	public TileHorizontallyAction() {
        ClassLoader cl = this.getClass().getClassLoader();
		
		
		putValue(NAME, "Tile Windows Horizontally");
		putValue(SMALL_ICON, new ImageIcon(cl.getResource("tileHorizontal.png")));
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("shift H"));
        putValue(ACTION_COMMAND_KEY, "Tile Windows Horizontally");
        putValue(SHORT_DESCRIPTION, "Tile Windows Horizontally");
		
    }

    public void actionPerformed(ActionEvent e) {
    	//System.out.println("Action [" + e.getActionCommand() + "] performed!");
        
        int n = Frame.getInstance().getDesk().getAllFrames().length; // vraca broj iframeova
        int visina = Frame.getInstance().getDesk().getHeight();
        int sirina = Frame.getInstance().getDesk().getWidth();
        
        int fvisina=-1;
        int fsirina=-1;
        
        if (n>=1) {
        fvisina=visina;
        fsirina=sirina/n;
        
 	       for (int i = 0; i < n; i++) {
 	    	   
 	    	   Frame.getInstance().getDesk().getAllFrames()[i].setSize(fsirina, fvisina);
 	    	   Frame.getInstance().getDesk().getAllFrames()[i].setLocation(i*fsirina, 0);
 	    	   //System.out.println(Frame.getInstance().getDesk().getAllFrames()[i].getLocation());
 	       }
        }
    }
}