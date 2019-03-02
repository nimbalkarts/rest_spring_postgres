package org.eclipse.che.controller;

import org.eclipse.che.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.eclipse.che.domain.User;

import java.util.List;

@RestController
public class UserResource {
    
    @Autowired
    UserService userService;
    
    @GetMapping(value="/users")
    public List<User>  getUsers() {
        return userService.getAllUsers();
    }
    
    @PostMapping("/uploadUser")
    public String uploadUser(@RequestParam("file") MultipartFile file){
        boolean flag=userService.storeFile(file);
        if(flag)
            return "User Uploaded Successfully";
        else return "Fail to upload users";
    }
}
