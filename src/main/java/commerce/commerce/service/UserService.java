package commerce.commerce.service;

import commerce.commerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public void setAddNewUser(String email, String name, String phone){userRepository.setAddNewUser(email,name,phone);}

    public String getUserEmailPhone(String email, String phone){userRepository.getUserEmailPhone(email, phone);
        if(email != "" || phone != ""){
            return "User already exist";
        }else{
            return "1";
        }
    }





}
