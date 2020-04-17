package logic;

import java.io.IOException;

import Entity.Car;
import config.Persistence;

public class CarFileTxt extends Persistence {
	public static final char IDENTI = ',';
	public static final String CAR_TABLE_INFORMATION = "cartable.txt";

	public CarFileTxt(String fileName) {
		super(fileName);
	}

	public void saveACar(Car car) throws IOException {
		String CarToSave = "";
		CarToSave = car.getPlaca() + IDENTI + car.getMarca() + IDENTI + car.getModelo() + IDENTI + car.getBox();
		super.open(false);
		super.writer(CarToSave);
		super.close();
	}
	


	public Car readCar() throws IOException {
		String info = super.readFile();
		Car car = null;
		if (info != null) {
			String[] cutInfo = info.split(",");
			car = new Car();
			car.setPlaca(cutInfo[0]);
			car.setMarca(cutInfo[1]);
			car.setModelo(cutInfo[2]);
			car.setBox(cutInfo[3]);
		}
		return car;
	}

}
