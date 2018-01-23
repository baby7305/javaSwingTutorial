import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CardLayoutEx extends JFrame {

	private ImageIcon horka1;
	private ImageIcon horka2;
	private ImageIcon horka3;
	private ImageIcon horka4;
	private ImageIcon previ;
	private ImageIcon nexti;

	private JPanel mainPanel;
	private CardLayout layout;

	public CardLayoutEx() {

		initUI();
	}

	private void initUI() {

		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(50, 50, 50));

		mainPanel.setBorder(
				BorderFactory.createEmptyBorder(5, 5, 5, 5)
		);

		layout = new CardLayout();
		mainPanel.setLayout(layout);

		horka1 = new ImageIcon("res/mushrooms.jpg");
		horka2 = new ImageIcon("res/rotunda.jpg");
		horka3 = new ImageIcon("horka3.jpg");
		horka4 = new ImageIcon("horka4.jpg");

		previ = new ImageIcon("res/previous.png");
		nexti = new ImageIcon("res/next.png");

		JLabel label1 = new JLabel(horka1);
		JLabel label2 = new JLabel(horka2);
		JLabel label3 = new JLabel(horka3);
		JLabel label4 = new JLabel(horka4);

		mainPanel.add(label1);
		mainPanel.add(label2);
		mainPanel.add(label3);
		mainPanel.add(label4);

		add(mainPanel);

		JButton prevButton = new JButton(previ);
		prevButton.addActionListener((ActionEvent e) -> {
			layout.previous(mainPanel);
		});

		JButton nextButton = new JButton(nexti);
		nextButton.addActionListener((ActionEvent e) -> {
			layout.next(mainPanel);
		});

		JPanel btnPanel = new JPanel();
		btnPanel.setBackground(new Color(50, 50, 50));
		btnPanel.add(prevButton);
		btnPanel.add(nextButton);

		add(btnPanel, BorderLayout.SOUTH);

		pack();

		setTitle("Gallery");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(() -> {
			CardLayoutEx ex = new CardLayoutEx();
			ex.setVisible(true);
		});
	}
}
