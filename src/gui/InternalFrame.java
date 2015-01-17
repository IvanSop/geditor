package gui;


import java.awt.Adjustable;
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Dimension2D;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Iterator;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

import listeners.IFrameListener;
import painters.ElementPainter;
import states.StateManager;
import tree.Diagram;
import elements.DiagramDevice;
import elements.DiagramElement;
import event.UpdateEvent;
import event.UpdateListener;

public class InternalFrame extends JInternalFrame implements UpdateListener,AdjustmentListener {
	
	
	static int openFrameCount = 0;
	static final int xOffset = 30, yOffset = 30;
	
	private Diagram diagram;
	
	private JPanel framework;

	private JScrollBar sbVertical;
	private JScrollBar sbHorizontal;
	
	private int hScrollValue=1490;
	private int vScrollValue=1490;
	
	
	
	private StateManager stateManager=new StateManager(this);
	
	
	private Point2D lastPosition=null;
	private Rectangle2D selectionRectangle=new Rectangle2D.Double();
	
	double translateX = 0;
	double translateY = 0;
	double scaling = 1;
	final static double translateFactor = 10;
	final static double scalingFactor = 1.2;
	
	
	
	private AffineTransform transformation = new AffineTransform();
	
	
	
	// -- state manager
	
	public void startCircleState() {
		stateManager.setCircleState();
		}

    public void startSelectState() {
    	stateManager.setSelectState();
		}

    public void startRectangleState(){
    	stateManager.setRectangleState();
    }		
	
    public void startTriangleState() {
    	stateManager.setTriangleState();
    }
	
    public void startStarState() {
    	stateManager.setStarState();
    }
    
	public void startLassoState() {
		stateManager.setLassoState();
	}
    
    public StateManager getStateManager() {
		return stateManager;
	}
	
    public void startResizeState(){
    	stateManager.setResizeState();
    }
	// ----
	
	public enum Handle {
		North, South, East, West, SouthEast, SouthWest, NorthEast, NorthWest
	}
	static final int handleSize = 7;
	
	
	
		
	
	
	
	
	
	public static int getOpenFrameCount() {
		return openFrameCount;
	}


	public static void setOpenFrameCount(int openFrameCount) {
		InternalFrame.openFrameCount = openFrameCount;
	}


	public static int getXoffset() {
		return xOffset;
	}


	public static int getYoffset() {
		return yOffset;
	}


	public InternalFrame() {
		super("Diagram #" + (++openFrameCount),
		          true, //resizable
		          true, //closable
		          true, //maximizable
		          true);//iconifiable

		
		int width = Frame.getInstance().getDesk().getWidth()/2;
		int height = Frame.getInstance().getDesk().getHeight()/2;
		setSize(width,height);
		
		setLocation(xOffset*openFrameCount, yOffset*openFrameCount);
    	
		setVisible(true);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		addInternalFrameListener(new IFrameListener());
	
		 framework=new Framework();
		 framework.setBackground(Color.WHITE);
		
		 getContentPane().add(framework,BorderLayout.CENTER);
		
		sbHorizontal=new JScrollBar(JScrollBar.HORIZONTAL, hScrollValue, 20, 0, 3000);
		sbVertical=new JScrollBar(JScrollBar.VERTICAL, vScrollValue, 20, 0, 3000);

			
		sbHorizontal.addAdjustmentListener(this);
		sbVertical.addAdjustmentListener(this);
		
		this.add(sbHorizontal,BorderLayout.SOUTH);
		this.add(sbVertical,BorderLayout.EAST);
		 		 
		 DiagramController c=new DiagramController();
		framework.addMouseListener(c);
		framework.addMouseMotionListener(c);
		framework.addMouseWheelListener(c);
		
	}


	public JPanel getFramework() {
		return framework;
	}


	public Diagram getDiagram() {
		return diagram;
	}


	public void setDiagram(Diagram diagram) {
		this.diagram = diagram;
		setName(diagram.getName());
		setTitle(diagram.getName());
		this.diagram.getModel().addUpdateListener(this);
		this.diagram.getSelectionModel().addUpdateListener(this);
	}


	private class DiagramController extends MouseAdapter implements MouseMotionListener{

		public void mousePressed(MouseEvent e) {
			
			lastPosition=e.getPoint();
			transformToUserSpace(lastPosition);
			getStateManager().getCurrentState().mousePressed(e);
		}

		public void mouseReleased(MouseEvent e) {
			   getStateManager().getCurrentState().mouseReleased(e);
		}
		
		public void mouseDragged(MouseEvent e ){
			
				
			   getStateManager().getCurrentState().mouseDragged(e);
		}
		
		public void mouseMoved(MouseEvent e) {
			getStateManager().getCurrentState().mouseMoved(e); //
		}
	
	
	
		public void mouseWheelMoved(MouseWheelEvent e) {
			
			if((e.getModifiers()&MouseWheelEvent.CTRL_MASK) != 0){ // Ako pritisnut Ctrl
				// Radimo zoom u tački (diskretni zoom)
				// Prvo je potrebno da odredimo novo skaliranje 
				double newScaling = scaling;
				if(e.getWheelRotation()>0)
					
					newScaling /= (double)e.getWheelRotation()*scalingFactor;
				
				else{
					
					if (e.getWheelRotation()!=0){
						
						newScaling *= -(double)e.getWheelRotation()*scalingFactor;
						
					}
					
					
				}
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
				
				Point2D oldPosition = e.getPoint();
				transformToUserSpace(oldPosition);
				
				scaling = newScaling;
				setupTransformation();

				
				Point2D newPosition = e.getPoint();
				transformToUserSpace(newPosition);
				
				translateX +=  newPosition.getX() - oldPosition.getX();
				translateY += newPosition.getY() - oldPosition.getY();
	
				//setupTransformation();
				
				

			}else if((e.getModifiers()&MouseWheelEvent.SHIFT_MASK) != 0){  // Ako je pritisnut Shift
				
					translateX += (double)e.getWheelRotation() * translateFactor/scaling;
					
			}else{ // u ostalim slučajevima vršimo skrolovanje po Y osi
				
					translateY -= (double)e.getWheelRotation() * translateFactor/scaling;
				

				
			}
			
			setupTransformation();
			repaint();
		}
	
	
	
	
	
	
	
	
	
	
	
	
	}


	public void transformToUserSpace(Point2D deviceSpace){
		try {
			transformation.inverseTransform(deviceSpace, deviceSpace);
		} catch (NoninvertibleTransformException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updatePerformed(UpdateEvent e) {
		repaint();
		
	}
	
	
	
	private void setupTransformation() {
		
		transformation.setToIdentity();
		// Zumiranje
		
		transformation.scale(scaling, scaling);
		// Skrolovanje
		transformation.translate(translateX, translateY);
		
	}
		
	
	private class Framework extends JPanel{
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			Graphics2D g2 = (Graphics2D) g;
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			
			g2.transform(transformation);
			
			Iterator<DiagramElement> it = diagram.getModel().getDeviceIterator();
			while(it.hasNext()){
				DiagramElement element = it.next();
				ElementPainter painter =  element.getPainter();
				painter.paint(g2, element);
				
			}
			
			paintSelectionHandles(g2);
			
			//iscrtavanje pravougaonika za lasso
			g2.setColor(Color.BLACK);
			g2.setStroke(new BasicStroke((float)1, BasicStroke.CAP_SQUARE, 
					BasicStroke.JOIN_BEVEL, 1f, new float[]{(float)3, (float)6}, 0 ));
			g2.draw(selectionRectangle);			
		}

		}
	
	
	
	
	
	
	private void paintSelectionHandles(Graphics2D g2) {
		
		Iterator<DiagramElement> it = diagram.getSelectionModel().getSelectionListIterator();
		while(it.hasNext()){
			DiagramElement element =  it.next();
			if (element instanceof DiagramDevice){
				DiagramDevice device=(DiagramDevice)element;
				// Iscrtavanje pravougaonika sa isprekidanom linijom
				g2.setStroke(new BasicStroke((float)1, BasicStroke.CAP_SQUARE, 
						BasicStroke.JOIN_BEVEL, 1f, new float[]{3f, 6f}, 0 ));
				g2.setPaint(Color.BLACK);
			
				g2.drawRect((int)device.getPosition().getX(), (int)device.getPosition().getY(),
						(int)device.getSize().getWidth(), (int)device.getSize().getHeight());
			
				// 	Iscrtavanje hendlova
				for(Handle e: Handle.values()){
					paintSelectionHandle(g2, getHandlePoint(device.getPosition(), device.getSize(), e));
				}
			
			
			}else {
				//isrtavanje handlova za link
				/*LinkElement link=(LinkElement)element;
			

				Point2D bp=null;
				bp=link.getOutput().getPosition();
				g2.setPaint(Color.BLACK);
				g2.setStroke(new BasicStroke((float)2, BasicStroke.CAP_SQUARE, 
							BasicStroke.JOIN_BEVEL));
				
				g2.drawRect((int)bp.getX()-handleSize/2, (int)bp.getY()-handleSize/2,
						handleSize, handleSize);
	
				Iterator<Point2D> itp = link.getPointsIterator();
				while(itp.hasNext()){
					bp = (Point2D) itp.next();
					g2.drawRect((int)bp.getX()-handleSize/2, (int)bp.getY()-handleSize/2,
							handleSize, handleSize);
				
				}
				bp=link.getInput().getPosition();
				g2.drawRect((int)bp.getX()-handleSize/2, (int)bp.getY()-handleSize/2,
						handleSize, handleSize);*/
			}

		}
	}	
	
	
	
	private void paintSelectionHandle(Graphics2D g2, Point2D position){
		double size = handleSize;
		g2.fill(new Rectangle2D.Double(position.getX()-size/2, position.getY()-size/2, 
				size, size));	
	}
	
	
	private Point2D getHandlePoint(Point2D topLeft, Dimension2D size, Handle handlePosition ){
		double x=0, y=0;
		
		// Određivanje y koordinate
		
		// Ako su gornji hendlovi
		if(handlePosition == Handle.NorthWest || handlePosition == Handle.North || handlePosition == Handle.NorthEast){
			y = topLeft.getY();
		}
		// Ako su centralni po y osi
		if(handlePosition == Handle.East || handlePosition == Handle.West){
			y = topLeft.getY()+size.getHeight()/2;
		}
		//Ako su donji
		if(handlePosition == Handle.SouthWest || handlePosition == Handle.South || handlePosition == Handle.SouthEast){
			y = topLeft.getY() + size.getHeight();
		}

		// Određivanje x koordinate
		
		// Ako su levi
		if(handlePosition == Handle.NorthWest || handlePosition == Handle.West || handlePosition == Handle.SouthWest){
			x = topLeft.getX();
		}
		// ako su centralni po x osi
		if(handlePosition == Handle.North || handlePosition == Handle.South){
			x = topLeft.getX() + size.getWidth()/2;
		}
		// ako su desni
		if(handlePosition == Handle.NorthEast || handlePosition == Handle.East || handlePosition == Handle.SouthEast){
			x = topLeft.getX() + size.getWidth();
		}
		
		return new Point2D.Double(x,y);
		
	}
	
	
	public void setMouseCursor(Point2D point){
		
		Handle handle = getDeviceAndHandleForPoint(point);

		if(handle != null){
			Cursor cursor = null;
			
			switch(handle){
			case North: cursor = Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR);break;
			case South: cursor = Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR);break;
			case East: cursor = Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR);break;
			case West: cursor = Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR);break;
			case SouthEast: cursor = Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR);break;
			case NorthWest: cursor = Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR);break;
			case SouthWest: cursor = Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR);break;
			case NorthEast: cursor = Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR);break;
			}
			framework.setCursor(cursor);
		}
		else
			framework.setCursor(Cursor.getDefaultCursor());
	}
	
	
	public Handle getDeviceAndHandleForPoint(Point2D point){
		DiagramElement element;
		
		Iterator<DiagramElement> it = diagram.getSelectionModel().getSelectionListIterator();
		while(it.hasNext()){
			element = it.next();
			return getHandleForPoint(element, point);
		}
		return null;
	}
	
	
	private Handle getHandleForPoint(DiagramElement element, Point2D point){
		for(Handle h: Handle.values()){
			if(isPointInHandle(element, point, h)){
				return h;
			}
		}
		return null;
	}
	
	
	private boolean isPointInHandle(DiagramElement element, Point2D point, Handle handle){
		if (element instanceof DiagramDevice){
			DiagramDevice device=(DiagramDevice)element;
			Point2D handleCenter = getHandlePoint(device.getPosition(), device.getSize(), handle);
			return ( (Math.abs(point.getX()-handleCenter.getX())<=(double)handleSize/2) && 
					(Math.abs(point.getY()-handleCenter.getY())<=(double)handleSize/2) );
		}else 
			return false;
	}
	
	
	
	
	
	public Point2D getLastPosition() {
		return lastPosition;
	}

	public void setLastPosition(Point2D lastPosition) {
		this.lastPosition = lastPosition;
	}

	public Rectangle2D getSelectionRectangle() {
		return selectionRectangle;
	}

	public void setSelectionRectangle(Rectangle2D selectionRectangle) {
		this.selectionRectangle = selectionRectangle;
	}
	
	
	
	
	
	public void adjustmentValueChanged(AdjustmentEvent e) {
		// TODO Auto-generated method stub
		
		System.out.println(e.getValue());
		//Nakon određivanja vrednosti translateX i translateY potrebno je setovati novu transformaciju
		//uzeti u obzir koji je skrol bar pomeran (horizontalni ili vertikalni)
		//i u zavisnosti od prethodne pozicije datog skrol bara
		//i trenutnog skaliranja izvrsiti transformaciju translacije
		if (e.getAdjustable().getOrientation()==Adjustable.HORIZONTAL){
			//translateX
			
			translateX -=  e.getValue()-hScrollValue;
			hScrollValue  = e.getValue();
			setupTransformation();
			repaint();
		}
		else {
			//<translate Y
			translateY -=  e.getValue()-vScrollValue;
			vScrollValue  = e.getValue();
			setupTransformation();
			repaint();
		}
		

	}

	public AffineTransform getTransformation() {
		return transformation;
	}

	public void setTransformation(AffineTransform transformation) {
		this.transformation = transformation;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	


