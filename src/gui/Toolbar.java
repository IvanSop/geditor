package gui;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import actions.ActionManager;

public class Toolbar extends JToolBar {

	public Toolbar() {
		super(SwingConstants.HORIZONTAL);
		setFloatable(false);
		ClassLoader cl = this.getClass().getClassLoader();
		
		BoxLayout box=new BoxLayout(this, BoxLayout.X_AXIS); 
		setLayout(box); 
		

		
		add(ActionManager.getAction().getNewDiaAction());
		add(ActionManager.getAction().getNewProjAction());
		addSeparator();
		add(ActionManager.getAction().getSaveAction());
		add(ActionManager.getAction().getLoadAction());
		addSeparator();
		//add(ActionManager.getAction().getExitAction());
		
		
		
		
		
		add(ActionManager.getAction().getUndoAction());
		add(ActionManager.getAction().getRedoAction());
		add(ActionManager.getAction().getTrashAction());
		add(ActionManager.getAction().getDeleteAction());
		addSeparator();
		
		add(ActionManager.getAction().getZoomInAction());
		add(ActionManager.getAction().getZoomOutAction());
		add(ActionManager.getAction().getLassoZoomAction());
		add(ActionManager.getAction().getZoomToBestFitAction());
		addSeparator();
		
		add(ActionManager.getAction().getCascadeWindowsAction());
		add(ActionManager.getAction().getTileVerticallyAction());
		add(ActionManager.getAction().getTileHorizontallyAction());
		add(ActionManager.getAction().getPreviousWindowAction());
		add(ActionManager.getAction().getNextWindowAction());
		
		addSeparator();
		add(ActionManager.getAction().getAboutAction());
		
		add(Box.createGlue());
		// ============================================================================================================
		JComboBox cmbLAF=new JComboBox();
		cmbLAF.setFocusable(false);
		cmbLAF.setMaximumSize(new Dimension(150, 24));
		cmbLAF.setPreferredSize(new Dimension(150, 24));
		cmbLAF.setSize(new Dimension(150, 24));
		cmbLAF.setMinimumSize(new Dimension(150, 24));
		final UIManager.LookAndFeelInfo[] laf=UIManager.getInstalledLookAndFeels();
		for (int i=0;i<laf.length;i++){
			cmbLAF.addItem(laf[i].getName());
			
			if (UIManager.getLookAndFeel().getName().equals(laf[i].getName())){
				//System.out.println(i);
				cmbLAF.setSelectedIndex(i);
			}
		}
		
		final String nazivi[] = new String[laf.length];
		
		for (int i=0;i<laf.length;i++){
		nazivi[i] = laf[i].getName();
		//System.out.println(nazivi[i]);
		}
		
		cmbLAF.addActionListener(new ActionListener(){
        
			
			public void actionPerformed(ActionEvent arg0) {
				String taj="xxx";
				//JComboBox cb = (JComboBox)arg0.getSource();
				for (int i=0;i<laf.length;i++) {
					//System.out.println(nazivi[i]);
					JComboBox cb = (JComboBox)arg0.getSource();
					//System.out.println("**"+(String)cb.getSelectedItem());
					if (((String)cb.getSelectedItem()).equals(nazivi[i]))
						taj = laf[i].getClassName();
				}
				//System.out.println(taj);	
				try {
					
					UIManager.setLookAndFeel(taj);
					SwingUtilities.updateComponentTreeUI(Frame.getInstance());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 


			}
			
			
		});
		
		add(new JLabel("Skin:"));
		add(cmbLAF);
		// ==============================================================================================================
						
	}
}
