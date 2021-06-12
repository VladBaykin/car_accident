package ru.accident.repository.springdatajpa;

import org.springframework.data.repository.CrudRepository;
import ru.accident.model.Rule;

public interface RuleRepository extends CrudRepository<Rule, Integer> {
}
