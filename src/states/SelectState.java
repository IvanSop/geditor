package states;

import elements.DiagramDevice;
import elements.DiagramElement;
import gui.Frame;
import gui.InternalFrame;
import gui.InternalFrame.Handle;
import gui.PropertyDialog;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

public class SelectState extends State{
	private InternalFrame med; //save the Mediator
	private int elementInMotion = -1;
	private Handle handleInMotion = null;
	private int mouseButton=0;

	public SelectState(InternalFrame md) {
		med = md;
		name ="Select";
	}



	public void mousePressed(MouseEvent e) {
		mouseButton=e.getButton();
		Point position = e.getPoint();
		med.transformToUserSpace(position);
		if (e.getButton()==MouseEvent.BUTTON1){

			handleInMotion = med.getDeviceAndHandleForPoint(position);
			if(handleInMotion == null){
				if(!e.isControlDown()){
					med.getDiagram().getSelectionModel().removeAllFromSelectionList();
					Frame.getInstance().getStatusBar().setDim("//");
					Frame.getInstance().getStatusBar().setElType("//");
					Frame.getInstance().getStatusBar().setElName("//");
					Frame.getInstance().getStatusBar().setPos("//");
				}




				elementInMotion = med.getDiagram().getModel().getElementAtPosition(position);
				if(elementInMotion != -1){
					//pogodjen je element, ukoliko je selektovan treba ga ukloniti iz liste,
					//ako nije treba ga dodati u listu
					DiagramElement element=med.getDiagram().getModel().getElementAt(elementInMotion);
					DiagramDevice dev = (DiagramDevice)element;

					if (med.getDiagram().getSelectionModel().isElementSelected(element)){
						med.getDiagram().getSelectionModel().removeFromSelectionList(element);
					}else{
						med.getDiagram().getSelectionModel().addToSelectionList(element);
						// sad ode mozda za statusbar
						//System.out.println(dev.getPosition().getX());
						if(med.getDiagram().getSelectionModel().getSelectionListSize()==1) {
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

				}else{
					//nije pogodjen nijedan element

				}
			} else {
				med.startResizeState();
			}
		}

		if(e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2) {
			System.out.println("LLLLLLL");

			if ( ((InternalFrame)Frame.getInstance().getDesk().getSelectedFrame()).getDiagram().getSelectionModel().getSelectionListSize()==1 && !e.isControlDown()) {
				PropertyDialog pd = new PropertyDialog();

				DiagramDevice tempdev = (DiagramDevice)((InternalFrame)Frame.getInstance().getDesk().getSelectedFrame()).getDiagram().getSelectionModel().getSelectionList().get(0);
				pd.setTitle(tempdev.getClass().getSimpleName());




				pd.setVisible(true);
			}

		}
	}

	public void mouseMoved(MouseEvent e) {
		Point2D point = e.getPoint();
		med.transformToUserSpace(point);
		med.setMouseCursor(point);

	}

	public void mouseDragged(MouseEvent e) {
		if(mouseButton == MouseEvent.BUTTON1){
			//vrši se povlačenje sa levim tasterom miša
			//provera da li je selektovan handle elementa, tada se radi resize elementa
			Point position = e.getPoint();
			med.transformToUserSpace(position);
			handleInMotion = med.getDeviceAndHandleForPoint(position);
			if(handleInMotion != null){
				med.startResizeState();
			}else{
				//nije selektovan handle, da li je selektovan element
				elementInMotion = med.getDiagram().getModel().getElementAtPosition(position);
				if(elementInMotion != -1){
					//selektovan je element ili grupa elemenata
					//preci u MoveState
					System.out.println("start move state --");//med.startMoveState();
					return;


				}else	//nije pogodjen element, prelazimo u Laso stanje
					med.startLassoState();	
			}
		}

	}
}
