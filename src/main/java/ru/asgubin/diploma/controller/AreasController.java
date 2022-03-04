package ru.asgubin.diploma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.asgubin.diploma.entity.Areas;
import ru.asgubin.diploma.service.AreasService;

import java.util.List;

@Controller
public class AreasController {

    private AreasService areasService;

    @Autowired
    public void areasController(AreasService areasService) {
        this.areasService = areasService;
    }

    @GetMapping("/areas")
    public String getAreas(Model model) {

        List<Areas> areas = areasService.findAll();
        model.addAttribute("areas", areas);

        return "areas";
    }
}
