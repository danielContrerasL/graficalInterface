package logic;

import java.io.IOException;
import java.util.ArrayList;

import Entity.Car;
import persistence.interfce.Iperdistence;

public class CarLogic {
	@SuppressWarnings("unused")
	private CarFileTxt carFileTxt;
	private Iperdistence iperdistence;

	public CarLogic() {
		carFileTxt = new CarFileTxt(CarFileTxt.CAR_TABLE_INFORMATION);
	}

	public void save(Car car) throws IOException {
		vlidteEmptyspace(car);
		validatePlaca(car.getPlaca());
		if (iperdistence == null) {
			throw new IOException("No Persistence");
		}
		iperdistence.saveCar(car);
	}
	
	public void vlidteEmptyspace(Car car) throws IOException {
		if (car.getBox() == null || car.getMarca() == null || car.getModelo() == null || car.getPlaca()	== null ) {
			throw new IOException("Espacio Vacío Invalido");
		}
	}
	public ArrayList<Car> load() throws IOException {
		if (iperdistence == null) {
			throw new IOException("No Persistence");
		}
		return iperdistence.lodCar();
	}
	
	public void setPersistence(Iperdistence iperdistence) {
		this.iperdistence = iperdistence;
	}
	
	public void validatePlaca(String placa) throws IOException {
		if (placa.length() > 5) {
			throw new IOException("Extencion invalida");
		}
		validateNumber(placa);
		validateChar(placa);
			
	}
	
	private void validateNumber(String placa) throws IOException {
		try {
			Integer.parseInt(placa.substring(0,2));
		} catch (NumberFormatException e) {
			throw new IOException("Numeros Invalido");
		}
	}
	
	private void validateChar(String placa)throws IOException {
		placa = placa.substring(2, placa.length());
		for (int i = 0; i < placa.length(); i++) {
			if (placa.charAt(i) < 65 || placa.charAt(i) > 90) {
				throw new IOException("Letras Invalidas");
			}
		}
		
	}

}
