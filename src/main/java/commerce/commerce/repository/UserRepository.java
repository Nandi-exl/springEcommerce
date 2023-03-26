package commerce.commerce.repository;

import commerce.commerce.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    String addNewUser = "INSERT INTO user(email, password, name, phone) VALUES(:email, :password, :name, :phone)";
    @Modifying
    @Query(nativeQuery = true, value = addNewUser)
    public void setAddNewUser(
            @Param("email") String email,
            @Param("password") String password,
            @Param("name") String name,
            @Param("phone") String phone);


    //Check existence of email and phone number
    String checkEmailPhone = "SELECT count(*) from user WHERE user.email = :email AND user.phone = :phone";
    @Query(nativeQuery = true, value = checkEmailPhone)
    public int getUserEmailPhone(@Param("email") String email, @Param("phone") String phone);

    //login check email password
    String loginUser = "SELECT password FROM user WHERE email = :email";
    @Query(nativeQuery = true, value = loginUser)
    public String loginUser(@Param("email") String email);

    //get user by id
    String aUser= "SELECT * FROM user where user.id = :id";
    @Query(nativeQuery = true, value = aUser)
    public List<User> getUserInfo(@Param("id") Long id);

    //update user information
    String updateUserInfo = "UPDATE user SET name=:name, email=:email, phone=:phone WHERE user.id = :id";
    @Query(nativeQuery = true, value = updateUserInfo)
    public String updateUser(
            @Param("name") String name,
            @Param("email") String email,
            @Param("phone") String phone,
            @Param("id") int id);

    //delete user
    String deleteUser = "Delete * from user WHERE user.id = :id";
    @Query(nativeQuery = true, value= deleteUser)
    public String userDeleted(@Param("id") Long id);

    //getUserName
    String getUserName = "SELECT * from user WHERE email = :email";
    @Query(nativeQuery = true, value = getUserName)
    public Optional<User> getUserNameByEmail(@Param("email") String email);






}
