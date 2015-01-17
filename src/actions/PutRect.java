package actions;

import gui.Frame;
import gui.InternalFrame;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

public class PutRect extends AbstractAction {

	//private Cursor stoneCursor;
	 
	public PutRect() {
       
		ClassLoader cl = this.getClass().getClassLoader();
		/*
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        ImageIcon imgic = new ImageIcon(cl.getResource("rectangle.png"));
        Image image = imgic.getImage();
        Point hotspot = new Point(15,15);
        stoneCursor = toolkit.createCustomCursor(image, hotspot, "Stone");
		*/
		
		
		
		
		
		
		
		putValue(NAME, "PutRect");
		putValue(SMALL_ICON, new ImageIcon(cl.getResource("rectangle.png")));
        //putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl Z"));
        putValue(ACTION_COMMAND_KEY, "PutRect");
        putValue(SHORT_DESCRIPTION, "Place rectangle");
		
    }


	
    public void actionPerformed(ActionEvent e) {
    	if (((InternalFrame)Frame.getInstance().getDesk().getSelectedFrame())!=null) // bez ovoga hover preko neselektovanih frameova daje null pointer exc
    		((InternalFrame)Frame.getInstance().getDesk().getSelectedFrame()).startRectangleState();
        System.out.println("Action [" + e.getActionCommand() + "] performed!");
        
     // if (((InternalFrame)Frame.getInstance().getDesk().getSelectedFrame())!=null) // bez ovoga hover preko neselektovanih frameova daje null pointer exc
      	//	((InternalFrame)Frame.getInstance().getDesk().getSelectedFrame()).getFramework().setCursor(stoneCursor);

    }
}