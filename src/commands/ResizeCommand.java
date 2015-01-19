package commands;

import java.util.ArrayList;

import models.DiagramModel;
import models.DiagramSelectionModel;

import elements.DiagramElement;

public class ResizeCommand extends AbstractCommand {

	ArrayList<DiagramElement> resizedElements=new ArrayList<DiagramElement>();
	private DiagramModel model;
	private DiagramSelectionModel dsm;
	
	
	public ResizeCommand(DiagramModel model, DiagramSelectionModel dsm,double x,double y) {
		this.model = model;
		this.dsm = dsm;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void doCommand() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void undoCommand() {
		// TODO Auto-generated method stub
		
	}

}
