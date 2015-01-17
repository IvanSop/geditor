package gui;



import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;

public class Desktop extends JDesktopPane {
	ClassLoader cl = this.getClass().getClassLoader();
	ImageIcon icon = new ImageIcon(cl.getResource("background2.jpg")); // 
    Image image = icon.getImage();

    ImageIcon icon2 = new ImageIcon(cl.getResource("logo2.png"));
    Image image2 = icon2.getImage();
    
  
	@Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(image,0,0,null);
        g.drawImage(image2,11*this.getWidth()/13,3*this.getHeight()/4,null);
    }
	
	
	public Desktop() {
		
		setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
		
	}
}
