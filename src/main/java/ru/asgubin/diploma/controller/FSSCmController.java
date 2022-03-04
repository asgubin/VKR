package ru.asgubin.diploma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.asgubin.diploma.entity.Elements;
import ru.asgubin.diploma.entity.FSSCm;
import ru.asgubin.diploma.service.ElementsService;
import ru.asgubin.diploma.service.FSSCmService;

import java.util.List;
import java.util.Optional;

@Controller
public class FSSCmController {

    private FSSCmService fsscmService;
    private ElementsService elementsService;

    @Autowired
    public void FSSCmController(FSSCmService fsscmService) {
        this.fsscmService = fsscmService;
    }

    @Autowired
    public void elementsController(ElementsService elementsService) {
        this.elementsService = elementsService;
    }

    @GetMapping("/fsscms")
    public String getFSSCms(Model model) {

        List<FSSCm> fsscms = fsscmService.findAll();
        model.addAttribute("fsscms", fsscms);

        return "fsscms";
    }

    @PostMapping("/deleteFSSCm")
    public String deleteFSSCm(@RequestParam String id) {

        Optional<FSSCm> fsscm = fsscmService.findById(id);

        if (fsscm.isPresent()) {
            Optional<Elements> element = elementsService.findByFsscmId(fsscm.get());

            if (element.isEmpty()) {
                fsscmService.deleteById(id);
            }
        }

        return "redirect:/fsscms";
    }

    @PostMapping("/addFSSCm")
    public String addFSSCm( @RequestParam String id,
                            @RequestParam String name,
                            @RequestParam Double coast) {

        Optional<FSSCm> fsscm = fsscmService.findById(id);

        if (fsscm.isEmpty()) {
            FSSCm newFSSCm = new FSSCm(id, name, coast);
            fsscmService.save(newFSSCm);
        }

        return "redirect:/fsscms";
    }
}
