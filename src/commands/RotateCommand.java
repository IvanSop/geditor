package commands;

import java.util.ArrayList;

import models.DiagramModel;
import models.DiagramSelectionModel;
import elements.DiagramDevice;
import elements.DiagramElement;
import gui.Frame;

public class RotateCommand extends AbstractCommand {

	private DiagramModel model;
	private DiagramSelectionModel selectionModel;
	
	private int direction; // bice 1 ili -1
	ArrayList<DiagramElement> rotatedElements=new ArrayList<DiagramElement>();
	boolean firstAction;
	
	
	public RotateCommand(DiagramModel model, DiagramSelectionModel gsm,int direction) {
		this.model = model;
		this.direction = direction;
		this.selectionModel = gsm;
		
		DiagramElement el = selectionModel.getSelectionList().get(0);
		DiagramDevice dev = (DiagramDevice)el;
		
		rotatedElements.add(dev);
		
		//firstAction = true;
	}
	
	
	
		
	
	
	
	@Override
	public void doCommand() {
		// TODO Auto-generated method stub
	//	if (firstAction) {
		//	firstAction = false;
		//} else {
		
		
		//DiagramElement el = selectionModel.getSelectionList().get(0);
		//DiagramDevice dev = (DiagramDevice)el;
		DiagramDevice dev = (DiagramDevice)rotatedElements.get(0);
		dev.setRotation(dev.getRotation()+(Math.PI/2*direction));
		rotatedElements.add(dev);
		Frame.getInstance().getDesk().getSelectedFrame().repaint();
		//}
	}

	@Override
	public void undoCommand() {
		// TODO Auto-generated method stub
		DiagramElement el = rotatedElements.get(0);
		DiagramDevice dev = (DiagramDevice)el;
		
		dev.setRotation(dev.getRotation()+(Math.PI/2*direction*(-1)));
		Frame.getInstance().getDesk().getSelectedFrame().repaint();
	}
	
}
