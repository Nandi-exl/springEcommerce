package commerce.commerce.service;

import commerce.commerce.model.User;
import commerce.commerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    //Register
    public void setAddNewUser( String email, String password, String name, String phone){userRepository.setAddNewUser(email,password,name,phone);}

    //check existing user
    public String getUserEmailPhone(String email, String phone){
        int total = userRepository.getUserEmailPhone(email, phone);
        if (total >= 1){
            return "1";
        }else{
            return "0";
        }
    }

    //login
    public String loginUser(String email){
        String password = userRepository.loginUser(email);
        return password;
    }

    //get specific user by id
    public List<User> getUser(Long id) {
        List<User> getUser = userRepository.getUserInfo(id);
        return getUser;
    }

    //updateUSer
    public String updateUserInfo(Long id, String email, String name, String phone, String password){
        return "";
    }

    //getUserbyemail
    public List<User> getUserName(String email){
        List<User> userEmail = userRepository.getUserNameByEmail(email);
        return userEmail;
    }

}
