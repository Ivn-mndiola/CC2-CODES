import java.awt.*;
import javax.swing.*;
public class DrawShapes extends Canvas{
    public void paint(Graphics g) {
        // Draw the tree trunk
        g.setColor(new Color(139, 69, 19)); // Brown color for the trunk
        g.fillRect(350, 300, 40, 100); // Trunk dimensions (x, y, width, height)
    
        // Draw the foliage (leaves) - using green ovals
        g.setColor(Color.GREEN);
        g.fillOval(300, 200, 120, 120); // Top foliage
        g.fillOval(320, 150, 120, 120); // Upper foliage
        g.fillOval(340, 200, 120, 120); // Right foliage
    }
    
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Tree");
        DrawShapes canvas = new DrawShapes();

        frame.setSize(800,  500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(canvas);
        frame.setVisible(true);

    }
}
