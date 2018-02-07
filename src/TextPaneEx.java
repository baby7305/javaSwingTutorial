import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TextPaneEx extends JFrame {

	private JTextPane textPane;

	public TextPaneEx() {

		initUI();
	}

	private void initUI() {

		textPane = new JTextPane();
		JScrollPane spane = new JScrollPane(textPane);

		textPane.setContentType("text/html");
		textPane.setEditable(false);

		loadFile();

		createLayout(spane);

		setTitle("JTextPane");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	private void createLayout(JComponent... arg) {

		Container pane = getContentPane();
		GroupLayout gl = new GroupLayout(pane);
		pane.setLayout(gl);

		gl.setAutoCreateContainerGaps(true);
		gl.setAutoCreateGaps(true);

		gl.setHorizontalGroup(gl.createSequentialGroup()
				.addComponent(arg[0])
		);

		gl.setVerticalGroup(gl.createParallelGroup()
				.addComponent(arg[0])
		);

		pack();
	}

	private void loadFile() {

		try {
			String cd = System.getProperty("user.dir") + "/" + "res/";
			textPane.setPage("File:///" + cd + "test.html");
		} catch (IOException ex) {
			Logger.getLogger(this.getName()).log(Level.SEVERE,
					null, ex);
		}
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(() -> {
			TextPaneEx ex = new TextPaneEx();
			ex.setVisible(true);
		});
	}
}
