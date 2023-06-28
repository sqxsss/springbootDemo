package com.example.springbootdemo.controller;

import com.example.springbootdemo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "nvsoftware";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User user(){
        User user = new User();
        user.setId("1234");
        user.setName("nvsoftware");
        user.setEmail("info@nvsoftware.net");

        return user;
    }

    // path variable
    @GetMapping("/user/{id}/{username}")
    public User userByPathVariable(@PathVariable String id, @PathVariable("username") String name){
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setEmail("info@nvsoftware.net");

        return user;
    }

    @GetMapping("/userrequest")
    public User userByRequest(@RequestParam String id,
                              @RequestParam("username") String name,
                              @RequestParam(required = false, defaultValue = "") String email){
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setEmail(email);

        return user;
    }
}
