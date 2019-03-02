package org.eclipse.che.domain;

public class User {
    private String userName;
    
    public User(){}
    
     public User(String usr){
         this.userName=usr;
     }
    
    public String  getUserName(){
        return userName;
    }
    
    public void  setUserName(String usrName){
        this.userName=usrName;
    }
}
