package painters;



import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.io.Serializable;

import elements.DiagramElement;


/**
 * ElementPainter je apstraktna klasa koja deklariše metode za iscrtavnje Diagram
 * elementa i detekciju pogotka
 * @author Igor Z.
 *
 */
public abstract class ElementPainter implements Serializable {

	
	protected Shape shape;
	/**
	 * Referenca na Element objekat kome painter pripada.
	 */
	protected DiagramElement element;
	public ElementPainter(DiagramElement element) {
		this.element=element;
	}
	

	public abstract void paint(Graphics2D g, DiagramElement element);
	
	public abstract boolean isElementAt( Point pos);

	public Shape getShape() {
		return shape;
	}

	
}
