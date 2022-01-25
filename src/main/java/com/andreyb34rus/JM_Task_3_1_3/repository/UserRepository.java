package com.andreyb34rus.JM_Task_3_1_3.repository;

import com.andreyb34rus.JM_Task_3_1_3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
