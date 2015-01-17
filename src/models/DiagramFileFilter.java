package models;

import java.io.File;

import javax.swing.filechooser.FileFilter;

// ne pripada tu
public class DiagramFileFilter extends FileFilter {

	@Override
	public String getDescription() {
		return "GrafEditor Project Files (*.gpf)";
	}

	@Override
	public boolean accept(File f) {
		return (f.isDirectory() || 
                f.getName().toLowerCase().endsWith(".gpf"));
	}

}
