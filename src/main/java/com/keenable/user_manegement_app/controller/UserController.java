package com.keenable.user_manegement_app.controller;
import com.keenable.user_manegement_app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.keenable.user_manegement_app.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register/{username}")
    public User registerUser(@PathVariable String username) {
        return userService.registerUser(username);
    }

    @PutMapping("/update/{username}")
    public User updateUser(@PathVariable String username, @RequestParam String newPassword) {
        return userService.updateUser(username, newPassword);
    }

    @DeleteMapping("/delete/{username}")
    public User deleteUser(@PathVariable String username) {
        return userService.deleteUser(username);
    }

    @GetMapping("/retrieve")
    public User retrieveUser(@RequestParam String password) {
        return userService.retrieveUser(password);
    }
}
