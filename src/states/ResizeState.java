package states;

import elements.DiagramDevice;
import elements.DiagramElement;
import gui.Frame;
import gui.InternalFrame;
import gui.InternalFrame.Handle;

import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.Iterator;

@SuppressWarnings("serial")
public class ResizeState extends State{
	Handle handleInMotion=null;
	private InternalFrame med; 
	
	
	
	public ResizeState(InternalFrame md) {
	med = md;
	name = "Resize";
	}
	
	private void updateStatusBar() {
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
	
	
	
	public void mousePressed(MouseEvent e) {

	}
	
	public void mouseMoved(MouseEvent e) {
	}	

	public void mouseDragged(MouseEvent e) {

		Point2D position = e.getPoint();
		med.transformToUserSpace(position);
		if (handleInMotion==null){
			handleInMotion = med.getDeviceAndHandleForPoint(position);
		}
		if (handleInMotion!=null){
		
			
			DiagramDevice dev = null;
			if(med.getDiagram().getSelectionModel().getSelectionListSize()==1) {
			dev = (DiagramDevice)((InternalFrame)Frame.getInstance().getDesk().getSelectedFrame()).getDiagram().getSelectionModel().getSelectionList().get(0);
			
			
			//Iterator<DiagramElement> it = med.getDiagram().getSelectionModel().getSelectionListIterator();
			//while(it.hasNext()){
				
				//DiagramElement element =  it.next();
				//if (element instanceof DiagramDevice ){
					DiagramDevice device=dev;//(DiagramDevice) element;
					switch(handleInMotion.ordinal()){
					//southeast
					case 4:{	
						double deltaX=position.getX()-(device.getPosition().getX()+device.getSize().getWidth());
						double deltaY=position.getY()-(device.getPosition().getY()+device.getSize().getHeight());					
						double newWidth = device.getSize().getWidth()+deltaX;
						double newHeight = device.getSize().getHeight()+deltaY;
						double scaleX=newWidth/device.getInitSize().getWidth();
						double scaleY=newHeight/device.getInitSize().getHeight();
						double newScale = 1;
							if(scaleX<scaleY)
								newScale=scaleX;
							else
								newScale=scaleY;
						if(newScale<0.2)
							device.setScale(0.2);
						else if(newScale>5)
							device.setScale(5);
						else
							device.setScale(newScale);
						updateStatusBar();
						break;
					}
					
					
					case 5:{
						double deltaX=device.getPosition().getX() - position.getX();
						double deltaY=position.getY()-(device.getPosition().getY()+device.getSize().getHeight());				
						double newWidth = device.getSize().getWidth()+deltaX;
						double newHeight = device.getSize().getHeight()+deltaY;
						double scaleX=newWidth/device.getInitSize().getWidth();
						double scaleY=newHeight/device.getInitSize().getHeight();
						double newScale = 1;
						
						double oldHeight=device.getSize().getHeight();
						double oldWidth=device.getSize().getWidth();
						
						if(scaleX<scaleY){
								newScale=scaleX;
								
							}
							else{
								newScale=scaleY;
						
							}
						 
						if(newScale<0.2)
							device.setScale(0.2);
						else if(newScale>5)
							device.setScale(5);
						else
							device.setScale(newScale);
						
						newHeight=device.getSize().getHeight();
						newWidth=device.getSize().getWidth();
						
						deltaX=newWidth-oldWidth;
						deltaY=newHeight-oldHeight;
						
						device.setPosition(new Point2D.Double(device.getPosition().getX()-deltaX,device.getPosition().getY()));
						updateStatusBar();
						break;
					}
					
					
					
					
					
					
					case 6: {
						double deltaX=position.getX()-(device.getPosition().getX()+device.getSize().getWidth());
						double deltaY=(device.getPosition().getY()) - position.getY();					
						double newWidth = device.getSize().getWidth()+deltaX;
						double newHeight = device.getSize().getHeight()+deltaY;
						double scaleX=newWidth/device.getInitSize().getWidth();
						double scaleY=newHeight/device.getInitSize().getHeight();
						double newScale = 1;
						
						double oldHeight=device.getSize().getHeight();
						double oldWidth=device.getSize().getWidth();
						
						if(scaleX<scaleY){
								newScale=scaleX;
								
							}
							else{
								newScale=scaleY;
						
							}
						 
						if(newScale<0.2)
							device.setScale(0.2);
						else if(newScale>5)
							device.setScale(5);
						else
							device.setScale(newScale);
						
						newHeight=device.getSize().getHeight();
						newWidth=device.getSize().getWidth();
						
						deltaX=newWidth-oldWidth;
						deltaY=newHeight-oldHeight;
						
						device.setPosition(new Point2D.Double(device.getPosition().getX(),device.getPosition().getY()-deltaY));
						updateStatusBar();
						break;
					}
					
					case 7: {
						double deltaX=device.getPosition().getX() - position.getX();
						double deltaY=device.getPosition().getY() - position.getY();					
						double newWidth = device.getSize().getWidth()+deltaX;
						double newHeight = device.getSize().getHeight()+deltaY;
						double scaleX=newWidth/device.getInitSize().getWidth();
						double scaleY=newHeight/device.getInitSize().getHeight();
						double newScale = 1;
						
						double oldHeight=device.getSize().getHeight();
						double oldWidth=device.getSize().getWidth();
						
						if(scaleX<scaleY){
								newScale=scaleX;
								
							}
							else{
								newScale=scaleY;
						
							}
						 
						if(newScale<0.2)
							device.setScale(0.2);
						else if(newScale>5)
							device.setScale(5);
						else
							device.setScale(newScale);
						
						newHeight=device.getSize().getHeight();
						newWidth=device.getSize().getWidth();
						
						deltaX=newWidth-oldWidth;
						deltaY=newHeight-oldHeight;
						
						device.setPosition(new Point2D.Double(device.getPosition().getX()-deltaX,device.getPosition().getY()-deltaY));
						updateStatusBar();
						break;
					}
					
					
					
					}
				}
				med.updatePerformed(null);
			}
	
		}
	
	
	public void mouseReleased(MouseEvent e){
		handleInMotion=null;
		med.startSelectState();
	}
}
