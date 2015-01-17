package states;

import gui.Frame;
import gui.InternalFrame;

import java.io.Serializable;

public class StateManager implements Serializable {
	private State currentState;
	
	
	CircleState circleState; 
	RectangleState rectangleState;
	SelectState selectState;
	TriangleState triangleState;
	StarState starState;
	LassoState lassoState;
	ResizeState resizeState;
	public StateManager(InternalFrame med)
	{
		 
		circleState = new CircleState(med); 
		rectangleState=new RectangleState(med);
		selectState=new SelectState(med);
     	triangleState=new TriangleState(med);
		starState=new StarState(med);
		lassoState =new LassoState(med);
		resizeState= new ResizeState(med);
     	currentState = selectState;
	}
	
	public void setCircleState() { currentState = circleState; Frame.getInstance().getStatusBar().setState("Circle"); }
	public void setRectangleState(){ currentState = rectangleState; Frame.getInstance().getStatusBar().setState("Rectangle"); }
	public void setSelectState(){ currentState = selectState; Frame.getInstance().getStatusBar().setState("Select"); }
	public void setTriangleState() { currentState = triangleState; Frame.getInstance().getStatusBar().setState("Triangle"); }
	public void setStarState() { currentState = starState; Frame.getInstance().getStatusBar().setState("Star"); }
	public void setLassoState() { currentState = lassoState; Frame.getInstance().getStatusBar().setState("Lasso"); }
	public void setResizeState() { currentState = resizeState; Frame.getInstance().getStatusBar().setState("Resize"); }
	public State getCurrentState() {
		return currentState;
	}
// ---
	public CircleState getCircleState() {
		return circleState;
	}

	public void setCircleState(CircleState circleState) {
		this.circleState = circleState;
	}

	public RectangleState getRectangleState() {
		return rectangleState;
	}

	public void setRectangleState(RectangleState rectangleState) {
		this.rectangleState = rectangleState;
	}

	public SelectState getSelectState() {
		return selectState;
	}

	public void setSelectState(SelectState selectState) {
		this.selectState = selectState;
	}

	public TriangleState getTriangleState() {
		return triangleState;
	}

	public void setTriangleState(TriangleState triangleState) {
		this.triangleState = triangleState;
	}

	public StarState getStarState() {
		return starState;
	}

	public void setStarState(StarState starState) {
		this.starState = starState;
	}

	public LassoState getLassoState() {
		return lassoState;
	}

	public void setLassoState(LassoState lassoState) {
		this.lassoState = lassoState;
	}

	public ResizeState getResizeState() {
		return resizeState;
	}

	public void setResizeState(ResizeState resizeState) {
		this.resizeState = resizeState;
	}
	
	
	
	
	
}
