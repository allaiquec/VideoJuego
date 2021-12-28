package Game;

import java.util.ArrayList;
import java.util.Scanner;

public class Aplicacion19 {
	public static String[][] tablero = new String[10][10];
	public static String[][] tablero2 = new String[10][10];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int resp;
		System.out.println("¿Desea comenzar? (yes=1) (No=2) ");
		resp = sc.nextInt();

		while (resp == 1) {
			// tablero
			ValoresInicialesTablero2();
			ImprimirTablero2();

			ValoresInicialesTablero();

			// Crear equipos
			Equipo ejer1 = new Equipo("Rojos", new ArrayList<Alien>());
			ejer1.CrearSoldadoAutogenerado("1", tablero);

			Equipo ejer2 = new Equipo("Azules", new ArrayList<Alien>());
			ejer2.CrearSoldadoAutogenerado("2", tablero);

			// Matriz de Aliens
			System.out.println("\n          BATALLA DE ALIENS");
			ImprimirTablero();

			while (true) {
				System.out.println("\nTurno del equipo: (1) " + ejer1.getReino());
				System.out.println("Seleccione a un alien de su equipo");
				String nomb1 = sc.next();
				while (BusquedaNomb(ejer1.getMisAliens(), nomb1) == -1) {
					// AQUI >>>>> JOptionPane
					System.out.println("No válido. Intente de nuevo");
					System.out.println("Seleccione a un alien de su equipo: ");
					nomb1 = sc.next();
				}
				int index1 = BusquedaNomb(ejer1.getMisAliens(), nomb1);
				// AQUI >>>>>> toString()
				System.out.println(ejer1.getMisAliens().get(index1).toString());
				System.out.println("\nSeleccione una opción: \n1.Mover\n2.Atacar\nRPTA:");
				int rptaAccion = sc.nextInt();

				// 1. MOVIMIENTO

				if (rptaAccion == 1) {
					int fil, col;
					System.out.println("Ingrese la fila que deseea: ");
					fil = sc.nextInt();
					System.out.println("Ingrese la columna que deseea: ");
					col = sc.nextInt();

					// verificar que esté vacío la casilla
					while (verificar(fil, col) == -1) {
						System.out
								.println("Fila y columna no válida(o bien no existe o está ocupada). Intente de nuevo");
						System.out.println("Ingrese la fila que deseea: ");
						fil = sc.nextInt();
						System.out.println("Ingrese la columna que deseea: ");
						col = sc.nextInt();
					}
					nuevaFilCol(fil, col, ejer1.getMisAliens().get(index1));

					System.out.println("Aumentó en : " + cuanto(fil, col));
					ejer1.getMisAliens().get(index1).sumarPuntos(cuanto(fil, col));
					ImprimirTablero();

					// 2. ATAQUE

				} else {
					// Si no tiene nadie cerca, pierde TURNO
					// Si ingresa a un soldado que no existe o que no está en su perimetro
					// Si todo estuviera bien:
					System.out.println("Ingrese nombre del alien a atacar: ");
					String nomb2 = sc.next();

					while (BusquedaNomb(ejer2.getMisAliens(), nomb2) == -1) {
						System.out.println("No válido. Intente de nuevo");
						System.out.println("Ingrese nombre del alien a atacar: ");
						nomb2 = sc.next();
					}
					int index2 = BusquedaNomb(ejer2.getMisAliens(), nomb2);

					// Resumiendo nombres
					Alien atacante = ejer1.getMisAliens().get(index1);
					Alien afectado = ejer2.getMisAliens().get(index2);

					System.out.println("El alien atacante posee los siguientes métodos: ");

					System.out.println(Poderes(atacante));
					int rptaMetodo1 = sc.nextInt();
					int cantPoder1;
					if (rptaMetodo1 == 1) {
						cantPoder1 = PrimerMetodo(atacante);
					} else {
						cantPoder1 = SegundoMetodo(atacante);
					}

					System.out.println("Te están atando, defiendete con los siguientes métodos: ");
					System.out.println(Poderes(afectado));
					int rptaMetodo2 = sc.nextInt();
					int cantPoder2;
					if (rptaMetodo2 == 1) {
						cantPoder2 = PrimerMetodo(afectado);
					} else {
						cantPoder2 = SegundoMetodo(afectado);
					}

					// DEFINIENDO GANADOR DE PARTIDA

					System.out.println("DEFINIENDO GANADOR");
					System.out.println(atacante.getNombre() + ": " + cantPoder1);
					System.out.println(afectado.getNombre() + ": " + cantPoder2);
					if (cantPoder1 > cantPoder2) {
						nuevaFilCol(afectado.getFila(), afectado.getColumna(), atacante);
						ejer2.getMisAliens().remove(index2);
						System.out.println("GANADOR: " + atacante.getNombre());
					} else if (cantPoder1 < cantPoder2) {
						nuevaFilCol(atacante.getFila(), atacante.getColumna(), afectado);
						ejer1.getMisAliens().remove(index1);
						System.out.println("GANADOR: " + afectado.getNombre());

					} else {
						System.out.println("EMPATE");
					}
					ImprimirTablero();

					if (ejer1.getMisAliens().isEmpty() || ejer2.getMisAliens().isEmpty()) {
						System.out.println("FIN DE LA BATALLA");
						if (ejer1.getMisAliens().isEmpty()) {
							System.out.println("EL GANADOR ES EL EJERCITO 2");
						} else {
							System.out.println("EL GANADOR ES EL EJERCITO 1");
						}
						break;
					}
				}
				System.out.println("\nTurno del equipo: (2) " + ejer2.getReino());

				System.out.println("Seleccione a un alien de su equipo");
				String nomb2 = sc.next();
				while (BusquedaNomb(ejer2.getMisAliens(), nomb2) == -1) {
					// AQUI >>>>> JOptionPane
					System.out.println("No válido. Intente de nuevo");
					System.out.println("Seleccione a un alien de su equipo: ");
					nomb2 = sc.next();
				}
				int index2 = BusquedaNomb(ejer2.getMisAliens(), nomb2);
				// AQUI >>>>>> toString()
				System.out.println(ejer2.getMisAliens().get(index2).toString());
				System.out.println("\nSeleccione una opción: \n1.Mover\n2.Atacar\nRPTA:");
				int rptaAccion2 = sc.nextInt();

				// 1. MOVIMIENTO

				if (rptaAccion2 == 1) {
					// Mover por toda la matriz
					int fil, col;
					System.out.println("Ingrese la fila que deseea: ");
					fil = sc.nextInt();
					System.out.println("Ingrese la columna que deseea: ");
					col = sc.nextInt();

					// verificar que esté vacío la casilla
					while (verificar(fil, col) == -1) {
						System.out
								.println("Fila y columna no válida(o bien no existe o está ocupada). Intente de nuevo");
						System.out.println("Ingrese la fila que deseea: ");
						fil = sc.nextInt();
						System.out.println("Ingrese la columna que deseea: ");
						col = sc.nextInt();
					}
					nuevaFilCol(fil, col, ejer2.getMisAliens().get(index2));
					System.out.println("Aumentó en : " + cuanto(fil, col));
					ejer2.getMisAliens().get(index2).sumarPuntos(cuanto(fil, col));
					ImprimirTablero();

					// 2. ATAQUE

				} else {
					// Si no tiene nadie cerca, pierde TURNO
					// Si ingresa a un soldado que no existe o que no está en su perimetro

					// Si todo estuviera bien:
					System.out.println("Ingrese nombre del alien a atacar: ");
					String nombre1 = sc.next();

					while (BusquedaNomb(ejer1.getMisAliens(), nombre1) == -1) {
						System.out.println("No válido. Intente de nuevo");
						System.out.println("Ingrese nombre del alien a atacar: ");
						nombre1 = sc.next();
					}
					int index_1 = BusquedaNomb(ejer1.getMisAliens(), nombre1);

					// Resumiendo nombres
					Alien atacante = ejer2.getMisAliens().get(index2);
					Alien afectado = ejer1.getMisAliens().get(index_1);

					System.out.println("El alien atacante posee los siguientes métodos: ");

					System.out.println(Poderes(atacante));
					int rptaMetodo1 = sc.nextInt();
					int cantPoder1;
					if (rptaMetodo1 == 1) {
						cantPoder1 = PrimerMetodo(atacante);
					} else {
						cantPoder1 = SegundoMetodo(atacante);
					}

					System.out.println("Te están atando, defiendete con los siguientes métodos: ");
					System.out.println(Poderes(afectado));
					int rptaMetodo2 = sc.nextInt();
					int cantPoder2;
					if (rptaMetodo2 == 1) {
						cantPoder2 = PrimerMetodo(afectado);
					} else {
						cantPoder2 = SegundoMetodo(afectado);
					}

					// DEFINIENDO GANADOR DE PARTIDA

					System.out.println("DEFINIENDO GANADOR");
					System.out.println(atacante.getNombre() + ": " + cantPoder1);
					System.out.println(afectado.getNombre() + ": " + cantPoder2);
					if (cantPoder1 > cantPoder2) {
						nuevaFilCol(afectado.getFila(), afectado.getColumna(), atacante);
						ejer1.getMisAliens().remove(index_1);
						System.out.println("GANADOR: " + atacante.getNombre());
					} else if (cantPoder1 < cantPoder2) {
						nuevaFilCol(atacante.getFila(), atacante.getColumna(), afectado);
						ejer2.getMisAliens().remove(index2);
						System.out.println("GANADOR: " + afectado.getNombre());
					} else {
						System.out.println("EMPATE");
					}
					ImprimirTablero();

					if (ejer1.getMisAliens().isEmpty() || ejer2.getMisAliens().isEmpty()) {
						System.out.println("FIN DE LA BATALLA");
						if (ejer1.getMisAliens().isEmpty()) {
							System.out.println("EL GANADOR ES EL EJERCITO 2");
						} else {
							System.out.println("EL GANADOR ES EL EJERCITO 1");
						}
						break;
					}
				}

			}

			System.out.println("Desea jugar de nuevo? (yes=1) (no=2) ");
			resp = sc.nextInt();

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
}
