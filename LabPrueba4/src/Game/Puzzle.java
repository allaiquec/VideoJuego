package Game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Puzzle extends JFrame {

	private JPanel panel;
	private BufferedImage source;
	private ArrayList<Boton> buttons;

	private ArrayList<Point> solution = new ArrayList<Point>();

	private Image image;
	private Boton lastButton;
	private int width, height;
	private final int anchoCasilla = 400;
	private BufferedImage resized; // BufferedImage = Para mantener una representación de una imagen en memoria

	// URISyntaxException: Excepción comprobada lanzada para indicar que una cuerda
	// no podía ser analizada como una referencia URI.
	public Puzzle() throws URISyntaxException {
		initComponents();
	}

	private void initComponents() throws URISyntaxException {

		solution.add(new Point(0, 0));
		solution.add(new Point(0, 1));
		solution.add(new Point(0, 2));
		solution.add(new Point(1, 0));
		solution.add(new Point(1, 1));
		solution.add(new Point(1, 2));
		solution.add(new Point(2, 0));
		solution.add(new Point(2, 1));
		solution.add(new Point(2, 2));
		solution.add(new Point(3, 0));
		solution.add(new Point(3, 1));
		solution.add(new Point(3, 2));

		buttons = new ArrayList<Boton>();

		panel = new JPanel();
		panel.setLayout(new GridLayout(4, 3, 0, 0));

		try {
			source = loadImage();
			int h = getNewHeight(source.getWidth(), source.getHeight());
			// resizeImage = Cambiar de tamaño a la imagen
			resized = resizeImage(source, anchoCasilla, h, BufferedImage.TYPE_INT_ARGB);

		} catch (IOException ex) {
			Logger.getLogger(Puzzle.class.getName()).log(Level.SEVERE, null, ex);
		}

		width = resized.getWidth(null);
		height = resized.getHeight(null);

		add(panel, BorderLayout.CENTER);

		for (int i = 0; i < 4; i++) {

			for (int j = 0; j < 3; j++) {

				image = createImage(new FilteredImageSource(resized.getSource(),
						new CropImageFilter(j * width / 3, i * height / 4, (width / 3), height / 4)));
				Boton button = new Boton(image);
				button.putClientProperty("position", new Point(i, j));

				if (i == 3 && j == 2) {
					lastButton = new Boton();
					lastButton.setBorderPainted(false);
					lastButton.setContentAreaFilled(false);
					lastButton.setLastButton();
					lastButton.putClientProperty("position", new Point(i, j));
				} else {
					buttons.add(button);
				}
			}
		}

		// Collections.shuffle = método usado para permutar aleatoriamente la lista
		// especificada utilizando una fuente predeterminada de aleatoriedad
		Collections.shuffle(buttons);
		buttons.add(lastButton);

		for (int i = 0; i < 12; i++) {
			Boton btn = (Boton) buttons.get(i);
			panel.add(btn);
			btn.setBorder(BorderFactory.createLineBorder(Color.gray)); // Hace que esten juntos
			btn.addActionListener(new ClickAction()); // Listener a cada boton
		}

		// pack() = ajusta el tamaño del marco para que todo su contenido sea igual o
		// superior a sus tamaños preferidos
		pack();
		setTitle("Puzzle");
		setResizable(false);
		setLocationRelativeTo(null);

	}

	private int getNewHeight(int w, int h) {
		double ratio = anchoCasilla / (double) w;
		int newHeight = (int) (h * ratio);
		return newHeight;
	}

	// IOException = generalmente relacionados con la entrada/salida del programa
	private BufferedImage loadImage() throws IOException, URISyntaxException {
		BufferedImage bimg = null;
		bimg = ImageIO.read(new File(getClass().getResource("alienAD.jpg").toURI()));
		return bimg;
	}

	// BufferedImage = se usa para mantener una representación de una imagen en
	// memoria
	private BufferedImage resizeImage(BufferedImage originalImage, int width, int height, int type) {
		BufferedImage resizedImage = new BufferedImage(width, height, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, width, height, null);
		g.dispose();
		return resizedImage;
	}

	// AbstractAction =Usado cuando se quiere invocar una operación de diferentes
	// formas.
	// Ejemplo: pulsando un boton o seleccionando un elemento de un menú
	private class ClickAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			checkButton(e);
			checkSolution();
		}

		private void checkButton(ActionEvent e) {
			int lidx = 0;
			for (Boton button : buttons) {
				if (button.isLastButton())
					lidx = buttons.indexOf(button);
			}
			JButton button = (JButton) e.getSource();
			int bidx = buttons.indexOf(button);

			if ((bidx - 1 == lidx) || (bidx + 1 == lidx) || (bidx - 3 == lidx) || (bidx + 3 == lidx)) {
				// Collections.swap = usa para intercambiar los elementos en las posiciones
				// especificadas en la lista especificada. Si las posiciones especificadas son
				// iguales, la invocación de este método deja la lista sin cambios
				Collections.swap(buttons, bidx, lidx);
				updateButtons();
			}
		}

		private void updateButtons() {

			// removeAll() = para eliminar de esta lista todos sus elementos
			panel.removeAll();
			for (JComponent btn : buttons)
				panel.add(btn);
			// validate() = realiza la retransmisión. Significa que se solicita contenido no
			// válido para todos los tamaños
			// y todos los tamaños de los subcomponentes se configuran en valores adecuados
			// mediante LayoutManager.
			panel.validate();
		}
	}

	private void checkSolution() {
		ArrayList<Point> current = new ArrayList<Point>();

		for (JComponent btn : buttons)
			current.add((Point) btn.getClientProperty("position"));

		if (compareList(solution, current))
			JOptionPane.showMessageDialog(null, "Completado!!!");

	}

	public static boolean compareList(ArrayList<Point> ls1, ArrayList<Point> ls2) {
		return ls1.toString().contentEquals(ls2.toString());
	}

}