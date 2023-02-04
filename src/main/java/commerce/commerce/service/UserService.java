package commerce.commerce.service;

import commerce.commerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public void setAddNewUser(String email, String name, String phone){userRepository.setAddNewUser(email,name,phone);}
}
