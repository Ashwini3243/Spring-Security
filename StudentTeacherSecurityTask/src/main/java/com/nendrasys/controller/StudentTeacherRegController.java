package com.nendrasys.controller;

import com.nendrasys.dao.StudentTeacherDao;
import com.nendrasys.model.StudentAndTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller("/StudentTeacher")
public class StudentTeacherRegController {
    @Autowired
    StudentTeacherDao studentTeacherDao;
    @RequestMapping(value = "/studTeachReg", method = RequestMethod.GET)
    public String showHome(Model model) {
        StudentAndTeacher reg = new StudentAndTeacher();
      /* reg.setId(1001);
        reg.setName("Ashwini");
        reg.setAge(25);*/
        model.addAttribute("reg", reg);
        return "StudTeachregister";
    }
    @RequestMapping(value = "/saveStudTeachData", method = RequestMethod.POST)
    public ModelAndView registerThestudent(ModelAndView mv, @ModelAttribute("reg") StudentAndTeacher reg ,
                                           @RequestParam("id") int id,
                                           @RequestParam("name") String name,
                                           @RequestParam("age") int age,
                                           @RequestParam("address") String address,
                                           @RequestParam("username") String username,
                                           @RequestParam("password") String password,
                                           @RequestParam("role") String role,
                                           @RequestParam("enabled") int enabled){
        StudentAndTeacher srM = new StudentAndTeacher();
        srM.setId(id);
        srM.setName(name);
        srM.setAge(age);
        srM.setAddress(address);
        srM.setUsername(username);
        srM.setPassword(password);
        srM.setRole(role);
        srM.setEnabled(enabled);
        studentTeacherDao.saveStudentData(srM);
        mv.setViewName("registerStudentTeacherSuccessMsg");
        return mv;
    }

    @ModelAttribute("rolesList")
    public List<String> rolesList() {
        List<String> list = new ArrayList<>();
        list.add("ROLE_S");
        list.add("ROLE_T");
        return list;
    }

}
