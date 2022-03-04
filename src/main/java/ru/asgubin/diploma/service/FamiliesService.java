package ru.asgubin.diploma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.asgubin.diploma.entity.Families;
import ru.asgubin.diploma.repository.FamiliesRepository;

@Component
public class FamiliesService extends AbstractService<Families, Long, FamiliesRepository> {

    @Autowired
    public FamiliesService(FamiliesRepository repository) {

        super(repository);
    }
}