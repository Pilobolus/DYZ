package tool;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBTool {

	private DataSource source;
	public static final DBTool INSTANCE = new DBTool();
	
	
	private DBTool() {
		Context ctx = null;
		
		try {
			
			ctx = new InitialContext();
			source = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
			
		} catch (NamingException ex) {
			ex.printStackTrace();
		} 
	}
	
	
	public Connection getConnection() throws SQLException {
		return source.getConnection();
	}
}
