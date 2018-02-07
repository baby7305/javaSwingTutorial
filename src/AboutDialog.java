import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.GroupLayout.Alignment.CENTER;

class AboutDialog extends JDialog {

	public AboutDialog(Frame parent) {
		super(parent);

		initUI();
	}

	private void initUI() {

		ImageIcon icon = new ImageIcon("res/notes.png");
		JLabel label = new JLabel(icon);

		JLabel name = new JLabel("Notes, 1.23");
		name.setFont(new Font("Serif", Font.BOLD, 13));

		JButton btn = new JButton("OK");
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				dispose();
			}
		});

		createLayout(name, label, btn);

		setModalityType(ModalityType.APPLICATION_MODAL);

		setTitle("About Notes");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(getParent());
	}

	private void createLayout(JComponent... arg) {

		Container pane = getContentPane();
		GroupLayout gl = new GroupLayout(pane);
		pane.setLayout(gl);

		gl.setAutoCreateContainerGaps(true);
		gl.setAutoCreateGaps(true);

		gl.setHorizontalGroup(gl.createParallelGroup(CENTER)
				.addComponent(arg[0])
				.addComponent(arg[1])
				.addComponent(arg[2])
				.addGap(200)
		);

		gl.setVerticalGroup(gl.createSequentialGroup()
				.addGap(30)
				.addComponent(arg[0])
				.addGap(20)
				.addComponent(arg[1])
				.addGap(20)
				.addComponent(arg[2])
				.addGap(30)
		);

		pack();
	}
}


