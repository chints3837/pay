import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//for hide warnings	
@SuppressWarnings("deprecation")

class newpay extends JFrame implements ActionListener,ItemListener
{
	//declaration
	JButton b1,b2;
	JTextArea t1;
	Choice ch1;
	JLabel l1,l2;
	DateButton dtb1,dtb2;
	
	int cnt;
	
	newpay()
	{
		super("PaySlip");
		setLocation(200,20);
		setSize(600,650);
		setLayout(null);
		setResizable(false);
		
		//memory allocation
		
		b1 = new JButton("Print");
		b2 = new JButton("Generate");
		
		t1 = new JTextArea();
		
		l1 = new JLabel("Start Date");
		l2 = new JLabel("End Date");
		
		ch1 = new Choice();
		try
		{
			conn c2 = new conn();
			String data = "select * from employee";
			
			ResultSet rsq = c2.s.executeQuery(data);
			
			while(rsq.next())
			{
				ch1.add(rsq.getString(1));
			}
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		
		dtb1 = new DateButton();
		dtb2 = new DateButton();
		
		//addcomponents
		
		add(b1); add(b2); add(t1); add(ch1);
		add(dtb1); add(dtb2);
		add(l1); add(l2);
		
		//setBounds
		
							ch1.setBounds(220,20,100,100);	
			
			l1.setBounds(80,20,100,100);	dtb1.setBounds(150,55,100,25);
			l2.setBounds(260,20,100,100);	dtb2.setBounds(320,55,100,25);
		
							t1.setBounds(10,100,570,400);
		
			b1.setBounds(130,570,300,30);	b2.setBounds(440,55,100,25);
		
		//addlisteners
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		ch1.addItemListener(this);
		
		t1.setEditable(false);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			if(e.getSource()==b2)
			{
				conn c = new conn();
				
				ResultSet rs = c.s.executeQuery(" select * from employee where id ="+ch1.getSelectedItem());
				rs.next();
				String name = rs.getString("name");
				rs.close();
				
				rs = c.s.executeQuery("select * from salary where id ="+ch1.getSelectedItem());
				double gross=0;
				double net =0;
				
				java.util.Date d1 = new java.util.Date();
				int month = d1.getMonth();
				
				t1.setText("	 ***************** Simple Payroll System *****************");
				t1.append("\n");
				t1.append("\n");
				t1.append(" 	***************** Pay Slip for the Month "+month+",2020 *****************");
				t1.append("\n");
				
				
				rs.next();
				
					t1.append(" 	Employee Id   :"+rs.getString("id"));
					t1.append("\n\n 	Employee Name :"+name);
					
					t1.append("\n 	**********************************************************************");
					t1.append("\n");
					
										
					double hra = rs.getDouble("hra");
					t1.append("\n 	HRA		:"+hra);
					
					double da = rs.getDouble("da");
					t1.append("\n 	DA		:"+da);
					
					double med = rs.getDouble("med");
					t1.append("\n 	MED		:"+med);
					
					double pf = rs.getDouble("pf");
					t1.append("\n 	PF		: "+pf);
					
					double basic = rs.getDouble("basic_salary");
					t1.append("\n 	Basic Salary		: "+basic);
					
					double dp = basic/30;
					
					gross = hra+da+med+pf;
					net = gross-pf;
					
					
					String count = "select COUNT(*) from atten where presenty='1' and jdate BETWEEN '"+dtb1.getText()+"' AND '"+dtb2.getText()+"' AND id='"+ch1.getSelectedItem()+"'";
					
					rs = c.s.executeQuery(count);
					rs.next();
					
					cnt = rs.getInt(1);
					double all = dp * cnt;
					double totalsal = all + net;
					
					t1.append("\n 	Gross Salary		:"+gross);
					t1.append("\n");
					
					t1.append("\n 	Total Present Days	:"+cnt);
					t1.append("\n");
					
					/*
					System.out.println(count);
					System.out.println(""+cnt);
					System.out.println(""+dp);
					System.out.println(""+net);
					System.out.println(""+gross);
					System.out.println(""+totalsal);
					*/
					
					t1.append("\n 	**********************************************************************");
				
					t1.append("\n 	Total Payable Salary	:"+totalsal);
					
					rs.close();				
					
					t1.append("\n 	**********************************************************************");
				
			}
			if(e.getSource()==b1)
			{
				t1.print();
			}
		}
		catch(Exception ew)
		{
			ew.printStackTrace();
		}
		
	}
	public void itemStateChanged(ItemEvent e)
	{}
	public static void main(String args[])
	{
		new newpay();
	}
}


/*

insert into atten values('2020-01-01',1,1),('2020-01-02',11,1),('2020-01-03',1,0),('2020-01-04',1,0),('2020-01-05',1,1),('2020-01-06',1,0),('2020-01-07',1,1),('2020-01-08',1,1),('2020-01-09',1,0),('2020-01-10',1,1),('2020-01-11',1,1),('2020-01-12',1,1),('2020-01-13',1,0),('2020-01-14',1,1),('2020-01-15',1,1),('2020-01-16',1,0),('2020-01-17',1,1),('2020-01-18',1,1),('2020-01-19',1,1),('2020-01-20',1,1),('2020-01-21',1,0),('2020-01-22',1,1),('2020-01-23',1,0),('2020-01-24',1,0),('2020-01-25',1,0),('2020-01-26',1,1),('2020-01-27',1,1),('2020-01-28',1,1),('2020-01-29',1,1),('2020-01-30',1,1);


select COUNT(*) from atten where presenty='1' and jdate BETWEEN '2020-01-01' AND '2020-01-30' AND id='11';

*/