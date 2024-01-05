/**
 * @author Jacob Hobbs
 */
package com.projects.pantrywizard.service;

import com.projects.pantrywizard.entity.User;
import org.springframework.stereotype.Service;

public interface UserService {

    public void registerUser(User user);
}
