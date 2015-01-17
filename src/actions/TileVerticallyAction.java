package actions;

import gui.Frame;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public class TileVerticallyAction extends AbstractAction {

	public TileVerticallyAction() {
        ClassLoader cl = this.getClass().getClassLoader();
		
		
		putValue(NAME, "Tile Windows Vertically");
		putValue(SMALL_ICON, new ImageIcon(cl.getResource("tileVertical.png")));
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("shift V"));
        putValue(ACTION_COMMAND_KEY, "Tile Windows Vertically");
        putValue(SHORT_DESCRIPTION, "Tile Windows Vertically");
		
    }

    public void actionPerformed(ActionEvent e) {
    	//System.out.println("Action [" + e.getActionCommand() + "] performed!");
        
        int n = Frame.getInstance().getDesk().getAllFrames().length; // vraca broj iframeova
        int visina = Frame.getInstance().getDesk().getHeight();
        int sirina = Frame.getInstance().getDesk().getWidth();
        int fvisina=-1;
        int fsirina=-1;
        
        if (n>=1) {
         fvisina=visina/n;
         fsirina=sirina;
        
       
        for (int i = 0; i < n; i++) {
     	   
     	   Frame.getInstance().getDesk().getAllFrames()[i].setSize(fsirina, fvisina);
     	   Frame.getInstance().getDesk().getAllFrames()[i].setLocation(0, i*fvisina);
     	   //System.out.println(Frame.getInstance().getDesk().getAllFrames()[i].getLocation());
        }
       }
    
    }
}