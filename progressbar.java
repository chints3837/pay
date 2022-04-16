import java.awt.*;
import javax.swing.*;

//it will not display warning

@SuppressWarnings({"deprecation"})

class progressbar extends JFrame implements Runnable
{
	JProgressBar pbar;
	JLabel l1;
	Thread t;
	int val=0;
	
	progressbar()
	{
			super("progressbar");
			
			setSize(600,100);
			setLocation(200,200);
			setLayout(null);
			
			l1 = new JLabel("Loading Please Wait...!!!");
			pbar = new JProgressBar();
			pbar.setValue(val);
			pbar.setStringPainted(true);
			
			add(pbar);	add(l1);
			pbar.setBounds(20,40,550,20);
			l1.setBounds(220,70,550,20);
			
			t = new Thread(this);
			t.start();	//call to run()
			
			setUndecorated(true);
			setVisible(true);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void run()
	{
		try
		{
			for(;;)
			{
				if(val==100)
				{
					//JOptionPane.showMessageDialog(null,"Loaded Successfully...!!!");
					new menu().setVisible(true);
					dispose();
					t.stop();
				}
				else
				{
					val = val+1;	// 
					pbar.setValue(val);
					Thread.sleep(50);		//time in miliseconds
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e); 	
		}
		
	}
	public static void main(String args[])
	{
		new progressbar();
	}
}