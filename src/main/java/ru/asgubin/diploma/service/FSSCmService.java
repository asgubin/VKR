package ru.asgubin.diploma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.asgubin.diploma.entity.FSSCm;
import ru.asgubin.diploma.repository.FSSCmRepository;

@Component
public class FSSCmService extends AbstractService<FSSCm, String, FSSCmRepository> {

    @Autowired
    public FSSCmService(FSSCmRepository repository) {

        super(repository);
    }
}