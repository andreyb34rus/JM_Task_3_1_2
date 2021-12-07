package com.andreyb34rus.JM_Task_3_1_2.service;

import com.andreyb34rus.JM_Task_3_1_2.model.Role;
import com.andreyb34rus.JM_Task_3_1_2.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public Role getRoleById(long id) {
        return roleRepository.getById(id);
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleByName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }
}
