package tp1.ejercicio5;

public class Resultado {
	private int minimo;
	private int maximo;
	private int promedio;
	
	public Resultado() {
		// TODO Auto-generated constructor stub
	}
	
	public void setMaximo(int maximo) {
		this.maximo = maximo;
	}
	public void setMinimo(int minimo) {
		this.minimo = minimo;
	}
	public void setPromedio(int promedio) {
		this.promedio = promedio;
	}
	public int getMaximo() {
		return maximo;
	}
	public int getMinimo() {
		return minimo;
	}
	public int getPromedio() {
		return promedio;
	}
	public void copiarValores(Resultado resultado) {
		this.minimo=resultado.minimo;
		this.maximo=resultado.maximo;
		this.promedio=resultado.promedio;
	}
}
