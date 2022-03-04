package ru.asgubin.diploma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.asgubin.diploma.entity.FER;
import ru.asgubin.diploma.repository.FERRepository;

@Component
public class FERService extends AbstractService<FER, String, FERRepository> {

    @Autowired
    public FERService(FERRepository repository) {

        super(repository);
    }
}
