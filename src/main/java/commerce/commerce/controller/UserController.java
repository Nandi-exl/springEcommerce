package commerce.commerce.controller;

import commerce.commerce.model.User;
import commerce.commerce.repository.UserRepository;
import commerce.commerce.service.UserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String setAddNewUser(@RequestBody User newUser){
        // ResponseEntity<User> use this on function to return list new user in json format
        //can not let anything empty
        if (newUser.getEmail() == "" ||
            newUser.getPassword() == "" ||
            newUser.getName() == "" ||
            newUser.getPhone() == ""
           ){
            return "please don't leave any blank";
        }else {
            String userEmailPhone = userService.getUserEmailPhone(newUser.getEmail(), newUser.getPhone());
            String papper = "thePapperoni";
            String hashedPassword = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt()+papper);
            if(userEmailPhone == "0"){
                userService.setAddNewUser(newUser.getEmail(), hashedPassword, newUser.getName(), newUser.getPhone());
                return "successfully registered";
            }else {
                return "user Already exists";
            }
        }
    }

    //login user
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String userlogin(@RequestBody User user){

        String hashedPassword = userService.loginUser(user.getEmail());
        String passwordInput = user.getPassword();
        //decript hashed password
        if (BCrypt.checkpw(hashedPassword, passwordInput)){
            System.out.println("this is hashed password "+passwordInput);
            System.out.println("It matches");
            return "success login";
        }
        else{
            System.out.println("It does not match");
            return "invalid login";
        }

    }
}
