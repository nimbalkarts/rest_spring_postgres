package org.eclipse.che.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    
    static	Connection connection = null;
    
    private ConnectionFactory(){        
        
    }
    
    static Connection getConnection(){
        if(connection==null){      
        try {    
    			Class.forName("org.postgresql.Driver");
    
    		} catch (ClassNotFoundException e) {    
    			System.out.println("Where is your PostgreSQL JDBC Driver? "
    					+ "Include in your library path!");
    			e.printStackTrace();
    			return null;    
    		}    
    		System.out.println("PostgreSQL JDBC Driver Registered!");
		try {
			connection = DriverManager.getConnection(
					"jdbc:postgresql://stampy.db.elephantsql.com:5432/zcxfobqy", "zcxfobqy","sY06qww_01TI7aB2ORFNBOg4zw9r_SBF");
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return null;
		}
		
	      return connection;
        }
        else {
            return connection;
        }
    }
}
