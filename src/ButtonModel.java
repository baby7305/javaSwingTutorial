import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ButtonModel extends JFrame {

	private JButton okbtn;
	private JLabel enabledLbl;
	private JLabel pressedLbl;
	private JLabel armedLbl;
	private JCheckBox cb;

	public ButtonModel() {

		initUI();
	}

	private void initUI() {

		Container pane = getContentPane();
		GroupLayout gl = new GroupLayout(pane);
		pane.setLayout(gl);

		okbtn = new JButton("OK");
		cb = new JCheckBox();
		cb.setAction(new CheckBoxAction());

		enabledLbl = new JLabel("Enabled: true");
		pressedLbl = new JLabel("Pressed: false");
		armedLbl  = new JLabel("Armed: false");

		javax.swing.ButtonModel model = new OkButtonModel();
		okbtn.setModel(model);

		gl.setAutoCreateContainerGaps(true);
		gl.setAutoCreateGaps(true);

		gl.setHorizontalGroup(gl.createParallelGroup()
				.addGroup(gl.createSequentialGroup()
						.addComponent(okbtn)
						.addGap(80)
						.addComponent(cb))
				.addGroup(gl.createParallelGroup()
						.addComponent(enabledLbl)
						.addComponent(pressedLbl)
						.addComponent(armedLbl))
		);

		gl.setVerticalGroup(gl.createSequentialGroup()
				.addGroup(gl.createParallelGroup()
						.addComponent(okbtn)
						.addComponent(cb))
				.addGap(40)
				.addGroup(gl.createSequentialGroup()
						.addComponent(enabledLbl)
						.addComponent(pressedLbl)
						.addComponent(armedLbl))
		);

		pack();

		setTitle("Custom button model");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private class OkButtonModel extends DefaultButtonModel {

		@Override
		public void setEnabled(boolean b) {
			if (b) {
				enabledLbl.setText("Enabled: true");
			} else {
				enabledLbl.setText("Enabled: false");
			}

			super.setEnabled(b);
		}

		@Override
		public void setArmed(boolean b) {
			if (b) {
				armedLbl.setText("Armed: true");
			} else {
				armedLbl.setText("Armed: false");
			}

			super.setArmed(b);
		}

		@Override
		public void setPressed(boolean b) {
			if (b) {
				pressedLbl.setText("Pressed: true");
			} else {
				pressedLbl.setText("Pressed: false");
			}

			super.setPressed(b);
		}
	}

	private class CheckBoxAction extends AbstractAction {

		public CheckBoxAction() {
			super("Disabled");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (okbtn.isEnabled()) {
				okbtn.setEnabled(false);
			} else {
				okbtn.setEnabled(true);
			}
		}
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				ButtonModel ex = new ButtonModel();
				ex.setVisible(true);
			}
		});
	}
}
