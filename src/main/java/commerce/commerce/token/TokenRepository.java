package commerce.commerce.token;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface TokenRepository extends JpaRepository<Token, Long> {

    String getToken = "SELECT token.token from Token token" +
                      "INNER JOIN user user on user.id = token.id" +
                      "WHERE user.id = :id " +
                      "AND token.revoked = false AND token.expired = false";
    @Query(value = getToken)
    List<Token> findAllValidTokenUser(Long id);

    Optional<Token> findByToken(String token);
}
