import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class ListEx extends JFrame {

	private JLabel label;
	private JScrollPane spane;

	public ListEx() {

		initUI();
	}

	private void initUI() {

		GraphicsEnvironment ge
				= GraphicsEnvironment.getLocalGraphicsEnvironment();

		String[] fonts = ge.getAvailableFontFamilyNames();

		JList list = new JList(fonts);
		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					String name = (String) list.getSelectedValue();
					Font font = new Font(name, Font.PLAIN, 12);
					label.setFont(font);
				}
			}
		});

		spane = new JScrollPane();
		spane.getViewport().add(list);

		label = new JLabel("Aguirre, der Zorn Gottes");
		label.setFont(new Font("Serif", Font.PLAIN, 12));

		createLayout(spane, label);

		setTitle("JList");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	private void createLayout(JComponent... arg) {

		Container pane = getContentPane();
		GroupLayout gl = new GroupLayout(pane);
		pane.setLayout(gl);

		gl.setAutoCreateContainerGaps(true);
		gl.setAutoCreateGaps(true);

		gl.setHorizontalGroup(gl.createParallelGroup()
				.addComponent(arg[0])
				.addComponent(arg[1])

		);

		gl.setVerticalGroup(gl.createSequentialGroup()
				.addComponent(arg[0])
				.addComponent(arg[1])
		);

		pack();
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(() -> {
			ListEx ex = new ListEx();
			ex.setVisible(true);
		});
	}
}
