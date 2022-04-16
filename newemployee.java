import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

//it will not display warning

@SuppressWarnings({"deprecation"})

class newemployee extends JFrame implements ActionListener,ItemListener
{	
	//1) Declaration
	
	JTextField t1,t2,t3,t4,t5,t6;
	Font f;
	JButton b1,b2;
	Choice c1;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	
	
	newemployee()
	{
		super("Employee Entry");
		setSize(600,600);
		setLocation(200,100);
		
		//setLayout(new FlowLayout());
		setLayout(null);
		
		getContentPane().setBackground(Color.GRAY);
		
	//2) Memory allocation
			
			t1 = new JTextField();	t2 = new JTextField();	t3 = new JTextField();
			t4 = new JTextField();	t5 = new JTextField();	t6 = new JTextField();
			
			b1 = new JButton("Submit");		b2 = new JButton("Cancel");
			
			c1 = new Choice();
			
			l1 = new JLabel("Name");	l2 = new JLabel("Gender");	l3 = new JLabel("Address");
			l4 = new JLabel("State");	l5 = new JLabel("City");	l6 = new JLabel("Email");
			l7 = new JLabel("Contact No.");	l8 = new JLabel("Welcome Employee Registration System");
			
	//3) Add components to Frame
		
		add(t1);	add(t2);	add(t3);	add(t4);	add(t5);	add(t6);
		
		add(b1);	add(b2);
		
		c1.add("Male");		c1.add("Female");
		add(c1);
		
		add(l1);	add(l2);	add(l3);	add(l4);	add(l5);	add(l6);
		
		add(l7);	add(l8);
		
		l8.setFont(new Font("Arial",Font.BOLD,25));
		
	//4) SetBounds
						   l8.setBounds(80,10,600,30);
						
		l1.setBounds(100,70,100,20);	t1.setBounds(200,70,150,25);
		l2.setBounds(100,105,100,20);	c1.setBounds(200,105,150,30);
		l3.setBounds(100,145,100,20);	t2.setBounds(200,145,150,25);
		l4.setBounds(100,185,100,20);	t3.setBounds(200,185,150,25);
		l5.setBounds(100,225,100,20);	t4.setBounds(200,225,150,25);
		l6.setBounds(100,265,100,20);	t5.setBounds(200,265,150,25);
		l7.setBounds(100,305,100,20);	t6.setBounds(200,305,150,25);
		
		b1.setBounds(100,355,100,30);	b2.setBounds(250,355,100,30);
		
		
		
	//5) add Listeners
		
		b1.addActionListener(this);		b2.addActionListener(this);
		c1.addItemListener(this);
		
		//for Contact validation
		
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
		
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == b1)
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
					JOptionPane.showMessageDialog(null, "Incorrect Email E-Mail");
					t5.requestFocus();
				}
			else if(t6.getText().length() != 10)
				{    
					JOptionPane.showMessageDialog(null, "Enter Correct Contact Number");
					t6.requestFocus();
				}
			else
				{
					String a = t1.getText();
					String b = c1.getSelectedItem();
					String c = t2.getText();
					String d = t3.getText();
					String hh = t4.getText();
					String f = t5.getText();
					String g = t6.getText();
			
					String qry = "insert into employee values(null,'"+a+"','"+b+"','"+c+"','"+d+"','"+hh+"','"+f+"','"+g+"')";
					
					try
					{
						conn c1 = new conn();
						c1.s.executeUpdate(qry);
						
						JOptionPane.showMessageDialog(null,"Employee Inserted");
						t1.setText("");t2.setText("");t3.setText("");t4.setText("");
						t5.setText("");t6.setText("");
						t1.requestFocus();
					}
					catch(Exception ae)
					{
						ae.printStackTrace();
					}
			}
		}
		if(e.getSource() == b2)
		{
			dispose();
		}
	}
	public void itemStateChanged(ItemEvent er)
	{}

	public static void main(String args[])
	{
		new newemployee();
	}
}