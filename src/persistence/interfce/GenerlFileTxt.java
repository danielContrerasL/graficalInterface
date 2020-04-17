package persistence.interfce;

import java.io.IOException;
import java.util.ArrayList;

import Entity.Car;
import Entity.Person;
import logic.CarFileTxt;
import logic.PersonFileTxt;

public class GenerlFileTxt implements Iperdistence {
	private PersonFileTxt fileTxt;
	private CarFileTxt carFileTxt;

	public GenerlFileTxt() {
		fileTxt = new PersonFileTxt(PersonFileTxt.TABLE_INFORMATION);
		carFileTxt= new CarFileTxt(CarFileTxt.CAR_TABLE_INFORMATION);
	}

	public ArrayList<Person> load() throws IOException {
		fileTxt.open(true);
		Person person = null;
		ArrayList<Person> list = new ArrayList<Person>();
		while ((person = fileTxt.readPerson()) != null) {
			list.add(person);
		}
		fileTxt.close();
		return list;
	}

	public void validateGender(String gender) throws Exception {
		if (gender.equals("n")) {
			throw new Exception("Definir Genero");
		}
	}

	public void validateCharaterChain(String name) throws Exception {
		if (name == null || name.length() < 3) {
			throw new Exception(name + ": Etencion invalida");
		}
	}

	@Override
	public void svePerson(Person person) throws IOException {
		fileTxt.open(false);
		fileTxt.saveAPerson(person);
		fileTxt.close();		
	}

	@Override
	public ArrayList<Person> lodPerson() throws IOException {
		fileTxt.open(true);
		Person person = null;
		ArrayList<Person> list = new ArrayList<Person>();
		while ((person = fileTxt.readPerson()) != null) {
			list.add(person);
		}
		fileTxt.close();
		return list;
	}

	@Override
	public void saveCar(Car car) throws IOException {
		carFileTxt.open(false);
		carFileTxt.saveACar(car);
		carFileTxt.close();
	}

	@Override
	public ArrayList<Car> lodCar() throws IOException {
		carFileTxt.open(true);
		Car car = null;
		ArrayList<Car> list = new ArrayList<Car>();
		while ((car = carFileTxt.readCar()) != null) {
			list.add(car);
		}
		carFileTxt.close();
		return list;
	}

}
