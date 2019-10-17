package com.codegym.casestudy.controller;

import com.codegym.casestudy.model.User;
import com.codegym.casestudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.logging.LoggingSystem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public ModelAndView listUser(){
        ModelAndView modelAndView = new ModelAndView("index", "users", userService.findAll());

        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("create","user",new  User());
        modelAndView.addObject("user", new User());
        return modelAndView;
    }
    @PostMapping("/save")
    public ModelAndView saveUser(@ModelAttribute("user") User user){
        userService.save(user);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("users", userService.findAll());
        modelAndView.addObject("message", "Create User successfully");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Optional<User> user = userService.findById(id);
        if (user != null){
            ModelAndView modelAndView = new ModelAndView("edit");
            modelAndView.addObject("user", user.get());
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView(("/error-404"));
            return modelAndView;
        }
    }
    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute User user){
        userService.save(user);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("user", user);
        modelAndView.addObject("message", "Update employ successfully");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteUserForm(@PathVariable Long id){
        Optional<User> user = userService.findById(id);
        if (user != null){
            ModelAndView modelAndView = new ModelAndView("delete");
            modelAndView.addObject("user",user.get());
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error-404");
            return modelAndView;
        }
    }
    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id){
        userService.remove(id);
        return "redirect:/user/index";
    }
    @GetMapping("/view/{id}")
    public ModelAndView showUser(@PathVariable Long id) {
        User user = userService.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("view","user",user);
        return modelAndView;
    }


}