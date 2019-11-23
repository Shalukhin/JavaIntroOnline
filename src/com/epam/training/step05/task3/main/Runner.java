package com.epam.training.step05.task3.main;

import com.epam.training.step05.task3.beans.Calendar;
import com.epam.training.step05.task3.logic.CalendarLogic;
import com.epam.training.step05.task3.view.Viewer;

public class Runner {

	public static void main(String[] args) {
		
		Calendar calendar = new Calendar(2019);
		CalendarLogic calendarLogic = new CalendarLogic(calendar);
		Viewer view = new Viewer();
		
		calendarLogic.addAllStandartWeekend();
		
		System.out.printf("Колличество выходных дней (Сб и Вс) в %d году равно %d\n", calendar.getYear(), calendarLogic.numberOfHolidaysInYear());		
		
		calendarLogic.addHoliday("Праздник1", 1, 1);
		calendarLogic.addHoliday("Праздник2", 1, 4);
		calendarLogic.addHoliday("Праздник3", 1, 3);
		calendarLogic.addHoliday("Праздник4", 1, 16);
		calendarLogic.addHoliday("Праздник5", 1, 6);
		
		view.printAllHolidaysFromCalendar(calendar);
		System.out.println();
		
		calendarLogic.deleteHoliday(1, 3);
		
		view.printAllHolidaysFromCalendar(calendar);		
	}
}
