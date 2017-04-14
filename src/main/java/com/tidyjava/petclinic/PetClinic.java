package com.tidyjava.petclinic;

import com.tidyjava.petclinic.application.VisitCalendar;
import com.tidyjava.petclinic.application.VisitCalendarController;
import com.tidyjava.petclinic.application.VisitCalendarView;
import com.tidyjava.petclinic.domain.time.Week;
import com.tidyjava.petclinic.domain.visits.Visits;

import java.time.LocalDate;

import static java.time.DayOfWeek.MONDAY;

public class PetClinic {
    public static void main(String[] args) {
        Week currentWeek = Week.since(LocalDate.now().with(MONDAY));
        Visits visits = new Visits();
        VisitCalendar visitCalendar = new VisitCalendar(currentWeek, visits);
        VisitCalendarController visitCalendarController = new VisitCalendarController(visitCalendar);
        VisitCalendarView visitCalendarView = new VisitCalendarView(visitCalendar, visitCalendarController);
        visitCalendarView.show();
    }
}
