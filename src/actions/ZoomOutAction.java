package actions;

import gui.Frame;
import gui.InternalFrame;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public class ZoomOutAction extends AbstractAction {

	public ZoomOutAction() {
        ClassLoader cl = this.getClass().getClassLoader();
		
		
		putValue(NAME, "Zoom Out");
		putValue(SMALL_ICON, new ImageIcon(cl.getResource("zoomOut.png")));
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_SUBTRACT, ActionEvent.CTRL_MASK));
        putValue(ACTION_COMMAND_KEY, "Zoom Out");
        putValue(SHORT_DESCRIPTION, "Zoom Out");
		
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("Action [" + e.getActionCommand() + "] performed!");
        InternalFrame selF = (InternalFrame)Frame.getInstance().getDesk().getSelectedFrame();
		if (selF == null) return;
        
		// Radimo zoom u tački (diskretni zoom)
		// Prvo je potrebno da odredimo novo skaliranje 
		double newScaling = selF.getScaling();
			
							
				newScaling /= 1.2;
				
			
			
			
		
		// Zatim je potrebno da skaliranje održimo u intervalu [0.2, 5]
		if(newScaling < 0.2){
			newScaling = 0.2;
			
		}else if(newScaling > 5){
			newScaling = 5;
		}
		
		
		/* newScaling je novi parametar skaliranja (članovi m00 i m11 transformacione matrice)
		 * Prilikom skaliranja dolazi do pomeranja userspace koordinata na kojima se nalazi pokazivač miša.
		 * Da bi dobili ispravan Point zoom moramo izvršiti translaciju tako da poništimo "smicanje" usled skaliranja 
		 * tj. moramo postići da se userspace koordinate miša ne promene.
		 */
		double x = selF.getWidth()/2;
		double y = selF.getHeight()/2;
		
		
		Point2D oldPosition = new Point2D.Double(x,y);
		selF.transformToUserSpace(oldPosition);
		
		selF.setScaling(newScaling);
		selF.setupTransformation();

		
		Point2D newPosition = new Point2D.Double(x,y);
		selF.transformToUserSpace(newPosition);
		
		selF.setTranslateX(selF.getTranslateX()+newPosition.getX()-oldPosition.getX());
		selF.setTranslateY(selF.getTranslateY()+newPosition.getY()-oldPosition.getY());
		
		
		//translateX +=  newPosition.getX() - oldPosition.getX();
		//translateY += newPosition.getY() - oldPosition.getY();
               
		selF.setupTransformation();
		selF.repaint();
        
        
    }
}