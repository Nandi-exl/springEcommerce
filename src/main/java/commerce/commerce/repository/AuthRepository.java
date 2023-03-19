package commerce.commerce.repository;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import commerce.commerce.model.User;

public interface AuthRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);
}
