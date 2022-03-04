package ru.asgubin.diploma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.asgubin.diploma.entity.Levels;
import ru.asgubin.diploma.repository.LevelsRepository;

@Component
public class LevelsService extends AbstractService<Levels, Long, LevelsRepository> {

    @Autowired
    public LevelsService(LevelsRepository repository) {

        super(repository);
    }
}