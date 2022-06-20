package preproject.spring_boot.dao;


import preproject.spring_boot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> {
}
