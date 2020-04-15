package ru.petr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.petr.entity.Bulletin;
import ru.petr.entity.Session;
import ru.petr.service.BulletinService;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/bulletin")
public class BulletinController {
    private static final String FORM = "form_bulletin";
    private static final String DETAILS_PAGE = "bulletin_details_page";
    private static final String LIST_PAGE = "bulletin_list";
    private static final String URI_LIST = "redirect:/bulletin/list";
    private static final String PERMISSION_KEY = "permissionDeleteBulletin";
    private static final String BULLETINS_ATTRIBUTE = "bulletins";
    private static final String SINGLE_BULLETIN_ATTRIBUTE = "bulletin";
    private static final int EMPTY_LIST = 0;
    private static final String ID_PARAM = "id";
    @Autowired
    private Session session;

    @Autowired
    private BulletinService service;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/list")
    public String showAllBulletin(Model model) {
        model.addAttribute(BULLETINS_ATTRIBUTE, service.getBulletins());
        return LIST_PAGE;
    }

    @GetMapping("/details")
    public String showDetailsPage(@RequestParam(ID_PARAM) int bulletinId, Model model) {
        model.addAttribute(PERMISSION_KEY, false);
        Bulletin bulletinFromStorage = service.getBulletin(bulletinId);
        model.addAttribute(SINGLE_BULLETIN_ATTRIBUTE, bulletinFromStorage);
        if (bulletinFromStorage.getUserId() == session.getUserId()) {
            model.addAttribute(PERMISSION_KEY, true);
        }
        return DETAILS_PAGE;
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(ID_PARAM) int bulletinId) {
        service.delete(bulletinId);
        return URI_LIST;
    }

    @GetMapping("/add")
    public String showFormAdd(Model model) {
        model.addAttribute(SINGLE_BULLETIN_ATTRIBUTE, new Bulletin());
        return FORM;
    }

    @PostMapping("/save")
    public String processAction(@Valid @ModelAttribute(SINGLE_BULLETIN_ATTRIBUTE) Bulletin bulletinFromRequest,
                                BindingResult bindingResult) {
        String redirectUri = FORM;
        if (!bindingResult.hasErrors()) {
            bulletinFromRequest.setUserId(session.getUserId());
            service.saveBulletin(bulletinFromRequest);
            redirectUri = URI_LIST;
        }
        return redirectUri;
    }

    @GetMapping("/update")
    public String showFormUpdate(@RequestParam(ID_PARAM) int bulletinId, Model model) {
        model.addAttribute(SINGLE_BULLETIN_ATTRIBUTE, service.getBulletin(bulletinId));
        return FORM;
    }

    @PostMapping("/search")
    public String searchRow(@RequestParam("searchLine") String row, Model model) {
        String redirectPAth = URI_LIST;
        List<Bulletin> bulletinList = service.findByCriteria(row);
        if (Objects.nonNull(row) && bulletinList.size() > EMPTY_LIST) {
            model.addAttribute(BULLETINS_ATTRIBUTE, bulletinList);
            redirectPAth = LIST_PAGE;
        }
        return redirectPAth;
    }
}
