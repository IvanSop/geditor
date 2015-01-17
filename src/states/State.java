package states;

import java.awt.event.MouseEvent;
import java.io.Serializable;

public class State implements Serializable {
	//unija svih akcija koje se javljaju u svim konkretnim stanjima
	//ne moraju sve akcije da budu implementirane u svim stanjima
	protected String name;
	// ovde je mozda trebalo ono za cursore al ko ce ga sad
	public String getName() {
		return name;
	}
	public void mousePressed(MouseEvent e){}
	public void mouseDragged(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseMoved(MouseEvent e){} //
	
}
