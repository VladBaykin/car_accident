package ru.accident.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.accident.model.Accident;
import ru.accident.repository.AccidentMem;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccidentService {
    private final AccidentMem store;

    @Autowired
    public AccidentService(AccidentMem store) {
        this.store = store;
    }
    public List<Accident> getAllAccidents() {
        return new ArrayList<>(store.findAll().values());
    }
}
