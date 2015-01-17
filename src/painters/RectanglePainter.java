package painters;

import java.awt.geom.Rectangle2D;

import elements.DiagramElement;
import elements.RectangleElement;

/**
 * Konkretan painter je zadužen za definisanje Shape objekta koji predstavlja dati element
 * @author Igor Z.
 *
 */
public class RectanglePainter extends DevicePainter{

	public RectanglePainter(DiagramElement device) {
		super(device);
		RectangleElement rectangle = (RectangleElement) device;

		/*
		shape=new GeneralPath();
		((GeneralPath)shape).moveTo(rectangle.getPosition().x,rectangle.getPosition().y);
		
		((GeneralPath)shape).lineTo(rectangle.getPosition().x+rectangle.getSize().width,rectangle.getPosition().y);
		
		((GeneralPath)shape).lineTo(rectangle.getPosition().x+rectangle.getSize().width,rectangle.getPosition().y+rectangle.getSize().height);
		
		((GeneralPath)shape).lineTo(rectangle.getPosition().x,rectangle.getPosition().y+rectangle.getSize().height);
		
		((GeneralPath)shape).closePath();
		 */
		shape = new Rectangle2D.Float(0,0,rectangle.getSize().width,rectangle.getSize().height);
		
	}
	

	
}
