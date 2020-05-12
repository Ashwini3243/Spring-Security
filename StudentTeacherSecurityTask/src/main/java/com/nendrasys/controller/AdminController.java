package com.nendrasys.controller;

import com.nendrasys.dao.AdminDaoImpl;
import com.nendrasys.model.StudentAndTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;
@Controller("/AdminController")
public class AdminController {
    @Autowired
    AdminDaoImpl adminDao;

    @RequestMapping(value = "/dispStudentTeachersList")
    public String displayStudentTeacherDetails(Model model) {
        List<StudentAndTeacher> students = adminDao.getStudentTeacherDeatails();
        model.addAttribute("studentData", students);
        return "dispStudentsTeacher";
    }

}
