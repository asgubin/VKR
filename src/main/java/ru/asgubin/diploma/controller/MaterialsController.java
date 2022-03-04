package ru.asgubin.diploma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.asgubin.diploma.entity.Materials;
import ru.asgubin.diploma.service.MaterialsService;

import java.util.List;

@Controller
public class MaterialsController {

    private MaterialsService materialsService;

    @Autowired
    public void materialsController(MaterialsService materialsService) {
        this.materialsService = materialsService;
    }

    @GetMapping("/materials")
    public String getMaterials(Model model) {

        List<Materials> materials = materialsService.findAll();
        model.addAttribute("materials", materials);

        return "materials";
    }
}