package com.ch07.controller;

import com.ch07.dto.User5DTO;
import com.ch07.service.User5Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class User5Controller {

    private final User5Service user5Service;

    @GetMapping("/user5/list")
    public String user5List(Model model) {
        List<User5DTO> users = user5Service.selectUser5s();
        model.addAttribute("users", users);
        return "/user5/list";
    }

    @GetMapping("/user5/register")
    public String user5Register() {
        return "/user5/register";
    }

    @PostMapping("/user5/register")
    public String user5Register(User5DTO user5DTO) {
        user5Service.insertUser5(user5DTO);
        return "redirect:/user5/list";
    }

    @GetMapping("/user5/modify")
    public String user5Modify(String seq, Model model) {
        User5DTO user5DTO = user5Service.selectUser5(seq);
        model.addAttribute("user5", user5DTO);
        return "/user5/modify";
    }

    @PostMapping("/user5/modify")
    public String user5Modify(User5DTO user5DTO) {
        user5Service.updateUser5(user5DTO);
        return "redirect:/user5/list";
    }

    @GetMapping("/user5/delete")
    public String user5Delete(String seq) {
        user5Service.deleteUser5(seq);
        return "redirect:/user5/list";
    }

}
