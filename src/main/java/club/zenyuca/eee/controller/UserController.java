package club.zenyuca.eee.controller;

import club.zenyuca.core.beans.Result;
import club.zenyuca.core.enums.ResultEnum;
import club.zenyuca.core.exception.EeeException;
import club.zenyuca.core.util.Const;
import club.zenyuca.core.util.ResultUtil;
import club.zenyuca.eee.beans.User;
import club.zenyuca.eee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(User user, HttpServletRequest request) {
        user.setLoginIP(request.getRemoteAddr());
        Result<User> loginResult = this.userService.login(user);
        if (ResultUtil.isSeccess(loginResult)) {
            User loginUser = loginResult.getData();
            request.getSession().setAttribute(Const.LOGIN_USER, loginUser);
        }
        return loginResult;
    }
}
