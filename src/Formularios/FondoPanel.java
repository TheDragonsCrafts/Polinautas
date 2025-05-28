package Formularios;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class FondoPanel extends JPanel {
    private Image imagen;

    @Override
    public void paint(Graphics g) {
        // Load the image within the paint method.
        // This ensures that if the panel is recreated or the path context changes,
        // it attempts to load the image again.
        // Consider making the image path configurable or a constant.
        imagen = new ImageIcon(getClass().getResource("/Imagenes/Fondito.jpg")).getImage();
        if (imagen != null) {
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        } else {
            // Fallback if image not found, e.g., draw a solid color
            g.setColor(java.awt.Color.LIGHT_GRAY);
            g.fillRect(0, 0, getWidth(), getHeight());
            System.err.println("Background image not found at /Imagenes/Fondito.jpg");
        }
        setOpaque(false); // Important for background panels if they are layered
        super.paint(g);   // Calls the superclass's paint method
    }
}
