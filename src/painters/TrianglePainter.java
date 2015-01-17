package painters;

import java.awt.geom.GeneralPath;

import elements.DiagramElement;
import elements.TriangleElement;

/**
 * Konkretan painter je zadužen za definisanje Shape objekta koji predstavlja dati element
 * @author Igor Z.
 *
 */
public class TrianglePainter extends DevicePainter{

	public TrianglePainter(DiagramElement device) {
		super(device);
		TriangleElement or = (TriangleElement) device;
		
		shape=new GeneralPath();
		
		//((GeneralPath)shape).moveTo(or.getPosition().getX()+or.getSize().getWidth()/2,or.getPosition().getY());
		((GeneralPath)shape).moveTo(0,or.getSize().height);
		
		((GeneralPath)shape).lineTo(or.getSize().width/2,0);
		((GeneralPath)shape).lineTo(or.getSize().width,or.getSize().height);
		((GeneralPath)shape).closePath();
	
	//shape = new Ellipse2D.Float( (float)or.getPosition().getX() , (float)or.getPosition().getY() , (float)or.getSize().width , (float)or.getSize().height);	
	}
	

	
}
