package Game;

public class Alien {
	private String nombre;
	private int fila;
	private int columna;

	private int fuerza;
	private int agilidad;
	private int defensa;
	private int vida;

	// setter y getters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public int getAgilidad() {
		return agilidad;
	}

	public void setAgilidad(int agilidad) {
		this.agilidad = agilidad;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	// constructor Alien
	public Alien(String nombre_, int fila_, int columna_, int fuerza_, int agilidad_, int defensa_, int vida_) {
		nombre = nombre_;
		fila = fila_;
		columna = columna_;
		fuerza = fuerza_;
		agilidad = agilidad_;
		defensa = defensa_;
		vida = vida_;
	}

	public String toString() {
		return "\nNombre: " + nombre + "\nFila: " + fila + "\nColumna: " + columna + "\nNivel de Fuerza: " + fuerza
				+ "\nNivel de Agilidad: " + agilidad + "\nNivel de defensa: " + defensa + "\nNivel de Vida: " + vida;
	}

	public void sumarPuntos(int puntoExtra) {
		fuerza = fuerza + puntoExtra;
		agilidad = agilidad + puntoExtra;
		defensa = defensa + puntoExtra;
	}

	public void sumarVida(int n) {
		vida = vida + n;
	}

}