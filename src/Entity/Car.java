package Entity;

public class Car {
	private String marca;
	private String placa;
	private String color;
	private String modelo;
	private String box;
	private int primaryOwner;
	private int secondOwner;
	
	public int getPrimaryOwner() {
		return primaryOwner;
	}

	public void setPrimaryOwner(int primaryOwner) {
		this.primaryOwner = primaryOwner;
	}

	public int getSecondOwner() {
		return secondOwner;
	}

	public void setSecondOwner(int secondOwner) {
		this.secondOwner = secondOwner;
	}

	public String getBox() {
		return box;
	}

	public void setBox(String box) {
		this.box = box;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;	
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	@Override
	public String toString() {
		return "Placa: " + placa + " | Modelo: " + modelo + " | Marca: " + marca + " | Caja: " + box;
	}

}
