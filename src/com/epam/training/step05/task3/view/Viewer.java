package step05.task3.view;

import step05.task3.beans.Calendar;

public class Viewer {
	
	public void printAllHolidaysFromCalendar(Calendar calendar) {
		System.out.printf("Все праздничные и выходные дни %d года:\n", calendar.getYear());
		for (int i = 0; i < calendar.getHolidays().length; i++) {
			System.out.printf("%s\t%s\n", calendar.getHolidays()[i].getDate().toString(), calendar.getHolidays()[i].getName());
		}
	}

}
