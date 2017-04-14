package com.tidyjava.petclinic.domain.visits;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Visits {
    private List<Visit> visits = new ArrayList<>();

    public void add(Visit visit) {
        this.visits.add(visit);
    }

    public List<Visit> on(LocalDate date) {
        return visits.stream()
                .filter(visit -> visit.isOn(date))
                .collect(Collectors.toList());
    }
}
