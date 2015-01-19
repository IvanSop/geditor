package states;

import gui.Frame;
import gui.InternalFrame;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import commands.AddDeviceCommand;

public class CircleState extends State{
	private InternalFrame med; 
	transient private Cursor stoneCursor;
	
	
	
	public Cursor getStoneCursor() {
		return stoneCursor;
	}

	public void setStoneCursor(Cursor stoneCursor) {
		this.stoneCursor = stoneCursor;
	}

	public CircleState(InternalFrame md) {
	    med = md;
	    name = "Circle";
	    ClassLoader cl = this.getClass().getClassLoader();
    	
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        ImageIcon imgic = new ImageIcon(cl.getResource("circle.png"));
        Image image = imgic.getImage();
        Point hotspot = new Point(15,15);
        stoneCursor = toolkit.createCustomCursor(image, hotspot, "Stone");
	    
	    
	    
	}
	
	public void mousePressed(MouseEvent e) {
		Point position = e.getPoint();
		med. transformToUserSpace(position);
		if (e.getButton()==MouseEvent.BUTTON1){
			if (med.getDiagram().getModel().getElementAtPosition(position)==-1){
				 med.getCommandManager().addCommand(new AddDeviceCommand(med.getDiagram().getModel(),med.getDiagram().getSelectionModel(),position,InternalFrame.CIRCLE));
			 }
			
			
		}
	}
	
	public void mouseMoved(MouseEvent e) {
		if (((InternalFrame)Frame.getInstance().getDesk().getSelectedFrame())!=null) // bez ovoga hover preko neselektovanih frameova daje null pointer exc
		((InternalFrame)Frame.getInstance().getDesk().getSelectedFrame()).getFramework().setCursor(stoneCursor);
	}
}
