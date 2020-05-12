package com.nendrasys.controller;

import com.nendrasys.dao.TeacherDaoImpl;
import com.nendrasys.model.StudentAndTeacher;
import com.nendrasys.sevices.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@Controller("/teacher")
public class TeacherController {
@Autowired
    TeacherDaoImpl teacherDao;
@Autowired
TeacherServiceImpl teacherServiceDao;
    @RequestMapping(value = "/dispTeachersList")
    public String displayTeacherdetails(Model model) {
        List<StudentAndTeacher> teachers = teacherDao.getTeacherdetails();
        model.addAttribute("teacherData", teachers);
        return "dispTeachers";
    }
    @RequestMapping(value = "/updateTeacher/{id}", method = RequestMethod.GET)
    public String updatestudentsform(Model model, @PathVariable(value = "id") int id) {
        StudentAndTeacher update = teacherServiceDao.getTeacherdetailsbyid(id);
        model.addAttribute("update", update);
        return "updateTeachers";
    }
    @RequestMapping("/updateTeacherdata")
    public String updateStudentData(@ModelAttribute("update") StudentAndTeacher update, Model model) {
        String updatedetailsmsg = teacherServiceDao.updateTeacherdetails(update);
        System.out.println(updatedetailsmsg);
        model.addAttribute("result1", updatedetailsmsg);
        return "TeacherMsgResult";
    }
    @RequestMapping(value = "deleteTeacher/{id}")
    public String deletestddatabyeid(Model model, @PathVariable(value = "id") String id) {
       Integer currentId = Integer.parseInt(id);
        model.addAttribute("deletebyeid", teacherServiceDao.deleteTeacherDetails(currentId));
        return "deleteTeachdata";
    }
}
