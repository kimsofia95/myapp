package app.web.controller;

import app.service.UserService;
import app.service.UserServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsersController {
    private UserServiceImp userServiceImp = new UserServiceImp();

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView printUsers() {
        userServiceImp.addUsers();
        userServiceImp.getAllUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users");
        modelAndView.addObject("usersList", userServiceImp.getAllUsers());
        return modelAndView;
    }
}
