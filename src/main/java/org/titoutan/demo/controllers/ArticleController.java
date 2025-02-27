package org.titoutan.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.titoutan.demo.enums.Role;
import org.titoutan.demo.models.Article;
import org.titoutan.demo.models.User;
import org.titoutan.demo.repositories.ArticleRepository;
import org.titoutan.demo.repositories.UserRepository;

import java.time.LocalDate;


@Controller // This means that this class is a Controller
@RestController
@RequestMapping(path="/articles") // This means URL's start with /users (after Application path)
public class ArticleController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private ArticleRepository articleRepository;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestBody Article article) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        articleRepository.save(article);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Article> getAllUsers() {
        // This returns a JSON or XML with the users
        return articleRepository.findAll();
    }
}
