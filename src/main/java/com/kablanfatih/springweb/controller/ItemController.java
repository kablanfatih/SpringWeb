package com.kablanfatih.springweb.controller;

import com.kablanfatih.springweb.domain.ItemAddForm;
import com.kablanfatih.springweb.domain.ItemAssignForm;
import com.kablanfatih.springweb.service.ItemService;
import com.kablanfatih.springweb.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;
    private final UserService userService;

    @RequestMapping("/items/add")
    public ModelAndView itemAddPage() {
        return new ModelAndView("add-item", "itemForm", new ItemAddForm());
    }

    @RequestMapping(value = "/items", method = RequestMethod.POST)
    public String handleItemAdd(@Valid @ModelAttribute("itemForm") ItemAddForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "add-item";
        itemService.addItem(form);
        return "redirect:/items";
    }

    @RequestMapping("/items")
    public ModelAndView getItemsPage() {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("items", itemService.getItems());
        model.put("usernames", userService.getUsernames());
        model.put("assignForm", new ItemAssignForm());
        return new ModelAndView("items", model);
    }

    @RequestMapping(value = "/items/{id}", method = RequestMethod.DELETE)
    public String handleItemDelete(@PathVariable Long id) {
        itemService.deleteItemById(id);
        return "redirect:/items";
    }

    @RequestMapping(value = "/items/{id}", method = RequestMethod.PUT)
    public String handleItemAssign(@ModelAttribute("user") ItemAssignForm form, @PathVariable("id") long id) {
        itemService.assignItem(form.getUsername(), id);
        return "redirect:/items";
    }
}
