package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;


    	
       // super(f);
        //ClassLoader cl = this.getClass().getClassLoader();
       // JLabel l = new JLabel(new ImageIcon(cl.getResource("logo2.png")));


class Splash extends JWindow
{
    public Splash()
    {
        //super(f);
    	
    	ClassLoader cl = this.getClass().getClassLoader();
    	JLabel l = new JLabel(new ImageIcon(cl.getResource("logo.jpg")));
    	l.setBorder(BorderFactory.createLineBorder(Color.black));
    	//setAlwaysOnTop(true);
        getContentPane().add(l, BorderLayout.CENTER);
        pack();
        Dimension screenSize =
          Toolkit.getDefaultToolkit().getScreenSize();
        Dimension labelSize = l.getPreferredSize();
        setLocation(screenSize.width/8 - (labelSize.width/8),
                    screenSize.height/4 - (labelSize.height/4));
        setLocationRelativeTo(null);

        final int pause = 1000;
        final Runnable closerRunner = new Runnable()
            {
                public void run()
                {
                    setVisible(false);
                   
                    dispose();
                }
            };
        Runnable waitRunner = new Runnable()
            {
                public void run()
                {
                    try
                        {
                            Thread.sleep(pause);
                            SwingUtilities.invokeAndWait(closerRunner);
                        }
                    catch(Exception e)
                        {
                            e.printStackTrace();
                            // can catch InvocationTargetException
                            // can catch InterruptedException
                        }
                }
            };
        setVisible(true);
        Thread splashThread = new Thread(waitRunner, "SplashThread");
        splashThread.start();
    }
}