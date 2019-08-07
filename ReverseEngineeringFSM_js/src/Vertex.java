
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Vertex {

    int x;
    int y;
    String name;
    int r;
    int shift ;
    boolean isSelect;

    Vertex(int x, int y) {
        this.r = 36;
        this.shift = 30;
        this.x = x;
        this.y = y;
        this.name = "";
        this.isSelect = false;
    }

    boolean inCircle(int x0, int y0) {
        return ((x0 - x) * (x0 - x) + (y0 - y) * (y0 - y)) <= r * r;
    }

    void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(isSelect ? Color.BLUE : Color.BLACK);
        g2.setStroke(new BasicStroke(2));

        g2.fillOval(x - r, y - r, r * 2, r * 2);

        g2.setColor(Color.WHITE);
        g2.fillOval(x - r + (r - shift) / 2, y - r + (r - shift) / 2, r * 2 - (r - shift), r * 2 - (r - shift));

        g2.setColor(isSelect ? Color.BLUE : Color.BLACK);
        g2.drawString(name, x - 10, y + 10);
    }

}

