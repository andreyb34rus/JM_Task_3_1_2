package com.andreyb34rus.JM_Task_3_1_2.controller;

import com.andreyb34rus.JM_Task_3_1_2.model.Role;
import com.andreyb34rus.JM_Task_3_1_2.model.User;
import com.andreyb34rus.JM_Task_3_1_2.service.RoleService;
import com.andreyb34rus.JM_Task_3_1_2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.HashSet;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;


    @GetMapping(value = "")
    public String getAdminPage(Model model, Principal principal) {
        model.addAttribute("user", userService.getUserByEmail(principal.getName()));
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("roles", roleService.getAllRoles());
        model.addAttribute("emptyUser", new User());
        model.addAttribute("editUser", new User());
        return "/admin";
    }

    @GetMapping(value = "/newUser")
    public ModelAndView showNewUserPage(Model model) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/newUser");
        mav.addObject("emptyUser", new User());
        mav.addObject("allRolesList", roleService.getAllRoles());
        return mav;
    }

    @PostMapping("/addUser")
    public String createUser(@ModelAttribute("emptyUser") User user,
                             @RequestParam(value = "checkedRoles") String[] selectResult) {
        for (String s : selectResult) {
            user.addRole(roleService.getRoleByName("ROLE_" + s));
        }
        userService.save(user);
        return "redirect:/admin";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/admin";
    }
/*

    @GetMapping("edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("userRolesList", user.getRoles());
        model.addAttribute("allRolesList", roleService.getAllRoles());
        return "/editUser";
    }
*/



    @PostMapping ( "/updateUser/{id}")
    public String updateUser(@ModelAttribute("editUser") User user,
                             @PathVariable("id") Long id,
                             @RequestParam(value = "userRolesSelector") String[] selectResult) throws Exception {

        for (String s : selectResult) {
            user.addRole(roleService.getRoleByName("ROLE_" + s));
        }
        userService.update(id, user);
        return "redirect:/admin";
    }
}
