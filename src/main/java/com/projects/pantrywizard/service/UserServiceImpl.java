/**
 * @author Jacob Hobbs
 */
package com.projects.pantrywizard.service;


import com.projects.pantrywizard.dao.UserRepository;
import com.projects.pantrywizard.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void registerUser(User user) {
        userRepository.save(user);

    }




}
