package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Menu extends JFrame {
	private JButton btn1Batalla, btn2Pares, btn3Puzzle;
	private JPanel panel1;

	public Menu() {
		setSize(600, 600);
		setLocationRelativeTo(null);
		colocarPaneles();
		initComponents();
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	private void colocarPaneles() {
		panel1 = new JPanel();

		panel1.setLayout(null);// desactivamos el diseño de los paneles
		panel1.setBackground(Color.black);
		this.getContentPane().add(panel1);

	}

	private void initComponents() {
		JLabel etiqueta = new JLabel();

		etiqueta.setText("SPACE GAMES");// aparece en el centro del panel
		etiqueta.setBounds(150, 10, 300, 70);// ppara que salga, debemos descativar el panel con layaout
		etiqueta.setForeground(Color.RED);// cambiar color de letra
		etiqueta.setBackground(Color.black);// cambiar color de fondo de la etiqueta,para eso se desactiva el diseño por
											// ddefecto de la etiqueta
		etiqueta.setOpaque(true);// desactiva el diseño de fondo de la etieuqta, ahora si lo va pintar
		etiqueta.setHorizontalAlignment(SwingConstants.CENTER);// posicion en el centro la etiqueta
		etiqueta.setFont(new Font("Chiller", 1, 50));

		ImageIcon imagen = new ImageIcon("alien.jpeg");
		JLabel etiquetau = new JLabel();
		etiquetau.setBounds(70, 250, 500, 300);
		etiquetau.setIcon(imagen);

		panel1.add(etiquetau);
		btn1Batalla = new JButton();
		btn2Pares = new JButton();
		btn3Puzzle = new JButton();

		btn1Batalla.setText("btn1Batalla");
		btn1Batalla.setBounds(50, 100, 130, 100);
		ImageIcon imagenb1 = new ImageIcon("alien.jpg");
		btn1Batalla.setIcon(new ImageIcon(imagenb1.getImage().getScaledInstance(btn1Batalla.getWidth(),
				btn1Batalla.getHeight(), Image.SCALE_SMOOTH)));
		btn1Batalla.setBorder(new LineBorder(Color.GRAY));
		btn1Batalla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				App miApp = new App();
			}
		});
		btn2Pares.setText("btn2Pares");
		btn2Pares.setBounds(250, 100, 100, 100);
		ImageIcon imagenb2 = new ImageIcon("encuentra.jpg");
		btn2Pares.setIcon(new ImageIcon(imagenb2.getImage().getScaledInstance(btn2Pares.getWidth(),
				btn2Pares.getHeight(), Image.SCALE_SMOOTH)));
		btn2Pares.setBorder(new LineBorder(Color.GRAY));
		btn2Pares.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				JuegoPar pares = new JuegoPar();
				pares.setVisible(true);
			}
		});
		btn3Puzzle.setText("btn3Puzzle");
		btn3Puzzle.setBounds(450, 100, 100, 100);
		ImageIcon imagenb3 = new ImageIcon("puzzle.png");
		btn3Puzzle.setIcon(new ImageIcon(imagenb3.getImage().getScaledInstance(btn3Puzzle.getWidth(),
				btn3Puzzle.getHeight(), Image.SCALE_SMOOTH)));

		btn3Puzzle.setBorder(new LineBorder(Color.GRAY));
		btn3Puzzle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Puzzle elPuzzle;
				try {
					elPuzzle = new Puzzle();
					elPuzzle.setVisible(true);
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		add(panel1);
		panel1.add(etiqueta);
		panel1.add(btn1Batalla);
		panel1.add(btn2Pares);
		panel1.add(btn3Puzzle);

	}

}
