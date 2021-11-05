package com.Perimetr.Perimetr.Controllers;

import com.Perimetr.Perimetr.Model.Orders;
import com.Perimetr.Perimetr.Model.Post;
import com.Perimetr.Perimetr.rep.OrderRepository;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class OrderController {

        @GetMapping("SendOrder")
        public String Message(Model model) {

            return "SendOrder";
        }
    @Autowired
    private OrderRepository orderRepository;

       @PostMapping("/SendOrder")
        public String OrderSave(@RequestParam String name, @RequestParam String andres, @RequestParam String num,@RequestParam String dat, @RequestParam String full_text,  Model model) {
            Orders orders = new Orders(name, andres, num, dat, full_text);
            orderRepository.save(orders);// сохранение в бд
            return "redirect:/";// переадресовываем на страницу

        }

    @GetMapping("/Order")
    public String Order (Model model)
    {
        Iterable<Orders> orders=orderRepository.findAll();
        model.addAttribute("orders",orders);
        return "Order";
    }

    @GetMapping("/Order/{id}")
    public String OrderDetails(@PathVariable(value = "id") long id, Model model) {
        Optional<Orders> order =  orderRepository.findById(id);
        ArrayList<Orders> res = new ArrayList<>();
        order.ifPresent(res::add);
        model.addAttribute("Order",res);
        return "Order_details";
    }

   @PostMapping("/Order/{id}/remove")
    public String OrderDelete(@PathVariable(value = "id") long id, Model model) {

        Orders order=orderRepository.findById(id).orElseThrow(null);
        orderRepository.delete(order);//удаление в бд

        return "redirect:/Order";// переадресовываем на страницу

    }
}
