/*3. Создать объект класса Государство, используя классы Область, Район, Город. Методы: вывести на консоль 
столицу, количество областей, площадь, областные центры.  */

/*
  Данный класс содержит метод main и демонстрирует работу приложения.
  
  В данном классе, кроме main, определены некоторые вспомогательные статические методы:
  	getArrayCitesFromFile() - возвращает массив экземпляров класса City, построенный на осове данных из текстового файла \data\cites.txt
  	getArrayDistrictsFromFile() - возвращает массив экземпляров класса District, построенный на осове данных из текстового файла \data\districts.txt
  	getArrayRegionsFromFile() - возвращает массив экземпляров класса Region, построенный на осове данных из текстового файла \data\regions.txt
  	getCityFromArroyByName(City[] cites, String name) - возвращает экземпляр класса City, который ищется в массиве City[] cites по имени String name
  	findCenterOfUnitFromArroy(Entity entity, City[] cites) - возвращает экземпляр класса City, который ищется в массиве City[] cites по имени 
  переданной структурной территориальной единицы и который является центром этой территориальной единицы. (Например: если передать обьект типа District 
  с именем "Минский" или обьект типа Region с именем "Минская", то из массива городов будет найден и возвращён экземпляр класса City с именем "Минск")  
  
 */
package com.epam.training.step04.task2_03.main;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.epam.training.step04.task2_03.beans.City;
import com.epam.training.step04.task2_03.beans.District;
import com.epam.training.step04.task2_03.beans.Region;
import com.epam.training.step04.task2_03.beans.State;
import com.epam.training.step04.task2_03.beans.Unit;
import com.epam.training.step04.task2_03.logic.DistrictLogic;
import com.epam.training.step04.task2_03.logic.RegionLogic;
import com.epam.training.step04.task2_03.logic.StateLogic;
import com.epam.training.step04.task2_03.view.Viewer;

public class Runner {

	public static void main(String[] args) throws IOException {
		
		Viewer viewer = new Viewer();

		State belarus = new State("Беларусь");					// создаём экземпляр класса State с именем "Беларусь"
		
		Region[] regions = getArrayRegionsFromFile();			// создаём массив областей РБ (описанных в файле \data\regions.txt)
		District[] districts = getArrayDistrictsFromFile();		// создаём массив районов РБ (описанных в файле \data\districts.txt)
		City[] cites = getArrayCitesFromFile();					// создаём массив городов РБ (описанных в файле \data\cites.txt)
		
		StateLogic stateLogic = new StateLogic(belarus);
		RegionLogic regionLogic = new RegionLogic();
		DistrictLogic districLogic = new DistrictLogic();
		

		for (int i = 0; i < districts.length; i++) {								// заполняем районы городами и устанавливаем районные центры
			districLogic.setDistrict(districts[i]);
			districLogic.addArreyUnits(cites);
			districts[i].setCenter(findCenterOfUnitFromArroy(districts[i], cites));
		}

		for (int i = 0; i < regions.length; i++) {									// заполняем области районами и устанавливаем областные центры
			regionLogic.setRegion(regions[i]);
			regionLogic.addArreyUnits(districts);
			regions[i].setCenter(findCenterOfUnitFromArroy(regions[i], cites));			
		}
				
		stateLogic.addArreyUnits(regions);			// заполняем государство РБ областями

		viewer.showCapitalInConsole(belarus);			// пытаемся посмотреть столицу РБ (но её ещё не определили)

		City minsk = getCityFromArroyByName(cites, "Минск");  	// из массива городов выбираем минск

		stateLogic.setCapital(minsk);				// устанавливаем Минск столицей РБ

		viewer.showCapitalInConsole(belarus);		// смотрим столицу РБ

		viewer.showAreaInConsole(belarus);; 		// смотрим площадь РБ
		
		viewer.showPopulationInConsole(belarus);	// смотрим население РБ
		
		viewer.showPopulationInConsole(minsk);		// смотрим население Минска
		
		viewer.showMessageInConsole(stateLogic.unitConsistOf()); 		// смотрим области входящие в РБ
		
		regionLogic.setRegion(belarus.getArrayUnits()[0]);
		viewer.showMessageInConsole(regionLogic.unitConsistOf()); 		// смотрим районы входящие в состав, например, Брестской области
		
		viewer.showRegionCentersInConsole(belarus);				// смотрим перечень областных центров РБ
		
		System.out.println();
		System.out.println(belarus.stuctureOfUnit());		// смотрим полную территориальную структуру РБ
	}

	public static City[] getArrayCitesFromFile() throws IOException {

		int ch;
		StringBuilder sb = new StringBuilder();

		String pass = System.getProperty("user.dir") + "\\src\\com.epam.training.step04\\task2_03\\data\\cites.txt";
		File f = new File(pass);

		@SuppressWarnings("resource")
		FileReader reader = new FileReader(f);

		while ((ch = reader.read()) != -1) {
			sb.append((char) ch);
		}

		String[] line_cites = sb.toString().split("\\n");

		City[] cites = new City[line_cites.length];

		for (int i = 0; i < line_cites.length; i++) {
			String[] data_city = line_cites[i].trim().split("\\*");
			cites[i] = new City(data_city[0].trim(), Integer.valueOf(data_city[1].trim()), data_city[2].trim(),
					(long) ((double) (Double.valueOf(data_city[3].trim().replaceAll(",", ".")) * 1000)));
		}

		return cites;
	}

	public static District[] getArrayDistrictsFromFile() throws IOException {

		int ch;
		StringBuilder sb = new StringBuilder();

		String pass = System.getProperty("user.dir") + "\\src\\com.epam.training.step04\\task2_03\\data\\districts.txt";
		File f = new File(pass);

		@SuppressWarnings("resource")
		FileReader reader = new FileReader(f);

		while ((ch = reader.read()) != -1) {
			sb.append((char) ch);
		}

		String[] line_districts = sb.toString().split("\\n");

		District[] districts = new District[line_districts.length];

		for (int i = 0; i < line_districts.length; i++) {
			String[] data_district = line_districts[i].trim().split("\\*");
			districts[i] = new District(data_district[0].trim(), data_district[1].trim(),
					Long.valueOf(data_district[2].trim()),
					Double.valueOf(data_district[3].trim().replaceAll(",", ".")));
		}

		return districts;
	}

	public static Region[] getArrayRegionsFromFile() throws IOException {

		int ch;
		StringBuilder sb = new StringBuilder();

		String pass = System.getProperty("user.dir") + "\\src\\com.epam.training.step04\\task2_03\\data\\regions.txt";
		File f = new File(pass);

		@SuppressWarnings("resource")
		FileReader reader = new FileReader(f);

		while ((ch = reader.read()) != -1) {
			sb.append((char) ch);
		}

		String[] line_regions = sb.toString().split("\\n");

		Region[] regions = new Region[line_regions.length];

		for (int i = 0; i < line_regions.length; i++) {
			String[] data_region = line_regions[i].trim().split("\\*");
			regions[i] = new Region(data_region[0].trim(), data_region[1].trim(), Long.valueOf(data_region[2].trim()));
		}

		return regions;
	}

	public static City getCityFromArroyByName(City[] cites, String name) {

		City result = null;

		for (int i = 0; i < cites.length; i++) {
			if (cites[i].getName().equals(name)) {
				result = cites[i];
				break;
			}
		}

		if (result == null) {
			System.out.printf("Город \"%s\" не найден!\n", name);
		}
		return result;
	}

	public static City findCenterOfUnitFromArroy(Unit entity, City[] cites) {

		int i = 0;
		int k = -1;
		int s = 0;
		while (i != 1) {
			i = 0;
			StringBuilder sb = new StringBuilder();
			for (int l = 0; l <= s; l++) {
				if (l == entity.getName().length() - 1) {
					break;
				}
				sb.append(entity.getName().charAt(l));
			}
			sb.append(".*");
			for (int j = 0; j < cites.length; j++) {
				if (cites[j].getName().matches(sb.toString())) {
					i++;
					k = j;
				}
			}
			s++;
			if (s == entity.getName().length()) {
				return null;
			}
		}

		return cites[k];
	}

	

}
