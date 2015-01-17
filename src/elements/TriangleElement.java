package elements;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Point2D;

import painters.TrianglePainter;

public class TriangleElement extends DiagramDevice {

	public TriangleElement(Point2D position, Dimension size, Stroke stroke, Paint paint,Color strokeColor) {
		super(position, size, stroke, paint,strokeColor);
		
		elementPainter = new TrianglePainter(this); //zzz
		

	}

	
	public static DiagramDevice createDefault(Point2D pos, int elemNo){
		Point2D position = (Point2D) pos.clone();
		
        Paint fill = Color.WHITE;
	    TriangleElement or=new TriangleElement(position, 
	    		                   new Dimension(50,50),
	    		                   new BasicStroke((float)(2), BasicStroke.CAP_SQUARE,BasicStroke.JOIN_BEVEL ),
	    		                   fill,
	    		                   Color.BLACK);
        or.setName("Triangle " + elemNo);
		return or;
	}

}
