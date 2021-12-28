package Game;


public class Nature extends Alien {
	private int cantEspinas = 15;
	private int cantEnredaderas = 20;
	private boolean veneno;
	private boolean lanza;

	public int LanzarEspinas() {
		if (cantEspinas == 0)
			return -1;
		int cantEspin = (int) (Math.random() * 2 + 1);
		cantEspinas = cantEspinas - cantEspin;

		int poderTotal = cantEspin * getAgilidad() + getFuerza();
		if (lanza)
			poderTotal += getDefensa();
		return poderTotal;

	}

	public int Inmovilizar() {
		int cantEnd = (int) (Math.random() * 2 + 1);
		cantEnredaderas = cantEnredaderas - cantEnd;
		int total = cantEnd * (getFuerza() / 2) + getAgilidad() + getDefensa();

		if (veneno) {
			return total + 5;
		}
		return total;
	}

	// constructor
	public Nature(String nombre_, int fila_, int columna_, int fuerza_, int agilidad_, int defensa_, int vida_,
			boolean veneno_, boolean lanza_) {
		super(nombre_, fila_, columna_, fuerza_, agilidad_, defensa_, vida_);
		veneno = veneno_;
		lanza = lanza_;
	}

	// metodo toString()
	public String toString() {
		String contenido = super.toString() + "\nCantidad de espinas: " + cantEspinas + "\nCantidad de enredaderas: "
				+ cantEnredaderas;
		if (lanza) {
			contenido = contenido + "\nPosee lanza";
		}
		if (veneno) {
			contenido = contenido + "\nTiene veneno";
		}
		return contenido;
	}

}
