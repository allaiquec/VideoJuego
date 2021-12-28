package Game;


public class Destructor extends Alien {
	private int cantRocas = 15;
	private int cantBrazos;
	private boolean martillo;

	public int LanzarRocas() {
		if (cantRocas == 0)
			return -1;
		int rocas = (int) (Math.random() * 3 + 1);
		cantRocas = cantRocas - rocas;

		if (martillo)
			return rocas * cantBrazos + getFuerza() + (getAgilidad() / 2) + getDefensa();

		return rocas * cantBrazos + getFuerza() + (getAgilidad() / 2);

	}

	public int GolpeDemoledor() {
		return cantBrazos * getFuerza() - getAgilidad();
	}

	// contructor
	public Destructor(String nombre_, int fila_, int columna_, int fuerza_, int agilidad_, int defensa_, int vida_,
			int cantidadBrazos_, boolean martillo_) {
		super(nombre_, fila_, columna_, fuerza_, agilidad_, defensa_, vida_);
		cantBrazos = cantidadBrazos_;
		martillo = martillo_;
	}

	// metodo toString()
	public String toString() {
		if (martillo) {
			return super.toString() + "\nCantidad de rocas: " + cantRocas + "\nCantidad de brazos: " + cantBrazos
					+ "\nPosee martillo";
		}
		return super.toString() + "\nCantidad de rocas: " + cantRocas + "\nCantidad de brazos: " + cantBrazos;
	}
}
