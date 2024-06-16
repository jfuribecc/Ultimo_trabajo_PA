import java.awt.*;
import javax.swing.*;

public class CasaGUI extends JPanel {
    private Color colorTecho;
    private Color colorVentanas;
    private Color colorParedes;
    private JLabel labelNumeroCasa;

    public CasaGUI(Color colorTecho, Color colorVentanas, Color colorParedes, String numeroCasa) {
        this.colorTecho = colorTecho;
        this.colorVentanas = colorVentanas;
        this.colorParedes = colorParedes;

        setLayout(new BorderLayout());
        labelNumeroCasa = new JLabel(numeroCasa, SwingConstants.CENTER);
        labelNumeroCasa.setFont(new Font("Arial", Font.BOLD, 16));
        add(labelNumeroCasa, BorderLayout.NORTH);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibujar paredes
        g.setColor(colorParedes);
        g.fillRect(50, 50, 200, 200);

        // Dibujar techo
        g.setColor(colorTecho);
        int[] xPoints = {50, 150, 250};
        int[] yPoints = {50, 0, 50};
        g.fillPolygon(xPoints, yPoints, 3);

        // Dibujar ventanas
        g.setColor(colorVentanas);
        g.fillRect(75, 100, 50, 50);
        g.fillRect(175, 100, 50, 50);
    }
}
