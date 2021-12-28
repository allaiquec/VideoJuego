package Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GuiTablero extends JFrame {
	public JPanel panel1;
	JLabel etiquetaTurno;
	JTextArea textArea;
	JTextField cajaTexto1;
	Aplicacion19 app = new Aplicacion19();
	public String textoBoton;
	public String textoB;

	public GuiTablero() {

	}

	public GuiTablero(String[][] tabla) {
		setSize(1100, 700);
		this.setTitle("JUEGO ALIENS");
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(200, 200));

		colocarPaneles();
		numeros();
		colocarEtiquetas();

		colocarTablero(tabla);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	private void colocarTablero(String[][] tabla) {
		JButton[][] TABLA;
		int x = 10;
		int y = 10;
		JLabel tablero = new JLabel();
		tablero.setBounds(30, 100, 1000, 500);
		tablero.setLayout(new GridLayout(10, 10, 0, 0));

		TABLA = new JButton[10][10];
		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla[i].length; j++) {
				TABLA[i][j] = new JButton();
				TABLA[i][j].setBounds(10, 10, 0, 0);
				TABLA[i][j].setText(tabla[i][j]);
				TABLA[i][j].setOpaque(true);
				TABLA[i][j].setForeground(Color.WHITE);
				ColorBotonAliens(TABLA[i][j]);
				tablero.add(TABLA[i][j]);
			}
		}

		panel1.add(tablero);

	}

	private void ColorBotonAliens(JButton a) {
		if (a.getText().substring(3).equals("1")) {
			a.setBackground(Color.red);
		} else {
			if ((a.getText().substring(3).equals("2")))
				a.setBackground(Color.blue);
		}
	}

	public void Actualizar(String[][] tabla) {

		colocarTablero(tabla);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	private void colocarPaneles() {
		panel1 = new JPanel();
		// JPanel panel1= new JPanel();//es como la hoja de papel encima de la
		// mesa(ventana)
		panel1.setLayout(null);// desactivamos el diseño de los paneles

		this.getContentPane().add(panel1);
		// this refiere a jframe
	}

	private void colocarEtiquetas() {

		JLabel etiqueta = new JLabel();

		etiqueta.setText("JUEGO DE ALIENS 1");// aparece en el centro del panel
		// ancho alto etiqueta.setBounds(145,150,220,70) centrado
		etiqueta.setBounds(400, 7, 220, 70);// ppara que salga, debemos descativar el panel con layaout
		etiqueta.setForeground(Color.RED);// cambiar color de letra
		etiqueta.setBackground(Color.yellow);// cambiar color de fondo de la etiqueta,para eso se desactiva el diseño
												// por ddefecto de la etiqueta
		etiqueta.setOpaque(true);// desactiva el diseño de fondo de la etieuqta, ahora si lo va pintar
		etiqueta.setHorizontalAlignment(SwingConstants.CENTER);// posicion en el centro la etiqueta
		etiqueta.setFont(new Font("arial", Font.BOLD, 20));
		// 1 negrita, 2,cursiva, 3 negrita y cursiva en font.
		// tambien se puede copiar el nombr del estilo de letra de word

		panel1.add(etiqueta);
	}

	private void colocarCajasDeTexto(String a) {// son de una sola linea
		// JTextField cajaTexto = new JTextField ("holaa",20);//solo cuando comentamos
		// el layaout

		cajaTexto1 = new JTextField();
		cajaTexto1.setBounds(1141, 200, 150, 40);
		// inicializar el texto
		cajaTexto1.setText(a);
		cajaTexto1.setHorizontalAlignment(SwingConstants.CENTER);// posicion en el centro la etiqueta
		cajaTexto1.setFont(new Font("arial", Font.BOLD, 20));
		cajaTexto1.setEditable(false);

		// System.out.println("texto en la caja\n "+ cajaTexto.getText());
		cajaTexto1.setVisible(true);
		panel1.add(cajaTexto1);

	}

	public void InfoBoton(String a) {

		JTextArea etiquetaT = new JTextArea();

		etiquetaT.setText(a);// aparece en el centro del panel
		// ancho alto etiqueta.setBounds(145,150,220,70) centrado
		etiquetaT.setBounds(1100, 500, 220, 200);// ppara que salga, debemos descativar el panel con layaout
		etiquetaT.setForeground(Color.black);// cambiar color de letra
		// etiquetaT.setBackground(Color.blue);//cambiar color de fondo de la
		// etiqueta,para eso se desactiva el diseño por ddefecto de la etiqueta
		// etiquetaT.setOpaque(true);//desactiva el diseño de fondo de la etieuqta,
		// ahora si lo va pintar

		etiquetaT.setFont(new Font("arial", Font.BOLD, 20));
		// 1 negrita, 2,cursiva, 3 negrita y cursiva en font.
		// tambien se puede copiar el nombr del estilo de letra de word

		panel1.add(etiquetaT);
	}

	private void EventoBotonActualizar(JButton a, String b, String[][] tabla) {
		ActionListener oyentedeAccion = new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {// loque va suceder en caso de click al boton
				colocarTablero(tabla);
				// tituloTurno(b);
			}

		};

		a.addActionListener(oyentedeAccion);
		// return TextoBoton1(a);
	}

	public void InfoAlien(String a) {
		textArea = new JTextArea();
		textArea.setBounds(1000, 300, 350, 181);
		textArea.setText(a);

		panel1.add(textArea);
	}

	private void numeros() {
		JLabel ceroA = new JLabel("0");
		ceroA.setBounds(70, 80, 10, 10);
		ceroA.setHorizontalAlignment(SwingConstants.CENTER);
		panel1.add(ceroA);

		JLabel unoA = new JLabel("1");
		unoA.setBounds(170, 80, 10, 10);
		unoA.setHorizontalAlignment(SwingConstants.CENTER);
		panel1.add(unoA);
		JLabel dosA = new JLabel("2");
		dosA.setBounds(270, 80, 10, 10);
		dosA.setHorizontalAlignment(SwingConstants.CENTER);
		panel1.add(dosA);

		JLabel tresA = new JLabel("3");
		tresA.setBounds(370, 80, 10, 10);
		tresA.setHorizontalAlignment(SwingConstants.CENTER);
		panel1.add(tresA);

		JLabel cuatroA = new JLabel("4");
		cuatroA.setBounds(470, 80, 10, 10);
		cuatroA.setHorizontalAlignment(SwingConstants.CENTER);
		panel1.add(cuatroA);

		JLabel cincoA = new JLabel("5");
		cincoA.setBounds(570, 80, 10, 10);
		cincoA.setHorizontalAlignment(SwingConstants.CENTER);
		panel1.add(cincoA);
		JLabel seisA = new JLabel("6");
		seisA.setBounds(670, 80, 10, 10);
		seisA.setHorizontalAlignment(SwingConstants.CENTER);
		panel1.add(seisA);

		JLabel sieteA = new JLabel("7");
		sieteA.setBounds(770, 80, 10, 10);
		sieteA.setHorizontalAlignment(SwingConstants.CENTER);
		panel1.add(sieteA);
		JLabel ochoA = new JLabel("8");
		ochoA.setBounds(870, 80, 10, 10);
		ochoA.setHorizontalAlignment(SwingConstants.CENTER);
		panel1.add(ochoA);

		JLabel nueveA = new JLabel("9");
		nueveA.setBounds(970, 80, 10, 10);
		nueveA.setHorizontalAlignment(SwingConstants.CENTER);
		panel1.add(nueveA);

		JLabel unoB = new JLabel("0");
		unoB.setBounds(10, 120, 10, 10);
		unoB.setHorizontalAlignment(SwingConstants.CENTER);
		panel1.add(unoB);
		JLabel dosB = new JLabel("1");
		dosB.setBounds(10, 170, 10, 10);
		dosB.setHorizontalAlignment(SwingConstants.CENTER);
		panel1.add(dosB);

		JLabel tresB = new JLabel("2");
		tresB.setBounds(10, 220, 10, 10);
		tresB.setHorizontalAlignment(SwingConstants.CENTER);
		panel1.add(tresB);

		JLabel cuatroB = new JLabel("3");
		cuatroB.setBounds(10, 270, 10, 10);
		cuatroB.setHorizontalAlignment(SwingConstants.CENTER);
		panel1.add(cuatroB);

		JLabel cincoB = new JLabel("4");
		cincoB.setBounds(10, 320, 10, 10);
		cincoB.setHorizontalAlignment(SwingConstants.CENTER);
		panel1.add(cincoB);
		JLabel seisB = new JLabel("5");
		seisB.setBounds(10, 370, 10, 10);
		seisB.setHorizontalAlignment(SwingConstants.CENTER);
		panel1.add(seisB);

		JLabel sieteB = new JLabel("6");
		sieteB.setBounds(10, 420, 10, 10);
		sieteB.setHorizontalAlignment(SwingConstants.CENTER);
		panel1.add(sieteB);
		JLabel ochoB = new JLabel("7");
		ochoB.setBounds(10, 470, 10, 10);
		ochoB.setHorizontalAlignment(SwingConstants.CENTER);
		panel1.add(ochoB);

		JLabel nueveB = new JLabel("8");
		nueveB.setBounds(10, 520, 10, 10);
		nueveB.setHorizontalAlignment(SwingConstants.CENTER);
		panel1.add(nueveB);
		JLabel ceroB = new JLabel("9");
		ceroB.setBounds(10, 570, 10, 10);
		ceroB.setHorizontalAlignment(SwingConstants.CENTER);
		panel1.add(ceroB);
	}

}
