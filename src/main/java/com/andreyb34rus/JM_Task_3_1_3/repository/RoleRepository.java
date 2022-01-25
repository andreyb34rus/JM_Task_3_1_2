package com.andreyb34rus.JM_Task_3_1_3.repository;

import com.andreyb34rus.JM_Task_3_1_3.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(String roleName);
}
