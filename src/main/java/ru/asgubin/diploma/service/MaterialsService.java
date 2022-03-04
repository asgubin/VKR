package ru.asgubin.diploma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.asgubin.diploma.entity.Materials;
import ru.asgubin.diploma.repository.MaterialsRepository;

@Component
public class MaterialsService extends AbstractService<Materials, Long, MaterialsRepository> {

    @Autowired
    public MaterialsService(MaterialsRepository repository) {

        super(repository);
    }
}