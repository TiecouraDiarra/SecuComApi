package com.bezkoder.springjwt.service;

import com.bezkoder.springjwt.models.ERole;
import com.bezkoder.springjwt.models.Role;
import com.bezkoder.springjwt.models.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

   // void addRoleToUser(String username, String roleName);
    /*Role saveRole(Role role);
    User saveUser(User user);*/

    List<User> getUsers();
}
