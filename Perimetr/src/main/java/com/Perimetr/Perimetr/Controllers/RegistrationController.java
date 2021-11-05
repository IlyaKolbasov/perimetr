package com.Perimetr.Perimetr.Controllers;

import com.Perimetr.Perimetr.Model.Role;
import com.Perimetr.Perimetr.Model.User;
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
    public String addUser(User user, Map<String, Object> model)
    {
       User userFromDb =  userRepository.findByUsername(user.getUsername());
       if(userFromDb!=null)
       {
           model.put("message","User exists");
           return "Registration";
       }
       user.setActive(true);
       user.setRoles(Collections.singleton(Role.User));

        userRepository.save(user);
        return"redirect:/login";
    }
}
