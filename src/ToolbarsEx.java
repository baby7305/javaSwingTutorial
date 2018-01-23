import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ToolbarsEx extends JFrame {

	public ToolbarsEx() {

		initUI();
	}

	public final void initUI() {

		createToolBars();

		setTitle("Toolbars");
		setSize(360, 250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void createToolBars() {

		JToolBar toolbar1 = new JToolBar();
		JToolBar toolbar2 = new JToolBar();

		ImageIcon newi = new ImageIcon("new.png");
		ImageIcon open = new ImageIcon("open.png");
		ImageIcon save = new ImageIcon("res/exit.png");
		ImageIcon exit = new ImageIcon("res/exit.png");

		JButton newb = new JButton(newi);
		JButton openb = new JButton(open);
		JButton saveb = new JButton(save);

		toolbar1.add(newb);
		toolbar1.add(openb);
		toolbar1.add(saveb);

		JButton exitb = new JButton(exit);
		toolbar2.add(exitb);

		exitb.addActionListener((ActionEvent event) -> {
			System.exit(0);
		});

		createLayout(toolbar1, toolbar2);
	}

	private void createLayout(JComponent... arg) {

		Container pane = getContentPane();
		GroupLayout gl = new GroupLayout(pane);
		pane.setLayout(gl);

		gl.setHorizontalGroup(gl.createParallelGroup()
				.addComponent(arg[0], GroupLayout.DEFAULT_SIZE,
						GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(arg[1], GroupLayout.DEFAULT_SIZE,
						GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);

		gl.setVerticalGroup(gl.createSequentialGroup()
				.addComponent(arg[0])
				.addComponent(arg[1])
		);
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(() -> {
			ToolbarsEx ex = new ToolbarsEx();
			ex.setVisible(true);
		});
	}
}
