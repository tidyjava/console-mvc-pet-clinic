package com.tidyjava.petclinic.application;

import com.tidyjava.petclinic.domain.time.Week;
import com.tidyjava.petclinic.domain.visits.Owner;
import com.tidyjava.petclinic.domain.visits.Pet;
import com.tidyjava.petclinic.domain.visits.Visit;
import com.tidyjava.petclinic.domain.visits.Visits;
import com.tidyjava.petclinic.mvc.Model;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static java.time.DayOfWeek.*;

public class VisitCalendar extends Model {
    static final DayOfWeek[] OPEN_DAYS = {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY};

    private Week currentWeek;
    private Visits visits;

    public VisitCalendar(Week currentWeek, Visits visits) {
        this.currentWeek = currentWeek;
        this.visits = visits;
    }

    Week getCurrentWeek() {
        return currentWeek;
    }

    void nextWeek() {
        this.currentWeek = currentWeek.next();
        changed();
    }

    void previousWeek() {
        this.currentWeek = currentWeek.previous();
        changed();
    }

    List<Visit> visitsOn(DayOfWeek day) {
        return visits.on(currentWeek.get(day));
    }

    void addVisit(DayOfWeek dayOfWeek, LocalTime time, String ownerName, String[] petNames) {
        LocalDateTime dateTime = currentWeek.get(dayOfWeek).atTime(time);
        Owner owner = new Owner(ownerName);
        List<Pet> pets = toPets(petNames, owner);
        visits.add(new Visit(dateTime, pets));
        changed();
    }

    private List<Pet> toPets(String[] petNames, Owner owner) {
        List<Pet> pets = new ArrayList<>();
        for (String petName : petNames) {
            Pet pet = new Pet(petName, owner);
            pets.add(pet);
        }
        return pets;
    }
}
