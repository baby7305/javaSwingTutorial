import javax.swing.*;
import java.awt.*;

public class DerivedClassEx extends JFrame {

    public DerivedClassEx() {

        initUI();
    }

    private void initUI() {

        MyButton closeBtn = new MyButton("Close");

        createLayout(closeBtn);

        setTitle("Derived class");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createLayout(JComponent... arg) {

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
                .addGap(220)
        );

        gl.setVerticalGroup(gl.createParallelGroup()
                .addComponent(arg[0])
                .addGap(220)
        );

        pack();
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            DerivedClassEx ex = new DerivedClassEx();
            ex.setVisible(true);
        });
    }


}
