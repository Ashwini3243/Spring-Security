package com.nendrasys.dao;

import com.nendrasys.model.StudentAndTeacher;

import java.util.List;

public interface TeacherDao {
    List<StudentAndTeacher> getTeacherdetails();
    StudentAndTeacher getTeacherdetailsbyid(int id);
    public int updateTeacherdetails(StudentAndTeacher update);
    public int deleteTeacherDetails(int id);
}
