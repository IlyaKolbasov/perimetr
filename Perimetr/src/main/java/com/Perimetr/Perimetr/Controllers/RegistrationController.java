package com.Perimetr.Perimetr.Controllers;

import com.Perimetr.Perimetr.Model.Role;
import com.Perimetr.Perimetr.Model.Users;
import com.Perimetr.Perimetr.rep.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/Registration")
    public String registration()
    {
        return "Registration";
    }


    @PostMapping("/Registration")
    public String addUser(Users users, Map<String, Object> model)
    {
       Users usersFromDb =  userRepository.findByUsername(users.getUsername());
       if(usersFromDb !=null)
       {
           model.put("message","User exists");
           return "Registration";
       }
       users.setActive(true);
       users.setRoles(Collections.singleton(Role.User));

        userRepository.save(users);
        return"redirect:/login";
    }
}
