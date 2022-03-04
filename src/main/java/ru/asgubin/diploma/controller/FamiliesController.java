package ru.asgubin.diploma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.asgubin.diploma.entity.Families;
import ru.asgubin.diploma.service.FamiliesService;

import java.util.List;

@Controller
public class FamiliesController {

    private FamiliesService familiesService;

    @Autowired
    public void familiesController(FamiliesService familiesService) {
        this.familiesService = familiesService;
    }

    @GetMapping("/families")
    public String getFamilies(Model model) {

        List<Families> families = familiesService.findAll();
        model.addAttribute("families", families);

        return "families";
    }
}
