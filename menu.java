import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//it will not display warning

@SuppressWarnings({"deprecation"})

class menu extends JFrame implements ActionListener
{
	//Declaration
	
	JMenuBar mbr;
	JMenu m1,m2,m3,m4,m5;
	JMenuItem mi1,mi2,mi3,mi4,mi5,mi6,mi7,mi8,mi9,mi10,mi11,mi12;
	
	menu()
	{
		super("Menu bar");
		
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension d = t.getScreenSize();
		setSize(d.width,d.height-25);
		
		getContentPane().setBackground(Color.WHITE);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("myicon/33.jpg"));
        Image i2 = i1.getImage().getScaledInstance(2000,999,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        add(l1);
		
		//Memory Allocation
		
		mbr = new JMenuBar();
		
		m1 = new JMenu("Master");	m2 = new JMenu("Update");
		m3 = new JMenu("Report");	m4 = new JMenu("Utilities");
		m5 = new JMenu("Exit");
		
		mi1 = new JMenuItem("New Employee");		mi2 = new JMenuItem("Salary");	
		mi3 = new JMenuItem("List Employee");		mi4 = new JMenuItem("Update Salary");	
		mi5 = new JMenuItem("Update Employee");		mi6 = new JMenuItem("Take Attendance");	
		mi7 = new JMenuItem("List Attendance");		mi8 = new JMenuItem("Generate Pay Slip");
		mi9 = new JMenuItem("Notepad");				mi10 = new JMenuItem("Calculator");
		mi11 = new JMenuItem("Web Browser");		mi12 = new JMenuItem("Exit");
		
		//Add Components
		
		m1.add(mi1);	m1.add(mi2);	m1.add(mi3);
		mbr.add(m1);
		
		m2.add(mi4);	m2.add(mi5);	m2.add(mi6);
		mbr.add(m2);
		
		m3.add(mi7);	m3.add(mi8);	m3.add(mi9);
		mbr.add(m3);
		
		m4.add(mi9);	m4.add(mi10);	m4.add(mi11);
		mbr.add(m4);
		
		m5.add(mi12);	
		mbr.add(m5);
		
		
		mi1.setMnemonic('N');
		mi1.setFont(new Font("Arial",Font.BOLD,12));
		mi1.setIcon(new ImageIcon(ClassLoader.getSystemResource("Iconsdata/Icons/New.png")));
		
		
		mi2.setMnemonic('S');
		mi2.setFont(new Font("Arial",Font.BOLD,12));
		mi2.setIcon(new ImageIcon(ClassLoader.getSystemResource("Iconsdata/icon/schedreport.png")));
		
		mi3.setMnemonic('L');
		mi3.setFont(new Font("Arial",Font.BOLD,12));
		mi3.setIcon(new ImageIcon(ClassLoader.getSystemResource("Iconsdata/icon/newinvoice.png")));
		
		mi4.setMnemonic('U');
		mi4.setFont(new Font("Arial",Font.BOLD,12));
		mi4.setIcon(new ImageIcon(ClassLoader.getSystemResource("Iconsdata/Icons/EditOpen.png")));
		
		mi5.setMnemonic('P');
		mi5.setFont(new Font("Arial",Font.BOLD,12));
		mi5.setIcon(new ImageIcon(ClassLoader.getSystemResource("Iconsdata/icon/empreport.png")));
		
		mi6.setMnemonic('T');
		mi6.setFont(new Font("Arial",Font.BOLD,12));
		mi6.setIcon(new ImageIcon(ClassLoader.getSystemResource("Iconsdata/icon/EXPENSE.PNG")));
		
		mi7.setMnemonic('S');
		mi7.setFont(new Font("Arial",Font.BOLD,12));
		mi7.setIcon(new ImageIcon(ClassLoader.getSystemResource("Iconsdata/icon/payments.png")));
		
		mi8.setMnemonic('L');
		mi8.setFont(new Font("Arial",Font.BOLD,12));
		mi8.setIcon(new ImageIcon(ClassLoader.getSystemResource("Iconsdata/icon/empreport.png")));
		
		
		mi9.setFont(new Font("Arial",Font.BOLD,12));
		mi9.setIcon(new ImageIcon(ClassLoader.getSystemResource("Iconsdata/Icons/New.png")));
		
		
		mi10.setFont(new Font("Arial",Font.BOLD,12));
		mi10.setIcon(new ImageIcon(ClassLoader.getSystemResource("Iconsdata/icon/calc.png")));
		
		
		mi11.setFont(new Font("Arial",Font.BOLD,12));
		mi11.setIcon(new ImageIcon(ClassLoader.getSystemResource("Iconsdata/icon/explorer.jpg")));
		
		mi12.setMnemonic('E');
		mi12.setFont(new Font("Arial",Font.BOLD,12));
		mi12.setIcon(new ImageIcon(ClassLoader.getSystemResource("Iconsdata/icon/exit.PNG")));
		
		
		//Add Listeners
		
		mi1.addActionListener(this);
		mi2.addActionListener(this);
		mi3.addActionListener(this);
		mi4.addActionListener(this);
		mi5.addActionListener(this);
		mi6.addActionListener(this);
		mi7.addActionListener(this);
		mi8.addActionListener(this);
		mi9.addActionListener(this);
		mi10.addActionListener(this);
		mi11.addActionListener(this);
		mi12.addActionListener(this);
		
		setJMenuBar(mbr);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == mi1)
		{
			new newemployee();
		}
		if(e.getSource() == mi2)
		{
			new salary();
		}	
		if(e.getSource() == mi3)
		{
			new listemp().setVisible(true);
		}
		if(e.getSource() == mi4)
		{
			new update();
		}
		if(e.getSource() == mi5)
		{
			new empupdate();
		}
		if(e.getSource() == mi6)
		{
			new attendance1();
		}
		if(e.getSource() == mi7)
		{
			new listattendence();
		}
		if(e.getSource() == mi8)
		{
			new newpay();
		}
		if(e.getSource() == mi9)
		{
			try
			{
               Runtime.getRuntime().exec("notepad.exe");
            }
			catch(Exception ae)
			{
				
			}
		}
		if(e.getSource() == mi10)
		{
			try
			{
               Runtime.getRuntime().exec("calc.exe");
            }
			catch(Exception ae)
			{
				
			}
		}
		if(e.getSource() == mi11)
		{
			try
			{
               Runtime.getRuntime().exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
            }
			catch(Exception ae)
			{
				
			}
		}
		if(e.getSource() == mi12)
		{
			System.exit(0);
		}
	}
	public static void main(String args[])
	{
		new menu().setVisible(true);
	}
}