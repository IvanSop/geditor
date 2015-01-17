package gui;

import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

public class SplitPane extends JSplitPane {
public SplitPane(JScrollPane levi,Desktop desni) {
	setOrientation(JSplitPane.HORIZONTAL_SPLIT);
	setLeftComponent(levi);
	setRightComponent(desni);
	setDividerLocation(200);

}
}
