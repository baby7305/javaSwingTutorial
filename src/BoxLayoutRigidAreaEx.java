import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BoxLayoutRigidAreaEx extends JFrame {

	public BoxLayoutRigidAreaEx() {

		initUI();
	}

	private void initUI() {

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		panel.setBorder(new EmptyBorder(new Insets(40, 60, 40, 60)));

		panel.add(new JButton("Button"));
		panel.add(Box.createRigidArea(new Dimension(0, 5)));
		panel.add(new JButton("Button"));
		panel.add(Box.createRigidArea(new Dimension(0, 5)));
		panel.add(new JButton("Button"));
		panel.add(Box.createRigidArea(new Dimension(0, 5)));
		panel.add(new JButton("Button"));

		add(panel);

		pack();

		setTitle("RigidArea");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(() -> {
			BoxLayoutRigidAreaEx ex = new BoxLayoutRigidAreaEx();
			ex.setVisible(true);
		});
	}
}
