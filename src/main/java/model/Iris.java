package model;

public class Iris {

	private double sepalLength;
	private double sepalWidth;
	private double petalLength;
	private double petalWidth;
	private String classe;
	public double getSepalLength() {
		return sepalLength;
	}
	public void setSepalLength(double sepalLength) {
		this.sepalLength = sepalLength;
	}
	public double getSepalWidth() {
		return sepalWidth;
	}
	public void setSepalWidth(double sepalWidth) {
		this.sepalWidth = sepalWidth;
	}
	public double getPetalLength() {
		return petalLength;
	}
	public void setPetalLength(double petalLength) {
		this.petalLength = petalLength;
	}
	public double getPetalWidth() {
		return petalWidth;
	}
	public void setPetalWidth(double petalWidth) {
		this.petalWidth = petalWidth;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	@Override
	public String toString() {
		return this.classe;
	}
	
	
}
