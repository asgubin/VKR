package ru.asgubin.diploma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.asgubin.diploma.entity.Elements;
import ru.asgubin.diploma.entity.FER;
import ru.asgubin.diploma.service.ElementsService;
import ru.asgubin.diploma.service.FERService;

import java.util.List;
import java.util.Optional;

@Controller
public class FERController {

    private FERService ferService;
    private ElementsService elementsService;

    @Autowired
    public void FERController(FERService ferService) {
        this.ferService = ferService;
    }

    @Autowired
    public void elementsController(ElementsService elementsService) {
        this.elementsService = elementsService;
    }

    @GetMapping("/fers")
    public String getFERs(Model model) {

        List<FER> fers = ferService.findAll();
        model.addAttribute("fers", fers);

        return "fers";
    }

    @PostMapping("/deleteFER")
    public String deleteFER(@RequestParam String id) {

        Optional<FER> fer = ferService.findById(id);

        if (fer.isPresent()) {
            Optional<Elements> element = elementsService.findByFerId(fer.get());

            if (element.isEmpty()) {
                ferService.deleteById(id);
            }
        }

        return "redirect:/fers";
    }

    @PostMapping("/addFER")
    public String addFER(@RequestParam String id,
                          @RequestParam String name,
                          @RequestParam Double coast) {

        Optional<FER> fer = ferService.findById(id);

        if (fer.isEmpty()) {
            FER newFER = new FER(id, name, coast);
            ferService.save(newFER);
        }

        return "redirect:/fers";
    }
}
