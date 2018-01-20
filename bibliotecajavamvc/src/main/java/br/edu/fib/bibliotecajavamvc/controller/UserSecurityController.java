package br.edu.fib.bibliotecajavamvc.controller;

import br.edu.fib.bibliotecajavamvc.model.Usuario;
import br.edu.fib.bibliotecajavamvc.security.SecurityService;
import br.edu.fib.bibliotecajavamvc.service.IUsuarioService;
import br.edu.fib.bibliotecajavamvc.validator.LoginValidator;
import br.edu.fib.bibliotecajavamvc.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user-security")
public class UserSecurityController {

    @Autowired
    private IUsuarioService userService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private LoginValidator loginValidator;

    @Autowired
    private SecurityService securityService;

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("/user-security/form", "userForm", new Usuario());
    }

    @PostMapping("/autentication")
    public ModelAndView autentication(@ModelAttribute("userForm") Usuario userForm, BindingResult bindingResult, Model model) {

        loginValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return login();
        }

        securityService.login(userForm.getUsername(), userForm.getPassword());
        return new ModelAndView("redirect:/index");
    }

    @GetMapping(value = "/registration")
    public ModelAndView registration() {

        return new ModelAndView("/user-security/registration", "userForm", new Usuario());
    }

    @PostMapping(value = "/registration")
    public ModelAndView registrationform(@ModelAttribute("userForm") Usuario userForm, BindingResult bindingResult, Model model) {

        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return new ModelAndView("/user-security/registration");
        }

        String password = userForm.getPassword();

        userService.save(userForm);

        try {

            securityService.login(userForm.getUsername(), password);
            return new ModelAndView("redirect:/user/list");

        } catch (Exception e) {

            return new ModelAndView("redirect:/user/login");
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        SecurityContextHolder.clearContext();
        if (session != null) {
            session.invalidate();
        }

        return "redirect:/user-security/login";
    }

}
