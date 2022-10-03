package paint;

import java.awt.geom.Ellipse2D;

public class Cerc extends Oval {
	public void setElip2d(Ellipse2D elip2d) {
		elip2d.setFrame(elip2d.getX(), elip2d.getY(), elip2d.getWidth(), elip2d.getWidth());
		super.setElip2d(elip2d);
	}	
}
