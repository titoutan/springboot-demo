package org.titoutan.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.titoutan.demo.enums.Role;
import org.titoutan.demo.models.Article;
import org.titoutan.demo.models.User;
import org.titoutan.demo.repositories.UserRepository;

import java.util.Arrays;

@Controller // This means that this class is a Controller
@RestController
@RequestMapping(path="/users") // This means URL's start with /users (after Application path)
public class UserController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private UserRepository userRepository;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestBody User user) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        userRepository.save(user);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    // @GetMapping(path="/articles")
    // public @ResponseBody Iterable<Article> getAllArticles(@RequestParam User user) {
    //     return user.getArticles();
    // }
}
