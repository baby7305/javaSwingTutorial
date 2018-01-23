import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ToolbarEx extends JFrame {

	public ToolbarEx() {

		initUI();
	}

	private void initUI() {

		createMenuBar();
		createToolBar();

		setTitle("Simple toolbar");
		setSize(300, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void createMenuBar() {

		JMenuBar menubar = new JMenuBar();
		JMenu file = new JMenu("File");
		menubar.add(file);
		setJMenuBar(menubar);
	}

	private void createToolBar() {

		JToolBar toolbar = new JToolBar();

		ImageIcon icon = new ImageIcon("res/exit.png");

		JButton exitButton = new JButton(icon);
		toolbar.add(exitButton);

		exitButton.addActionListener((ActionEvent event) -> {
			System.exit(0);
		});

		add(toolbar, BorderLayout.NORTH);
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(() -> {
			ToolbarEx ex = new ToolbarEx();
			ex.setVisible(true);
		});
	}
}
