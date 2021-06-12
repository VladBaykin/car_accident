package ru.accident.repository.springdatajpa;

import org.springframework.data.repository.CrudRepository;
import ru.accident.model.Authority;

public interface AuthorityRepository extends CrudRepository<Authority, Integer> {

    Authority findByAuthority(String authority);
}
