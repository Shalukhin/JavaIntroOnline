/*4. Создайте класс Train, содержащий поля: название пункта назначения, номер поезда, время отправления. 
Создайте данные в массив из пяти элементов типа Train, добавьте возможность сортировки элементов массива по 
номерам поездов. Добавьте возможность вывода информации о поезде, номер которого введен пользователем. 
Добавьте возможность сортировки массив по пункту назначения, причем поезда с одинаковыми пунктами 
назначения должны быть упорядочены по времени отправления.*/

package com.epam.training.step04.task1_04;

import java.time.LocalTime;

public class Train implements Comparable<Train>{
	
	public String aim;
	public int number;	
	public LocalTime time;	
	
	public Train() {
		super();		
	}

	public Train(String aim, int number, String time) {
		super();
		this.aim = aim;
		this.number = number;
		this.time = LocalTime.parse(time);
	}

	@Override
	public int compareTo(Train otherTrain) {
		int result = this.aim.compareTo(otherTrain.aim);
		if (result == 0) {
			if (this.time.isAfter(otherTrain.time)) {
				return 1;
			}else if (this.time.isBefore(otherTrain.time)) {
				return -1;
			}else {
				return 0;
			}	
		}else {
			return result;
		}
	}
	
	public int compareToByNumber(Train otherTrain) {
		if (this.number > otherTrain.number) {
			return 1;
		}else if (this.number < otherTrain.number) {
			return -1;
		}else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return "Train [aim=" + aim + ", number=" + number + ", time=" + time + "]";
	}
	
	
	
	
	
	
	
	
	

}
