import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

//it will not display warning

@SuppressWarnings({"deprecation"})

class attendance1 extends JFrame implements ActionListener
{
	//Declaration
	JLabel l1;
	JCheckBox cb[];
    JPanel p1;
	JButton load,selall,unselall,submt,b3;
	DateButton dtbtn;
	ArrayList al;
	
	int cnt = 0;
	String da;
	
	attendance1()
	{
		super("Attendence Form");
		setSize(600,600);
		setLocation(100,100);
		setLayout(null);
		
		//memory allocation
		l1 = 	new JLabel("Select Date");
		
		load = 		new JButton("LOAD");
		selall = 	new JButton("Select All");
		unselall = 	new JButton("Unselect All");
		submt = 	new JButton("Submit");
		b3 = 		new JButton("Exit");
		
		dtbtn = 	new DateButton();
		
		al = 		new ArrayList();
		
		p1 = 		new JPanel();
        
		add(p1);
		p1.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		
		//add components
		add(l1);	add(dtbtn);
		add(load);	add(selall);	add(unselall);	add(submt);	add(b3);
		
		add(p1);
		
		
		//setBounds
		
		l1.setBounds(160,20,100,50);		dtbtn.setBounds(250,30,100,30);
		load.setBounds(200,70,100,30);
		selall.setBounds(300,430,100,30);	unselall.setBounds(420,430,130,30);
		submt.setBounds(300,470,100,30);	b3.setBounds(420,470,100,30);
		
		p1.setBounds(100,120,450,300);
		
		//Add Listeners
		load.addActionListener(this);
		selall.addActionListener(this);
		unselall.addActionListener(this);
		submt.addActionListener(this);
		b3.addActionListener(this);
		
		//setMnemonic's
		
		load.setMnemonic('L');	selall.setMnemonic('A');	unselall.setMnemonic('U');
		submt.setMnemonic('S');	b3.setMnemonic('E');
		
		//for take attendance with checkbox using employee id
		try
		{
			conn c2 = new conn();
			ResultSet rs = c2.s.executeQuery("select count(*) from employee");
			rs.next();
			cnt = rs.getInt(1);
			
			p1.setLayout(new GridLayout(cnt,1,5,5));
			
			cb = new JCheckBox[cnt];
							
			rs = c2.s.executeQuery("select * from employee");
			for(int i=0;rs.next();i++)
			{
				cb[i] = new JCheckBox(rs.getString(1));
				al.add(i,rs.getString("id")); 
				p1.add(cb[i]);
			}
		}
		catch(Exception en)
		{
			en.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			if(e.getSource()==selall)
			{
				for(int i=0;i<cnt;i++)
					cb[i].setSelected(true);
			}
			if(e.getSource()==unselall)
			{
				for(int i=0;i<cnt;i++)
					cb[i].setSelected(false);
			}
			if(e.getSource()==submt)
			{
				conn cnn = new conn();
				String sql;
				
				String date1 = dtbtn.getText();
				//String date = dtbtn.getText();
				
				for(int i=0;i<cnt;i++)
				{
					if(cb[i].isSelected())
						da = "insert into atten values('"+date1+"','"+cb[i].getText()+"','1')";
						
					else
						da = "insert into atten values('"+date1+"','"+cb[i].getText()+"','0')";
						
						cnn.s.executeUpdate(da);
						
				}
				JOptionPane.showMessageDialog(null,"Record Inserted...");
			}
			if(e.getSource()==b3)
			{
				dispose();
			}
		}
		
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	public static void main(String args[])
	{
		new attendance1();
	}
}