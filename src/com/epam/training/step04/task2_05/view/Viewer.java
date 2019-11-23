package step04.task2_05.view;

import step04.task2_05.beans.Order;
import step04.task2_05.beans.TravelAgency;
import step04.task2_05.beans.tours.Tour;

public class Viewer {
	
	public static void printAllOrdersInTravelAgencyToConsol(TravelAgency agency) {
		System.out.printf("\tВсе заказы оформленные клиентами турагентства \"%s\":\n", agency.getName());
		for (Order order : agency.getAll_orders()) {
			System.out.printf("Заказ от клиента \"%s\" id = \"%s\":\n", order.getClient().getName(), order.getClient().getId());
			int i = 1;
			for (Tour tour : order.getTours()) {
				System.out.printf("%d) тур id = \"%s\": тип - \"%s\"; %s\n", i, tour.getId(), tour.getType(), tour.receiveSpecificInfo());
				System.out.printf("Кол-во дней - %s | транспорт - %s | питание - %s | цена - %d\n", tour.getDays(), tour.getTransportation(), (tour.isFood() ? "да" : "нет"), tour.getPrice());				
				i++;
			}
			System.out.println("----------------------------------");
		}
	}
	
	public static void printAllToursInTravelAgencyToConsol(TravelAgency agency) {
		System.out.printf("\tВсе туры доступные в турагентстве \"%s\":\n", agency.getName());
		int i = 1;
		for (Tour tour : agency.getAll_tours()) {
			System.out.printf("%d) тур id = \"%s\": тип - \"%s\"; %s\n", i, tour.getId(), tour.getType(), tour.receiveSpecificInfo());
			System.out.printf("Кол-во дней - %s | транспорт - %s | питание - %s | цена - %d\n", tour.getDays(), tour.getTransportation(), (tour.isFood() ? "да" : "нет"), tour.getPrice());				
			i++;
			System.out.println("----------------------------------");
		}
	}
	
}
