package com.nendrasys.sevices;

import com.nendrasys.dao.StudentDaoImpl;
import com.nendrasys.model.StudentAndTeacher;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDaoImpl studentDao;
    @Override
    public String updatestudentdetails(StudentAndTeacher update) {
        int count = 0;
        count= studentDao.updatestudentdetails(update);
        System.out.println(count);
        if(count==1){
            return "Data is updated successfully";
        }
        else{
            return "Data is not updated";
        }
    }

    @Override
    public StudentAndTeacher getStudentdetailsbyid(int id)
    {
        return studentDao.getStudentdetailsbyid(id);
    }

    @Override
    public String deleteStudentDetails(int stu_Id)
    {
        int count = 0;
        count=  studentDao.deleteStudentDetails(stu_Id);
        System.out.println(count);
        if(count==1){
            return "Data is deleted successfully";
        }
        else{
            return "Data is not deleted";
        }

    }
}
