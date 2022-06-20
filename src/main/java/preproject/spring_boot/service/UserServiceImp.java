package preproject.spring_boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import preproject.spring_boot.dao.UserDAO;
import preproject.spring_boot.model.User;

import java.util.List;

@Service
public class UserServiceImp {
    private final UserDAO userDAO;

    @Autowired
    public UserServiceImp(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void addUser(User user) {
        userDAO.save(user);
    }


    public void deleteUser(Long id) {
        userDAO.deleteById(id);
    }

    public List<User> allUsers() {
        return userDAO.findAll();
    }

    public User getUser(Long id) {
        return userDAO.getReferenceById(id);
    }
}
