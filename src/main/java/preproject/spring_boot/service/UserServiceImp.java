package preproject.spring_boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import preproject.spring_boot.dao.UserDAO;
import preproject.spring_boot.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImp(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    public void addUser(User user) {
        userDAO.save(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        userDAO.deleteById(id);
    }

    @Transactional
    public List<User> allUsers() {
        return userDAO.findAll();
    }

    @Transactional
    public User getUser(Long id) {
        return userDAO.getReferenceById(id);
    }
}
