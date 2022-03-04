package ru.asgubin.diploma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.asgubin.diploma.entity.Families;

public interface FamiliesRepository extends JpaRepository<Families, Long> {
}
