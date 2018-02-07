import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.GroupLayout.DEFAULT_SIZE;

/**
 * Created by Administrator on 2018/2/7.
 */
public class ColorChooserEx extends JFrame {

	private JPanel colourPanel;

	public ColorChooserEx() {

		initUI();
	}

	private void initUI() {

		colourPanel = new JPanel();
		colourPanel.setBackground(Color.WHITE);

		JToolBar toolbar = createToolBar();

		createLayout(toolbar, colourPanel);

		setTitle("JColorChooser");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private JToolBar createToolBar() {

		ImageIcon open = new ImageIcon("res/colourdlg.png");

		JToolBar toolbar = new JToolBar();
		JButton openb = new JButton(open);

		openb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Color color = JColorChooser.showDialog(colourPanel,
						"Choose colour", Color.white);
				colourPanel.setBackground(color);
			}
		});

		toolbar.add(openb);

		return toolbar;
	}

	private void createLayout(JComponent... arg) {

		Container pane = getContentPane();
		GroupLayout gl = new GroupLayout(pane);
		pane.setLayout(gl);

		gl.setHorizontalGroup(gl.createParallelGroup()
				.addComponent(arg[0], DEFAULT_SIZE, DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addGroup(gl.createSequentialGroup()
						.addGap(30)
						.addComponent(arg[1])
						.addGap(30))
		);

		gl.setVerticalGroup(gl.createSequentialGroup()
				.addComponent(arg[0])
				.addGap(30)
				.addComponent(arg[1])
				.addGap(30)
		);

		pack();
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				ColorChooserEx ccd = new ColorChooserEx();
				ccd.setVisible(true);
			}
		});
	}
}
