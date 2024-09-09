package com.ch07.controller;

import com.ch07.dto.User4DTO;
import com.ch07.service.User4Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class User4Controller {

    private final User4Service user4Service;

    @GetMapping("/user4/list")
    public String user4List(Model model) {
        List<User4DTO> users = user4Service.selectUser4s();
        model.addAttribute("users", users);
        return "/user4/list";
    }

    @GetMapping("/user4/register")
    public String user4Register() {
        return "/user4/register";
    }

    @PostMapping("/user4/register")
    public String user4Register(User4DTO user4DTO) {
        user4Service.insertUser4(user4DTO);
        return "redirect:/user4/list";
    }

    @GetMapping("/user4/modify")
    public String user4Modify(String uid,Model model) {
        User4DTO user4DTO = user4Service.selectUser4(uid);
        model.addAttribute("user4", user4DTO);
        return "/user4/modify";
    }

    @PostMapping("/user4/modify")
    public String user4Modify(User4DTO user4DTO) {
        user4Service.updateUser4(user4DTO);
        return "redirect:/user4/list";
    }

    @GetMapping("/user4/delete")
    public String user4Delete(String uid) {
        user4Service.deleteUser4(uid);
        return "redirect:/user4/list";
    }





}
