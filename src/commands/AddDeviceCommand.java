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


public class AddDeviceCommand extends AbstractCommand{

	DiagramModel model;
	Point2D lastPosition;
	DiagramElement device = null;
	DiagramSelectionModel selectionModel;
	int deviceType;
	

	public AddDeviceCommand(DiagramModel model, DiagramSelectionModel selectionModel, Point2D lastPosition,int deviceType) {
		this.model = model;
		this.lastPosition = lastPosition;
		this.selectionModel = selectionModel;
		this.deviceType=deviceType;
		
		
	}

	@Override
	public void doCommand() {
		if (device==null)
			if (deviceType==InternalFrame.CIRCLE){
				device=CircleElement.createDefault(lastPosition,model.getElementsCount());
			}else if (deviceType==InternalFrame.RECTANGLE){
				device=RectangleElement.createDefault(lastPosition,model.getElementsCount());
			}else if (deviceType==InternalFrame.TRIANGLE) {
				device=TriangleElement.createDefault(lastPosition, model.getElementsCount());
			}else if (deviceType==InternalFrame.STAR) {
				device=StarElement.createDefault(lastPosition, model.getElementsCount());
			}
			
		selectionModel.removeAllFromSelectionList();
		model.addDiagramElements(device); //	
		selectionModel.addToSelectionList(device);
			
	}

	@Override
	public void undoCommand() {
		selectionModel.removeAllFromSelectionList();
		model.removeElement(device);

	}

}
