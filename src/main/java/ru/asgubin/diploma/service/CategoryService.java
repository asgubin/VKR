package ru.asgubin.diploma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.asgubin.diploma.entity.Category;
import ru.asgubin.diploma.repository.CategoryRepository;

@Component
public class CategoryService extends AbstractService<Category, Long, CategoryRepository> {

    @Autowired
    public CategoryService(CategoryRepository repository) {

        super(repository);
    }
}
