package com.andreyb34rus.JM_Task_3_1_2.service;

import com.andreyb34rus.JM_Task_3_1_2.model.Role;
import com.andreyb34rus.JM_Task_3_1_2.model.User;
import com.andreyb34rus.JM_Task_3_1_2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User getUserById(long id) {
        return userRepository.getById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void update(User user) throws Exception {
        if (user.getFirstName() == null){
            throw new Exception("Boo!");
        }else{
            System.out.println(user.getFirstName());
            System.out.println(user);
        }
            Optional<User> userOpt = userRepository.findById(user.getId());
        User userToUpdate;
        if (userOpt.isPresent()) {
            userToUpdate = userOpt.get();
        } else {
            throw new Exception("Нет юзера");
        }
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setAge(user.getAge());
        userToUpdate.setRoles(user.getRoles());
        userRepository.save(userToUpdate);
    }

    public void delete(long id) {
        userRepository.deleteById(id);
    }

    public void setInitData() {
        Role userRole = new Role("ROLE_USER");
        Role adminRole = new Role("ROLE_ADMIN");
        userRepository.save(new User("user", "user", (byte) 30, "user@mail.ru", "123", new HashSet<Role>() {{
            add(userRole);
        }}));
        userRepository.save(new User("admin", "admin", (byte) 35, "admin@mail.ru", "456", new HashSet<Role>() {{
            add(userRole);
            add(adminRole);
        }}));
    }
}
