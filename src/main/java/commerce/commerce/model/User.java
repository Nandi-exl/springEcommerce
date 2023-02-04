package commerce.commerce.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;

@Entity
public class User {
    private Long id;
    private String name;
    private String email;
    private String phone;

    public User(){

    }

    public User(
            @JsonProperty("id") Long id,
            @JsonProperty("name") String name,
            @JsonProperty("email") String email,
            @JsonProperty("phone") String phone

    ){
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}
    public String getName(){return name;}
    public void setName(String name){this.name=name;}
    public String getEmail(){return email;}
    public void setEmail(String email){this.email = email;}
    public String getPhone(){return phone;}
    public void setPhone(String phone){this.phone = phone;}

}
