package org.eclipse.che.dao;
import org.eclipse.che.domain.User;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{
    
    
    @Override
    public List<User> getAllUsers(){
        List<User> userList= new ArrayList<User>();
        try{
        Connection conn=ConnectionFactory.getConnection();
        
        Statement st= conn.createStatement();
        
        ResultSet rs=st.executeQuery("select * FROM Users");
        
        while(rs.next()){
            userList.add(new User(rs.getString("username")));
        }
        
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return userList;
        
    }
    
    @Override
    public boolean createUser(String usr){
        
        try{
            
            String sql="insert into users(username) values('"+usr+"')";
    
            Connection conn=ConnectionFactory.getConnection();        
            Statement st= conn.createStatement();
            int result=st.executeUpdate(sql);
            
            if(result>0)
            return true;
        
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return false;
    }
}
