package com.Perimetr.Perimetr.Controllers;

import com.Perimetr.Perimetr.Model.Post;
import com.Perimetr.Perimetr.rep.PostRepository;
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
public class CamController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/Cameras")
    public String Cameras(Model model)
    {
        Iterable<Post> posts=postRepository.findAll();
        model.addAttribute("posts",posts);
        return "Cameras";
    }

    @Controller
    public class AddPost {
        @GetMapping("AddPost")
        public String postAdd(Model model) {

            return "AddPost";
        }

        @PostMapping("/AddPost")
        public String PostAdd(@RequestParam String title, @RequestParam String anons, @RequestParam String url, @RequestParam String full_text, @RequestParam int price, Model model) {
            Post post = new Post(title, anons, full_text, url, price);
            postRepository.save(post);// сохранение в бд
            return "redirect:/Cameras";// переадресовываем на страницу блог

        }
        @GetMapping("/Cameras/{id}")
        public String CameraDetails(@PathVariable(value = "id") long id, Model model) {
          Optional<Post> post =  postRepository.findById(id);
            ArrayList<Post> res = new ArrayList<>();
            post.ifPresent(res::add);
            model.addAttribute("post",res);
            return "Camera_detailss";
        }
    }
}
