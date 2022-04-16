import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

//it will not display warning

@SuppressWarnings({"deprecation"})

class salary extends JFrame implements ActionListener
{	
	//1) Declaration
	
	JTextField t1,t2,t3,t4,t5,t6;
	Font f;
	JButton b1,b2;
	Choice c1;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	
	
	salary()
	{
		super("Add Salary");
		setSize(600,600);
		setLocation(200,100);
		
		
		
		//setLayout(new FlowLayout());
		setLayout(null);
	
	//2) Memory allocation
			t1 = new JTextField();	t2 = new JTextField();	t3 = new JTextField();
			t4 = new JTextField();	t5 = new JTextField();	t6 = new JTextField();
			
			b1 = new JButton("Submit");		b2 = new JButton("Cancel");
			
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
		
			l1 = new JLabel("Select Emp no");	l2 = new JLabel("HRA");	l3 = new JLabel("DA");
			l4 = new JLabel("MED");	l5 = new JLabel("PF");	l6 = new JLabel("Basic Salary");
			l8 = new JLabel("Set Salary");
			
			
			
	//3) Add components to Frame
		add(t1);	add(t2);	add(t3);	add(t4);	add(t5);	add(t6);
		
		add(b1);	add(b2);
		
		
		add(c1);
		
		add(l1);	add(l2);	add(l3);	add(l4);	add(l5);	add(l6);
		
			add(l8);
		
		l8.setFont(new Font("Arial",Font.BOLD,25));
		
	//4) SetBounds
						l8.setBounds(80,10,600,30);
						
		l1.setBounds(100,70,100,20);	c1.setBounds(200,70,150,25);
		l2.setBounds(100,105,100,20);	t1.setBounds(200,105,150,30);
		l3.setBounds(100,145,100,20);	t2.setBounds(200,145,150,25);
		l4.setBounds(100,185,100,20);	t3.setBounds(200,185,150,25);
		l5.setBounds(100,225,100,20);	t4.setBounds(200,225,150,25);
		l6.setBounds(100,265,100,20);	t5.setBounds(200,265,150,25);
			//t6.setBounds(200,305,150,25);
		
		b1.setBounds(100,325,100,30);	b2.setBounds(250,325,100,30);
		
		
		
		/*				
		l5.setBounds();		l6.setBounds();		l7.setBounds();		l8.setBounds();
		
						
		t4.setBounds();		t5.setBounds();		t6.setBounds();
		
				
		*/
		
		
	//5) add Listeners
		
		b1.addActionListener(this);		b2.addActionListener(this);
		
		//c1.addActionListener(this);
		
		
		t1.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				
					char c = e.getKeyChar();
					if(Character.isDigit(c) && t1.getText().length()<6)
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
		
		t2.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				
					char c = e.getKeyChar();
					if(Character.isDigit(c) && t2.getText().length()<6)
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
		
		t3.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				
					char c = e.getKeyChar();
					if(Character.isDigit(c) && t3.getText().length()<6)
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
		
		t4.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				
					char c = e.getKeyChar();
					if(Character.isDigit(c) && t4.getText().length()<6)
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
		
		t5.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				
					char c = e.getKeyChar();
					if(Character.isDigit(c) && t5.getText().length()<6)
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
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setVisible(true);
	}
		
		
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			if(e.getSource() == b1)
			{
			if(t1.getText().length()==0 && t2.getText().length()==0 && t3.getText().length()==0 && t4.getText().length()==0 && t5.getText().length()==0)
			{
				JOptionPane.showMessageDialog(null,"All Fields Are Necessary...!!!");
			}
			else if(t1.getText().length()==0)
			{
				JOptionPane.showMessageDialog(null,"Enter Hra");
				t1.requestFocus();
			}
			else if(t2.getText().length()==0)
			{
				JOptionPane.showMessageDialog(null,"Enter DA");
				t2.requestFocus();
			}
			else if(t3.getText().length()==0)
			{
				JOptionPane.showMessageDialog(null,"Enter MED");
				t3.requestFocus();
			}
			else if(t4.getText().length()==0)
			{
				JOptionPane.showMessageDialog(null,"Enter PF");
				t4.requestFocus();
			}
			else if(t5.getText().length()==0)
			{
				JOptionPane.showMessageDialog(null,"Enter Basic Salary");
				t5.requestFocus();
			}
		else
		{
			String a = c1.getSelectedItem();
			String b = t1.getText();
			String c = t2.getText();
			String d = t3.getText();
			String hh = t4.getText();
			String f = t5.getText();
			
		String qry = "insert into salary values("+a+","+b+","+c+","+d+","+hh+","+f+")";
			
				conn c1 = new conn();
				c1.s.executeUpdate(qry);
				JOptionPane.showMessageDialog(null,"Salary Inserted");
			t1.setText("");t2.setText("");t3.setText("");t4.setText("");t5.setText("");
			t1.requestFocus();
		}
			}
		
		if(e.getSource() == b2)
		{
			dispose();
		}
		}
		catch(Exception ae)
			{
				ae.printStackTrace();
			}
	}

	public static void main(String args[])
	{
		new salary();
	}
}