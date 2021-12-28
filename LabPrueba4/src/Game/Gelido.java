package Game;


public class Gelido extends Alien {
	private int cantEstacasHielo = 15;
	private int portalHielo = 20;
	private boolean espada;

	public int LanzarEstacas() {
		if (cantEstacasHielo == 0 || portalHielo == 0)
			return -1;
		int estacas = (int) (Math.random() * 3 + 1);
		cantEstacasHielo = cantEstacasHielo - estacas;
		int cant1 = (int) (Math.random() * 5 + 1);
		portalHielo = portalHielo - cant1;

		if (espada) {
			return estacas * cant1 + ((getFuerza() / 2)) + getAgilidad() + getDefensa();
		}
		return estacas * cant1 + ((getFuerza() / 2)) + getAgilidad();
	}

	public int Congelar() {
		if (portalHielo == 0)
			return -1;

		int cant1 = (int) (Math.random() * 5 + 1);
		portalHielo = portalHielo - cant1;

		int poderTotal = (cant1 * (getAgilidad() / 2) + (getFuerza() / 2) + getDefensa());

		return poderTotal;
	}

	// constructor
	public Gelido(String nombre_, int fila_, int columna_, int fuerza_, int agilidad_, int defensa_, int vida_,
			boolean espada_) {
		super(nombre_, fila_, columna_, fuerza_, agilidad_, defensa_, vida_);
		espada = espada_;
	}

	// metodo toString()
	public String toString() {
		if (espada) {
			return super.toString() + "\nCantidad de estacas de hielo: " + cantEstacasHielo
					+ "\nCantidad de portales de hielo: " + portalHielo + "\nPosee espada";
		}
		return super.toString() + "\nCantidad de estacas de hielo: " + cantEstacasHielo
				+ "\nCantidad de portales de hielo: " + portalHielo;
	}
}
