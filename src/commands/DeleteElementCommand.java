package commands;

import java.awt.geom.Point2D;

import models.DiagramModel;
import models.DiagramSelectionModel;
import elements.CircleElement;
import elements.DiagramElement;
import elements.RectangleElement;
import elements.StarElement;
import elements.TriangleElement;
import gui.InternalFrame;

public class DeleteElementCommand extends AbstractCommand {
	DiagramModel model;
	Point2D lastPosition;
	DiagramElement device = null;
	DiagramSelectionModel selectionModel;
	int deviceType;
	
	//
	public DeleteElementCommand(DiagramModel model, DiagramSelectionModel selectionModel, Point2D lastPosition,int deviceType) {
		this.model = model;
		this.lastPosition = lastPosition;
		this.selectionModel = selectionModel;
		this.deviceType=deviceType;
		
		
	}

	@Override
	public void doCommand() {
		
		//	
	}

	@Override
	public void undoCommand() {
		//

	}

}
