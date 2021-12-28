package Game;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

class Boton extends JButton {

	private boolean isLastButton;

	public Boton() {
		super();
		initUI();
	}

	public Boton(Image image) {
		super(new ImageIcon(image));
		initUI();
	}

	private void initUI() {
		isLastButton = false;
		BorderFactory.createLineBorder(Color.gray); // para que

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				setBorder(BorderFactory.createLineBorder(Color.gray));
			}
		});
	}

	public void setLastButton() {
		isLastButton = true;
	}

	public boolean isLastButton() {
		return isLastButton;
	}
}
