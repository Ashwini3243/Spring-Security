package com.nendrasys.dao;

import com.nendrasys.model.StudentAndTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class StudentTeacherDaoImpl implements StudentTeacherDao {
    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
@Autowired
    JdbcTemplate template;
    @Override
    public void saveStudentData(StudentAndTeacher reg) {
        String sql = "insert into usersdata(id, name, age, address, username,password,role,enabled) values(?,?,?,?,?,?,?,?)";
        template.update(sql, new Object[]
                {reg.getId(), reg.getName(), reg.getAge()
                        , reg.getAddress(), reg.getUsername(),reg.getPassword(),reg.getRole(),reg.getEnabled()});
    }
}
