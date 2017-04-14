package com.tidyjava.petclinic.application;

import com.tidyjava.petclinic.domain.time.Week;
import com.tidyjava.petclinic.domain.visits.Visit;
import com.tidyjava.petclinic.mvc.Controller;
import com.tidyjava.petclinic.mvc.View;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Scanner;

public class VisitCalendarView implements View {
    private VisitCalendar visitCalendar;
    private Controller controller;

    public VisitCalendarView(VisitCalendar visitCalendar, Controller controller) {
        this.visitCalendar = visitCalendar;
        this.controller = controller;
        visitCalendar.addView(this);
    }

    public void modelChanged() {
        show();
    }

    public void show() {
        show(visitCalendar.getCurrentWeek());
        for (DayOfWeek day : VisitCalendar.OPEN_DAYS)
            show(day);
        askForCommand();
    }

    private void show(Week week) {
        System.out.println(week.getStart() + " - " + week.getEnd());
    }

    private void show(DayOfWeek day) {
        System.out.println(day + ":");
        show(visitCalendar.visitsOn(day));
    }

    private void show(List<Visit> visitsOnDay) {
        if (visitsOnDay.isEmpty()) {
            System.out.println("No visits!");
        } else {
            visitsOnDay.forEach(this::show);
        }
    }

    private void show(Visit visit) {
        System.out.println(visit.getTime() + ": " + visit.getOwnerName());
        System.out.println("Pets: " + visit.getPetNames());
    }

    private void askForCommand() {
        try (Scanner scanner = new Scanner(System.in)) {
            String command;
            do {
                command = scanner.nextLine();
            } while (!controller.execute(command));
        }
    }
}
