package paint;

import java.awt.Rectangle;

public class Patrat extends Dreptunghi {
	public void setRect(Rectangle rect) {
		rect.setBounds(rect.x, rect.y , rect.width, rect.width);
		super.setRect(rect);
	}
}
