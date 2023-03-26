//package commerce.commerce.token;
//
//import com.fasterxml.jackson.annotation.JsonProperty;
//import commerce.commerce.model.User;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.hibernate.annotations.GenericGenerator;
//
//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//public class Token {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native") //auto increment id
//    @GenericGenerator(name="native", strategy = "native")
//    public Long id;
//
//    @Column(unique = true)
//    public String token;
//
//    @Enumerated(EnumType.STRING)
//    public TokenType tokenType = TokenType.BEARER;
//
//    public boolean revoked;
//
//    public boolean expired;
//
//
//}
