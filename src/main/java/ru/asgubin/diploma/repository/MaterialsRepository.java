package ru.asgubin.diploma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.asgubin.diploma.entity.Materials;

public interface MaterialsRepository extends JpaRepository<Materials, Long> {
}
