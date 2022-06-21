package preproject.spring_boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import preproject.spring_boot.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImp {
    private final UserService userService;

    @Autowired
    public UserServiceImp(UserService userService) {
        this.userService = userService;
    }

    @Transactional
    public void addUser(User user) {
        userService.save(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        userService.deleteById(id);
    }

    @Transactional
    public List<User> allUsers() {
        return userService.findAll();
    }

    @Transactional
    public User getUser(Long id) {
        return userService.getReferenceById(id);
    }
}
