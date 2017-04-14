package com.tidyjava.petclinic.domain.time;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Week {
    private final LocalDate start;

    private Week(LocalDate start) {
        this.start = start;
    }

    public static Week since(LocalDate start) {
        return new Week(start);
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getEnd() {
        return start.plusDays(6);
    }

    public Week next() {
        return new Week(start.plusDays(7));
    }

    public Week previous() {
        return new Week(start.minusDays(7));
    }

    public LocalDate get(DayOfWeek day) {
        return start.with(day);
    }
}
