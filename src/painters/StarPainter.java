package painters;

import java.awt.geom.GeneralPath;

import elements.DiagramElement;
import elements.StarElement;

/**
 * Konkretan painter je zadužen za definisanje Shape objekta koji predstavlja dati element
 * @author Igor Z.
 *
 */
public class StarPainter extends DevicePainter{

	public StarPainter(DiagramElement device) {
		super(device);
		StarElement or = (StarElement) device;
		
		shape=new GeneralPath();
	
		((GeneralPath)shape).moveTo (or.getSize().width/5, or.getSize().height-1); 
        ((GeneralPath)shape).lineTo (or.getSize().width/2, 0); //0
        ((GeneralPath)shape).lineTo (4*or.getSize().width/5, or.getSize().height-1); 
        ((GeneralPath)shape).lineTo (0, 2*or.getSize().height/5); 
        ((GeneralPath)shape).lineTo (or.getSize().width-1,2*or.getSize().height/5); 
        ((GeneralPath)shape).closePath (); 
		
		
		
		
	//shape = new Ellipse2D.Float( (float)or.getPosition().getX() , (float)or.getPosition().getY() , (float)or.getSize().width , (float)or.getSize().height);	
	}
	

	
}
