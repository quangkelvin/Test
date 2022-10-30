package com.observationclass.service;

import com.observationclass.entity.Role;
import com.observationclass.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;
    public Role findRoleById(Integer id){
        return roleRepository.findRoleById(id).get();
    }
}
