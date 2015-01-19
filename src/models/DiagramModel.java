package models;



import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.event.EventListenerList;

import elements.DiagramElement;
import event.UpdateEvent;
import event.UpdateListener;


/**
 * 
 * U sebi će sadržati kolekciju grafičkih elemenata
 * takođe će imati i podršku za tree view komponentu
 * @author ASCOM
 *
 */
public class DiagramModel implements Serializable {

	private static int count=0;
	private String name;
	
	protected ArrayList<DiagramElement> diagramElements =new ArrayList <DiagramElement>();
	
	transient EventListenerList listenerList = new EventListenerList();
	transient UpdateEvent updateEvent = null;
	 
	private Object readResolve(){
		listenerList = new EventListenerList();	
		return this;
	}	
	

	/**
	 * Pronalazi indeks elementa koji se nalazi na zadatim logičkim koordinatama
	 * @param point
	 * @return
	 */
	public int getDeviceAtPosition(Point point) {
		for(int i=getDeviceCount()-1;i>=0;i--){
			DiagramElement device = getDeviceAt(i);
			if(device.getPainter().isElementAt(point)){
				return i;
			}
		}
		return -1;
	}	
	
	public int getDeviceCount(){
		return diagramElements.size();
	}
	
	public DiagramElement getDeviceAt(int i){
		return diagramElements.get(i);
	}
	

	
	public int getElementAtPosition(Point point) {
		for(int i=getElementsCount()-1;i>=0;i--){
			DiagramElement element = getElementAt(i);
			if(element.getPainter().isElementAt(point)){
				return i;
			}
		}
		return -1;
	}
	
	
	public int getElementsCount(){
		return diagramElements.size();
	}
	
	public DiagramElement getElementAt(int i){
		return diagramElements.get(i);
	}
	
	public void removeElement(DiagramElement element){
		
		diagramElements.remove(element);
		fireUpdatePerformed();
	}		
	
	

	public static int getCount() {
		return count;
	}


	public static void setCount(int count) {
		DiagramModel.count = count;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}	
	public int getElementCount(){
		return diagramElements.size();
	}
	
	public Iterator<DiagramElement> getDeviceIterator(){
		return diagramElements.iterator();
	}
	
	public void addDiagramElements(DiagramElement device){
	
		diagramElements.add(device);
		fireUpdatePerformed();
	}	
	
	 public void addUpdateListener(UpdateListener l) {
	     listenerList.add(UpdateListener.class, l);
	 }

	 public void removeUpdateListener(UpdateListener l) {
	     listenerList.remove(UpdateListener.class, l);
	 }

	 public ArrayList<DiagramElement>  getDiagramElements() {
			return diagramElements;
	}

	 /**
	 * Javljamo svim listenerima da se dogaД‘aj desio 
	 */
	public void fireUpdatePerformed() {
	     // Guaranteed to return a non-null array
	     Object[] listeners = listenerList.getListenerList();
	     // Process the listeners last to first, notifying
	     // those that are interested in this event
	     for (int i = listeners.length-2; i>=0; i-=2) {
	         if (listeners[i]==UpdateListener.class) {
	            // Lazily create the event:
	             if (updateEvent == null)
	                 updateEvent = new UpdateEvent(this);
	             ((UpdateListener)listeners[i+1]).updatePerformed(updateEvent);
	            
	             
	         }
	     }
	 }	
	
}
