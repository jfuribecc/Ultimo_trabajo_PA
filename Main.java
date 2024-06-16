import java.awt.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> crearYMostrarGUI());
    }

    private static void crearYMostrarGUI() {
        JFrame frame = new JFrame("Casas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int numCasas = 0;
        Color colorTecho = null;
        Color colorVentanas = null;
        Color colorParedes = null;

        // 1. Manejar la entrada del número de casas
        try {
            numCasas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de casas:"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Número de casas no válido. Usando valor por defecto: 1");
            numCasas = 1; // Valor por defecto
        }

        // 2. Manejar la selección del color del techo
        try {
            colorTecho = JColorChooser.showDialog(null, "Seleccione el color del techo", Color.RED);
            if (colorTecho == null) throw new NullPointerException("Selección de color cancelada.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Color del techo no seleccionado. Usando color por defecto: Rojo");
            colorTecho = Color.RED; // Valor por defecto
        }

        // 3. Manejar la selección del color de las ventanas
        try {
            colorVentanas = JColorChooser.showDialog(null, "Seleccione el color de las ventanas", Color.BLUE);
            if (colorVentanas == null) throw new NullPointerException("Selección de color cancelada.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Color de las ventanas no seleccionado. Usando color por defecto: Azul");
            colorVentanas = Color.BLUE; // Valor por defecto
        }

        // 4. Manejar la selección del color de las paredes
        try {
            colorParedes = JColorChooser.showDialog(null, "Seleccione el color de las paredes", Color.WHITE);
            if (colorParedes == null) throw new NullPointerException("Selección de color cancelada.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Color de las paredes no seleccionado. Usando color por defecto: Blanco");
            colorParedes = Color.WHITE; // Valor por defecto
        }

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, numCasas, 10, 10));

        // 5. Manejar la creación y adición de paneles
        try {
            for (int i = 0; i < numCasas; i++) {
                String numeroCasa = "Casa " + (i + 1);
                CasaGUI casa = new CasaGUI(colorTecho, colorVentanas, colorParedes, numeroCasa);
                panel.add(casa);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al crear las casas: " + e.getMessage());
        }

        // 6. Manejar la configuración del frame
        try {
            frame.add(panel);
            frame.pack(); // Ajustar el tamaño del frame al contenido
            frame.setLocationRelativeTo(null); // Centrar el frame en la pantalla
            frame.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al configurar la ventana: " + e.getMessage());
        }
    }
}
