package eazybyts.Muktar.WellFit.controller;



import eazybyts.Muktar.WellFit.model.Users;
import eazybyts.Muktar.WellFit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public Users Register(@RequestBody Users user){

       return userService.createUser(user);
    }

    @PostMapping("/login")
    public String Login(@RequestBody Users user){
        return userService.verify(user);

    }

}
