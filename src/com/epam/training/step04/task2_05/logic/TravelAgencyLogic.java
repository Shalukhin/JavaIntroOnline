package com.epam.training.step04.task2_05.logic;

import java.util.Arrays;
import java.util.Comparator;

import com.epam.training.step04.task2_05.beans.Client;
import com.epam.training.step04.task2_05.beans.Order;
import com.epam.training.step04.task2_05.beans.TravelAgency;
import com.epam.training.step04.task2_05.beans.tours.Cruise;
import com.epam.training.step04.task2_05.beans.tours.Excursion;
import com.epam.training.step04.task2_05.beans.tours.Recovery;
import com.epam.training.step04.task2_05.beans.tours.Relaxation;
import com.epam.training.step04.task2_05.beans.tours.Shopping;
import com.epam.training.step04.task2_05.beans.tours.Tour;

public class TravelAgencyLogic {

	private TravelAgency agency;

	public TravelAgencyLogic(TravelAgency agency) {
		super();
		this.agency = agency;
	}

	public TravelAgency getAgency() {
		return agency;
	}

	public void setAgency(TravelAgency agency) {
		this.agency = agency;
	}

	public void loadStandartListOfTours() {
		Cruise tour1 = new Cruise("1", 4, "sheep", true, 1000);
		tour1.setAll_countries(new String[] { "Kaunus", "Kopengagen", "Stokholm", "Riga" });
		agency.setAll_toursIndex(tour1, agency.getAll_tours().length);

		Excursion tour2 = new Excursion("2", 3, "bus", false, 550);
		tour2.setCountry("Frence");
		tour2.setGuide_language("english");
		agency.setAll_toursIndex(tour2, agency.getAll_tours().length);

		Recovery tour3 = new Recovery("3", 30, "train", true, 1500);
		tour3.setIllness("osteochondrosis");
		agency.setAll_toursIndex(tour3, agency.getAll_tours().length);

		Relaxation tour4 = new Relaxation("4", 15, "airplane", false, 700);
		tour4.setCountry("Tyrkey");
		agency.setAll_toursIndex(tour4, agency.getAll_tours().length);

		Shopping tour5 = new Shopping("5", 1, "minibus", false, 30);
		tour5.setCity("Belastok");
		tour5.setShop("Ashan");
		agency.setAll_toursIndex(tour5, agency.getAll_tours().length);
	}

	public boolean bookTour(Client client, Tour tour) {

		for (Order order : agency.getAll_orders()) {
			if (order.getClient().getId() == client.getId()) {
				for (Tour exist_tour : order.getTours()) {
					if (exist_tour.getId() == tour.getId()) {
						return false;
					}
				}

				order.setToursIndex(tour, order.getTours().length);
				return true;
			}
		}

		Order new_order = new Order(client, tour);
		agency.setAll_ordersIndex(new_order, agency.getAll_orders().length);
		return true;

	}

	public void sortToursByPrice() {

		Comparator<Tour> comparator = new Comparator<Tour>() {
			@Override
			public int compare(Tour tour1, Tour tour2) {
				if (tour1.getPrice() > tour2.getPrice()) {
					return 1;
				} else if (tour1.getPrice() < tour2.getPrice()) {
					return -1;
				} else {
					return 0;
				}
			}
		};

		Tour[] tempAllTours = agency.getAll_tours();
		tempAllTours = qSort(tempAllTours, comparator);
		agency.setAll_tours(tempAllTours);
	}

	public void sortToursByDayCount() {

		Comparator<Tour> comparator = new Comparator<Tour>() {
			@Override
			public int compare(Tour tour1, Tour tour2) {
				if (tour1.getDays() > tour2.getDays()) {
					return 1;
				} else if (tour1.getDays() < tour2.getDays()) {
					return -1;
				} else {
					return 0;
				}
			}
		};

		Tour[] tempAllTours = agency.getAll_tours();
		tempAllTours = qSort(tempAllTours, comparator);
		agency.setAll_tours(tempAllTours);
	}

	private Tour[] qSort(Tour[] tours, Comparator<Tour> comparator) {

		if (tours.length < 2) {
			return tours;
		}

		Tour[] one = new Tour[0];
		Tour[] two = new Tour[0];
		for (int i = 1; i < tours.length; i++) {
			if (comparator.compare(tours[i], tours[0]) < 0) {
				one = Arrays.copyOf(one, one.length + 1);
				one[one.length - 1] = tours[i];
			} else {
				two = Arrays.copyOf(two, two.length + 1);
				two[two.length - 1] = tours[i];
			}
		}
		return composite(qSort(one, comparator), tours[0], qSort(two, comparator));
	}

	private Tour[] composite(Tour[] one, Tour mid, Tour[] two) {
		Tour[] result = new Tour[one.length + 1 + two.length];
		int j = 0;
		for (int i = 0; i < one.length; i++) {
			result[j] = one[i];
			j++;
		}

		result[j] = mid;
		j++;

		for (int i = 0; i < two.length; i++) {
			result[j] = two[i];
			j++;
		}
		return result;
	}

	
	@Override
	public String toString() {
		return "TravelAgencyLogic [agency=" + agency + "]";
	}

}
