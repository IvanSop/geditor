package painters;



import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.Iterator;

import elements.DiagramDevice;
import elements.DiagramElement;

/**
 * DevicePainter je zadužen za crtanje uređaja kao i za detekciju pogotka
 * za sta koristi Shape.
 * @author igor
 *
 */
public class DevicePainter extends ElementPainter {
	
	protected Shape shape;
	
	public DevicePainter(DiagramElement device){
		super(device);
	}
	
	
	public void paint(Graphics2D g, DiagramElement element){
		
		AffineTransform oldTranform=g.getTransform();
		//uzimamo device kome painter pripada
		DiagramDevice device=(DiagramDevice) element;
		/*
		if (element instanceof DiagramDevice){
			
			
			
			  DiagramDevice device=(DiagramDevice )element;
			  //ako se iscrtava element, trebaju da se iscrtaju i njegovi ulazi i izlazi 
  	   		  Iterator it = device.getInputIterator();
			  while(it.hasNext()){
				    InputOutputElement d = (InputOutputElement) it.next();
				    d.getPainter().paint(g,d);
   			  } 
			  Iterator it2 = device.getOutputIterator();
			  while(it2.hasNext()){
				    InputOutputElement d2 = (InputOutputElement) it2.next();
				    d2.getPainter().paint(g,d2);
		     }	
			  
			  g.setPaint(Color.BLACK);
			  g.drawString(device.getName(), (int)device.getPosition().getX()+10, 
											   (int)device.getPosition().getY()+(int)device.getSize().getHeight()/2);
		}
	*/
		//ovaj deo iscrtava element i linkove
		g.translate(device.getPosition().getX(), device.getPosition().getY());
		g.rotate(device.getRotation(), device.getSize().getWidth()/2, device.getSize().getHeight()/2);
		g.scale(device.getScale(), device.getScale());	
		
		g.setPaint(element.getStrokeColor());
		g.setStroke(element.getStroke());
		g.draw(getShape());

		
		g.setPaint(element.getPaint());
		g.fill(getShape());	
		
		//DiagramDevice device=(DiagramDevice )element; 
		g.setPaint(Color.BLACK);
		g.drawString(element.getName(),10,(int)device.getSize().getHeight()/2);
	
		g.setTransform(oldTranform);
	}
	
	public boolean isElementAt( Point pos){
		DiagramDevice device = (DiagramDevice) element;
		Rectangle2D rect=new Rectangle2D.Double();
		rect.setRect(device.getPosition().getX(), device.getPosition().getY(),
				device.getSize().getWidth(), device.getSize().getHeight());
		return rect.contains(pos);
	}

	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

}
