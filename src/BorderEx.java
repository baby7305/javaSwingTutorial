import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BorderEx extends JFrame {

	public BorderEx() {

		initUI();
	}

	private void initUI() {

		JPanel bottomPanel = new JPanel(new BorderLayout());
		JPanel topPanel = new JPanel();

		topPanel.setBackground(Color.gray);
		topPanel.setPreferredSize(new Dimension(250, 150));
		bottomPanel.add(topPanel);

		bottomPanel.setBorder(new EmptyBorder(new Insets(20, 20, 20, 20)));

		add(bottomPanel);

		pack();

		setTitle("Border Example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(() -> {
			BorderEx ex = new BorderEx();
			ex.setVisible(true);
		});
	}
}
