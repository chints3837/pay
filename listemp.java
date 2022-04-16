import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.sql.*;
import java.util.*;

//it will not display warning

@SuppressWarnings({"deprecation"})

class listemp extends JFrame 
{
	String colHeads[] = {"Emp id","Name","Gender","Address","State","City","Email id","Phone"};
	String data[][] = new String[15][8];
	String sql,name;
	JTable table;
	
	Connection cn;
	Statement stm;
	ResultSet rs;
	
	int r_cnt=0,i;
			
			
		listemp()
		{
			super("DB Connectivity & Search");
			setLocation(100,150);
			setSize(1000,400);
			//setLayout(null);
			try
				{
					
					conn c1 = new conn();
					
					rs = c1.s.executeQuery("select count(*) from employee");
					rs.next();
					r_cnt=rs.getInt(1);
					
					data= new String[r_cnt][8];
					
					rs = c1.s.executeQuery("select * from employee");
					while (rs.next())
					{
						data[i][0] = rs.getString("id");
						data[i][1] = rs.getString("name");
						data[i][2] = rs.getString("gender");
						data[i][3] = rs.getString("address");
						data[i][4] = rs.getString("state");
						data[i][5] = rs.getString("city");
						data[i][6] = rs.getString("email");
						data[i][7] = rs.getString("phone");
						
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
		new listemp();
	}
}
/*
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class listemp extends JFrame implements ActionListener{
  
    JTable j1;
    JButton b1;
    String h[]={"Emp id","Name","Gender","Address","State","City","Email id","Phone"};
    String d[][]=new String[20][8];  
    int i=0,j=0;
    
    listemp()
	{
        super("View Employees");
        
        setSize(1000,400);
        setLocation(450,200);

        try{
            String q="select * from employee";
            conn c1=new conn();
            ResultSet rs=c1.s.executeQuery(q);
            while(rs.next()){
                // i = 0 j = 0
                d[i][j++]=rs.getString("id");
                d[i][j++]=rs.getString("name");
                d[i][j++]=rs.getString("gender");
                d[i][j++]=rs.getString("address");
                d[i][j++]=rs.getString("state");
                d[i][j++]=rs.getString("city");
                d[i][j++]=rs.getString("email");
                d[i][j++]=rs.getString("phone");
                i++;
                j=0;
            }
            j1=new JTable(d,h); 

        }
        catch(Exception e)
		{
			e.printStackTrace();
		}
        
        b1=new JButton("Print");
        
        JScrollPane s1=new JScrollPane(j1);
        
		add(b1,"South");
		add(s1);
        j1.setEnabled(false);
        b1.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
           j1.print();
        }catch(Exception e){}
    }
     
    public static void main(String s[]){
        new listemp().setVisible(true);
    }
}*/