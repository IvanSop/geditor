package states;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import tree.Diagram;
import elements.DiagramDevice;
import elements.RectangleElement;
import gui.Frame;
import gui.InternalFrame;

public class RectangleState extends State{
	private InternalFrame med; 
	transient private Cursor stoneCursor;
	
	
	
	public Cursor getStoneCursor() {
		return stoneCursor;
	}

	public void setStoneCursor(Cursor stoneCursor) {
		this.stoneCursor = stoneCursor;
	}

	public RectangleState(InternalFrame md) {
      	
		med = md;
      	name = "Rectangle";
    	ClassLoader cl = this.getClass().getClassLoader();
    	
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        ImageIcon imgic = new ImageIcon(cl.getResource("rectangle.png"));
        Image image = imgic.getImage();
        Point hotspot = new Point(15,15);
        stoneCursor = toolkit.createCustomCursor(image, hotspot, "Stone");
      	
      
      	
	}

	public void mousePressed(MouseEvent e) {
		Point position = e.getPoint();
		med. transformToUserSpace(position);
		//((InternalFrame)Frame.getInstance().getDesk().getSelectedFrame()).getFramework().setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		if (e.getButton()==MouseEvent.BUTTON1){
			 if (med.getDiagram().getModel().getDeviceAtPosition(position)==-1){
				 DiagramDevice device = RectangleElement.createDefault(position,med.getDiagram().getModel().getDeviceCount());
				 med.getDiagram().getModel().addDiagramElements(device);
			 }
		}
	}
	

    //getContentPane().setCursor(stoneCursor);
	
	
	
	
	
	
	
	
	public void mouseMoved(MouseEvent e) {
		if (((InternalFrame)Frame.getInstance().getDesk().getSelectedFrame())!=null) // bez ovoga hover preko neselektovanih frameova daje null pointer exc
			((InternalFrame)Frame.getInstance().getDesk().getSelectedFrame()).getFramework().setCursor(stoneCursor);
	}
	
}
