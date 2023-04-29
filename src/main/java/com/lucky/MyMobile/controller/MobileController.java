package com.lucky.MyMobile.controller;


import com.lucky.MyMobile.entity.Mobile;
import com.lucky.MyMobile.service.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MobileController {

    private MobileService mobileService;

    @Autowired
    public MobileController(MobileService mobileService) {
        this.mobileService = mobileService;
    }

    @GetMapping("/list")
    public String list(Model model) {

        List<Mobile> list = mobileService.findAll();

        model.addAttribute("mobile", list);

        return "list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        Mobile mobile = new Mobile();
        model.addAttribute("mobile", mobile);

        return "showFormForAdd";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("mobileId") int id, Model model){

        Mobile mobile = mobileService.findById(id);

        model.addAttribute("mobile", mobile );

        return "showFormForAdd";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("mobileId") int id){
        mobileService.deleteById(id);
        return "redirect:/list";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("mobile") Mobile mobile){

        mobileService.save(mobile);

        return "redirect:/list";
    }
}
