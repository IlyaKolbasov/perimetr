package com.Perimetr.Perimetr.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {

    @GetMapping("/Cart")
    public String Cart(Model model)
    {


        return "Cart";
    }
}
