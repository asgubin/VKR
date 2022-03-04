package ru.asgubin.diploma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.asgubin.diploma.entity.Levels;

public interface LevelsRepository extends JpaRepository<Levels, Long> {
}
