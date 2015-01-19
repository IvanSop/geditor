package states;

import elements.DiagramDevice;
import elements.DiagramElement;
import gui.Frame;
import gui.InternalFrame;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.Iterator;

import commands.MoveDeviceCommand;

@SuppressWarnings("serial")
public class MoveState extends State {
	private InternalFrame med;
	private double x = 0;
	private double y = 0;

	public MoveState(InternalFrame md) {
		med = md;

	}

	public void mouseDragged(MouseEvent e) {

		med.getFramework().setCursor(
				Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		Point2D lastPosition = e.getPoint();
		med.transformToUserSpace(lastPosition);

		double xx = med.getLastPosition().getX() - lastPosition.getX();
		double yy = med.getLastPosition().getY() - lastPosition.getY();
		// pomeranje elementa:
		Iterator<DiagramElement> it = med.getDiagram().getSelectionModel()
				.getSelectionListIterator();
		while (it.hasNext()) {
			DiagramElement element = it.next();
			if (element instanceof DiagramDevice) {

				DiagramDevice device = (DiagramDevice) element;
				Point2D newPosition = (Point2D) device.getPosition().clone();
				newPosition.setLocation(newPosition.getX() - xx,
						newPosition.getY() - yy);
				device.setPosition(newPosition);
					
			}
		}
		x = x - xx;
		y = y - yy;
		med.setLastPosition(lastPosition);
		med.updatePerformed(null);
		
		DiagramDevice dev = null;
			if(med.getDiagram().getSelectionModel().getSelectionListSize()==1) {
			dev = (DiagramDevice)((InternalFrame)Frame.getInstance().getDesk().getSelectedFrame()).getDiagram().getSelectionModel().getSelectionList().get(0);
			
			Frame.getInstance().getStatusBar().setDim("W:" + dev.getSize().width + " - H:" + dev.getSize().height);
			Frame.getInstance().getStatusBar().setElType(dev.getClass().getSimpleName());
			Frame.getInstance().getStatusBar().setElName(dev.getName());
			Frame.getInstance().getStatusBar().setPos("x: " + dev.getPosition().getX() + " , y: " + dev.getPosition().getY());
			} else {
				Frame.getInstance().getStatusBar().setDim("//");
				Frame.getInstance().getStatusBar().setElType("//");
				Frame.getInstance().getStatusBar().setElName("//");
				Frame.getInstance().getStatusBar().setPos("//");
			}
	}

	public void mouseReleased(MouseEvent e) {

		med.getCommandManager().addCommand(
				new MoveDeviceCommand(med.getDiagram().getModel(), med
						.getDiagram().getSelectionModel(), x, y));
		med.getFramework().setCursor(
				Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		x = 0;
		y = 0;
		Point2D lastPosition = e.getPoint();
		med.transformToUserSpace(lastPosition);
		med.setLastPosition(lastPosition);
		med.startSelectState();
	
	}
}
