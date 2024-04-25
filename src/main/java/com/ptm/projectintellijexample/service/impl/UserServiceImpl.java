package com.ptm.projectintellijexample.service.impl;

import com.ptm.projectintellijexample.model.User;
import com.ptm.projectintellijexample.repository.UserRepository;
import com.ptm.projectintellijexample.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findByUserName(String userName) {
        return this.userRepository.findByUserName(userName);
    }
}
