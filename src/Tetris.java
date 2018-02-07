import javax.swing.*;
import java.awt.*;

/**
 * Created by Administrator on 2018/2/7.
 */
public class Tetris extends JFrame {

	private JLabel statusbar;

	public Tetris() {

		initUI();
	}

	private void initUI() {

		statusbar = new JLabel(" 0");
		add(statusbar, BorderLayout.SOUTH);
		Board board = new Board(this);
		add(board);
		board.start();

		setSize(200, 400);
		setTitle("Tetris");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public JLabel getStatusBar() {

		return statusbar;
	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {

				Tetris game = new Tetris();
				game.setVisible(true);
			}
		});
	}
}
