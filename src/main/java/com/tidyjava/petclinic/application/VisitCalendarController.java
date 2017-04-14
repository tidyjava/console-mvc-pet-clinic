package com.tidyjava.petclinic.application;

import com.tidyjava.petclinic.mvc.Controller;

import java.time.DayOfWeek;
import java.time.LocalTime;

import static java.lang.Integer.parseInt;

public class VisitCalendarController implements Controller {
    private VisitCalendar visitCalendar;

    public VisitCalendarController(VisitCalendar visitCalendar) {
        this.visitCalendar = visitCalendar;
    }

    public boolean execute(String command) {
        if ("next".equals(command)) {
            visitCalendar.nextWeek();
            return true;
        }
        if ("previous".equals(command)) {
            visitCalendar.previousWeek();
            return true;
        }

        if (command.startsWith("add")) {
            parseAdd(command);
            return true;
        }

        return false;
    }

    private void parseAdd(String command) {
        String[] addCmd = command.split(" ");
        String dayOfWeek = addCmd[1];
        String[] hourMinute = addCmd[2].split(":");
        String ownerName = addCmd[3];
        String[] petNames = addCmd[4].split(",");
        visitCalendar.addVisit(DayOfWeek.valueOf(dayOfWeek), toLocalTime(hourMinute), ownerName, petNames);
    }

    private LocalTime toLocalTime(String[] hourMinute) {
        int hour = parseInt(hourMinute[0]);
        int minute = parseInt(hourMinute[1]);
        return LocalTime.of(hour, minute);
    }
}
