package gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class StatusBar extends JPanel {

	private JLabel state = new JLabel("State",SwingConstants.CENTER);
	private JLabel elType = new JLabel("Element type",SwingConstants.CENTER);
	private JLabel elName = new JLabel("Element name",SwingConstants.CENTER);
	private JLabel pos = new JLabel("Position",SwingConstants.CENTER);
	private JLabel dim = new JLabel("Dimension",SwingConstants.CENTER);
	
	public StatusBar() {
	
	setLayout(new GridLayout(1,5));
	
	// definisanje bordera
	Border raisedbevel,loweredbevel;
	raisedbevel = BorderFactory.createRaisedBevelBorder();
	loweredbevel = BorderFactory.createLoweredBevelBorder();
	//LineBorder roundedLineBorder = new LineBorder(Color.red, 2, true);
	
	this.setBorder(loweredbevel);
	
	
	
	//JLabel state = new JLabel("State",SwingConstants.CENTER);
	state.setBorder(BorderFactory.createCompoundBorder(loweredbevel,raisedbevel));
	
		
	//JLabel elType = new JLabel("Element type",SwingConstants.CENTER);
	elType.setBorder(BorderFactory.createCompoundBorder(loweredbevel,raisedbevel));

	
	
	//JLabel elName = new JLabel("Element name",SwingConstants.CENTER);
	elName.setBorder(BorderFactory.createCompoundBorder(loweredbevel,raisedbevel));
	
	
	//JLabel pos = new JLabel("Position",SwingConstants.CENTER);
	pos.setBorder(BorderFactory.createCompoundBorder(loweredbevel,raisedbevel));
	
	//JLabel dim = new JLabel("Dimension",SwingConstants.CENTER);
	dim.setBorder(BorderFactory.createCompoundBorder(loweredbevel,raisedbevel));
	
	add(state);
	add(elType);
	add(elName);
	add(pos);
	add(dim);
	
}

public void setState(String s) {
	state.setText(s);
}

public void setElType(String s) {
	elType.setText(s);
}

public void setElName(String s) {
	elName.setText(s);
}
	
public void setPos(String s) {
	pos.setText(s);
}
	
public void setDim(String s) {
	dim.setText(s);
}


}
