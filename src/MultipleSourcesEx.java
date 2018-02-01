import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.LayoutStyle.ComponentPlacement.RELATED;

public class MultipleSourcesEx extends JFrame {

    private JLabel sbar;

    public MultipleSourcesEx() {

        initUI();
    }

    private void initUI() {

        sbar = new JLabel("Ready");
        sbar.setBorder(BorderFactory.createEtchedBorder());

        ButtonListener butlist = new ButtonListener();

        JButton closeBtn = new JButton("Close");
        closeBtn.addActionListener(butlist);

        JButton openBtn = new JButton("Open");
        openBtn.addActionListener(butlist);

        JButton findBtn = new JButton("Find");
        findBtn.addActionListener(butlist);

        JButton saveBtn = new JButton("Save");
        saveBtn.addActionListener(butlist);

        createLayout(closeBtn, openBtn, findBtn, saveBtn, sbar);

        setTitle("Multiple Sources");
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
                .addComponent(arg[2])
                .addComponent(arg[3])
                .addComponent(arg[4], GroupLayout.DEFAULT_SIZE,
                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(250)
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
                .addComponent(arg[1])
                .addComponent(arg[2])
                .addComponent(arg[3])
                .addPreferredGap(RELATED,
                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(arg[4])
        );

        gl.linkSize(arg[0], arg[1], arg[2], arg[3]);

        pack();
    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            JButton o = (JButton) e.getSource();
            String label = o.getText();
            sbar.setText(" " + label + " button clicked");
        }
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            MultipleSourcesEx ex = new MultipleSourcesEx();
            ex.setVisible(true);
        });
    }


}
