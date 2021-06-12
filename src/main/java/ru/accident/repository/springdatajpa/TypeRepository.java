package ru.accident.repository.springdatajpa;

import org.springframework.data.repository.CrudRepository;
import ru.accident.model.AccidentType;

public interface TypeRepository extends CrudRepository<AccidentType, Integer> {
}
