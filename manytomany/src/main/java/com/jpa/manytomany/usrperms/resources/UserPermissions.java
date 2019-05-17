package com.jpa.manytomany.usrperms.resources;

import com.jpa.manytomany.usrperms.entities.PaaUsersEntity;
import com.jpa.manytomany.usrperms.pojo.PaaUser;
import com.jpa.manytomany.usrperms.repos.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class UserPermissions {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
private ModelMapper modelMapper;
    @GetMapping("users")
    public ResponseEntity getUsers() {
        Set<PaaUser> users = new HashSet<>();
        Iterable<PaaUsersEntity> paaUsersEntitySet = usersRepository.findAll();
        paaUsersEntitySet.forEach((userEntity)->{
            users.add(modelMapper.map(userEntity,PaaUser.class));
        });
        return ResponseEntity.ok(users);
    }
}
