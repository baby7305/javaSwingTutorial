import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Created by Administrator on 2018/2/7.
 */
public class JDialogEx extends JFrame
		implements ActionListener {

	public JDialogEx() {

		initUI();
	}

	private void initUI() {

		createMenuBar();

		setTitle("Simple Dialog");
		setSize(350, 250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void createMenuBar() {

		JMenuBar menubar = new JMenuBar();

		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);

		JMenu helpMenu = new JMenu("Help");
		helpMenu.setMnemonic(KeyEvent.VK_H);

		JMenuItem aboutMi = new JMenuItem("About");
		aboutMi.setMnemonic(KeyEvent.VK_A);
		helpMenu.add(aboutMi);

		aboutMi.addActionListener(this);

		menubar.add(fileMenu);
		menubar.add(Box.createGlue());
		menubar.add(helpMenu);
		setJMenuBar(menubar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		showAboutDialog();
	}

	private void showAboutDialog() {

		AboutDialog ad = new AboutDialog(this);
		ad.setVisible(true);
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JDialogEx sd = new JDialogEx();
				sd.setVisible(true);
			}
		});
	}
}
