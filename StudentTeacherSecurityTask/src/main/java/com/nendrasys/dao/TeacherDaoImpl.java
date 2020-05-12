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

public class TeacherDaoImpl implements TeacherDao {
    private static final Logger LOGGER = Logger.getLogger(StudentDaoImpl.class.getName());
    @Autowired
    private JdbcTemplate template;
    private static final String QUERY1 = "SELECT * FROM usersdata WHERE id = ?";
    @Override
    public List<StudentAndTeacher> getTeacherdetails() {
        List<StudentAndTeacher> teacherinfoArrayList = template.query("select * from usersdata where role='ROLE_T' ", new RowMapper<StudentAndTeacher>() {
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
        return teacherinfoArrayList;
    }

    @Override
    public StudentAndTeacher getTeacherdetailsbyid(int id) {
        StudentAndTeacher teacherinfo = (StudentAndTeacher) template.queryForObject(QUERY1, new BeanPropertyRowMapper(StudentAndTeacher.class), id);
        //System.out.println("from dao: "+studentinfo);
        return teacherinfo;
    }

    @Override
    public int updateTeacherdetails(StudentAndTeacher update) {
        String query1 = "update usersdata set name='" + update.getName() + "',age='" + update.getAge() + "',address='" + update.getAddress() + "',username='" + update.getUsername() + "',password='" + update.getPassword() + "' ,role='" + update.getRole() + "' ,enabled='" + update.getEnabled() + "'where id='" + update.getId() + "'";
        System.out.println(query1);
        return template.update(query1);
    }

    @Override
    public int deleteTeacherDetails(int id) {
        String querydel = "delete from usersdata WHERE id="+id+" ";
        return template.update(querydel);
    }
}

