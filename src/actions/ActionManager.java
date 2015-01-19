package actions;





public class ActionManager  {
	
	
	private AboutAction aboutAction = new AboutAction();
	private CascadeWindowsAction cascadeWindowsAction = new CascadeWindowsAction();
	private ExitAction exitAction = new ExitAction();
	private LassoZoomAction lassoZoomAction = new LassoZoomAction();
	private LoadAction loadAction = new LoadAction();
	private NewDiaAction newDiaAction = new NewDiaAction();
	private NewProjAction newProjAction = new NewProjAction();
	private NextWindowAction nextWindowAction = new NextWindowAction();
	private PreviousWindowAction previousWindowAction = new PreviousWindowAction();
	private RedoAction redoAction = new RedoAction();
	private SaveAction saveAction = new SaveAction();
	private TileHorizontallyAction tileHorizontallyAction = new TileHorizontallyAction();
	private TileVerticallyAction tileVerticallyAction = new TileVerticallyAction();
	private UndoAction undoAction = new UndoAction();
	private ZoomInAction zoomInAction = new ZoomInAction();
	private ZoomOutAction zoomOutAction = new ZoomOutAction();
	private ZoomToBestFitAction zoomToBestFitAction = new ZoomToBestFitAction();
	private DeleteAction deleteAction = new DeleteAction();
	private TrashAction trashAction = new TrashAction();
	private Rotate90ClockwiseAction rotate90ClockwiseAction = new Rotate90ClockwiseAction();
	private Rotate90CounterClockwiseAction rotate90CounterClockwiseAction  = new Rotate90CounterClockwiseAction();
	
	private PutRect putRect = new PutRect();
	private PutCircle putCircle = new PutCircle();
	private PutTriangle putTriangle = new PutTriangle();
	private SelectionAction selAction = new SelectionAction();
	private PutStar putStar = new PutStar();
	public ActionManager() {
		
	}
	
	private static ActionManager instance = null;
	
	public static ActionManager getAction() {
		if (instance == null) {
			instance = new ActionManager();
		}
		return instance;
	}

	public AboutAction getAboutAction() {
		return aboutAction;
	}

	public CascadeWindowsAction getCascadeWindowsAction() {
		return cascadeWindowsAction;
	}

	public ExitAction getExitAction() {
		return exitAction;
	}

	public LassoZoomAction getLassoZoomAction() {
		return lassoZoomAction;
	}

	public LoadAction getLoadAction() {
		return loadAction;
	}

	public NewDiaAction getNewDiaAction() {
		return newDiaAction;
	}

	public NewProjAction getNewProjAction() {
		return newProjAction;
	}

	public NextWindowAction getNextWindowAction() {
		return nextWindowAction;
	}

	public PreviousWindowAction getPreviousWindowAction() {
		return previousWindowAction;
	}

	public RedoAction getRedoAction() {
		return redoAction;
	}

	public SaveAction getSaveAction() {
		return saveAction;
	}

	public TileHorizontallyAction getTileHorizontallyAction() {
		return tileHorizontallyAction;
	}

	public TileVerticallyAction getTileVerticallyAction() {
		return tileVerticallyAction;
	}

	public UndoAction getUndoAction() {
		return undoAction;
	}

	public ZoomInAction getZoomInAction() {
		return zoomInAction;
	}

	public ZoomOutAction getZoomOutAction() {
		return zoomOutAction;
	}

	public ZoomToBestFitAction getZoomToBestFitAction() {
		return zoomToBestFitAction;
	}

	public DeleteAction getDeleteAction() {
		return deleteAction;
	}

	
	
	public TrashAction getTrashAction() {
		return trashAction;
	}

	public PutRect getPutRect() {
		return putRect;
	}

	public PutCircle getPutCircle() {
		return putCircle;
	}

	public PutTriangle getPutTriangle() {
		return putTriangle;
	}

	public SelectionAction getSelAction() {
		return selAction;
	}

	public PutStar getPutStar() {
		return putStar;
	}

	public Rotate90ClockwiseAction getRotate90ClockwiseAction() {
		return rotate90ClockwiseAction;
	}

	public Rotate90CounterClockwiseAction getRotate90CounterClockwiseAction() {
		return rotate90CounterClockwiseAction;
	}

	
}
