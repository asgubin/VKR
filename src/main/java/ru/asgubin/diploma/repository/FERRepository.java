package ru.asgubin.diploma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.asgubin.diploma.entity.FER;

public interface FERRepository extends JpaRepository<FER, String> {
}