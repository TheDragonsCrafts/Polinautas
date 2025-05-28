package Formularios;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AjustesPanel extends JPanel {

    private JLabel titleLabel;
    private JButton btnRetroceder;

    public AjustesPanel() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Center alignment, 10px hgap/vgap

        titleLabel = new JLabel("Ajustes Panel");
        add(titleLabel);

        btnRetroceder = new JButton("Retroceder");
        btnRetroceder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Retroceder from Ajustes clicked");
            }
        });
        add(btnRetroceder);
    }

    // Getter methods
    public JLabel getTitleLabel() { return titleLabel; }
    public JButton getBtnRetroceder() { return btnRetroceder; }
}
