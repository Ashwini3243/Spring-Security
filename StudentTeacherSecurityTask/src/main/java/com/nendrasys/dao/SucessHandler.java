package com.nendrasys.dao;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Collection;
@Component
public class SucessHandler implements AuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse res, Authentication authentication) throws IOException, ServletException {

        boolean hasStudRole = false;
        boolean hasTeachRole = false;
        boolean hasAdminRole = false;
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority grantedAuthority : authorities) {
            if (grantedAuthority.getAuthority().equals("ROLE_S")) {
                hasStudRole = true;
                break;
            } else if (grantedAuthority.getAuthority().equals("ROLE_T")) {
                hasTeachRole = true;
                break;
            }
            else if (grantedAuthority.getAuthority().equals("ROLE_A")) {
                hasAdminRole = true;
                break;
            }
        }

        if (hasStudRole) {
            redirectStrategy.sendRedirect(req, res, "/dispStudentsList");
        } else if (hasTeachRole) {
            redirectStrategy.sendRedirect(req, res, "/dispTeachersList");
        } else if (hasAdminRole) {
            redirectStrategy.sendRedirect(req, res, "/dispStudentTeachersList");
        } else {
            throw new IllegalStateException();
        }
    }

    }

