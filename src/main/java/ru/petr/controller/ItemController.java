package ru.petr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.petr.entity.Item;
import ru.petr.service.ItemService;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/item")
public class ItemController {
    private static final String FORM = "add_item_form";
    private static final String DETAILS_PAGE = "item_details_page";
    private static final String LIST_PAGE = "item_list";
    private static final String URI_LIST = "redirect:/item/list";
    private static final String PERMISSION_KEY = "permissionDeleteItem";
    private static final String ITEMS_ATTRIBUTE = "items";
    private static final String SINGLE_ITEM_ATTRIBUTE = "item";
    private static final int EMPTY_LIST = 0;
    private static final String ID_PARAM = "id";
    private static final String EDIT_FORM = "edit_item_form";

    @Autowired
    private ItemService service;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/list")
    public String showAllBulletin(Model model) {
        model.addAttribute(ITEMS_ATTRIBUTE, service.getItems());
        return LIST_PAGE;
    }

    @GetMapping("/details")
    public String showDetailsPage(@RequestParam(ID_PARAM) int itemId, Model model) {
        model.addAttribute(PERMISSION_KEY, false);
        Item itemFromStorage = service.findById(itemId);
        model.addAttribute(SINGLE_ITEM_ATTRIBUTE, itemFromStorage);
        if (itemFromStorage.getUserName().equals(getSessionUserName())) {
            model.addAttribute(PERMISSION_KEY, true);
        }
        return DETAILS_PAGE;
    }

    private String getSessionUserName() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }
    @GetMapping("/delete")
    public String delete(@RequestParam(ID_PARAM) int itemId) {
        service.delete(itemId);
        return URI_LIST;
    }

    @GetMapping("/add")
    public String showFormAdd(Model model) {
        model.addAttribute(SINGLE_ITEM_ATTRIBUTE, new Item());
        return FORM;
    }

    @PostMapping("/save")
    public String processAction(@Valid @ModelAttribute(SINGLE_ITEM_ATTRIBUTE) Item itemFromRequest,
                                BindingResult bindingResult) {
        String redirectUri = FORM;
        if (!bindingResult.hasErrors()) {
            itemFromRequest.setUserName(getSessionUserName());
            service.save(itemFromRequest);
            redirectUri = URI_LIST;
        }
        return redirectUri;
    }

    @GetMapping("/update")
    public String showFormUpdate(@RequestParam(ID_PARAM) int itemId, Model model) {
        model.addAttribute(SINGLE_ITEM_ATTRIBUTE, service.findById(itemId));
        return EDIT_FORM;
    }

    @PostMapping("/update")
    public String updateItem(@Valid @ModelAttribute(SINGLE_ITEM_ATTRIBUTE) Item itemFromRequest,
                                BindingResult bindingResult) {
        String redirectUri = EDIT_FORM;
        if (!bindingResult.hasErrors()) {
            itemFromRequest.setUserName(getSessionUserName());
            service.update(itemFromRequest);
            redirectUri = URI_LIST;
        }
        return redirectUri;
    }

    @PostMapping("/search")
    public String searchRow(@RequestParam("searchLine") String row, Model model) {
        String redirectPath = URI_LIST;
        List<Item> itemList = service.findByCriteria(row);
        if (Objects.nonNull(row) && itemList.size() > EMPTY_LIST) {
            model.addAttribute(ITEMS_ATTRIBUTE, itemList);
            redirectPath = LIST_PAGE;
        }
        return redirectPath;
    }
}
