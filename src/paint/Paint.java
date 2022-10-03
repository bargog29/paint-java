package paint;

import java.awt.Point;
import java.io.BufferedWriter;

public interface Paint
{

    public void draw(GraphicAdapter g);

    public boolean contains(Point p);

    public void move(Point startDrag, Point endDrag);

    public void writetoFile(BufferedWriter b);

    public void makeObject(Point startDrag, Point endDrag);
}
