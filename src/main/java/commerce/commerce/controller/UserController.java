package commerce.commerce.controller;

import commerce.commerce.model.User;
import commerce.commerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String setAddNewUser(@RequestBody User email, @RequestBody User name, @RequestBody User phone){
        userService.setAddNewUser(email.getEmail(), name.getName(), phone.getPhone());
        return "success fully registered";
    }
}
