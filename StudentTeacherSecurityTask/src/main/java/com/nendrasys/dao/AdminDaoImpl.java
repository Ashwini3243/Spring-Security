package com.nendrasys.dao;

import com.nendrasys.model.StudentAndTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

public class AdminDaoImpl implements AdminDao {
    private static final Logger LOGGER = Logger.getLogger(StudentDaoImpl.class.getName());

    @Autowired
    private JdbcTemplate template;
    private static final String QUERY1 = "SELECT * FROM usersdata WHERE id = ?";
    @Override
    public List<StudentAndTeacher> getStudentTeacherDeatails() {
        List<StudentAndTeacher> studentinfoArrayList = template.query("select * from usersdata ", new RowMapper<StudentAndTeacher>() {
            @Override
            public StudentAndTeacher mapRow(ResultSet rs, int i) throws SQLException {
                StudentAndTeacher s = new StudentAndTeacher();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setAge(rs.getInt("age"));
                s.setAddress(rs.getString("address"));
                s.setUsername(rs.getString("username"));
                s.setPassword(rs.getString("password"));
                s.setRole(rs.getString("role"));
                s.setEnabled(rs.getInt("enabled"));
                return s;
            }
        });
        return studentinfoArrayList;
    }


}
