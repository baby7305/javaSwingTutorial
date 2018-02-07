import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.GroupLayout.Alignment.CENTER;

public class ProgressBarEx extends JFrame {

	private Timer timer;
	private JProgressBar pbar;
	private JButton sBtn;

	public ProgressBarEx() {

		initUI();
	}

	private void initUI() {

		pbar = new JProgressBar();
		pbar.setStringPainted(true);

		sBtn = new JButton("Start");
		sBtn.addActionListener(new ClickAction());

		timer = new Timer(50, new UpdateBarListener());

		createLayout(pbar, sBtn);

		setTitle("JProgressBar");
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
				.addComponent(arg[1])
		);

		gl.setVerticalGroup(gl.createParallelGroup(CENTER)
				.addComponent(arg[0])
				.addComponent(arg[1])
		);

		pack();
	}

	private class UpdateBarListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			int val = pbar.getValue();

			if (val >= 100) {

				timer.stop();
				sBtn.setText("End");
				return;
			}

			pbar.setValue(++val);
		}
	}

	private class ClickAction extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (timer.isRunning()) {

				timer.stop();
				sBtn.setText("Start");

			} else if (!"End".equals(sBtn.getText())) {

				timer.start();
				sBtn.setText("Stop");
			}
		}
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(() -> {
			ProgressBarEx ex = new ProgressBarEx();
			ex.setVisible(true);
		});
	}
}
