package config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

@SuppressWarnings("serial")
public class HandlerProperties extends Properties {
	private String fileName;

	public HandlerProperties(String fileName) {
		this.fileName = fileName;
		try {
			load();
		} catch (Exception e) {
		}
	}

	private void load() throws IOException {
		FileInputStream inputStream;
		inputStream = new FileInputStream(fileName);
		load(inputStream);
		inputStream.close();
	}

	public void save() throws IOException {
		FileOutputStream fileOutputStream = new FileOutputStream(fileName);
		store(fileOutputStream, null);
		fileOutputStream.close();
	}

	// public HandlerProperties(String propertiesFileName) {
	// try {
	// load(new FileReader(propertiesFileName));
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
}
// clase abstracta
// metodos virtuales,
// polimorfismo