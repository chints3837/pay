import java.sql.*;

public class conn
{
	public Connection c;
	public Statement s;
	
	public conn()
	{
		try
		{
			c = DriverManager.getConnection("jdbc:mysql:///payrollnew","root","");
			s = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}