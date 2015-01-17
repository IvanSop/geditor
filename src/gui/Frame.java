package gui;








import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import tree.Tree;
import tree.TreeModel;

import listeners.MainFrameListener;

public class Frame extends JFrame {

	
	
	private Toolbar toolbar = null;
	private Palette palette = null;
	private JScrollPane treeArea = null;
	private StatusBar statusBar = null;
	private Desktop desk = null;
	private Tree tree;
	private TreeModel treeModel;
	
	private ArrayList<InternalFrame> internalframes = new ArrayList<InternalFrame>();
	
	
	// ----------- 	
	
		private static Frame instance = null;
		
		private Frame () {
			
		}
		
		public static Frame getInstance() {
			if (instance == null) {
				instance = new Frame();
				instance.Init();
			}
			
			return instance;
		}
		
	// -----------
	
	
	
	public void Init() {
	
	this.setLayout(new BorderLayout());
    
    
	
	ClassLoader cl = this.getClass().getClassLoader();
	
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screenSize = kit.getScreenSize();
	int screenHeight = screenSize.height;
	int screenWidth = screenSize.width;
	setSize(3*screenWidth/4,3*screenHeight/4);
	setTitle("Geditor");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	addWindowListener(new MainFrameListener());
	ImageIcon frameIco = new ImageIcon(cl.getResource("frameicon.png"));
	setIconImage(frameIco.getImage());
		
	
	
	Menu menu = new Menu();
	setJMenuBar(menu);
	
	toolbar = new Toolbar();
	add(toolbar,BorderLayout.NORTH);
	
	palette = new Palette();
	add(palette,BorderLayout.EAST);
	
	
	
	tree = new Tree();
	treeModel = new TreeModel();
	tree.setModel(treeModel);
	
	treeArea = new JScrollPane(tree,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	
		
	desk = new Desktop();
	
	SplitPane splitPane = new SplitPane(treeArea,desk);
	this.add(splitPane,BorderLayout.CENTER);
			
	statusBar = new StatusBar();

	
	this.add(statusBar,BorderLayout.SOUTH);
	
	

	}

	public Desktop getDesk() {
		return desk;
	}

	public StatusBar getStatusBar() {
		return statusBar;
	}

	public Tree getTree() {
		return tree;
	}

	public TreeModel getWorkspaceModel() {
		return treeModel;
	}

	public ArrayList<InternalFrame> getInternalframes() {
		return internalframes;
	}

	public void setInternalframes(ArrayList<InternalFrame> internalframes) {
		this.internalframes = internalframes;
	}
	
	
}
