package com.nendrasys.sevices;

import com.nendrasys.model.StudentAndTeacher;

public interface StudentService {
    public String updatestudentdetails(StudentAndTeacher update);
    StudentAndTeacher getStudentdetailsbyid(int id);
    public String deleteStudentDetails(int id);
}
