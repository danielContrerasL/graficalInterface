package persistence.interfce;

import java.io.IOException;
import java.util.ArrayList;

import Entity.Car;
import Entity.Person;

public interface Iperdistence {
	
	public void svePerson(Person person)throws IOException;
	public ArrayList<Person> lodPerson()throws IOException;
		
	public void saveCar(Car car)throws IOException;
	public ArrayList<Car> lodCar()throws IOException;
		

}
