package com.ptm.projectintellijexample.service.impl;

import com.ptm.projectintellijexample.model.CustomUserDetails;
import com.ptm.projectintellijexample.model.User;
import com.ptm.projectintellijexample.model.UserRole;
import com.ptm.projectintellijexample.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUserName(username);
        if(user == null){
            throw new UsernameNotFoundException("Không tìm thấy tên tài khoản");
        }
        Collection<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
        Set<UserRole> roles = user.getUserRoles();

        for (UserRole userRole: roles) {
            grantedAuthoritySet.add(new SimpleGrantedAuthority(userRole.getRole().getName()));
        }
        return new CustomUserDetails(user, grantedAuthoritySet);
    }
}
