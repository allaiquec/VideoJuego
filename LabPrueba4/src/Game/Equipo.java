package Game;

import java.util.ArrayList;

public class Equipo {
	private String reino;
	private ArrayList<Alien> misAliens = new ArrayList<Alien>();

	// constructor
	public Equipo(String nombre_, ArrayList<Alien> misAliens_) {
		reino = nombre_;
		misAliens = misAliens_;
	}

	// setter y getters
	public ArrayList<Alien> getMisAliens() {
		return misAliens;
	}

	public void setMisAliens(ArrayList<Alien> misAliens) {
		this.misAliens = misAliens;
	}

	public String getReino() {
		return reino;
	}

	public void setReino(String nombre) {
		this.reino = nombre;
	}

	// métodos
	public void CrearSoldadoAutogenerado(String numEjer_, String[][] tablero) {
		String nomb;
		int maxCant = 10;
		int cantidad1 = (int) (Math.random() * maxCant + 1);
		for (int i = 0; i < cantidad1; i++) {
			int sorteo = (int) (Math.random() * 4 + 1);
			if (sorteo == 1) {
				nomb = "I" + i + "x" + numEjer_;
				int fil = (int) (Math.random() * 9 + 0);
				int col = (int) (Math.random() * 9 + 0);
				int fuerza = (int) (Math.random() * 10 + 1);
				int agilidad = (int) (Math.random() * 10 + 1);
				int defensa = (int) (Math.random() * 10 + 1);
				int vida = (int) (Math.random() * 10 + 1);
				Probarvalores(fil, col, tablero, nomb);

				misAliens.add(new Infernal(nomb, fil, col, fuerza, agilidad, defensa, vida, true, false));

			} else if (sorteo == 2) {
				nomb = "G" + i + "x" + numEjer_;
				int fil = (int) (Math.random() * 9 + 0);
				int col = (int) (Math.random() * 9 + 0);
				int fuerza = (int) (Math.random() * 10 + 1);
				int agilidad = (int) (Math.random() * 10 + 1);
				int defensa = (int) (Math.random() * 10 + 1);
				int vida = (int) (Math.random() * 10 + 1);
				Probarvalores(fil, col, tablero, nomb);

				misAliens.add((new Gelido(nomb, fil, col, fuerza, agilidad, defensa, vida, false)));

			} else if (sorteo == 3) {
				nomb = "D" + i + "x" + numEjer_;
				int fil = (int) (Math.random() * 9 + 0);
				int col = (int) (Math.random() * 9 + 0);
				int fuerza = (int) (Math.random() * 10 + 1);
				int agilidad = (int) (Math.random() * 10 + 1);
				int defensa = (int) (Math.random() * 10 + 1);
				int vida = (int) (Math.random() * 10 + 1);
				Probarvalores(fil, col, tablero, nomb);

				misAliens.add((new Destructor(nomb, fil, col, fuerza, agilidad, defensa, vida, 3, true)));

			} else {
				nomb = "N" + i + "x" + numEjer_;
				int fil = (int) (Math.random() * 9 + 0);
				int col = (int) (Math.random() * 9 + 0);
				int fuerza = (int) (Math.random() * 10 + 1);
				int agilidad = (int) (Math.random() * 10 + 1);
				int defensa = (int) (Math.random() * 10 + 1);
				int vida = (int) (Math.random() * 10 + 1);
				Probarvalores(fil, col, tablero, nomb);

				misAliens.add((new Nature(nomb, fil, col, fuerza, agilidad, defensa, vida, false, false)));
			}

		}

	}

	public static void Probarvalores(int x, int y, String[][] tablero, String nomb) {
		while (true) {
			if (tablero[x][y] != "____") {
				x = (int) (Math.random() * 9 + 0);
				y = (int) (Math.random() * 9 + 0);
			} else if (tablero[x][y] == "____") {
				tablero[x][y] = nomb;
				break;
			}
		}
	}

}