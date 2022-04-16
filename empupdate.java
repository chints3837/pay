import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

//it will not display warning

@SuppressWarnings({"deprecation"})

class empupdate extends JFrame implements ActionListener,ItemListener
{	
	//1) Declaration
	
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	JTextField t1,t2,t3,t4,t5,t6;
	Choice c1,c4;
	JButton b1,b2,b3;
	
	empupdate()
	{
		super("Employee Update & Delete");
		setSize(600,600);
		setLocation(200,100);
		
		
		
		//setLayout(new FlowLayout());
		setLayout(null);
	
	//2) Memory allocation
		l1 = new JLabel("Select Employee");		
		l2 = new JLabel("Name");
		l3 = new JLabel("Gender");
		l4 = new JLabel("Address");
		l5 = new JLabel("State");
		l6 = new JLabel("City");
		l7 = new JLabel("Email id");
		l8 = new JLabel("Phone");
		
		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		t4 = new JTextField();
		t5 = new JTextField();
		t6 = new JTextField();
		
		c1 = new Choice();
				try
				{
					conn c = new conn();
					ResultSet rs = c.s.executeQuery("select * from employee");
					
					while(rs.next())
					{
						c1.add(rs.getString("id"));
					}
				}
				catch(Exception ae)
				{
					ae.printStackTrace();
				}
		
		c4 = new Choice();
		
		
		
		b1 = new JButton("Update");		b2 = new JButton("Delete");
		b3 = new JButton("Exit");
		
	//3) Add components to Frame
		
		add(l1);	add(l2);	add(l3);	add(l7);	
		add(l4);	add(l5);	add(l6);	add(l8);
		
		add(t1);	add(t2);	add(t3);
		add(t4);	add(t5);	add(t6);
		
		add(c1);	
		c4.add("Male");
		c4.add("Female");
		add(c4);
		
		add(b1);	add(b2);	add(b3);
		
		
		
	//4) SetBounds
		l1.setBounds(30,30,100,20);		c1.setBounds(200,30,100,20);
		l2.setBounds(30,70,100,20);		t1.setBounds(200,70,100,20);
		l3.setBounds(30,100,100,20);	c4.setBounds(200,100,100,20);
		l4.setBounds(30,140,100,20);	t2.setBounds(200,140,100,20);
		l5.setBounds(30,180,100,20);	t3.setBounds(200,180,100,20);
		l6.setBounds(30,210,100,20);	t4.setBounds(200,210,100,20);
		l7.setBounds(30,260,100,20);	t5.setBounds(200,260,100,20);
		l8.setBounds(30,300,100,20);	t6.setBounds(200,300,100,20);
		b1.setBounds(30,350,100,20);	b2.setBounds(200,350,100,20);
					
						b3.setBounds(115,390,100,20);
		
	//5) add Listeners
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		c1.addItemListener(this);
		//c4.addItemListener(this);
		
		
		
		t6.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				
					char c = e.getKeyChar();
					if(Character.isDigit(c) && t6.getText().length()<10)
					{
						super.keyTyped(e);		//optional
					}

					else{
						e.consume();
						Toolkit tk = Toolkit.getDefaultToolkit();
						tk.beep();
					}
			}
		});
		
		//For Email Validation
		
		//For Name Validation
		
		t1.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				char c = e.getKeyChar();
				if(Character.isLetter(c) && t1.getText().length()<30 || c == KeyEvent.VK_SPACE)
					super.keyTyped(e);		//optional
					else
					{
						e.consume();
						Toolkit tk = Toolkit.getDefaultToolkit();
						tk.beep();
					}
			}
		});
		
		t2.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				char c = e.getKeyChar();
				if(Character.isLetter(c) && t2.getText().length()<30 || c == KeyEvent.VK_SPACE)
					super.keyTyped(e);		//optional
					else
					{
						e.consume();
						Toolkit tk = Toolkit.getDefaultToolkit();
						tk.beep();
					}
			}
		});
		
		t3.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				char c = e.getKeyChar();
				if(Character.isLetter(c) && t3.getText().length()<15 || c == KeyEvent.VK_SPACE)
					super.keyTyped(e);		//optional
					else
					{
						e.consume();
						Toolkit tk = Toolkit.getDefaultToolkit();
						tk.beep();
					}
			}
		});
		
		t4.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				char c = e.getKeyChar();
				if(Character.isLetter(c) && t4.getText().length()<30 || c == KeyEvent.VK_SPACE)
					super.keyTyped(e);		//optional
					else
					{
						e.consume();
						Toolkit tk = Toolkit.getDefaultToolkit();
						tk.beep();
					}
			}
		});
		
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setVisible(true);
	}
		
		
	public void actionPerformed(ActionEvent be)
	{
		try
		{
		if(be.getSource()==b1)
		{
			if(t1.getText().length()==0 && t2.getText().length()==0 && t3.getText().length()==0 && t4.getText().length()==0 && t5.getText().length()==0 && t6.getText().length()==0)
			{
				JOptionPane.showMessageDialog(null,"All Field's Are Necessary !!!");
				t1.requestFocus();
			}
			else if(t1.getText().length()==0)
					{    
						JOptionPane.showMessageDialog(null, "Enter Name");
						t1.requestFocus();
					}
			else if(t2.getText().length()==0)
					{    
						JOptionPane.showMessageDialog(null, "Enter Address");
						t2.requestFocus();
					}
			else if(t3.getText().length()==0)
					{    
						JOptionPane.showMessageDialog(null, "Enter State");
						t3.requestFocus();
					}
			else if(t4.getText().length()==0)
					{    
						JOptionPane.showMessageDialog(null, "Enter City");
						t4.requestFocus();
					}
			else if(t5.getText().length()==0)
					{    
						JOptionPane.showMessageDialog(null, "Incorrect  E-Mail");
						t5.requestFocus();
					}
			else if(t6.getText().length() != 10)
					{    
						JOptionPane.showMessageDialog(null, "Enter Correct Contact Number");
						t6.requestFocus();
					}
			else
			{
            String n = t1.getText();
            String g = c4.getSelectedItem();
            String a = t2.getText();
            String s = t3.getText();
            String c = t4.getText();
            String er = t5.getText();
            String p = t6.getText();
            String qry = "update employee set name='"+n+"',gender='"+g+"',address='"+a+"',state='"+s+"',city='"+c+"',email='"+er+"',phone='"+p+"'   where id="+c1.getSelectedItem();
       
			
				conn c2 = new conn();
				c2.s.executeUpdate(qry);
				JOptionPane.showMessageDialog(null,"Employee Updated");
			}
		}
		if(be.getSource() == b2)
		{
			if(t1.getText().length()==0 && t2.getText().length()==0 && t3.getText().length()==0 && t4.getText().length()==0 && t5.getText().length()==0 && t6.getText().length()==0)
			{
				JOptionPane.showMessageDialog(null,"Please Select Employee !!!");
				c1.requestFocus();
			}
			else
			{
				conn c2 = new conn();
				c2.s.executeUpdate("delete from employee where id="+c1.getSelectedItem());
				JOptionPane.showMessageDialog(null,"Employee Deleted");
				c1.requestFocus();
				t1.setText(""); t2.setText(""); t3.setText("");
				t4.setText(""); t5.setText(""); t6.setText("");
			}
		}
		if(be.getSource() == b3)
		{
			dispose();
		}
		}
		catch(Exception sa)
			{
				sa.printStackTrace();
			}
	}
	
	
	public void itemStateChanged(ItemEvent ce)
	{
		try
		{
			
			conn c2 = new conn();
			ResultSet rs = c2.s.executeQuery("select * from employee where id="+c1.getSelectedItem());
			if(rs.next())
			{
				t1.setText(rs.getString("name"));
                t2.setText(rs.getString("address"));
				//c4.setSelectedItem(rs.getString("gender").toString());
                t3.setText(rs.getString("state"));
                t4.setText(rs.getString("city"));
                t5.setText(rs.getString("email"));
				t6.setText(rs.getString("phone"));
			}
			
		}
		catch(Exception d)
		{
			d.printStackTrace();
		}
		
	}
	

	public static void main(String args[])
	{
		new empupdate();
	}
}