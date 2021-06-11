package ru.accident.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.accident.model.Accident;
import ru.accident.model.AccidentType;
import ru.accident.model.Rule;
import ru.accident.repository.AccidentMem;

import java.util.List;

@Service
public class AccidentService {
    private final AccidentMem store;

    @Autowired
    public AccidentService(AccidentMem store) {
        this.store = store;
    }
    public List<Accident> getAllAccidents() {
        return store.findAllAccidents();
    }

    public List<AccidentType> getAllAccidentType() {
        return store.findAllAccidentTypes();
    }

    public List<Rule> getAllRules() {
        return store.findAllRules();
    }

    public Accident getAccidentById(int id) {
        return store.getAccidentById(id);
    }

    public void saveAccident(Accident accident) {
        int id = accident.getId();
        AccidentType type = accident.getType();
        String typeName = store.getAccidentTypeById(type.getId()).getName();
        type.setName(typeName);
        accident.setType(type);
        accident.getRules().forEach(rule -> rule.setName(
                store.getRuleById(rule.getId()).getName()));
        if (id != 0) {
            store.update(accident);
        } else {
            store.create(accident);
        }
    }
}
