package apap.tutorial.emsidi.controller;

import apap.tutorial.emsidi.model.*;
import apap.tutorial.emsidi.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.time.LocalTime;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping(value = "/add")
    private String adddUserFormPage(Model model) {
        UserModel user = new UserModel();
        List<RoleModel> listRole = roleService.findAll();
        model.addAttribute("user", user);
        model.addAttribute("listRole", listRole);
        return "form-add-user";
    }

    @PostMapping(value = "/add")
    private String addUserSubmit(@ModelAttribute UserModel user, Model model) {
        userService.addUser(user);
        model.addAttribute("user", user);
        return "redirect:/";
    }

    @GetMapping(value = "/list-user")
    private String seeAllUser(Model model) {
        UserModel user = new UserModel();
        List<UserModel> listUser = userService.findAll();
        model.addAttribute("listUser", listUser);
        return "list-all-user";
    }

    @RequestMapping(value = "/delete/{username}")
    public String deleteUser(@PathVariable(value = "username", required = true) String username, Model model) {
        UserModel user = userService.getUserByUsername(username);
        userService.deleteUser(user);

        // model.addAttribute("pegawai", id);
        return seeAllUser(model);
    }

    @GetMapping(value = "/update-password")
    private String updatePasswordFormPage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserModel user = userService.getUserByUsername(auth.getName());
        model.addAttribute("user", user);
        return "form-update-password";
    }

    @PostMapping(value = "/update-password")
    private String updatePasswordSubmit(@ModelAttribute UserModel user,
            @RequestParam(value = "oldPassword") String oldPassword,
            @RequestParam(value = "newPassword") String newPassword,
            @RequestParam(value = "confirmPassword") String confirmPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        if (passwordEncoder.matches(oldPassword, user.getPassword()) & newPassword.equals(confirmPassword)) {
            // Encode new password and store it
            if (newPassword.equals(oldPassword)) {
                return "gagal-update";
            } else {
                userService.updateUser(user, newPassword);
                return "update-password";
            }
        }
        return "gagal-update";
    }

}
