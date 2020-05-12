package com.nendrasys.sevices;

import com.nendrasys.dao.PasswordDaoImpl;
import com.nendrasys.model.Password;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

public class PasswordServiceImpl implements PassowrdService {
    @Autowired
    PasswordDaoImpl passwordDao;
    @Override
    public String updatePassword(Password p, Principal principal) {
        int count = 0;
        count= passwordDao.updatePassword(p,principal);
        System.out.println(count);
        if(count==1){
                return "password updated successfully";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
            }

        else {
            return "Password is not updated";
        }
    }
}
