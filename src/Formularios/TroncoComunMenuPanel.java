package Formularios;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TroncoComunMenuPanel extends JPanel {

    private JButton btnOrientacionJuvProf;
    private JButton btnCalculoIntegral;
    private JButton btnContabilidadIII;
    private JButton btnInglesV;
    private JButton btnMicroeconomia;
    private JButton btnDerechoMercantil;
    private JButton btnMenuPrincipal;

    public TroncoComunMenuPanel() {
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Menú Tronco Común", JLabel.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 2, 10, 10)); // 4 rows, 2 columns

        btnOrientacionJuvProf = new JButton("Orientacion Juvenil y Profecional III");
        btnCalculoIntegral = new JButton("Cálculo Integral");
        btnContabilidadIII = new JButton("Contabilidad III");
        btnInglesV = new JButton("Inglés V");
        btnMicroeconomia = new JButton("Microeconomía");
        btnDerechoMercantil = new JButton("Derecho Mercantil");
        btnMenuPrincipal = new JButton("Menú Principal");

        // Add ActionListeners
        btnOrientacionJuvProf.addActionListener(e -> System.out.println("Orientacion Juvenil y Profecional III button clicked"));
        btnCalculoIntegral.addActionListener(e -> System.out.println("Cálculo Integral button clicked"));
        btnContabilidadIII.addActionListener(e -> System.out.println("Contabilidad III button clicked"));
        btnInglesV.addActionListener(e -> System.out.println("Inglés V button clicked"));
        btnMicroeconomia.addActionListener(e -> System.out.println("Microeconomía button clicked"));
        btnDerechoMercantil.addActionListener(e -> System.out.println("Derecho Mercantil button clicked"));
        btnMenuPrincipal.addActionListener(e -> System.out.println("Menú Principal from Tronco Común clicked"));

        // Add buttons to the panel
        buttonPanel.add(btnOrientacionJuvProf);
        buttonPanel.add(btnCalculoIntegral);
        buttonPanel.add(btnContabilidadIII);
        buttonPanel.add(btnInglesV);
        buttonPanel.add(btnMicroeconomia);
        buttonPanel.add(btnDerechoMercantil);
        buttonPanel.add(btnMenuPrincipal);
        
        add(buttonPanel, BorderLayout.CENTER);
    }

    // Getter methods
    public JButton getBtnOrientacionJuvProf() { return btnOrientacionJuvProf; }
    public JButton getBtnCalculoIntegral() { return btnCalculoIntegral; }
    public JButton getBtnContabilidadIII() { return btnContabilidadIII; }
    public JButton getBtnInglesV() { return btnInglesV; }
    public JButton getBtnMicroeconomia() { return btnMicroeconomia; }
    public JButton getBtnDerechoMercantil() { return btnDerechoMercantil; }
    public JButton getBtnMenuPrincipal() { return btnMenuPrincipal; }
}
