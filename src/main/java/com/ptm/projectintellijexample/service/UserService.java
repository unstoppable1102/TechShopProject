package com.ptm.projectintellijexample.service;

import com.ptm.projectintellijexample.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User findByUserName(String username);
}
