package commerce.commerce.service;

import commerce.commerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public String loginUser(String email){
        String password = userRepository.loginUser(email);
        return password;
    }



}
