package actions;

import elements.DiagramDevice;
import elements.DiagramElement;
import gui.Frame;
import gui.InternalFrame;

import java.awt.event.ActionEvent;
import java.util.Iterator;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import commands.DeleteElementCommand;

public class TrashAction extends AbstractAction {
	public TrashAction() {
        ClassLoader cl = this.getClass().getClassLoader();
		
		
		putValue(NAME, "Delete element(s)");
		putValue(SMALL_ICON, new ImageIcon(cl.getResource("trash.png")));
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl K"));
        putValue(ACTION_COMMAND_KEY, "Trash");
        putValue(SHORT_DESCRIPTION, "Remove element(s)");
		setEnabled(true);
    }

public void actionPerformed(ActionEvent e) {
      System.out.println("mmm");
		InternalFrame view= (InternalFrame) Frame.getInstance().getDesk().getSelectedFrame();
		//view.startSelectState();
		if (view!=null) { 
			if (!view.getDiagram().getSelectionModel().getSelectionList().isEmpty() ){
				Iterator<DiagramElement > it=view.getDiagram().getSelectionModel().getSelectionListIterator();
				while (it.hasNext()){
					DiagramElement element=it.next();
					DiagramDevice dev = (DiagramDevice)element;
					view.getDiagram().getModel().removeElement(element);
					
				}
				view.getDiagram().getSelectionModel().removeAllFromSelectionList();
				
				
				Frame.getInstance().getStatusBar().setDim("//");
				Frame.getInstance().getStatusBar().setElType("//");
				Frame.getInstance().getStatusBar().setElName("//");
				Frame.getInstance().getStatusBar().setPos("//");
		
			}
		}
    	
}
        
          
       
       
    
}