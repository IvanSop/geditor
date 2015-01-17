package elements;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Point2D;

import painters.RectanglePainter;

public class RectangleElement extends DiagramDevice {

	public RectangleElement(Point2D position, Dimension size, Stroke stroke, Paint paint, Color strokeColor) {
		super(position, size, stroke, paint,strokeColor);
		elementPainter = new RectanglePainter(this);
	}

	
	public static DiagramDevice createDefault(Point2D pos, int elemNo){
		Point2D position = (Point2D) pos.clone();
		
        Paint fill = Color.WHITE;
        RectangleElement rectangleElement=new RectangleElement(position, 
	    		                       new Dimension(80,40),
	    		                      new BasicStroke((float)(2), BasicStroke.CAP_SQUARE,BasicStroke.JOIN_BEVEL ),
             	                      fill,
	    		                      Color.BLACK);
        rectangleElement.setName("Rectangle" + elemNo);
		return rectangleElement;
	}
}
