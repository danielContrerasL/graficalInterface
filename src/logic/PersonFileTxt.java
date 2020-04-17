package logic;

import java.io.IOException;

import Entity.Person;
import config.Persistence;

public class PersonFileTxt extends Persistence {
	public static final char IDENTI = ',';
	public static final String TABLE_INFORMATION = "table.txt";

	public PersonFileTxt(String fileName) {
		super(fileName);
	}
	
	public void saveAPerson(Person person) throws IOException {
		String personToSave = "";
		personToSave = person.getName() +IDENTI + person.getLastName() + IDENTI + person.getGender() + IDENTI + person.getCode();
		super.open(false);
		super.writer(personToSave);
		super.close();
	}
	
	public Person readPerson() throws IOException {
		String info = super.readFile();
		Person person =  null;
		if (info != null) {
			String[] cutInfo = info.split(",");
			person =  new Person();
			person.setName(cutInfo[0]);
			person.setLastName(cutInfo[1]);
			person.setGender(cutInfo[2]);
			person.setCode(Integer.parseInt(cutInfo[3]));
		}
		return person;
	}
}
