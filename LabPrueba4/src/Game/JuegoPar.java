
package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class JuegoPar extends javax.swing.JFrame {
	private JButton btnC1, btnC2, btnC3, btnC4, btnC5, btnC6, btnC7, btnC8, btnC9, btnC10, btnC11, btnC12, btnC13,
			btnC14, btnC15, btnC16;
	private JLabel jLabel1;
	private JPanel jPanel1;
	private boolean caraUp = false;
	private ImageIcon im1;
	private ImageIcon im2;
	private JButton[] pbtn = new JButton[2];
	private boolean primerc = false;
	private int puntaje = 0;

	public JuegoPar() {
		initComponents();
		setCards();
	}

	private void setCards() {
		int[] numbers = getCardNumbers();
		// .setDisabledIcon = Establecer icono de desactivación
		btnC1.setDisabledIcon(new ImageIcon(getClass().getResource("/imagenes/c" + numbers[0] + ".png")));
		btnC2.setDisabledIcon(new ImageIcon(getClass().getResource("/imagenes/c" + numbers[1] + ".png")));
		btnC3.setDisabledIcon(new ImageIcon(getClass().getResource("/imagenes/c" + numbers[2] + ".png")));
		btnC4.setDisabledIcon(new ImageIcon(getClass().getResource("/imagenes/c" + numbers[3] + ".png")));
		btnC5.setDisabledIcon(new ImageIcon(getClass().getResource("/imagenes/c" + numbers[4] + ".png")));
		btnC6.setDisabledIcon(new ImageIcon(getClass().getResource("/imagenes/c" + numbers[5] + ".png")));
		btnC7.setDisabledIcon(new ImageIcon(getClass().getResource("/imagenes/c" + numbers[6] + ".png")));
		btnC8.setDisabledIcon(new ImageIcon(getClass().getResource("/imagenes/c" + numbers[7] + ".png")));
		btnC9.setDisabledIcon(new ImageIcon(getClass().getResource("/imagenes/c" + numbers[8] + ".png")));
		btnC10.setDisabledIcon(new ImageIcon(getClass().getResource("/imagenes/c" + numbers[9] + ".png")));
		btnC11.setDisabledIcon(new ImageIcon(getClass().getResource("/imagenes/c" + numbers[10] + ".png")));
		btnC12.setDisabledIcon(new ImageIcon(getClass().getResource("/imagenes/c" + numbers[11] + ".png")));
		btnC13.setDisabledIcon(new ImageIcon(getClass().getResource("/imagenes/c" + numbers[12] + ".png")));
		btnC14.setDisabledIcon(new ImageIcon(getClass().getResource("/imagenes/c" + numbers[13] + ".png")));
		btnC15.setDisabledIcon(new ImageIcon(getClass().getResource("/imagenes/c" + numbers[14] + ".png")));
		btnC16.setDisabledIcon(new ImageIcon(getClass().getResource("/imagenes/c" + numbers[15] + ".png")));
	}

	public int[] getCardNumbers() {

		int[] numbers = new int[16];
		int count = 0;

		while (count < 16) {
			Random r = new Random();
			int na = r.nextInt(8) + 1;
			int nvr = 0;

			for (int i = 0; i < 16; i++) {
				if (numbers[i] == na) {
					nvr++;
				}
			}
			if (nvr < 2) {
				numbers[count] = na;
				count++;
			} // fin

		}

		return numbers;
	}

	private void initComponents() {

		jLabel1 = new JLabel();
		jPanel1 = new JPanel();
		btnC1 = new JButton();
		btnC2 = new JButton();
		btnC3 = new JButton();
		btnC4 = new JButton();
		btnC5 = new JButton();
		btnC6 = new JButton();
		btnC7 = new JButton();
		btnC8 = new JButton();
		btnC9 = new JButton();
		btnC10 = new JButton();
		btnC11 = new JButton();
		btnC12 = new JButton();
		btnC13 = new JButton();
		btnC14 = new JButton();
		btnC15 = new JButton();
		btnC16 = new JButton();

		setTitle("Pares");
		setSize(450, 600);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.DARK_GRAY);

		jLabel1.setFont(new Font("Georgia", 1, 18));
		jLabel1.setForeground(Color.YELLOW);
		jLabel1.setText("Encuentra los planetas");

		jPanel1.setBackground(Color.GRAY);

		btnC1.setIcon(new ImageIcon(getClass().getResource("/imagenes/c0.png")));
		btnC1.setBorder(new LineBorder(Color.GRAY));
		btnC1.setContentAreaFilled(false); // para rellenar la imagen con gris
		btnC1.setFocusable(false);
		btnC1.setRolloverIcon(new ImageIcon(getClass().getResource("/imagenes/cr.png")));
		btnC1.addMouseListener(new Listener2());
		btnC1.addActionListener(new Listener());

		btnC2.setIcon(new ImageIcon(getClass().getResource("/imagenes/c0.png")));
		btnC2.setBorder(new LineBorder(Color.GRAY));
		btnC2.setContentAreaFilled(false);
		btnC2.setFocusable(false);
		btnC2.setRolloverIcon(new ImageIcon(getClass().getResource("/imagenes/cr.png")));
		btnC2.addMouseListener(new Listener2());
		btnC2.addActionListener(new Listener());

		btnC3.setIcon(new ImageIcon(getClass().getResource("/imagenes/c0.png")));
		btnC3.setBorder(new LineBorder(Color.GRAY));
		btnC3.setContentAreaFilled(false);
		btnC3.setFocusable(false);
		btnC3.setRolloverIcon(new ImageIcon(getClass().getResource("/imagenes/cr.png")));
		btnC3.addMouseListener(new Listener2());
		btnC3.addActionListener(new Listener());

		btnC4.setIcon(new ImageIcon(getClass().getResource("/imagenes/c0.png")));
		btnC4.setBorder(new LineBorder(Color.GRAY));
		btnC4.setContentAreaFilled(false);
		btnC4.setFocusable(false);
		btnC4.setRolloverIcon(new ImageIcon(getClass().getResource("/imagenes/cr.png")));
		btnC4.addMouseListener(new Listener2());
		btnC4.addActionListener(new Listener());

		btnC5.setIcon(new ImageIcon(getClass().getResource("/imagenes/c0.png")));
		btnC5.setBorder(new LineBorder(Color.GRAY));
		btnC5.setContentAreaFilled(false);
		btnC5.setFocusable(false);
		btnC5.setRolloverIcon(new ImageIcon(getClass().getResource("/imagenes/cr.png")));
		btnC5.addMouseListener(new Listener2());
		btnC5.addActionListener(new Listener());

		btnC6.setIcon(new ImageIcon(getClass().getResource("/imagenes/c0.png")));
		btnC6.setBorder(new LineBorder(Color.GRAY));
		btnC6.setContentAreaFilled(false);
		btnC6.setFocusable(false);
		btnC6.setRolloverIcon(new ImageIcon(getClass().getResource("/imagenes/cr.png")));
		btnC6.addMouseListener(new Listener2());
		btnC6.addActionListener(new Listener());

		btnC7.setIcon(new ImageIcon(getClass().getResource("/imagenes/c0.png")));
		btnC7.setBorder(new LineBorder(Color.GRAY));
		btnC7.setContentAreaFilled(false);
		btnC7.setFocusable(false);
		btnC7.setRolloverIcon(new ImageIcon(getClass().getResource("/imagenes/cr.png")));
		btnC7.addMouseListener(new Listener2());
		btnC7.addActionListener(new Listener());

		btnC8.setIcon(new ImageIcon(getClass().getResource("/imagenes/c0.png")));
		btnC8.setBorder(new LineBorder(Color.GRAY));
		btnC8.setContentAreaFilled(false);
		btnC8.setFocusable(false);
		btnC8.setRolloverIcon(new ImageIcon(getClass().getResource("/imagenes/cr.png")));
		btnC8.addMouseListener(new Listener2());
		btnC8.addActionListener(new Listener());

		btnC9.setIcon(new ImageIcon(getClass().getResource("/imagenes/c0.png")));
		btnC9.setBorder(new LineBorder(Color.GRAY));
		btnC9.setContentAreaFilled(false);
		btnC9.setFocusable(false);
		btnC9.setRolloverIcon(new ImageIcon(getClass().getResource("/imagenes/cr.png")));
		btnC9.addMouseListener(new Listener2());
		btnC9.addActionListener(new Listener());

		btnC10.setIcon(new ImageIcon(getClass().getResource("/imagenes/c0.png")));
		btnC10.setBorder(new LineBorder(Color.GRAY));
		btnC10.setContentAreaFilled(false);
		btnC10.setFocusable(false);
		btnC10.setRolloverIcon(new ImageIcon(getClass().getResource("/imagenes/cr.png")));
		btnC10.addMouseListener(new Listener2());
		btnC10.addActionListener(new Listener());

		btnC11.setIcon(new ImageIcon(getClass().getResource("/imagenes/c0.png")));
		btnC11.setBorder(new LineBorder(Color.GRAY));
		btnC11.setContentAreaFilled(false);
		btnC11.setFocusable(false);
		btnC11.setRolloverIcon(new ImageIcon(getClass().getResource("/imagenes/cr.png")));
		btnC11.addMouseListener(new Listener2());
		btnC11.addActionListener(new Listener());

		btnC12.setIcon(new ImageIcon(getClass().getResource("/imagenes/c0.png")));
		btnC12.setBorder(new LineBorder(Color.GRAY));
		btnC12.setContentAreaFilled(false);
		btnC12.setFocusable(false);
		btnC12.setRolloverIcon(new ImageIcon(getClass().getResource("/imagenes/cr.png")));
		btnC12.addMouseListener(new Listener2());
		btnC12.addActionListener(new Listener());

		btnC13.setIcon(new ImageIcon(getClass().getResource("/imagenes/c0.png")));
		btnC13.setBorder(new LineBorder(Color.GRAY));
		btnC13.setContentAreaFilled(false);
		btnC13.setFocusable(false);
		btnC13.setRolloverIcon(new ImageIcon(getClass().getResource("/imagenes/cr.png")));
		btnC13.addMouseListener(new Listener2());
		btnC13.addActionListener(new Listener());

		btnC16.setIcon(new ImageIcon(getClass().getResource("/imagenes/c0.png")));
		btnC16.setBorder(new LineBorder(Color.GRAY));
		btnC16.setContentAreaFilled(false);
		btnC16.setFocusable(false);
		btnC16.setRolloverIcon(new ImageIcon(getClass().getResource("/imagenes/cr.png")));
		btnC16.addMouseListener(new Listener2());
		btnC16.addActionListener(new Listener());

		btnC15.setIcon(new ImageIcon(getClass().getResource("/imagenes/c0.png")));
		btnC15.setBorder(new LineBorder(Color.GRAY));
		btnC15.setContentAreaFilled(false);
		btnC15.setFocusable(false);
		btnC15.setRolloverIcon(new ImageIcon(getClass().getResource("/imagenes/cr.png")));
		btnC15.addMouseListener(new Listener2());
		btnC15.addActionListener(new Listener());

		btnC14.setIcon(new ImageIcon(getClass().getResource("/imagenes/c0.png")));
		btnC14.setBorder(new LineBorder(Color.GRAY));
		btnC14.setContentAreaFilled(false);
		btnC14.setFocusable(false);
		btnC14.setRolloverIcon(new ImageIcon(getClass().getResource("/imagenes/cr.png")));
		btnC14.addMouseListener(new Listener2());
		btnC14.addActionListener(new Listener());

		// Conjunto de Botones
		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup().addComponent(btnC1).addComponent(btnC2)
										.addComponent(btnC3).addComponent(btnC4))
								.addGroup(jPanel1Layout.createSequentialGroup().addComponent(btnC5).addComponent(btnC6)
										.addComponent(btnC7).addComponent(btnC8))
								.addGroup(jPanel1Layout.createSequentialGroup().addComponent(btnC9).addComponent(btnC10)
										.addComponent(btnC11).addComponent(btnC12))
								.addGroup(jPanel1Layout.createSequentialGroup().addComponent(btnC13)
										.addComponent(btnC14).addComponent(btnC15).addComponent(btnC16)))
						.addContainerGap()));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(btnC2)
								.addComponent(btnC1).addComponent(btnC3).addComponent(btnC4))

						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(btnC6)
								.addComponent(btnC5).addComponent(btnC7).addComponent(btnC8))

						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(btnC9)
								.addComponent(btnC10).addComponent(btnC11).addComponent(btnC12))

						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(btnC13)
								.addComponent(btnC14).addComponent(btnC15).addComponent(btnC16))
						.addContainerGap()));

		// El contenido de la ventana
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jPanel1)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(layout.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jLabel1).addGap(35, 35, 35).addGap(32, 32, 32)));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addContainerGap()).addComponent(jLabel1))
						.addGap(18, 18, 18).addComponent(jPanel1).addContainerGap()));

	}

	private class Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton) e.getSource();
			btnEnabled(btn);

		}
	}

	// ------------------------------------------------------

	private class Listener2 implements MouseListener {
		public void mouseExited(MouseEvent e) {
			comparar();

		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

	// Verificar si la imagen coincide y de ser así aumentar +20 puntos
	private void btnEnabled(JButton btn) {

		if (!caraUp) {
			btn.setEnabled(false);
			im1 = (ImageIcon) btn.getDisabledIcon();
			pbtn[0] = btn;
			caraUp = true;
			primerc = false;
		} else {
			btn.setEnabled(false);
			im2 = (ImageIcon) btn.getDisabledIcon();
			pbtn[1] = btn;
			primerc = true;
			puntaje += 20;
			ganar();
		}
	}

	// Compara las figuras
	private void comparar() {
		if (caraUp && primerc) {

			if (im1.getDescription().compareTo(im2.getDescription()) != 0) {
				pbtn[0].setEnabled(true);
				pbtn[1].setEnabled(true);
				if (puntaje > 10)
					puntaje -= 10;
			}
			caraUp = false;
		}
	}

	// Emitir mensaje de que ha ganado
	private void ganar() {
		if (!btnC1.isEnabled() && !btnC2.isEnabled() && !btnC3.isEnabled() && !btnC4.isEnabled() && !btnC5.isEnabled()
				&& !btnC6.isEnabled() && !btnC7.isEnabled() && !btnC8.isEnabled() && !btnC9.isEnabled()
				&& !btnC10.isEnabled() && !btnC11.isEnabled() && !btnC12.isEnabled() && !btnC13.isEnabled()
				&& !btnC14.isEnabled() && !btnC15.isEnabled() && !btnC16.isEnabled()) {
			JOptionPane.showMessageDialog(null, "GANADOR!!. Su puntaje es: " + puntaje);
		}
	}

}
