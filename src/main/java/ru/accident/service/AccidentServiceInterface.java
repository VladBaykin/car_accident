package ru.accident.service;

import ru.accident.model.Accident;
import ru.accident.model.AccidentType;
import ru.accident.model.Rule;

import java.util.List;

public interface AccidentServiceInterface {

    List<Accident> getAllAccidents();

    List<AccidentType> getAllAccidentType();

    List<Rule> getAllRules();

    Accident getAccidentById(int id);

    void saveAccident(Accident accident, String[] rulesFromUI);
}
