package org.eclipse.che.dao;

import org.eclipse.che.domain.User;
import java.util.List;

public interface UserDAO {
    
    public List<User> getAllUsers();
    public boolean createUser(String usr);
}

