package Game;


public class Infernal extends Alien {
	private int cantLlamas = 15;
	private int portalFuego = 20;
	private boolean alas;
	private boolean hacha;

	public int LanzarLlamas() {
		if (cantLlamas == 0 || portalFuego == 0)
			return -1;

		int llama = (int) (Math.random() * 3 + 1);
		cantLlamas = cantLlamas - llama;

		int portal = (int) (Math.random() * 5 + 1);
		portalFuego = portalFuego - portal;

		int poderTotal = llama * portal + getAgilidad() + (getFuerza() / 2);
		if (hacha)
			poderTotal += getDefensa();

		return poderTotal;
	}

	public int GolpeLetal() {
		int portal = (int) (Math.random() * 5 + 1);
		portalFuego = portalFuego - portal;

		int poderTotal = portal * (getFuerza() / 2) + (getAgilidad() / 2);
		if (alas)
			poderTotal += getDefensa();

		return poderTotal;
	}

	// constructor
	public Infernal(String nombre_, int fila_, int columna_, int fuerza_, int agilidad_, int defensa_, int vida_,
			boolean alas_, boolean hacha_) {
		super(nombre_, fila_, columna_, fuerza_, agilidad_, defensa_, vida_);
		alas = alas_;
		hacha = hacha_;
	}

	public String toString() {
		String contenido = super.toString() + "\nCantidad de llamas: " + cantLlamas
				+ "\nCantidad de portales de fuego: " + portalFuego;
		if (hacha) {
			contenido = contenido + "\nPosee hacha";
		}
		if (alas) {
			contenido = contenido + "\nPude volar";
		}
		return contenido;
	}

}
