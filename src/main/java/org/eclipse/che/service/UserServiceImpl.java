package org.eclipse.che.service;

import org.eclipse.che.dao.UserDAO;
import org.eclipse.che.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    UserDAO userDAO;
    
    @Override
    public List<User> getAllUsers(){        
        return userDAO.getAllUsers();        
    }
    
    @Override
    public boolean createUser(String usr){
        return userDAO.createUser(usr);
    }    
    
    @Override
    public boolean storeFile(MultipartFile file) {
        try{
         List<String> userList=readFromInputStream(file.getInputStream());

         for(String usr:userList){
             createUser(usr);
         }
         return true;
        }catch(IOException oie){
            oie.printStackTrace();
			return false;
         }
    }
    
    private List<String> readFromInputStream(InputStream inputStream) throws IOException {
        List<String> userList=new ArrayList<String>(); 
        BufferedReader br=null;
        try {
            br = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = br.readLine()) != null) {
                userList.add(line);
                }
            }
        finally{
            if(br!=null)
            br.close();
        }
          return userList;
    }
}
