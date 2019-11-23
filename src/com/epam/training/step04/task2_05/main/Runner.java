/* 5. Туристические путевки. Сформировать набор предложений клиенту по выбору туристической путевки 
различного типа (отдых, экскурсии, лечение, шопинг, круиз и т. д.) для оптимального выбора. Учитывать 
возможность выбора транспорта, питания и числа дней. Реализовать выбор и сортировку путевок. */

package com.epam.training.step04.task2_05.main;

import com.epam.training.step04.task2_05.beans.Client;
import com.epam.training.step04.task2_05.beans.TravelAgency;
import com.epam.training.step04.task2_05.logic.TravelAgencyLogic;
import com.epam.training.step04.task2_05.view.Viewer;

public class Runner {

	public static void main(String[] args) {
	
		TravelAgency agency = new TravelAgency("OverWorld");
		TravelAgencyLogic agencyLogic = new TravelAgencyLogic(agency);
		
		agencyLogic.loadStandartListOfTours();
		
		Viewer.printAllToursInTravelAgencyToConsol(agency);
		
		agencyLogic.sortToursByPrice();		
		System.out.println("\nТуры отсортированы в порядке возрастания цены!\n");
		
		Viewer.printAllToursInTravelAgencyToConsol(agency);
		
		agencyLogic.sortToursByDayCount();
		System.out.println("\nТуры отсортированы в порядке возрастания кол-ва дней!\n");
		
		Viewer.printAllToursInTravelAgencyToConsol(agency);		
		
		Client client1 = new Client("Vasia", "54667");
		Client client2 = new Client("Vania", "313");
		Client client3 = new Client("Jenia", "00032");
		
		agencyLogic.bookTour(client1, agency.getAll_tours()[0]);
		agencyLogic.bookTour(client1, agency.getAll_tours()[0]);
		agencyLogic.bookTour(client1, agency.getAll_tours()[1]);
		agencyLogic.bookTour(client2, agency.getAll_tours()[0]);
		agencyLogic.bookTour(client3, agency.getAll_tours()[4]);
		
		
		System.out.println();
		
		Viewer.printAllOrdersInTravelAgencyToConsol(agency);
	}
}
