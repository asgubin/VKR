package ru.asgubin.diploma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.asgubin.diploma.entity.Levels;
import ru.asgubin.diploma.service.LevelsService;

import java.util.List;

@Controller
public class LevelsController {

    private LevelsService levelsService;

    @Autowired
    public void levelsController(LevelsService levelsService) {
        this.levelsService = levelsService;
    }

    @GetMapping("/levels")
    public String getLevels(Model model) {

        List<Levels> levels = levelsService.findAll();
        model.addAttribute("levels", levels);

        return "levels";
    }
}
