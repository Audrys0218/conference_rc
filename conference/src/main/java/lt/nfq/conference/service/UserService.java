package lt.nfq.conference.service;

import lt.nfq.conference.domain.User;
import lt.nfq.conference.domain.UserRole;
import lt.nfq.conference.service.dao.UserMapper;
import lt.nfq.conference.service.dao.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Audrius
 * Date: 11/27/13
 * Time: 4:25 PM
 * To change this template use File | Settings | File Templates.
 */

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    public LinkedList<User> getUsers(){
        return userMapper.getUsers();
    }

    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }

    public User getUser(int id) {
        return userMapper.getUser(id);
    }

    public boolean updateUser(User user) {
        return userMapper.updateUser(user) > 0;
    }

    public void saveUser(User user) {
        if (user.getId() != null) {
            userMapper.updateUser(user);
        } else {
            userMapper.insertUser(user);
            System.out.println("=======================================");
            System.out.println(user.getId());
            UserRole userRole = new UserRole();
            userRole.setUser_id(user.getId());
            userRole.setAuthority("ROLE_USER");
            userRoleMapper.insertUserRole(userRole);
        }
    }
}
