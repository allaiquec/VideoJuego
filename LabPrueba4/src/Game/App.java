package Game;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class App {

	public static String[][] tablero = new String[10][10];
	public static String[][] tablero2 = new String[10][10];

	public App() {

		Scanner sc = new Scanner(System.in);
		int resp = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Desea comenzar? (yes=1) (No=2) "));

		while (resp == 1) {
			// tablero
			ValoresInicialesTablero2();
			// ImprimirTablero2();

			ValoresInicialesTablero();

			// Crear equipos
			Equipo ejer1 = new Equipo("Rojos", new ArrayList<Alien>());
			ejer1.CrearSoldadoAutogenerado("1", tablero);

			Equipo ejer2 = new Equipo("Azules", new ArrayList<Alien>());
			ejer2.CrearSoldadoAutogenerado("2", tablero);

			// Matriz de Aliens
			// System.out.println("\n BATALLA DE ALIENS");
			// ImprimirTablero();
			GuiTablero gui = new GuiTablero(tablero);
			gui.setVisible(true);

			while (true) {
				JOptionPane.showMessageDialog(null, "Turno del equipo: (1) " + ejer1.getReino());
				String nomb1 = JOptionPane.showInputDialog("Seleccione a un alien de su equipo");

				while (BusquedaNomb(ejer1.getMisAliens(), nomb1) == -1) {
					nomb1 = JOptionPane.showInputDialog(null,
							"No válido. Intente de nuevo.Seleccione a un alien de su equipo");
				}

				int index1 = BusquedaNomb(ejer1.getMisAliens(), nomb1);
				JOptionPane.showMessageDialog(null, ejer1.getMisAliens().get(index1).toString());

				int rptaAccion = Integer
						.parseInt(JOptionPane.showInputDialog("Seleccione una opción: \n1.Mover\n2.Atacar\nRPTA:"));

				// 1. MOVIMIENTO

				if (rptaAccion == 1) {
					int fil = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la fila que deseea: "));
					int col = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la columna que deseea: "));

					// verificar que esté vacío la casilla
					while (verificar(fil, col) == -1) {

						JOptionPane.showMessageDialog(null,
								"Fila y columna no válida(o bien no existe o está ocupada). Intente de nuevo");

						fil = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la fila que deseea: "));
						col = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la columna que deseea: "));

					}
					nuevaFilCol(fil, col, ejer1.getMisAliens().get(index1));
					JOptionPane.showMessageDialog(null,
							"La casilla escogida contenía : +" + cuanto(fil, col) + " puntos");
					ejer1.getMisAliens().get(index1).sumarPuntos(cuanto(fil, col));

					// ImprimirTablero();
					gui.Actualizar(tablero);
					gui.setVisible(true);
					// 2. ATAQUE

				} else {

					String nomb2 = JOptionPane.showInputDialog("Ingrese nombre del alien a atacar: ");

					while (BusquedaNomb(ejer2.getMisAliens(), nomb2) == -1) {

						nomb2 = JOptionPane
								.showInputDialog("No válido. Intente de nuevo.Ingrese nombre del alien a atacar: ");

					}
					int index2 = BusquedaNomb(ejer2.getMisAliens(), nomb2);

					// Resumiendo nombres
					Alien atacante = ejer1.getMisAliens().get(index1);
					Alien afectado = ejer2.getMisAliens().get(index2);

					int rptaMetodo1 = Integer.parseInt(JOptionPane
							.showInputDialog("El alien atacante posee los siguientes métodos: " + Poderes(atacante)));

					int cantPoder1;
					if (rptaMetodo1 == 1) {
						cantPoder1 = PrimerMetodo(atacante);
					} else {
						cantPoder1 = SegundoMetodo(atacante);
					}

					int rptaMetodo2 = Integer.parseInt(JOptionPane
							.showInputDialog("Equipo AZUL.Te están atacando, defiendete con los siguientes métodos: "
									+ Poderes(afectado)));

					int cantPoder2;
					if (rptaMetodo2 == 1) {
						cantPoder2 = PrimerMetodo(afectado);
					} else {
						cantPoder2 = SegundoMetodo(afectado);
					}

					// DEFINIENDO GANADOR DE PARTIDA

					JOptionPane.showMessageDialog(null,
							"DEFINIENDO GANADOR\n" + atacante.getNombre() + " con un total de poder: " + cantPoder1
									+ "\n" + afectado.getNombre() + " con un total de poder: " + cantPoder2);

					if (cantPoder1 > cantPoder2) {
						nuevaFilCol(afectado.getFila(), afectado.getColumna(), atacante);
						ejer2.getMisAliens().remove(index2);
						JOptionPane.showMessageDialog(null, "GANADOR: " + atacante.getNombre() + " \nHa ganado : +"
								+ afectado.getVida() + " puntos de vida");
						atacante.sumarVida(afectado.getVida());
					} else if (cantPoder1 < cantPoder2) {
						nuevaFilCol(atacante.getFila(), atacante.getColumna(), afectado);
						ejer1.getMisAliens().remove(index1);
						JOptionPane.showMessageDialog(null, "GANADOR: " + afectado.getNombre() + " \nHa ganado : +"
								+ atacante.getVida() + " puntos de vida");
						afectado.sumarVida(atacante.getVida());

					} else {
						JOptionPane.showMessageDialog(null, "EMPATE");
					}
					// ImprimirTablero();
					gui.Actualizar(tablero);
					gui.setVisible(true);

					if (ejer1.getMisAliens().isEmpty() || ejer2.getMisAliens().isEmpty()) {

						if (ejer1.getMisAliens().isEmpty()) {
							JOptionPane.showMessageDialog(null, "FIN DE LA BATALLA\nEL GANADOR ES EL EJERCITO 2");
						} else {
							JOptionPane.showMessageDialog(null, "FIN DE LA BATALLA\nEL GANADOR ES EL EJERCITO 1");
						}
						break;
					}
				}

				JOptionPane.showMessageDialog(null, "\nTurno del equipo: (2) " + ejer2.getReino());
				String nomb2 = JOptionPane.showInputDialog("Seleccione a un alien de su equipo");

				while (BusquedaNomb(ejer2.getMisAliens(), nomb2) == -1) {
					JOptionPane.showMessageDialog(null, "No válido. Intente de nuevo");
					nomb2 = JOptionPane.showInputDialog("Seleccione a un alien de su equipo");
				}

				int index2 = BusquedaNomb(ejer2.getMisAliens(), nomb2);

				JOptionPane.showMessageDialog(null, ejer2.getMisAliens().get(index2).toString());

				int rptaAccion2 = Integer
						.parseInt(JOptionPane.showInputDialog("Seleccione una opción: \n1.Mover\n2.Atacar\nRPTA:"));

				// 1. MOVIMIENTO

				if (rptaAccion2 == 1) {
					// Mover por toda la matriz
					int fil = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la fila que deseea: "));
					int col = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la columna que deseea: "));

					// verificar que esté vacío la casilla
					while (verificar(fil, col) == -1) {

						JOptionPane.showMessageDialog(null,
								"Fila y columna no válida(o bien no existe o está ocupada). Intente de nuevo");
						fil = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la fila que deseea: "));
						col = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la columna que deseea: "));

					}
					nuevaFilCol(fil, col, ejer2.getMisAliens().get(index2));
					JOptionPane.showMessageDialog(null,
							"La casilla escogida contenía : +" + cuanto(fil, col) + " puntos");
					ejer2.getMisAliens().get(index2).sumarPuntos(cuanto(fil, col));

					// ImprimirTablero();

					gui.Actualizar(tablero);
					gui.setVisible(true);
					// 2. ATAQUE

				} else {

					String nombre1 = JOptionPane.showInputDialog("Ingrese nombre del alien a atacar: ");

					while (BusquedaNomb(ejer1.getMisAliens(), nombre1) == -1) {
						nombre1 = JOptionPane
								.showInputDialog("No válido. Intente de nuevo.Ingrese nombre del alien a atacar: ");
					}
					int index_1 = BusquedaNomb(ejer1.getMisAliens(), nombre1);

					// Resumiendo nombres
					Alien atacante = ejer2.getMisAliens().get(index2);
					Alien afectado = ejer1.getMisAliens().get(index_1);

					int rptaMetodo1 = Integer.parseInt(JOptionPane
							.showInputDialog("El alien atacante posee los siguientes métodos: " + Poderes(atacante)));

					int cantPoder1;
					if (rptaMetodo1 == 1) {
						cantPoder1 = PrimerMetodo(atacante);
					} else {
						cantPoder1 = SegundoMetodo(atacante);
					}

					int rptaMetodo2 = Integer.parseInt(JOptionPane
							.showInputDialog("Equipo ROJO.Te están atacando, defiendete con los siguientes métodos: "
									+ Poderes(afectado)));

					int cantPoder2;
					if (rptaMetodo2 == 1) {
						cantPoder2 = PrimerMetodo(afectado);
					} else {
						cantPoder2 = SegundoMetodo(afectado);
					}

					// DEFINIENDO GANADOR DE PARTIDA

					JOptionPane.showMessageDialog(null,
							"DEFINIENDO GANADOR\n" + atacante.getNombre() + " con un total de poder: " + cantPoder1
									+ "\n" + afectado.getNombre() + " con un total de poder: " + cantPoder2);
					if (cantPoder1 > cantPoder2) {
						nuevaFilCol(afectado.getFila(), afectado.getColumna(), atacante);
						ejer1.getMisAliens().remove(index_1);
						JOptionPane.showMessageDialog(null, "GANADOR: " + atacante.getNombre() + " \nHa ganado : +"
								+ afectado.getVida() + " puntos de vida");
						atacante.sumarVida(afectado.getVida());

					} else if (cantPoder1 < cantPoder2) {
						nuevaFilCol(atacante.getFila(), atacante.getColumna(), afectado);
						ejer2.getMisAliens().remove(index2);
						JOptionPane.showMessageDialog(null, "GANADOR: " + afectado.getNombre() + " \nHa ganado : +"
								+ atacante.getVida() + " puntos de vida");
						afectado.sumarVida(atacante.getVida());

					} else {
						JOptionPane.showMessageDialog(null, "EMPATE");
					}
					// ImprimirTablero();
					gui.Actualizar(tablero);
					gui.setVisible(true);
					if (ejer1.getMisAliens().isEmpty() || ejer2.getMisAliens().isEmpty()) {

						if (ejer1.getMisAliens().isEmpty()) {
							JOptionPane.showMessageDialog(null,
									"FIN DE LA BATALLA\nEL GANADOR ES EL EJERCITO 2: AZULES");
						} else {
							JOptionPane.showMessageDialog(null,
									"FIN DE LA BATALLA\nEL GANADOR ES EL EJERCITO 1 : ROJOS");
						}
						break;
					}
				}

			}

			resp = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Desea jugar de nuevo? (yes=1) (No=2) "));

		}

	}

	// Llenar todo el tablero con "____" como valor inicial
	public static void ValoresInicialesTablero() {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				tablero[i][j] = "____";
			}
		}
	}

	// Llenar todo el tablero con "____" como valor inicial
	public static void ValoresInicialesTablero2() {

		for (int i = 0; i < tablero2.length; i++) {
			for (int j = 0; j < tablero2[i].length; j++) {
				int puntExtra = (int) (Math.random() * 3 + 1);
				if (puntExtra == 1) {
					tablero2[i][j] = "1";
				} else if (puntExtra == 2) {
					tablero2[i][j] = "2";
				} else if (puntExtra == 3) {
					tablero2[i][j] = "3";
				}

			}
		}
	}

	// Imprimir el tablero con todo sus elementos
	public static void ImprimirTablero() {

		System.out.println("    " + "0  " + "   " + "1 " + "   " + "2  " + "   " + "3  " + "   " + "4  " + "   " + "5  "
				+ "   " + "6  " + "   " + "7  " + "   " + "8  " + "   " + "9  ");
		for (int i = 0; i < tablero.length; i++) {
			System.out.print(i);
			for (int j = 0; j < tablero[i].length; j++) {
				System.out.print("|" + tablero[i][j] + "|");
			}
			System.out.println("");
		}
	}

	// Imprimir el tablero con todo sus elementos
	public static void ImprimirTablero2() {

		System.out.println("    " + "0  " + "   " + "1 " + "   " + "2  " + "   " + "3  " + "   " + "4  " + "   " + "5  "
				+ "   " + "6  " + "   " + "7  " + "   " + "8  " + "   " + "9  ");
		for (int i = 0; i < tablero2.length; i++) {
			System.out.print(i);
			for (int j = 0; j < tablero2[i].length; j++) {
				System.out.print("|" + tablero2[i][j] + "|");
			}
			System.out.println("");
		}
	}

	// Buscar el nombre de un soldado y dar su ubicación
	public static int BusquedaNomb(ArrayList<Alien> misAliens, String nomb) {
		for (int i = 0; i < misAliens.size(); i++) {
			if (misAliens.get(i).getNombre().equals(nomb)) {
				return i;
			}
		}
		return -1;
	}

	// Reconociendo a que clase pertenece
	public static void ReconocimientoAtacante(Alien sol1) {
		if (sol1 instanceof Gelido) {
			System.out.println("Gelido");
			System.out.println("a) Lanzar estacas");
			System.out.println("b) Congelar contrincante\nRPTA: ");

		} else if (sol1 instanceof Infernal) {
			System.out.println("Infernal");
			System.out.println("a) Lanzar llamas");
			System.out.println("b) Golpe Letal a contrincante\nRPTA: ");

		} else if (sol1 instanceof Destructor) {
			System.out.println("Destructor");
			System.out.println("a) Lanzar rocas");
			System.out.println("b) Golpe Demoledor a contrincante\nRPTA: ");

		} else if (sol1 instanceof Nature) {
			System.out.println("Nature");
			System.out.println("a) Lanzar espinas");
			System.out.println("b) Inmovilizar a contrincante\nRPTA: ");

		}

	}

	// Reconociendo los poderes
	public static String Poderes(Alien sol1) {
		if (sol1 instanceof Gelido) {
			return "Gelido \n1) Lanzar estacas\n2) Congelar contrincante\nRPTA: ";

		} else if (sol1 instanceof Infernal) {
			return "Infernal \n1) Lanzar llamas\n2) Golpe Letal a contrincante\nRPTA: ";

		} else if (sol1 instanceof Destructor) {
			return "Destructor \n1) Lanzar rocas\n2) Golpe Demoledor a contrincante\nRPTA: ";

		} else if (sol1 instanceof Nature) {
			return "Nature \n1) Lanzar espinas\n2) Inmovilizar a contrincante\nRPTA: ";

		} else {
			return null;
		}

	}

	public static int PrimerMetodo(Alien sol1) {
		if (sol1 instanceof Gelido) {
			return ((Gelido) sol1).LanzarEstacas();
		} else if (sol1 instanceof Infernal) {
			return ((Infernal) sol1).LanzarLlamas();
		} else if (sol1 instanceof Destructor) {
			return ((Destructor) sol1).LanzarRocas();
		} else if (sol1 instanceof Nature) {
			return ((Nature) sol1).LanzarEspinas();
		} else {
			return -1;
		}

	}

	public static int SegundoMetodo(Alien sol1) {
		if (sol1 instanceof Gelido) {
			return ((Gelido) sol1).Congelar();
		} else if (sol1 instanceof Infernal) {
			return ((Infernal) sol1).GolpeLetal();
		} else if (sol1 instanceof Destructor) {
			return ((Destructor) sol1).GolpeDemoledor();
		} else if (sol1 instanceof Nature) {
			return ((Nature) sol1).Inmovilizar();
		} else {
			return -1;
		}

	}

	public static int cuanto(int nuevFila, int nuevColumna) {
		String puntoExtraA = tablero2[nuevFila][nuevColumna];
		int puntoExtraB = Integer.parseInt(puntoExtraA);
		return puntoExtraB;

	}

	// Asignar una nueva ubicacion en la matriz y tambien set con la fila y columna
	public static void nuevaFilCol(int nuevFila, int nuevColumna, Alien sol1) {

		tablero[nuevFila][nuevColumna] = sol1.getNombre();
		tablero[sol1.getFila()][sol1.getColumna()] = "____";

		sol1.setFila(nuevFila);
		sol1.setColumna(nuevColumna);
	}

	// Verificar si el espacio elegido esta ocupado o simplemente no existe
	public static int verificar(int fil, int col) {
		if (fil >= 0 && fil < 10 && col >= 0 && col < 10 && (tablero[fil][col] == "____")) {
			return 1;
		}
		return -1;
	}

	public String LlamarBoton(JButton a) {
		return a.getText();
	}

}
