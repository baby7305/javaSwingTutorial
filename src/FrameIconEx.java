import javax.swing.*;
import java.awt.*;

public class FrameIconEx extends JFrame {

    public FrameIconEx() {

        initUI();
    }

    private void initUI() {

        ImageIcon webIcon = new ImageIcon("res/web.png");

        setIconImage(webIcon.getImage());

        setTitle("Icon");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            FrameIconEx ex = new FrameIconEx();
            ex.setVisible(true);
        });
    }
}
