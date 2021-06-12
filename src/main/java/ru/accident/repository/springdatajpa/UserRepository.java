package ru.accident.repository.springdatajpa;

import org.springframework.data.repository.CrudRepository;
import ru.accident.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
