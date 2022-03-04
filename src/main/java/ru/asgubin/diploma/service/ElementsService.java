package ru.asgubin.diploma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.asgubin.diploma.entity.ElementGroups;
import ru.asgubin.diploma.entity.Elements;
import ru.asgubin.diploma.entity.FER;
import ru.asgubin.diploma.entity.FSSCm;
import ru.asgubin.diploma.repository.ElementsRepository;

import java.util.List;
import java.util.Optional;

@Component
public class ElementsService extends AbstractService<Elements, Long, ElementsRepository> {

    @Autowired
    public ElementsService(ElementsRepository repository) {

        super(repository);
    }

    public List<ElementGroups> getElementGroups() {
        return repository.getElementGroups();
    }

    public List<Elements> findAllByMark(String mark) {
        return repository.findAllByMark(mark);
    }

    public Double getCoast() {
        return repository.getCoast();
    }

    public List<Elements> findAllByOrderByMark() {
        return repository.findAllByOrderByMark();
    }

    public List<Elements> findAllByFerId(FER fer) {
        return repository.findAllByFerId(fer);
    }

    public Optional<Elements> findByFerId(FER fer) {
        return repository.findByFerId(fer);
    }

    public List<Elements> findAllByFsscmId(FSSCm fsscm) {
        return repository.findAllByFsscmId(fsscm);
    }

    public Optional<Elements> findByFsscmId(FSSCm fsscm) {
        return repository.findByFsscmId(fsscm);
    }
}
