package ru.asgubin.diploma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.asgubin.diploma.entity.*;
import ru.asgubin.diploma.service.ElementsService;
import ru.asgubin.diploma.service.FERService;
import ru.asgubin.diploma.service.FSSCmService;
import ru.asgubin.diploma.service.FamiliesService;

import java.util.List;
import java.util.Optional;

@Controller
public class ElementsController {

    private ElementsService elementsService;
    private FERService fersService;
    private FSSCmService fsscmService;
    private FamiliesService familiesService;

    @Autowired
    public void elementsController(ElementsService elementsService) {
        this.elementsService = elementsService;
    }

    @Autowired
    public void fersController(FERService fersService) {
        this.fersService = fersService;
    }

    @Autowired
    public void fsscmController(FSSCmService fsscmService) {
        this.fsscmService = fsscmService;
    }

    @Autowired
    public void familiesController(FamiliesService familiesService) {
        this.familiesService = familiesService;
    }

    @GetMapping("/elements")
    public String getElements(Model model) {

        List<Elements> elements = elementsService.findAllByOrderByMark();
        model.addAttribute("elements", elements);

        List<Families> families = familiesService.findAll();
        model.addAttribute("families", families);

        List<FER> fers = fersService.findAll();
        model.addAttribute("fers", fers);

        Double fullCoast = elementsService.getCoast();
        model.addAttribute("fullCoast",fullCoast);

        return "elements";
    }

    @PostMapping("/edit")
    public String submitElements(@RequestParam Long id, @RequestParam Long family_id) {

        Optional<Elements> element = elementsService.findById(id);
        Optional<Families> family = familiesService.findById(family_id);

        if(family.isPresent() && element.isPresent()) {
            List<Elements> elementGroup = elementsService.findAllByMark(element.get().getMark());
            for (Elements item : elementGroup) {
                item.setFamily_id(family.get());
                item.setCoast(getFERCoast(item) + getFSSCmCoast(item));

                elementsService.save(item);
            }
        }

        return "redirect:/elements";
    }

    @GetMapping("/elementGroups")
    public String getElementGroups(Model model) {

        List<ElementGroups> elementGroups = elementsService.getElementGroups();
        model.addAttribute("elementGroups", elementGroups);

        List<Families> families = familiesService.findAll();
        model.addAttribute("families", families);

        List<FER> fers = fersService.findAll();
        model.addAttribute("fers", fers);

        List<FSSCm> fsscms = fsscmService.findAll();
        model.addAttribute("fsscms", fsscms);

        Double fullCoast = elementsService.getCoast();
        model.addAttribute("fullCoast",fullCoast);

        return "elementGroups";
    }

    @PostMapping("/editGroups")
    public String submitGroups(@RequestParam String mark, @RequestParam Long family_id,
                               @RequestParam String ferId, @RequestParam String fsscmId) {

        List<Elements> elements = elementsService.findAllByMark(mark);
        Optional<Families> family = familiesService.findById(family_id);
        Optional<FER> fer = fersService.findById(ferId);
        Optional<FSSCm> fsscm = fsscmService.findById(fsscmId);

        if (!elements.isEmpty()) {
            for (Elements element : elements) {
                double coast = 0.0;

                family.ifPresent(element::setFamily_id);

                if (fer.isPresent()) {
                    element.setFerId(fer.get());

                    coast += getFERCoast(element);
                    element.setCoast(coast);
                }

                if (fsscm.isPresent()) {
                    element.setFsscmId(fsscm.get());

                    coast += getFSSCmCoast(element);
                    element.setCoast(coast);
                }

                elementsService.save(element);
            }
        }

        return "redirect:/elementGroups";
    }

    private double getFERCoast(Elements element) {

        return ((((double)element.getLength() / 1000)
                * element.getFamily_id().getWeight()) / 1000)
                * element.getFerId().getCoast() * 1.04;
    }

    private double getFSSCmCoast(Elements element) {

        return ((((double)element.getLength() / 1000)
                * element.getFamily_id().getWeight()) / 1000)
                * element.getFsscmId().getCoast() * 1.04;
    }
}
