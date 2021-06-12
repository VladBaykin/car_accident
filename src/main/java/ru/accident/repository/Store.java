package ru.accident.repository;

import ru.accident.model.Accident;
import ru.accident.model.AccidentType;
import ru.accident.model.Rule;

import java.util.List;

public interface Store {

    List<Accident> findAllAccidents();

    List<AccidentType> findAllAccidentTypes();

    List<Rule> findAllRules();

    void create(Accident accident);

    void update(Accident accident);

    Accident getAccidentById(int id);

    AccidentType getAccidentTypeById(int id);

    Rule getRuleById(int id);
}
