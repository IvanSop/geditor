package gui;

import elements.DiagramDevice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Paint;
import java.awt.PaintContext;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.ColorModel;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PropertyDialog extends JDialog implements ActionListener {
	
	JTextField namef;
	JTextArea ta;
	JColorChooser cc = new JColorChooser();
	
	
	
	public PropertyDialog() {
	setSize(800,700);
	setLocationRelativeTo(Frame.getInstance());
	setModal(true);
	setResizable(false);
	
	setLayout(new BorderLayout());
	
	JPanel sever = new JPanel();
	JLabel namelb = new JLabel("Name: ");
	JLabel deslb = new JLabel("Description: ");
	namef = new JTextField();
	namef.setText(((InternalFrame)Frame.getInstance().getDesk().getSelectedFrame()).getDiagram().getSelectionModel().getSelectionList().get(0).getName());
	namef.selectAll();
	//JColorChooser cc = new JColorChooser();
	DiagramDevice tempdevice = (DiagramDevice)((InternalFrame)Frame.getInstance().getDesk().getSelectedFrame()).getDiagram().getSelectionModel().getSelectionList().get(0);
	cc.setColor((Color)tempdevice.getPaint());
	ta = new JTextArea();
	ta.setPreferredSize(new Dimension(500,120));
	
	ta.setText(((InternalFrame)Frame.getInstance().getDesk().getSelectedFrame()).getDiagram().getSelectionModel().getSelectionList().get(0).getDescription());
	
	
	JPanel jug = new JPanel();
	JButton ok = new JButton("OK");
	JButton cancel = new JButton("Cancel");
	ok.addActionListener(this);
	cancel.addActionListener(this);
	ok.setActionCommand("confirm");
	cancel.setActionCommand("discard");
	
	jug.add(ok);
	jug.add(cancel);
	
	JPanel kont1 = new JPanel();
	kont1.add(namelb);
	
	JPanel kont2 = new JPanel();
	kont2.add(deslb);
	
	BoxLayout box = new BoxLayout(sever, BoxLayout.Y_AXIS);
	sever.setLayout(box);
	

	sever.add(kont1);
	sever.add(Box.createGlue());
	sever.add(namef);
	sever.add(kont2);
	sever.add(Box.createGlue());
	sever.add(ta);
	
	
	add(sever,BorderLayout.NORTH);
	add(cc,BorderLayout.CENTER);
	add(jug,BorderLayout.SOUTH);
	
	
	
	
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//System.out.println(e.getActionCommand());
		if (e.getActionCommand().equals("confirm")) {
			//System.out.println("potvrda");
			// odje
			((InternalFrame)Frame.getInstance().getDesk().getSelectedFrame()).getDiagram().getSelectionModel().getSelectionList().get(0).setName(namef.getText());
			((InternalFrame)Frame.getInstance().getDesk().getSelectedFrame()).getDiagram().getSelectionModel().getSelectionList().get(0).setDescription(ta.getText());
			((InternalFrame)Frame.getInstance().getDesk().getSelectedFrame()).getDiagram().getModel().fireUpdatePerformed();
			
			((InternalFrame)Frame.getInstance().getDesk().getSelectedFrame()).getDiagram().getSelectionModel().getSelectionList().get(0).setPaint(cc.getColor());
			
			
			//DiagramDevice tempdev = (DiagramDevice)((InternalFrame)Frame.getInstance().getDesk().getSelectedFrame()).getDiagram().getSelectionModel().getSelectionList().get(0);
			//tempdev.getPainter
			
			dispose();
						
		} else {
			//System.out.println("cancl");
			dispose();
		}
		
	}
	
}
