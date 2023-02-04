package commerce.commerce.repository;

import commerce.commerce.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
    String addNewUser = "INSERT INTO user(email, name, phone) values(:email, :name, :phone) ";
    @Modifying
    @Query(nativeQuery = true, value = addNewUser)
    public void setAddNewUser(@Param("email") String email, @Param("name") String name, @Param("phone") String phone);


    //Check existence of email and phone number
    String checkEmailPhone = "SELECT email, phone from user WHERE user.email = :email AND user.phone = :phone";
    @Query(nativeQuery = true, value = checkEmailPhone)
    List <User> getUserEmailPhone(@Param("email") String email, @Param("phone") String phone);
}
