package com.ptm.projectintellijexample.service;

import com.ptm.projectintellijexample.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User findByUserName(String username);
    User save(User user);
    User update(User user);
    List<User> findAll();
}
