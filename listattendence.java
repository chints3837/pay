import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.sql.*;
import java.util.*;

//it will not display warning

@SuppressWarnings({"deprecation"})

class listattendence extends JFrame 
{
	String colHeads[] = { "Date", "Id", "Attendance"};
	String data[][] = new String[15][7];
	String sql,name;
	JTable table;
	
	Connection cn;
	Statement stm;
	ResultSet rs;
	
	int r_cnt=0,i,per,rollNo;
			
			
		listattendence()
		{
			super("DB Connectivity & Search");
			setLocation(100,150);
			setSize(500,300);
			//setLayout(null);
			try
				{
					/*cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll","root","");	
					stm = cn.createStatement();*/
					
					conn c1 = new conn();
					
					rs = c1.s.executeQuery("select count(*) from atten");
					rs.next();
					r_cnt=rs.getInt(1);
					
					data= new String[r_cnt][7];
					
					rs = c1.s.executeQuery("select * from atten");
					while (rs.next())
					{
						data[i][0] = rs.getString(1);
						data[i][1] = rs.getString(2);
						data[i][2] = rs.getString(3);
						
						i++;
					}
					table = new JTable(data,colHeads);
					add(table);
					
					table.setEnabled(false);
					
					int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
					int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
					JScrollPane jsp = new JScrollPane(table, v, h);
					add(jsp);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				setVisible(true);
		}
		
	

		
	public static void main(String args[])
	{
		new listattendence();
	}
}

