package com.nendrasys.sevices;

import com.nendrasys.model.Password;

import java.security.Principal;

public interface PassowrdService {
    String updatePassword(Password p, Principal principal);
}
