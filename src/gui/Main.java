package gui;

import java.awt.SplashScreen;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class Main {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
	
	    
	    try {
	        for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
	            if ("Nimbus".equals(info.getName())) {
	                UIManager.setLookAndFeel(info.getClassName());
	                break;
	            }
	        }
	    } catch (Exception e) {
	       System.out.println("zzzzzzz"); // If Nimbus is not available, you can set the GUI to another look and feel.
	    }
	
	    
		Splash spl = new Splash();
		try {
		    Thread.sleep(1000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	        
	    
		Frame frame = Frame.getInstance();
		
	
		
		frame.setVisible(true);
		
		
		
		
	}

}
