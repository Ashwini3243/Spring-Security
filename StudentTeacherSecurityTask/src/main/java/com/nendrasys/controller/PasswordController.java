package com.nendrasys.controller;

import com.nendrasys.dao.PasswordDaoImpl;
import com.nendrasys.model.Password;
import com.nendrasys.sevices.PassowrdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller("/PasswordController")
public class PasswordController {
@Autowired
PassowrdService passowrdService;
@Autowired
    PasswordDaoImpl passwordDao;
    @RequestMapping(value = "/password", method = RequestMethod.GET)
    public String showPassword(Model model, Principal principal) {
    Password p= new Password();
    String username=principal.getName();
    model.addAttribute("username",username);
    model.addAttribute("reg12",p);
        return "PasswordForm";
    }

    @RequestMapping(value = "/pswdChange", method = RequestMethod.POST)
    public ModelAndView passwordEvaluate(ModelAndView mv,
                                         @RequestParam("oldPassword") String oldPassword,
                                         @RequestParam("newPassword") String newPassword,
                                         @RequestParam("ConfirmNewPassword") String ConfirmNewPassword) {
        Password p = new Password();
        p.setOldPassword(oldPassword);
        p.setNewPassword(newPassword);
        p.setConfirmNewPassword(ConfirmNewPassword);
        return mv;
    }

    @RequestMapping(value = "/passwordAction", method = RequestMethod.POST)
    public ModelAndView changePassword(@ModelAttribute("reg12") Password p, ModelMap model, Principal principal) {
        String result=passowrdService.updatePassword(p,principal);
       model.addAttribute("result",result);

        if (result.contains("password updated successfully")) {
            return new ModelAndView("redirect:/logout", model);
        }
        else{
            return new ModelAndView("pwdChangeSuccessMsg", model);
        }
    }
    }
