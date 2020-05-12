package com.nendrasys.controller;
import com.nendrasys.dao.StudentDaoImpl;
import com.nendrasys.model.StudentAndTeacher;
import com.nendrasys.sevices.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.PrintStream;
import java.security.Principal;
import java.util.List;

@Controller("/student")
public class StudentController {
    @Autowired
    StudentDaoImpl studentDao;
    @Autowired
    StudentServiceImpl studentServiceDao;

    @RequestMapping(value = "/dispStudentsList")
    public String displayStudentDetails(Model model, Principal principal) {
        List<StudentAndTeacher> students = studentDao.getStudentdetails();
        model.addAttribute("studentData", students);
String name=principal.getName();
model.addAttribute("username",name);
        return "dispStudents";
    }

    @RequestMapping(value = "/updateStudent/{id}", method = RequestMethod.GET)
    public String updatestudentsform(Model model, @PathVariable(value = "id") int id) {
       // String id1=Integer.parseInt(id);
        StudentAndTeacher update = studentServiceDao.getStudentdetailsbyid(id);
        model.addAttribute("update", update);
        return "updatestudents";
    }

    @RequestMapping("/updateStudentdata")
    public String updateStudentData(@ModelAttribute("update") StudentAndTeacher update, Model model) {
        String updatedetailsmsg = studentServiceDao.updatestudentdetails(update);
        System.out.println(updatedetailsmsg);
        model.addAttribute("result1", updatedetailsmsg);
        return "StudentMsgResult";
    }
    @RequestMapping(value = "deleteStudent/{id}")
    public String deletestddatabyeid(Model model, @PathVariable(value = "id") String id) {
        Integer currentId = Integer.parseInt(id);
        model.addAttribute("deletebyeid", studentServiceDao.deleteStudentDetails(currentId));
        return "deletestddata";
    }

}
