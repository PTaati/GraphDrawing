
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class TempEdge {

    
    Vertex vertexA;
    int x1;
    int y1;
    
    TempEdge(int x, int y) {
        this.x1 = x;
        this.y1 = y;
    }

    void setA(Vertex a) {
        this.vertexA = a;
    }

    void line(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLUE);
        g2.setStroke(new BasicStroke(2));
        
        if(vertexA.inCircle(x1, y1)){
            double angle = Math.atan2(y1 - vertexA.y, x1 - vertexA.x);
            double dx = Math.cos(angle);
            double dy = Math.sin(angle);
            int rc = (int)(vertexA.r*Math.sqrt(2));
            int xloop = vertexA.x - vertexA.r + (int)(dx*rc);
            int yloop = vertexA.y - vertexA.r + (int)(dy*rc);
            
            g2.drawArc(xloop, yloop , vertexA.r*2, vertexA.r*2, 0, 360); 
        }else{
            g2.drawLine(vertexA.x, vertexA.y, x1, y1);
        }
    }
}


