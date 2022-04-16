import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

//it will not display warning

@SuppressWarnings({"deprecation"})

class Login extends JFrame implements ActionListener
{   
	JLabel l1,l2;
    JTextField t1;
    JPasswordField p1;
    JButton b1,b2;
    int cnt=3;

    Login()
    {   
		super("Login Page");
        setLayout(null);
        setSize(300,300);
        setLocation(380,250);
        setResizable(false);

        l1 = new JLabel("Login name ");
        l2 = new JLabel("Password ");

        t1 = new JTextField();
        p1 = new JPasswordField();

        b1 = new JButton("Login");
        b2 = new JButton("Exit");

        add(l1);    add(l2);   add(t1);
        add(p1);  add(b1);     add(b2);

        l1.setBounds(20,40,80,20);
        t1.setBounds(110,40,80,20);

        l2.setBounds(20,70,80,20);
        p1.setBounds(110,70,80,20);

        b1.setBounds(20,100,80,20);
        b2.setBounds(110,100,80,20);

        b1.setMnemonic('L');
        b2.setMnemonic('X');

        b1.addActionListener(this);
        b2.addActionListener(this);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e)
    {   
		if(e.getSource()==b1)
        {   
			try
			{
				conn c1 = new conn();
				String u = t1.getText();
				String v = p1.getText();
				String q = "select * from login where username='"+u+"' and password='"+v+"'";
				ResultSet rs = c1.s.executeQuery(q);
				
				
				if(rs.next())
				{
					new progressbar().setVisible(true);
					setVisible(false);
				}
				else if(t1.getText().length()==0 && p1.getText().length()==0)
					{   
						JOptionPane.showMessageDialog(null, "Enter User Name and Passward");
						t1.requestFocus();
					}
				else if(t1.getText().length()==0)
					{    
						JOptionPane.showMessageDialog(null, "Enter Login Name");
						t1.requestFocus();
					}
				else if(p1.getText().length()==0)
					{    
						JOptionPane.showMessageDialog(null, "Enter Password");
						p1.requestFocus();
					}
				else
				{
					cnt--;
					if(cnt>0)
					{
						JOptionPane.showMessageDialog(null,"Please Try Again ! " + cnt + " More Chance Remaining","Invalid Password !!!",JOptionPane.WARNING_MESSAGE);
						t1.setText("");    p1.setText("");       t1.requestFocus();
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Access Denied !!! ","Invalid Password !!!",JOptionPane.ERROR_MESSAGE);
						System.exit(0);
					}
				}

					
			}
				catch(Exception ae)
				{
					ae.printStackTrace();
				}
		}

		if(e.getSource()==b2)
		{
			System.exit(0);
		}
    }

    public static void main(String args[])
    {      
		new Login();
    }
}
