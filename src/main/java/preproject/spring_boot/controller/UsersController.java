package preproject.spring_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import preproject.spring_boot.model.User;
import preproject.spring_boot.service.UserServiceImp;

import javax.validation.Valid;

@Controller
public class UsersController {

    private final UserServiceImp userService;

    @Autowired
    public UsersController(UserServiceImp userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public String allUsers(ModelMap model, User user) {
        model.addAttribute("users", userService.allUsers());
        model.addAttribute("user", user);
        return "users";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("user") @Valid User user,
                          BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users";
        }
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/remove/{id}")
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String editUser(ModelMap model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.getUser(id));
        return "edit";
    }

        @PatchMapping("/update/{id}")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
                         @PathVariable("id") Long id) {
        if (bindingResult.hasErrors())
            return "edit";

        userService.addUser(user);
        return "redirect:/";
    }

}

