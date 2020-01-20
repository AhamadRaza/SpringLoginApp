package com.login.app.controller;
import com.login.app.model.UserInfo;
import com.login.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @Autowired private UserService userService;
    @GetMapping(value = "/")
    public String login(){
        return "redirect:/login";
    }

    @GetMapping(value = "/login")
    public String loginpage(){
        return "view/login";
    }

    @GetMapping(value = "/registration")
    public String registration(Model model){
        model.addAttribute("user", new UserInfo());
        return "view/registration";
    }

    @PostMapping(value = "/registration-process")
    public String registration(@ModelAttribute UserInfo userInfo){
        userService.save(userInfo);
        return "redirect:/login";
    }

    @PostMapping(value = "/dashboard")
    public String userDashbord(@ModelAttribute UserInfo user, Model model){
        UserInfo dbUser = userService.findByEmailAndPassword(user.getEmail(), user.getPassword());
        if(dbUser==dbUser && dbUser!=null) {
            model.addAttribute("user", dbUser);
            return "view/userdashboard";
        }
        else
            System.out.println(user.getEmail()+" " +user.getPassword());
            model.addAttribute("errormessage", "invalid email or password");
            return "view/login";
    }

    @GetMapping(value = "/logout")
    public String logoutsuccess(Model model){
        model.addAttribute("successmessage", "Logout Successfully");
        return "view/login";
    }
}