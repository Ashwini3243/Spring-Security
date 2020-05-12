package com.nendrasys.dao;

import com.nendrasys.model.Password;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.security.Principal;

public class PasswordDaoImpl implements PasswordDao {
    @Autowired
    JdbcTemplate template;
    @Override
    public int updatePassword(Password p, Principal principal) {
        String query=null;
    if(p.getOldPassword().equals(p.getNewPassword())){
    return 0;
    }else if (p.getNewPassword().equals(p.getConfirmNewPassword())){
     query = "update usersdata set password='"+p.getNewPassword()+"' where password='"+p.getOldPassword()+"' && username='"+principal.getName()+"'";
    }
    return template.update(query);
    }
}
