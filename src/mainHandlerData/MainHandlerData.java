package mainHandlerData;


import controller.Controller;
import persistence.interfce.GenerlFileTxt;
import persistence.interfce.Iperdistence;

public class MainHandlerData {

	public static void main(String[] args) {
		Iperdistence iperdistence = new GenerlFileTxt();
		Controller runner =  new Controller(iperdistence);
		runner.loadConfiguration();
		runner.openMainWindow();

	}
}
