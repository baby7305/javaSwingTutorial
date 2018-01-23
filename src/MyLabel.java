import javax.swing.*;

/**
 * Created by Administrator on 2018/1/23.
 */
class MyLabel extends JLabel {

	public MyLabel() {
		super("", null, LEADING);
	}

	@Override
	public boolean isOpaque() {
		return true;
	}
}
