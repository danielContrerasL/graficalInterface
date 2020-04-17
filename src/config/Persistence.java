package config;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Persistence {
	private File file;
	private FileReader fileReader;
	private FileWriter fileWriter;
	private BufferedReader bufferedReader;
	private BufferedWriter bufferedWriter;

	public Persistence(String fileName) {
		file = new File(fileName);
	}

	public void renamefile(String fileName) {
		file.renameTo(new File(fileName));
		file = new File(fileName);
	}

	public void open(boolean mode) throws IOException {
		if (mode) {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
		} else {
			fileWriter = new FileWriter(file, true);
			bufferedWriter = new BufferedWriter(fileWriter);
		}
	}

	public String readFile() throws IOException {
		return bufferedReader.readLine();
	}

	public void writer(String chain) throws IOException {
		bufferedWriter.write(chain);
		bufferedWriter.newLine();
	}

	public void close() throws IOException {
		if ((bufferedReader != null)) {
			bufferedReader.close();
			fileReader.close();
		} else {
			bufferedWriter.close();
			fileWriter.close();
		}
	}
}