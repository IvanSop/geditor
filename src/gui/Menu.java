package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

import actions.AboutAction;
import actions.ActionManager;
import actions.CascadeWindowsAction;
import actions.ExitAction;
import actions.LassoZoomAction;
import actions.LoadAction;
import actions.NewDiaAction;
import actions.NewProjAction;
import actions.NextWindowAction;
import actions.PreviousWindowAction;
import actions.RedoAction;
import actions.SaveAction;
import actions.TileHorizontallyAction;
import actions.TileVerticallyAction;
import actions.UndoAction;
import actions.ZoomInAction;
import actions.ZoomOutAction;
import actions.ZoomToBestFitAction;

public class Menu extends JMenuBar {
	
	public Menu() {
		
		ClassLoader cl = this.getClass().getClassLoader();
		
		
		JMenu file = new JMenu("File");
		file.setMnemonic('f');
				
		JMenu edit = new JMenu("Edit");
		edit.setMnemonic('E');
		
		
		JMenu view = new JMenu("View");
		view.setMnemonic('v');
		
		JMenu window = new JMenu("Window");
		window.setMnemonic('w');
				
		JMenu help = new JMenu("Help");
		help.setMnemonic('h');
		/*
		// mozda i ovo
		
		UIManager.LookAndFeelInfo[] n=UIManager.getInstalledLookAndFeels();
						
		JMenu laf = new JMenu("Look and Feel");
		JMenuItem lafovi[] = new JMenuItem[n.length];
		
		
			//UIManager.LookAndFeelInfo[] x=UIManager.getInstalledLookAndFeels();
			
			for (int i=0;i<n.length;i++){
				//cmbLAF.addItem(laf[i].getClassName());
				//if (UIManager.getLookAndFeel().getName().equals(x[i].getName())){
					System.out.println(n[i].getName());
					lafovi[i] = new JMenuItem(n[i].getName());
					laf.add(lafovi[i]);
					//cmbLAF.setSelectedIndex(i);
				//}
			}
		
		
		
		// ===
		*/

		
		add(file);
		add(edit);
		add(view);
		add(window);
		add(help);
		
		file.add(ActionManager.getAction().getNewDiaAction());
		file.add(ActionManager.getAction().getNewProjAction());
		file.addSeparator();
		file.add(ActionManager.getAction().getSaveAction());
		file.add(ActionManager.getAction().getLoadAction());
		file.addSeparator();
		file.add(ActionManager.getAction().getExitAction());
		
		edit.add(ActionManager.getAction().getUndoAction());
		edit.add(ActionManager.getAction().getRedoAction());
		edit.add(ActionManager.getAction().getTrashAction());
		edit.addSeparator();
		edit.add(ActionManager.getAction().getDeleteAction());
		
		view.add(ActionManager.getAction().getZoomInAction());
		view.add(ActionManager.getAction().getZoomOutAction());
		view.add(ActionManager.getAction().getLassoZoomAction());
		view.add(ActionManager.getAction().getZoomToBestFitAction());
		view.addSeparator();
		//view.add(laf); // ??
		
		window.add(ActionManager.getAction().getCascadeWindowsAction());
		window.add(ActionManager.getAction().getTileVerticallyAction());
		window.add(ActionManager.getAction().getTileHorizontallyAction());
		window.add(ActionManager.getAction().getPreviousWindowAction());
		window.add(ActionManager.getAction().getNextWindowAction());
		
		help.add(ActionManager.getAction().getAboutAction());
		
		
		
	}

}
