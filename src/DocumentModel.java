import javax.swing.*;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DocumentModel extends JFrame {

	private StyledDocument sdoc;
	private JTextPane textpane;

	public DocumentModel() {

		initUI();
	}

	private void initUI() {

		createToolbar();

		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

		textpane = new JTextPane();
		sdoc = textpane.getStyledDocument();
		initStyles(textpane);

		panel.add(new JScrollPane(textpane));
		add(panel);
		pack();

		setTitle("Document Model");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void createToolbar() {

		JToolBar toolbar = new JToolBar();

		ImageIcon bold = new ImageIcon("res/bold.png");
		ImageIcon italic = new ImageIcon("italic.png");
		ImageIcon strike = new ImageIcon("strike.png");
		ImageIcon underline = new ImageIcon("underline.png");

		JButton boldb = new JButton(bold);
		JButton italb = new JButton(italic);
		JButton strib = new JButton(strike);
		JButton undeb = new JButton(underline);

		toolbar.add(boldb);
		toolbar.add(italb);
		toolbar.add(strib);
		toolbar.add(undeb);

		add(toolbar, BorderLayout.NORTH);

		boldb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sdoc.setCharacterAttributes(textpane.getSelectionStart(),
						textpane.getSelectionEnd() - textpane.getSelectionStart(),
						textpane.getStyle("Bold"), false);
			}
		});

		italb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sdoc.setCharacterAttributes(textpane.getSelectionStart(),
						textpane.getSelectionEnd() - textpane.getSelectionStart(),
						textpane.getStyle("Italic"), false);
			}

		});

		strib.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sdoc.setCharacterAttributes(textpane.getSelectionStart(),
						textpane.getSelectionEnd() - textpane.getSelectionStart(),
						textpane.getStyle("Strike"), false);
			}

		});

		undeb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sdoc.setCharacterAttributes(textpane.getSelectionStart(),
						textpane.getSelectionEnd() - textpane.getSelectionStart(),
						textpane.getStyle("Underline"), false);
			}
		});

	}

	private void initStyles(JTextPane textpane) {

		Style style = textpane.addStyle("Bold", null);
		StyleConstants.setBold(style, true);

		style = textpane.addStyle("Italic", null);
		StyleConstants.setItalic(style, true);

		style = textpane.addStyle("Underline", null);
		StyleConstants.setUnderline(style, true);

		style = textpane.addStyle("Strike", null);
		StyleConstants.setStrikeThrough(style, true);
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				DocumentModel ex = new DocumentModel();
				ex.setVisible(true);
			}
		});
	}
}
