package com.example.rbaclogin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @GetMapping("/")
    public String welcome(){
        return "Welcome!";
    }

    @GetMapping("/user")
    public String welcomeUser(){
        return "Welcome , User!";
    }

    @GetMapping("/admin")
    public String welcomeAdmin(){
        return "Welcome , Admin!";
    }

    @PostMapping("/post")
    public String loginPoint(@RequestBody Users users){
        if(myUserDetailsService.loadUserByUsername(users.getUserName()) == null){
            return "error";
        }else {
            return "Success";
        }
    }
}
