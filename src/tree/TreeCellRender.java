package tree;



import java.awt.Component;
import java.awt.Font;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

public class TreeCellRender extends DefaultTreeCellRenderer {
	public TreeCellRender() {
		
	}
	
	  public Component getTreeCellRendererComponent(
              JTree tree,
              Object value,
              boolean sel,
              boolean expanded,
              boolean leaf,
              int row,
              boolean hasFocus) {
                 
		  		super.getTreeCellRendererComponent(tree, value, sel,expanded, leaf, row,hasFocus);
		  		ClassLoader cl = this.getClass().getClassLoader();  
             
             if (value instanceof Diagram ) {
                 URL imageURL = cl.getResource("tdiagram.png");
                 Icon icon = null;
                 if (imageURL != null)                       
                     icon = new ImageIcon(imageURL);
                 setIcon(icon);
 
             } else if (value instanceof Project ) {
                 URL imageURL = cl.getResource("tproject.png");
                 Icon icon = null;
                 if (imageURL != null)                       
                     icon = new ImageIcon(imageURL);
                 setIcon(icon);
                   
            }
             
 
            return this;
}
	
	
	
}
