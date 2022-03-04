package ru.asgubin.diploma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.asgubin.diploma.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
