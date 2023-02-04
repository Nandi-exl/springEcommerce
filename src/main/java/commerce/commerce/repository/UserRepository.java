package commerce.commerce.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UserRepository {
    String addNewUser = "INSERT INTO user(email, name, phone) values(:email, :name, :phone) ";
    @Modifying
    @Query(nativeQuery = true, value = addNewUser)
    public void setAddNewUser(@Param("email") String email, @Param("name") String name, @Param("phone") String phone);

}
