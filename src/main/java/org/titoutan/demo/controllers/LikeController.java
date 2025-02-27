package org.titoutan.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.titoutan.demo.models.Article;
import org.titoutan.demo.models.Liked;
import org.titoutan.demo.models.User;
import org.titoutan.demo.repositories.LikedRepository;

@Controller // This means that this class is a Controller
@RestController
@RequestMapping(path="/likes") // This means URL's start with /users (after Application path)
public class LikeController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private LikedRepository likedRepository;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestBody Liked liked) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        likedRepository.save(liked);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Liked> getAllUsers() {
        // This returns a JSON or XML with the users
        return likedRepository.findAll();
    }
}
