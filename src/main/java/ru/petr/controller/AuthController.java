package ru.petr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.petr.entity.Session;
import ru.petr.entity.User;
import ru.petr.service.UserService;
import javax.validation.Valid;
import java.util.Objects;

@Controller
public class AuthController {
    private static final String BULLETIN_LIST_PATH = "redirect:/bulletin/list";
    private static final String AUTHORIZATION_JSP = "authorization";
    private static final String NOT_FOUND_USER = "Неправильный логин или пароль!";
    private static final String CREDENTIAL_KEY = "credential";
    @Autowired
    private UserService service;

    @Autowired
    private Session session;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @PostMapping("/authorization")
    public String verify(@Valid @ModelAttribute("user") User userFromRequest, BindingResult bindingResult, Model model) {
        String redirectResource = AUTHORIZATION_JSP;
        User userFromStore = service.findByEmailAndPassword(userFromRequest);
        if (!bindingResult.hasErrors()) {
            if (Objects.nonNull(userFromStore)) {
                session.setUserId(userFromStore.getId());
                redirectResource = BULLETIN_LIST_PATH;
            } else {
                model.addAttribute(CREDENTIAL_KEY, NOT_FOUND_USER);
            }
        }
        return redirectResource;
    }

    @GetMapping("/")
    public String welcomePage(Model model) {
        model.addAttribute("user", new User());
        return AUTHORIZATION_JSP;
    }
}
