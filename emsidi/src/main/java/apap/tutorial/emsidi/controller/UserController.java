package apap.tutorial.emsidi.controller;

import apap.tutorial.emsidi.model.PegawaiModel;
import apap.tutorial.emsidi.model.RoleModel;
import apap.tutorial.emsidi.model.UserModel;
import apap.tutorial.emsidi.service.RoleService;
import apap.tutorial.emsidi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping(value = "/add")
    private String addUserFormPage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("Admin"));

        if (isAdmin) {
            UserModel user = new UserModel();
            List<RoleModel> listRole = roleService.getListRole();
            model.addAttribute("user", user);
            model.addAttribute("listRole", listRole);
            return "form-add-user";
        }
        return "home";
    }

    @PostMapping(value = "/add")
    private String addUserSubmit(@ModelAttribute UserModel user, final HttpServletRequest req, Model model) {
        String email = req.getParameter("email");
        boolean emailFound = false;
        for (UserModel userList: userService.getListUser()
             ) {
            if (userList.getEmail().equals(email)) {
                emailFound = true;
                break;
            }
        }
        if (emailFound) {
            return "error-email";
        }
        else {
            userService.addUser(user);
            model.addAttribute("user", user);
            return "redirect:/";
        }
    }

    @GetMapping(value = "/viewall")
    private String viewAllUser(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("Admin"));

        if (isAdmin) {
            model.addAttribute("listUser", userService.getListUser());
            return "viewall-user";
        }
        return "home";
    }

    @GetMapping("/delete/{username}")
    public String deleteUser(
            @PathVariable String username,
            Model model
    ) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("Admin"));

        if (isAdmin) {
            UserModel user = userService.findByUsername(username);
            userService.deleteUser(user);
            model.addAttribute("username", user.getUsername());
            return "delete-user";
        }
            return "home";
    }

    @GetMapping("/update")
    private String updateUserForm() {
        return "form-update-user";
    }

    @PostMapping(value = "/update")
    private String updateUserSubmit(final HttpServletRequest req, Model model) {
        String oldPassword = req.getParameter("old-password");
        String newPassword = req.getParameter("new-password");
        String confirmPassword = req.getParameter("confirm-password");
        String username = req.getRemoteUser();
        UserModel user = userService.findByUsername(username);
        boolean passwordMatches = userService.passwordMatches(user, oldPassword);
        if (passwordMatches) {
            boolean success = userService.updateUser(user, newPassword, confirmPassword);
            if (success) {
                model.addAttribute("passwordMatches", true);
                model.addAttribute("confirm", true);
                model.addAttribute("success", true);
                return "update-user";
            }
            else {
                model.addAttribute("passwordMatches", true);
                model.addAttribute("confirm", true);
                model.addAttribute("success", false);
                return "update-user";
            }
        }
        else {
            model.addAttribute("passwordMatches", false);
            return "update-user";
        }
    }
}
