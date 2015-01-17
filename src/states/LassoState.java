/**
 * 
 */
package states;

import elements.DiagramDevice;
import elements.DiagramElement;
import gui.Frame;
import gui.InternalFrame;

import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;


@SuppressWarnings("serial")
public class LassoState extends State {
	
	Rectangle2D rect=new Rectangle2D.Double();
	


	private InternalFrame med; 
	public LassoState(InternalFrame md) {
	med = md;
	}
	
	
	public void mouseDragged(MouseEvent e) {
		Point2D position=e.getPoint();
		med.transformToUserSpace(position);
		
		if(!e.isControlDown()){

			med.getDiagram().getSelectionModel().removeAllFromSelectionList();
		}
		
		double width=position.getX()-med.getLastPosition().getX();
		double height=position.getY()-med.getLastPosition().getY();
		if((width<0)&&(height<0)){
			rect.setRect(position.getX(), position.getY(),Math.abs(width),Math.abs(height));
		}
		else if((width<0)&&(height>=0)){
			rect.setRect(position.getX(), med.getLastPosition().getY(),Math.abs(width),Math.abs(height));
		}
		else if((width>0)&&(height<0)){
			rect.setRect(med.getLastPosition().getX(), position.getY(), Math.abs(width),Math.abs(height));
		}
		else{
			rect.setRect(med.getLastPosition().getX(), med.getLastPosition().getY(),Math.abs(width),Math.abs(height));
		}
		med.getDiagram().getSelectionModel().selectElements(rect, med.getDiagram().getModel().getDiagramElements());
		med.setSelectionRectangle(rect); 
		
		med.repaint();
		
	}

		public void mouseReleased(MouseEvent e) {		
		med.setSelectionRectangle(new Rectangle2D.Double(0,0,0,0));
		med.repaint();
		med.startSelectState();
		
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


}
