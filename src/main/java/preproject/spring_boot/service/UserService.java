package preproject.spring_boot.service;

import preproject.spring_boot.model.User;
import java.util.List;

public interface UserService {

    public void addUser(User user);

    public void deleteUser(Long id);

    public List<User> allUsers();

    public User getUser(Long id);
}
