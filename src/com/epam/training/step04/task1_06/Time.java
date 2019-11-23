/*6. Составьте описание класса для представления времени. Предусмотрте возможности установки времени и 
изменения его отдельных полей (час, минута, секунда) с проверкой допустимости вводимых значений. В случае 
недопустимых значений полей поле устанавливается в значение 0. Создать методы изменения времени на 
заданное количество часов, минут и секунд. */

package com.epam.training.step04.task1_06;

public class Time {

	private int hours;
	private int minutes;
	private int seconds;
	
	public Time() {
		super();
		hours = 0;
		minutes = 0;
		seconds = 0;
	}
	
	public void setTime (String time) {
		
		if (!time.matches("(\\d{2}:\\d{2}:\\d{2})|(\\d{2}:\\d{2})|\\d{2}|\\d")) {
			
			System.out.println("Не верный формат ввода! Введите \"чч:мм:сс\" либо \"чч:мм\" либо \"чч\" либо \"ч\"");
			return;
		}
						
		String[] arr = time.split(":");
		
		switch (arr.length) {
		
		case 1 : {
			
			int h = Integer.valueOf(arr[0]);
			
			setHours(h);
			setMinutes(0);
			setSeconds(0);
			
			break;
		}
		
		case 2 : {
			
			int h = Integer.valueOf(arr[0]);
			int m = Integer.valueOf(arr[1]);
			
			setHours(h);
			setMinutes(m);
			setSeconds(0);
			
			break;			
		}
		
		case 3 : {
			
			int h = Integer.valueOf(arr[0]);
			int m = Integer.valueOf(arr[1]);
			int s = Integer.valueOf(arr[2]);
			
			setHours(h);
			setMinutes(m);
			setSeconds(s);
			
			break;			
		}
		}
		
	}

	
	public void setHours(int hours) {
		if (hours > 23) {
			System.out.println("Внимание! Вы ввели \"чч\" = " + hours + "! \"чч\" должен быть в диапазоне [0 - 23]! \"чч\" установлено значение 23!");
			this.hours = 23;			
		} else if (hours < 0) {
			System.out.println("Внимание! Вы ввели \"чч\" = " + hours + "! \"чч\" должен быть в диапазоне [0 - 23]! \"чч\" установлено значение 00!");
			this.hours = 0;
		}
		else {
			this.hours = hours;
		}			
	}

	public void setMinutes(int minutes) {
		if (minutes > 59) {
			System.out.println("Внимание! Вы ввели \"мм\" = " + minutes + "! \"мм\" должен быть в диапазоне [0 - 59]! \"мм\" установлено значение 59!");
			this.minutes = 59;
		} else if (minutes < 0) {
			System.out.println("Внимание! Вы ввели \"мм\" = " + minutes + "! \"мм\" должен быть в диапазоне [0 - 59]! \"мм\" установлено значение 00!");
			this.minutes = 0;
		} else {
			this.minutes = minutes;
		}
	}

	public void setSeconds(int seconds) {
		if (seconds > 59) {
			System.out.println("Внимание! Вы ввели \"cc\" = " + seconds + "! \"сс\" должен быть в диапазоне [0 - 59]! \"cc\" установлено значение 59!");
			this.seconds = 59;
		} else if (seconds < 0) {
			System.out.println("Внимание! Вы ввели \"cc\" = " + seconds + "! \"сс\" должен быть в диапазоне [0 - 59]! \"cc\" установлено значение 00!");
			this.seconds = 0;
		} else {
			this.seconds = seconds;
		}
	}
	
	public void addHours(int add_hours) {
		
		int sec = add_hours * 3600;
		
		addSeconds(sec);		
	}
	
	public void addMinutes(int add_min) {
		
		int sec = add_min * 60;
		
		addSeconds(sec);
		
	}
	
	public void addSeconds(int add_sec) {
		
		int sec = hours * 3600 + minutes * 60 + seconds + add_sec;
		
		if (sec < 0) {
			System.out.println("Введённое значение меньше минимально-допустимого! Время установлено 00:00:00");
			hours = 0;
			minutes = 0;
			seconds = 0;
			return;
		}
		
		if (sec >= 86400) {
			System.out.println("Введённое значение больше максимально-допустимого! Время установлено 23:59:59");
			hours = 23;
			minutes = 59;
			seconds = 59;
			return;
		}
		
		minutes = sec / 60;
		hours = minutes / 60;
		
		seconds = sec % 60;
		minutes = minutes % 60;	
		
	}
	
	public void reset() {
		this.hours = 0;
		this.minutes = 0;
		this.seconds = 0;
		System.out.println("Время сброшено! Установлено значение 00:00:00");
	}
	
	public String toString() {
		
		return String.format("time: %02d:%02d:%02d", hours, minutes, seconds);
		
	}
	
}
