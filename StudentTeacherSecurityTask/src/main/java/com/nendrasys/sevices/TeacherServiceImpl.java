package com.nendrasys.sevices;

import com.nendrasys.dao.TeacherDaoImpl;
import com.nendrasys.model.StudentAndTeacher;
import org.springframework.beans.factory.annotation.Autowired;

public class TeacherServiceImpl implements TeacherService {
    @Autowired
TeacherDaoImpl teacherDao;
    @Override
    public String updateTeacherdetails(StudentAndTeacher update) {
        int count = 0;
        count= teacherDao.updateTeacherdetails(update);
        System.out.println(count);
        if(count==1){
            return "Data is updated successfully";
        }
        else{
            return "Data is not updated";
        }
    }

    @Override
    public StudentAndTeacher getTeacherdetailsbyid(int id) {
        return teacherDao.getTeacherdetailsbyid(id);
    }

    @Override
    public String deleteTeacherDetails(int id) { int count = 0;
        count=  teacherDao.deleteTeacherDetails(id);
        System.out.println(count);
        if(count==1){
            return "Data is deleted successfully";
        }
        else{
            return "Data is not deleted";
        }

    }
}
