import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Administrator on 2018/2/1.
 */
public class MyButton extends JButton implements ActionListener {

    public MyButton(String text) {

        super.setText(text);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
