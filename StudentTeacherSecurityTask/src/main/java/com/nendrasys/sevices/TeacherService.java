package com.nendrasys.sevices;

import com.nendrasys.model.StudentAndTeacher;

public interface TeacherService {
    public String updateTeacherdetails(StudentAndTeacher update);
    StudentAndTeacher getTeacherdetailsbyid(int id);
    public String deleteTeacherDetails(int id);
}
