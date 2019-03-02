package org.eclipse.che.service;

import org.eclipse.che.domain.User;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

public interface UserService {
    
    public List<User> getAllUsers();
    public boolean createUser(String user);
    public boolean storeFile(MultipartFile file);
}
