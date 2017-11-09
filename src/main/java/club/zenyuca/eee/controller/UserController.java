package club.zenyuca.eee.controller;

import club.zenyuca.eee.beans.User;
import club.zenyuca.eee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(User user) {
        return "";
    }

    @GetMapping("/users")
    public List<User> users() {
        return this.userService.findAll(null);
    }

    @GetMapping("/user/{id}")
    public User user(@PathVariable Integer id) {
        return this.userService.loadByPK(id);
    }
}
