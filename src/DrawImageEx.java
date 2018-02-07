import javax.swing.*;
import java.awt.*;

class DrawPanel extends JPanel {

	private Image img;

	public DrawPanel() {

		initPanel();
	}

	private void initPanel() {

		loadImage();
		Dimension dm = new Dimension(img.getWidth(null), img.getHeight(null));
		setPreferredSize(dm);
	}

	private void loadImage() {

		img = new ImageIcon("res/icesid.jpg").getImage();
	}

	private void doDrawing(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;

		g2d.drawImage(img, 0, 0, null);
	}

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		doDrawing(g);
	}
}

public class DrawImageEx extends JFrame {

	public DrawImageEx() {

		initUI();
	}

	private void initUI() {

		DrawPanel dpnl = new DrawPanel();
		add(dpnl);

		setTitle("Image");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(() -> {
			DrawImageEx ex = new DrawImageEx();
			ex.setVisible(true);
		});
	}
}
