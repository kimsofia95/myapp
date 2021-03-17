package app.web.controller;

import app.service.UserService;
import app.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;

@Controller
public class UsersController {
    @Autowired
    private UserService userService;

    @Transactional
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView printUsers() {
        userService.addUsers();
        userService.getAllUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users");
        modelAndView.addObject("usersList", userService.getAllUsers());
        return modelAndView;
    }
}
