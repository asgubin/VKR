package ru.asgubin.diploma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.asgubin.diploma.entity.Areas;
import ru.asgubin.diploma.repository.AreasRepository;

@Component
public class AreasService extends AbstractService<Areas, Long, AreasRepository> {

    @Autowired
    public AreasService(AreasRepository repository) {

        super(repository);
    }
}