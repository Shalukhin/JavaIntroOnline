package step04.task2_02.logic;

import java.util.Formatter;

import step04.task2_02.beans.Car;
import step04.task2_02.beans.Wheel;
import step04.task2_02.utils.ConsoleScanner;
import step04.task2_02.view.Viewer;

public class CarLogic {
	
	private Car car;
	private EngineLogic engineLogic = new EngineLogic();
	private TankLogic tankLogic = new TankLogic();
	private WheelLogic wheelLogic = new WheelLogic();
	private ConsoleScanner consoleScanner = new ConsoleScanner();
	private Viewer viewer = new Viewer();
	
	public CarLogic(Car car) {
		super();
		this.car = car;
	}
	
	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
	
	public void drive (int distance) throws InterruptedException {
		if (!checkBeforeStart()) {
			return;
		}
		for (int i = 1; i <= distance; i++) {
			
			if (!chekAfterStart()) {
				viewer.showMessageInConsole(String.format("Проехано %d км из запланированных %d км.", (i - 1), distance));
				return;
			}
			
			Thread.sleep(100);			
			
			viewer.showMessageInConsole(String.format("Проехали " + i + " км"));			
			car.setMileage(car.getMileage() + 1);
			wheelLogic.resourceDecrease(car.getFrontLeft(), 1.25);			
			wheelLogic.resourceDecrease(car.getFrontRight(), 1.15);			
			wheelLogic.resourceDecrease(car.getBackLeft(), 1);			
			wheelLogic.resourceDecrease(car.getBackRight(), 1.05);
			engineLogic.resourceDecrease(car.getEngine(), 1);
			tankLogic.fuelDecrease(car.getTank(), 1, car.getEngine().getFuelConsumption());
		}
		viewer.showMessageInConsole(String.format("Проехано %1$d км из запланированных %1$d км.\n", distance));
	}
	
	public boolean checkBeforeStart() {
		if (car.getFrontLeft().getResource() * car.getFrontRight().getResource() * car.getBackLeft().getResource() * car.getBackRight().getResource() == 0) {
			viewer.showMessageInConsole(String.format("Одно или несколько колёс исчерпали свой ресурс. Замените!"));
			return false;
		}		
		
		if (!car.getEngine().isStarted()) {
			viewer.showMessageInConsole(String.format("Двигатель не заведён! Заведите двигатель!"));
			return false;
		}
		
		if (car.getSpareWheel() == null) {
			viewer.showMessageInConsole(String.format("У вас нет запаски! Продолжить путь? (y/n)"));
			String opt = consoleScanner.getStrFromConsol();
			while (!opt.equals("y") || !opt.equals("n")) {
				viewer.showMessageInConsole(String.format("У вас нет запаски! Продолжить путь? (y/n)"));
				opt = consoleScanner.getStrFromConsol();
			}
			
			if (opt.equals("n")) {
				return false;
			}			
		}
		return true;
	}
	
	public boolean chekAfterStart() {
		
		if (car.getFrontLeft().getResource() <= 0) {
			viewer.showMessageInConsole(String.format("Лопнуло переднее левое колесо! Движение прекращено! Замените колесо!"));
			engineLogic.stop(car.getEngine());			
			return false;
		}
		if (car.getFrontRight().getResource() <= 0) {
			viewer.showMessageInConsole(String.format("Лопнуло переднее правое колесо! Движение прекращено! Замените колесо!"));
			engineLogic.stop(car.getEngine());
			return false;
		}
		if (car.getBackLeft().getResource() <= 0) {
			viewer.showMessageInConsole(String.format("Лопнуло заднее левое колесо! Движение прекращено! Замените колесо!"));
			engineLogic.stop(car.getEngine());
			return false;
		}
		if (car.getBackRight().getResource() <= 0) {
			viewer.showMessageInConsole(String.format("Лопнуло заднее правое колесо! Движение прекращено! Замените колесо!"));
			engineLogic.stop(car.getEngine());
			return false;
		}
		if (car.getEngine().getResource() <= 0) {
			viewer.showMessageInConsole(String.format("Двигатель исчерпал свой ресурс и вышел из строя! Движение прекращено! Замените двигатель!"));
			engineLogic.stop(car.getEngine());
			return false;
		}
		if (car.getTank().getVolumeFuel() <= 0) {
			viewer.showMessageInConsole(String.format("Кончелось топливо! Движение прекращено! Заправьте автомобиль!"));
			engineLogic.stop(car.getEngine());
			return false;
		}
		return true;
		
	}
	
	public void replaceWheelToSpare(int idWheel) {
		
		if (car.getSpareWheel() == null) {
			viewer.showMessageInConsole(String.format("У вас нет запаски! Купите новую запаску!"));
			return;
		}
		
		Wheel temp = car.getSpareWheel();				
		
		switch (idWheel) {
		case (1):
			car.setSpareWheel(car.getFrontLeft());
			car.setFrontLeft(temp);			
			break;
		case (2):
			car.setSpareWheel(car.getFrontRight());
			car.setFrontRight(temp);				
			break;
		case (3):
			car.setSpareWheel(car.getBackLeft());
			car.setBackLeft(temp);	
			break;
		case (4):
			car.setSpareWheel(car.getBackRight());
			car.setBackRight(temp);			
			break;					
		}		
	}	
	
	public void replaceWheel(int idWheel) {
		viewer.showMessageInConsole(String.format("введите производителя покупаемого колеса:"));
		String brand = consoleScanner.getStrFromConsol();
		viewer.showMessageInConsole(String.format("введите радиус покупаемого колеса:"));
		int radius = consoleScanner.getIntFromConsol();
		viewer.showMessageInConsole(String.format("введите ресурс покупаемого колеса:"));
		double resource = consoleScanner.getDoubleFromConsol();
		Wheel newWheel = new Wheel(brand, radius, resource);
		
		switch (idWheel) {
		case (1):
			car.setFrontLeft(newWheel);			
			break;
		case (2):
			car.setFrontRight(newWheel);	
			break;
		case (3):
			car.setBackLeft(newWheel);
			break;
		case (4):			
			car.setBackRight(newWheel);			
			break;
		case (5):
			car.setSpareWheel(newWheel);	
			break;
		}
	}	
	
	public void addFuel(double volumeFuel) {
		tankLogic.refuel(car.getTank(), volumeFuel);
	}
		
	public void startEngine() {
		if (car.getTank().getVolumeFuel() == 0) {
			viewer.showMessageInConsole(String.format("Двигатель не заведён! Нет топлива! Заправьте машину!"));
			return;
		}
		engineLogic.start(car.getEngine());
	}	
	
	public void stopEngine() {		
		engineLogic.stop(car.getEngine());
	}	
	
	public String infoAboutWheels() {
		
		@SuppressWarnings("resource")
		Formatter ft = new Formatter();
		ft.format("Состояние колёс:\n");
		ft.format("\tПереднее левое: \n%s\n", (car.getFrontLeft() != null ? car.getFrontLeft().info() : "отсутствует"));
		ft.format("\tПереднее правое: \n%s\n", (car.getFrontRight() != null ? car.getFrontRight().info() : "отсутствует"));
		ft.format("\tЗаднее левое: \n%s\n", (car.getBackLeft() != null ? car.getBackLeft().info() : "отсутствует"));
		ft.format("\tЗаднее правое: \n%s\n", (car.getBackRight() != null ? car.getBackRight().info() : "отсутствует"));
		ft.format("\tЗапаска: \n%s\n", (car.getSpareWheel() != null ? car.getSpareWheel().info() : "отсутствует"));
		
		return ft.toString();
	}	
	
	public String InfoAboutEngine() {				
		return car.getEngine().info();
	}
		
	public String InfoAboutTank() {		
		return car.getTank().info();
	}
	
	public String info() {
		return String.format("Марка автомобиля: %s\nПробег: %d\n\nИнформация по двигателю:\n%s\nИнформация по топливному баку:\n%s\nИнформация по колёсам:\n%s", car.getModel(), 
				car.getMileage(), car.getEngine().info(), car.getTank().info(), infoAboutWheels());
	}

	@Override
	public String toString() {
		return "CarLogic [car=" + car + "]";
	}	
}
