import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

//it will not display warning

@SuppressWarnings({"deprecation"})

class update extends JFrame implements ActionListener,ItemListener
{	
	//1) Declaration
	
	JLabel l1,l2,l3,l4,l5,l6;
	JTextField t1,t2,t3,t4,t5;
	Choice c1;
	JButton b1,b2,b3;
	
	update()
	{
		super("My Frame");
		setSize(600,600);
		setLocation(200,100);
		setLayout(null);
	
		//2) Memory allocation
		l1 = new JLabel("Select Employee");		
		l2 = new JLabel("HRA");
		l3 = new JLabel("DA");
		l4 = new JLabel("Med");
		l5 = new JLabel("PF");
		l6 = new JLabel("Basic Salary");
		
		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		t4 = new JTextField();
		t5 = new JTextField();
		
		c1 = new Choice();
				try
				{
					conn c = new conn();
					ResultSet rs = c.s.executeQuery("select * from salary");
					
					while(rs.next())
					{
						c1.add(rs.getString("id"));
					}
				}
				catch(Exception ae)
				{
					ae.printStackTrace();
				}
		
		b1 = new JButton("Update");		b2 = new JButton("Delete");
		b3 = new JButton("Cancel");
		
	//3) Add components to Frame
		
		add(l1);	add(l2);	add(l3);
		add(l4);	add(l5);	add(l6);
		
		add(t1);	add(t2);	add(t3);
		add(t4);	add(t5);
		
		add(c1);
		
		add(b1);	add(b2);	add(b3);
		
		
		
		
	//4) SetBounds
		l1.setBounds(30,30,100,20);		c1.setBounds(200,30,100,20);
		l2.setBounds(30,70,100,20);		t1.setBounds(200,70,100,20);
		l3.setBounds(30,100,100,20);	t2.setBounds(200,100,100,20);
		l4.setBounds(30,140,100,20);	t3.setBounds(200,140,100,20);
		l5.setBounds(30,180,100,20);	t4.setBounds(200,180,100,20);
		l6.setBounds(30,210,100,20);	t5.setBounds(200,210,100,20);
		
		b1.setBounds(30,270,100,20);	b2.setBounds(200,270,100,20);
						
						b3.setBounds(115,310,100,20);
	//5) add Listeners
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		c1.addItemListener(this);
	
		
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
		
	public void actionPerformed(ActionEvent be)
	{
		try
		{
			if(be.getSource() == b1)
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
					String hra = t1.getText();
					String id = c1.getSelectedItem();
					String da = t2.getText();
					String med = t3.getText();
					String pf = t4.getText();
					String basic = t5.getText();
			  
					String qry = "update salary set hra="+hra+",da="+da+",med="+med+",pf="+pf+",basic_salary="+basic+"  where id="+c1.getSelectedItem();
			   
					conn c2 = new conn();
					c2.s.executeUpdate(qry);
					JOptionPane.showMessageDialog(null,"Salary Updated");
				}
			}
			
			if(be.getSource() == b2)
			{
				conn c2 = new conn();
				c2.s.executeUpdate("delete from salary where id="+c1.getSelectedItem());
				JOptionPane.showMessageDialog(null,"Salary Deleted");
			}
			
			if(be.getSource() == b3)
			{
				dispose();
			}
		}
		catch(Exception e)
			{
				e.printStackTrace();
			}
	}
	
	
	public void itemStateChanged(ItemEvent ce)
	{
		try
		{
			conn c2 = new conn();
			ResultSet rs = c2.s.executeQuery("select * from salary where id="+c1.getSelectedItem());
			if(rs.next())
			{
				t1.setText(rs.getString("hra"));
                t2.setText(rs.getString("da"));
                t3.setText(rs.getString("med"));
                t4.setText(rs.getString("pf"));
                t5.setText(rs.getString("basic_salary"));
			}
		}
		catch(Exception e)
			{
				e.printStackTrace();
			}
	
		
	}
	

	public static void main(String args[])
	{
		new update();
	}
}