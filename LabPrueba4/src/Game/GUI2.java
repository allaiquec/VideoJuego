package Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI2 extends JFrame {
	public static String[][] tablero1 = new String[10][10];
	public static String[][] tablero2 = new String[10][10];
	public static Equipo ejer1 = new Equipo("Rojos", new ArrayList<Alien>());
	public static Equipo ejer2 = new Equipo("Azules", new ArrayList<Alien>());
	public static Alien atacante;
	public static Alien afectado;

	private JButton mover;
	private JButton atacar;
	public static JButton[][] TABLA = new JButton[10][10];
	public static JLabel tablero = new JLabel();

	public JPanel panel1;
	public JLabel etiquetaTurno;
	public JLabel indicaSelec;
	JTextField cajaTexto, turno;
	JButton boton1, boton2, actualizar, atacarlo;
	Alien sol1, sol12, sol2, sol21;
	Aplicacion19 app = new Aplicacion19();

	public String textoB;
	public String textoB2;
	public int index1;
	public int index2;
	public int cantPoder1;
	public int cantPoder2;
	public int cantPoder12;
	public int cantPoder21;

	public GUI2() {
		setSize(1500, 700);
		this.setTitle("JUEGO ALIENS");
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(200, 200));

		// colocarPaneles();
		// colocarEtiquetas();

		initTableros();
		add(panel1);
		// agregar panel
		agregarTablero();
		agregarEtiquetas();
		// agregarBotones1();
		iniciarBatalla();

		// JLabel etiquetaBotonA= new JLabel("");
		// add(etiquetaBotonA);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	private void agregarEtiquetas() {
		etiquetaTurno = new JLabel("Turno del equipo: " + ejer1.getReino());
		indicaSelec = new JLabel("Seleccione a un alien de su equipo");
		panel1.add(etiquetaTurno);
		panel1.add(indicaSelec);

	}

	private void agregarBotones1() {
		mover = new JButton("MOVER");
		atacar = new JButton("ATACAR");
		mover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {// loque va suceder en caso de click al boton
				// textoB2=a.getText();
				// JOptionPane.showMessageDialog(null, "MOVIMIENTO " + a);
			}

		});
		panel1.add(mover);
		panel1.add(atacar);

	}

	private void initTableros() {
		ValoresInicialesTablero2();

		ValoresInicialesTablero();
		ejer1.CrearSoldadoAutogenerado("1", tablero1);
		ejer2.CrearSoldadoAutogenerado("2", tablero1);

	}

	private void agregarTablero() {
		int x = 10;
		int y = 10;
		int cantPoder1, cantPoder2;

		Scanner scan = new Scanner(System.in);

		tablero.setBounds(30, 100, 1000, 500);
		tablero.setLayout(new GridLayout(10, 10, 0, 0));

		for (int i = 0; i < tablero1.length; i++) {
			for (int j = 0; j < tablero1[i].length; j++) {
				TABLA[i][j] = new JButton();

				TABLA[i][j].setBounds(x, y, 0, 0);

				TABLA[i][j].setText(tablero1[i][j]);
				TABLA[i][j].setOpaque(true);

				if (tablero1[i][j].substring(3).equals("1")) {

					switch (tablero1[i][j].substring(0, 1)) {
					case "D":
						ImageIcon des = new ImageIcon("rojoD.png");
						//// EventoBoton(TABLA[i][j]);

						TABLA[i][j]
								.setIcon(new ImageIcon(des.getImage().getScaledInstance(150, 50, Image.SCALE_SMOOTH)));

						break;
					case "G":
						ImageIcon des2 = new ImageIcon("rojoG.png");
						//// EventoBoton(TABLA[i][j]);
						TABLA[i][j]
								.setIcon(new ImageIcon(des2.getImage().getScaledInstance(150, 50, Image.SCALE_SMOOTH)));

						break;
					case "I":
						ImageIcon des3 = new ImageIcon("rojoI.png");
						//// EventoBoton(TABLA[i][j]);
						TABLA[i][j]
								.setIcon(new ImageIcon(des3.getImage().getScaledInstance(150, 50, Image.SCALE_SMOOTH)));
						break;
					case "N":
						ImageIcon des4 = new ImageIcon("rojoN.png");
						//// EventoBoton(TABLA[i][j]);
						TABLA[i][j]
								.setIcon(new ImageIcon(des4.getImage().getScaledInstance(150, 50, Image.SCALE_SMOOTH)));
						break;

					}
				} else if (tablero1[i][j].substring(3).equals("2")) {
					switch (tablero1[i][j].substring(0, 1)) {
					case "D":
						ImageIcon des = new ImageIcon("azulD.png");

						// EventoBoton2(TABLA[i][j]);
						TABLA[i][j]
								.setIcon(new ImageIcon(des.getImage().getScaledInstance(150, 50, Image.SCALE_SMOOTH)));
						break;
					case "G":
						ImageIcon des2 = new ImageIcon("azulG.png");
						// EventoBoton2(TABLA[i][j]);
						TABLA[i][j]
								.setIcon(new ImageIcon(des2.getImage().getScaledInstance(150, 50, Image.SCALE_SMOOTH)));

						break;
					case "I":
						ImageIcon des3 = new ImageIcon("azulI.png");
						// EventoBoton2(TABLA[i][j]);
						TABLA[i][j]
								.setIcon(new ImageIcon(des3.getImage().getScaledInstance(150, 50, Image.SCALE_SMOOTH)));
						break;
					case "N":
						ImageIcon des4 = new ImageIcon("azulN.png");
						TABLA[i][j].addActionListener(new Listener());
						// EventoBoton2(TABLA[i][j]);
						TABLA[i][j]
								.setIcon(new ImageIcon(des4.getImage().getScaledInstance(150, 50, Image.SCALE_SMOOTH)));
						break;
					}

				} else {
					TABLA[i][j].setBackground(Color.BLACK);
				}
				tablero.add(TABLA[i][j]);
			}
		}

		panel1.add(tablero);
	}

	private class Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton) e.getSource();
			String text = e.getActionCommand();
			while (BusquedaNomb(ejer1.getMisAliens(), text) == -1) {
				// AQUI >>>>> JOptionPane
				// System.out.println("No válido. Intente de nuevo");
				// System.out.println("Seleccione a un alien de su equipo: ");
				// nomb1 = sc.next();
			}
			int index1 = BusquedaNomb(ejer1.getMisAliens(), text);
			JOptionPane.showMessageDialog(null, ejer1.getMisAliens().get(index1).toString());
			atacante = ejer1.getMisAliens().get(index1);
			// btnEnabled(btn);

		}
	}

	private void iniciarBatalla() {
		while (true) {
			JOptionPane.showMessageDialog(null, "Turno del equipo: " + ejer1.getReino());
			// System.out.println("\nTurno del equipo: (1) " + ejer1.getReino());
			// System.out.println("Seleccione a un alien de su equipo");
			String nomb1 = JOptionPane.showInputDialog("Seleccione a un alien de su equipo");
			// String nomb1 = sc.next();

			while (BusquedaNomb(ejer1.getMisAliens(), nomb1) == -1) {
				JOptionPane.showMessageDialog(null, "No válido. Intente de nuevo");
				nomb1 = JOptionPane.showInputDialog("Seleccione a un alien de su equipo");
			}

			int index1 = BusquedaNomb(ejer1.getMisAliens(), nomb1);
			// AQUI >>>>>> toString()
			System.out.println(ejer1.getMisAliens().get(index1).toString());

			int rptaAccion = Integer
					.parseInt(JOptionPane.showInputDialog("Seleccione una opción: \n1.Mover\n2.Atacar\nRPTA:"));
			// System.out.println("\nSeleccione una opción: \n1.Mover\n2.Atacar\nRPTA:");
			// int rptaAccion = sc.nextInt();

			// 1. MOVIMIENTO

			if (rptaAccion == 1) {
				int fil = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la fila que deseea: "));
				// fil = sc.nextInt();
				int col = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la columna que deseea: "));
				System.out.println("Ingrese la columna que deseea: ");
				// col = sc.nextInt();

				// verificar que esté vacío la casilla
				while (verificar(fil, col) == -1) {

					JOptionPane.showMessageDialog(null,
							"Fila y columna no válida(o bien no existe o está ocupada). Intente de nuevo");
					// System.out.println("Ingrese la fila que deseea: ");
					fil = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la fila que deseea: "));
					col = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la columna que deseea: "));
					// fil = sc.nextInt();
					// System.out.println("Ingrese la columna que deseea: ");
					// col = sc.nextInt();
				}
				nuevaFilCol(fil, col, ejer1.getMisAliens().get(index1));
				JOptionPane.showMessageDialog(null, "Aumentó en : " + cuanto(fil, col));
				// System.out.println("Aumentó en : " + cuanto(fil, col));
				ejer1.getMisAliens().get(index1).sumarPuntos(cuanto(fil, col));

				// ImprimirTablero();

				// 2. ATAQUE

			} else {
				// Si no tiene nadie cerca, pierde TURNO
				// Si ingresa a un soldado que no existe o que no está en su perimetro
				// Si todo estuviera bien:
				String nomb2 = JOptionPane.showInputDialog("Ingrese nombre del alien a atacar: ");

				while (BusquedaNomb(ejer2.getMisAliens(), nomb2) == -1) {
					JOptionPane.showMessageDialog(null, "No válido. Intente de nuevo");
					nomb2 = JOptionPane.showInputDialog("Ingrese nombre del alien a atacar: ");
					// System.out.println("No válido. Intente de nuevo");
					// System.out.println("Ingrese nombre del alien a atacar: ");
					// nomb2 = sc.next();
				}
				int index2 = BusquedaNomb(ejer2.getMisAliens(), nomb2);

				// Resumiendo nombres
				Alien atacante = ejer1.getMisAliens().get(index1);
				Alien afectado = ejer2.getMisAliens().get(index2);

				int rptaMetodo1 = Integer.parseInt(JOptionPane
						.showInputDialog("El alien atacante posee los siguientes métodos: " + Poderes(atacante)));
				// System.out.println(Poderes(atacante));
				// int rptaMetodo1 = sc.nextInt();
				int cantPoder1;
				if (rptaMetodo1 == 1) {
					cantPoder1 = PrimerMetodo(atacante);
				} else {
					cantPoder1 = SegundoMetodo(atacante);
				}

				int rptaMetodo2 = Integer.parseInt(JOptionPane.showInputDialog(
						"Te están atando, defiendete con los siguientes métodos: " + Poderes(afectado)));
				// System.out.println(Poderes(afectado));
				// int rptaMetodo2 = sc.nextInt();
				int cantPoder2;
				if (rptaMetodo2 == 1) {
					cantPoder2 = PrimerMetodo(afectado);
				} else {
					cantPoder2 = SegundoMetodo(afectado);
				}

				// DEFINIENDO GANADOR DE PARTIDA

				System.out.println("DEFINIENDO GANADOR");
				JOptionPane.showMessageDialog(null,
						atacante.getNombre() + ": " + cantPoder1 + "\n" + afectado.getNombre() + ": " + cantPoder2);
				// System.out.println(atacante.getNombre() + ": " + cantPoder1);
				// System.out.println(afectado.getNombre() + ": " + cantPoder2);
				if (cantPoder1 > cantPoder2) {
					nuevaFilCol(afectado.getFila(), afectado.getColumna(), atacante);
					ejer2.getMisAliens().remove(index2);
					JOptionPane.showMessageDialog(null, "GANADOR: " + atacante.getNombre());
				} else if (cantPoder1 < cantPoder2) {
					nuevaFilCol(atacante.getFila(), atacante.getColumna(), afectado);
					ejer1.getMisAliens().remove(index1);
					JOptionPane.showMessageDialog(null, "GANADOR: " + afectado.getNombre());

				} else {
					JOptionPane.showMessageDialog(null, "EMPATE");
				}
				// ImprimirTablero();

				if (ejer1.getMisAliens().isEmpty() || ejer2.getMisAliens().isEmpty()) {
					System.out.println("FIN DE LA BATALLA");
					if (ejer1.getMisAliens().isEmpty()) {
						JOptionPane.showMessageDialog(null, "EL GANADOR ES EL EJERCITO 2");
					} else {
						JOptionPane.showMessageDialog(null, "EL GANADOR ES EL EJERCITO 1");
					}
					break;
				}
			}

			JOptionPane.showMessageDialog(null, "\nTurno del equipo: (2) " + ejer2.getReino());
			String nomb2 = JOptionPane.showInputDialog("Seleccione a un alien de su equipo");

			while (BusquedaNomb(ejer2.getMisAliens(), nomb1) == -1) {
				JOptionPane.showMessageDialog(null, "No válido. Intente de nuevo");
				nomb2 = JOptionPane.showInputDialog("Seleccione a un alien de su equipo");
			}

			int index2 = BusquedaNomb(ejer2.getMisAliens(), nomb2);
			// AQUI >>>>>> toString()
			System.out.println(ejer2.getMisAliens().get(index2).toString());

			int rptaAccion2 = Integer
					.parseInt(JOptionPane.showInputDialog("Seleccione una opción: \n1.Mover\n2.Atacar\nRPTA:"));
			// System.out.println("\nSeleccione una opción: \n1.Mover\n2.Atacar\nRPTA:");
			// int rptaAccion2 = sc.nextInt();

			// 1. MOVIMIENTO

			if (rptaAccion2 == 1) {
				// Mover por toda la matriz
				int fil = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la fila que deseea: "));
				// fil = sc.nextInt();
				int col = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la columna que deseea: "));
				System.out.println("Ingrese la columna que deseea: ");
				// col = sc.nextInt();

				// verificar que esté vacío la casilla
				while (verificar(fil, col) == -1) {

					JOptionPane.showMessageDialog(null,
							"Fila y columna no válida(o bien no existe o está ocupada). Intente de nuevo");
					// System.out.println("Ingrese la fila que deseea: ");
					fil = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la fila que deseea: "));
					col = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la columna que deseea: "));
					// fil = sc.nextInt();
					// System.out.println("Ingrese la columna que deseea: ");
					// col = sc.nextInt();
				}
				nuevaFilCol(fil, col, ejer2.getMisAliens().get(index2));
				System.out.println("Aumentó en : " + cuanto(fil, col));
				ejer2.getMisAliens().get(index2).sumarPuntos(cuanto(fil, col));
				// ImprimirTablero();

				// 2. ATAQUE

			} else {
				// Si no tiene nadie cerca, pierde TURNO
				// Si ingresa a un soldado que no existe o que no está en su perimetro

				// Si todo estuviera bien:
				String nombre1 = JOptionPane.showInputDialog("Ingrese nombre del alien a atacar: ");
				// System.out.println("Ingrese nombre del alien a atacar: ");
				// String nombre1 = sc.next();

				while (BusquedaNomb(ejer1.getMisAliens(), nombre1) == -1) {
					JOptionPane.showMessageDialog(null, "No válido. Intente de nuevo");
					nombre1 = JOptionPane.showInputDialog("Ingrese nombre del alien a atacar: ");
					// System.out.println("No válido. Intente de nuevo");
					// System.out.println("Ingrese nombre del alien a atacar: ");
					// nombre1 = sc.next();
				}
				int index_1 = BusquedaNomb(ejer1.getMisAliens(), nombre1);

				// Resumiendo nombres
				Alien atacante = ejer2.getMisAliens().get(index2);
				Alien afectado = ejer1.getMisAliens().get(index_1);

				int rptaMetodo1 = Integer.parseInt(JOptionPane
						.showInputDialog("El alien atacante posee los siguientes métodos: " + Poderes(atacante)));
				// System.out.println(Poderes(atacante));
				// int rptaMetodo1 = sc.nextInt();
				int cantPoder1;
				if (rptaMetodo1 == 1) {
					cantPoder1 = PrimerMetodo(atacante);
				} else {
					cantPoder1 = SegundoMetodo(atacante);
				}

				System.out.println("Te están atando, defiendete con los siguientes métodos: ");
				int rptaMetodo2 = Integer.parseInt(JOptionPane.showInputDialog(Poderes(afectado)));
				// System.out.println(Poderes(afectado));
				// int rptaMetodo2 = sc.nextInt();
				int cantPoder2;
				if (rptaMetodo2 == 1) {
					cantPoder2 = PrimerMetodo(afectado);
				} else {
					cantPoder2 = SegundoMetodo(afectado);
				}

				// DEFINIENDO GANADOR DE PARTIDA

				System.out.println("DEFINIENDO GANADOR");
				JOptionPane.showMessageDialog(null,
						atacante.getNombre() + ": " + cantPoder1 + "\n" + afectado.getNombre() + ": " + cantPoder2);
				// System.out.println(atacante.getNombre() + ": " + cantPoder1);
				// System.out.println(afectado.getNombre() + ": " + cantPoder2);
				if (cantPoder1 > cantPoder2) {
					nuevaFilCol(afectado.getFila(), afectado.getColumna(), atacante);
					ejer1.getMisAliens().remove(index_1);
					JOptionPane.showMessageDialog(null, "GANADOR: " + atacante.getNombre());
				} else if (cantPoder1 < cantPoder2) {
					nuevaFilCol(atacante.getFila(), atacante.getColumna(), afectado);
					ejer2.getMisAliens().remove(index2);
					JOptionPane.showMessageDialog(null, "GANADOR: " + afectado.getNombre());
				} else {
					JOptionPane.showMessageDialog(null, "EMPATE");
				}
				// ImprimirTablero();

				if (ejer1.getMisAliens().isEmpty() || ejer2.getMisAliens().isEmpty()) {
					JOptionPane.showMessageDialog(null, "FIN DE LA BATALLA");
					if (ejer1.getMisAliens().isEmpty()) {
						JOptionPane.showMessageDialog(null, "EL GANADOR ES EL EJERCITO 2");
					} else {
						JOptionPane.showMessageDialog(null, "EL GANADOR ES EL EJERCITO 1");
					}
					break;
				}
			}

		}

	}

	// _--------------------------------------------------------------
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

	// Llenar todo el tablero con "____" como valor inicial
	public static void ValoresInicialesTablero() {
		for (int i = 0; i < tablero1.length; i++) {
			for (int j = 0; j < tablero1[i].length; j++) {
				tablero1[i][j] = "____";
			}
		}
	}

	public static int BusquedaNomb(ArrayList<Alien> misAliens, String nomb) {
		for (int i = 0; i < misAliens.size(); i++) {
			if (misAliens.get(i).getNombre().equals(nomb)) {
				return i;
			}
		}
		return -1;
	}

	// Asignar una nueva ubicacion en la matriz y tambien set con la fila y columna
	public static void nuevaFilCol(int nuevFila, int nuevColumna, Alien sol1) {

		tablero1[nuevFila][nuevColumna] = sol1.getNombre();
		tablero1[sol1.getFila()][sol1.getColumna()] = "____";

		sol1.setFila(nuevFila);
		sol1.setColumna(nuevColumna);
	}

	// Verificar si el espacio elegido esta ocupado o simplemente no existe
	public static int verificar(int fil, int col) {
		if (fil >= 0 && fil < 10 && col >= 0 && col < 10 && (tablero1[fil][col] == "____")) {
			return 1;
		}
		return -1;
	}

	public static int cuanto(int nuevFila, int nuevColumna) {
		String puntoExtraA = tablero2[nuevFila][nuevColumna];
		int puntoExtraB = Integer.parseInt(puntoExtraA);
		return puntoExtraB;

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

}
