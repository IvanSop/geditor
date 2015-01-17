package elements;



import java.awt.Color;
import java.awt.Paint;
import java.awt.Stroke;
import java.io.Serializable;

import painters.ElementPainter;
import serialization.SerializableStrokeAdapter;

/**
 * Apstraktna klasa koja opisuje bilo koji element  mreže.
 * Opisuje i linkove dijagrama i elemente dijagrama
 * @author Igor Z. 
 *
 */
public abstract class DiagramElement implements Serializable{
	
	protected Paint paint;
	//protected Stroke stroke;
	protected SerializableStrokeAdapter stroke;
	protected Color  strokeColor;
	
	protected String name;
	protected String description;
	
	/**
	 * Instanciranje ElementPainter-a obavljaju konkretni  elementi dijagrama
	 * prilikom svoje konstrukcije 
	 */
	protected ElementPainter elementPainter;
	
	public DiagramElement(Stroke stroke, Paint paint,Color  strokeColor){
		setStroke(stroke);
		this.paint = paint;
		this.strokeColor=strokeColor;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public ElementPainter getPainter() {
		return elementPainter;
	}

	public Paint getPaint() {
		return paint;
	}

	public void setPaint(Paint paint) {
		this.paint = paint;
	}

	public Stroke getStroke() {
		return stroke;
	}

	public void setStroke(Stroke stroke) {
		this.stroke = new SerializableStrokeAdapter(stroke);
	}

	public String toString(){
		return name;
	}

	public Color getStrokeColor() {
		return strokeColor;
	}

	public void setStrokeColor(Color strokeColor) {
		this.strokeColor = strokeColor;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
