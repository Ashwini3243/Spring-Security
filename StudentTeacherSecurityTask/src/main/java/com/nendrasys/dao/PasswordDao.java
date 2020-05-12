package com.nendrasys.dao;

import com.nendrasys.model.Password;

import java.security.Principal;

public interface PasswordDao {
    int updatePassword(Password p, Principal principal);
}
