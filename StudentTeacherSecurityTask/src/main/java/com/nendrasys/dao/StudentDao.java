package com.nendrasys.dao;

import com.nendrasys.model.StudentAndTeacher;

import java.util.List;

public interface StudentDao {
    List<StudentAndTeacher> getStudentdetails();

    StudentAndTeacher getStudentdetailsbyid(int id);
    public int updatestudentdetails(StudentAndTeacher update);
    public int deleteStudentDetails(int id);
}
