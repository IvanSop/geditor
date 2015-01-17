package painters;

import java.awt.geom.Ellipse2D;

import elements.CircleElement;
import elements.DiagramElement;

/**
 * Konkretan painter je zadužen za definisanje Shape objekta koji predstavlja dati element
 * @author Igor Z.
 *
 */
public class CirclePainter extends DevicePainter{

	public CirclePainter(DiagramElement device) {
		super(device);
		CircleElement or = (CircleElement) device;
		/*
		shape=new GeneralPath();
		
		((GeneralPath)shape).moveTo(or.getPosition().getX()+or.getSize().getWidth()/2,or.getPosition().getY());
		
		((GeneralPath)shape).quadTo(or.getPosition().getX()+or.getSize().getWidth(), or.getPosition().getY(), 
									or.getPosition().getX()+or.getSize().getWidth(), or.getPosition().getY()+or.getSize().getHeight()/2);
		
		((GeneralPath)shape).quadTo(or.getPosition().getX()+or.getSize().getWidth(), or.getPosition().getY()+or.getSize().getHeight(),
									or.getPosition().getX()+or.getSize().getWidth()/2, or.getPosition().getY()+or.getSize().getHeight());
		
		((GeneralPath)shape).quadTo(or.getPosition().getX(), or.getPosition().getY()+or.getSize().getHeight(),
				or.getPosition().getX(), or.getPosition().getY()+or.getSize().getHeight()/2);


		((GeneralPath)shape).quadTo(or.getPosition().getX(), or.getPosition().getY(),
				or.getPosition().getX()+or.getSize().getWidth()/2,or.getPosition().getY());

		
	*/
	shape = new Ellipse2D.Float( 0 , 0 , (float)or.getSize().width , (float)or.getSize().height);	
	}
	

	
}
