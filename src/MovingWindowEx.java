import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MovingWindowEx extends JFrame {

    private JLabel labelx;
    private JLabel labely;

    public MovingWindowEx() {

        initUI();
    }

    private void initUI() {

        addComponentListener(new MoveAdapter());

        labelx = new JLabel("x: ");
        labelx.setFont(new Font("Serif", Font.BOLD, 14));

        labely = new JLabel("y: ");
        labely.setFont(new Font("Serif", Font.BOLD, 14));

        createLayout(labelx, labely);

        setTitle("Adapter example");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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
                .addGap(250)
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
                .addComponent(arg[1])
                .addGap(130)
        );

        pack();
    }

    private class MoveAdapter extends ComponentAdapter {

        @Override
        public void componentMoved(ComponentEvent e) {

            int x = e.getComponent().getX();
            int y = e.getComponent().getY();

            labelx.setText("x: " + x);
            labely.setText("y: " + y);
        }
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            MovingWindowEx ex = new MovingWindowEx();
            ex.setVisible(true);
        });
    }
}
