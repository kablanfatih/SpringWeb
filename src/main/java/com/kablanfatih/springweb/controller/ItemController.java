package com.kablanfatih.springweb.controller;

import com.kablanfatih.springweb.domain.ItemAddForm;
import com.kablanfatih.springweb.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;
    //private final UserService userService;

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
        return new ModelAndView("items", "items", itemService.getItems());
    }
    @RequestMapping(value = "/items/{id}", method = RequestMethod.DELETE)
    public String handleItemDelete(@PathVariable Long id) {
        itemService.deleteItemById(id);
        return "redirect:/items";
    }
}
