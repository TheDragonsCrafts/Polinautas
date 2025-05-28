package Formularios;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipalPanel extends JPanel {

    private JButton btnInformatica;
    private JButton btnContabilidad;
    private JButton btnMercadotecnia;
    private JButton btnAjustes;
    private JButton btnCreditos;
    private JButton btnTroncoComun;

    public MenuPrincipalPanel() {
        // Set layout manager - GridLayout for a 3x2 grid
        setLayout(new GridLayout(3, 2, 10, 10)); // 3 rows, 2 columns, 10px hgap, 10px vgap

        // Initialize buttons
        btnInformatica = new JButton("Informática");
        btnContabilidad = new JButton("Contabilidad");
        btnMercadotecnia = new JButton("Mercadotécnia digital");
        btnAjustes = new JButton("Ajustes");
        btnCreditos = new JButton("Créditos");
        btnTroncoComun = new JButton("Tronco Común");

        // Add ActionListeners
        btnInformatica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Informática button clicked");
            }
        });

        btnContabilidad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Contabilidad button clicked");
            }
        });

        btnMercadotecnia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Mercadotécnia digital button clicked");
            }
        });

        btnAjustes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ajustes button clicked");
            }
        });

        btnCreditos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Créditos button clicked");
            }
        });

        btnTroncoComun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Tronco Común button clicked");
            }
        });

        // Add buttons to the panel
        add(btnInformatica);
        add(btnContabilidad);
        add(btnMercadotecnia);
        add(btnAjustes);
        add(btnCreditos);
        add(btnTroncoComun);
    }

    // Placeholder for future methods to get buttons if needed for external ActionListeners
    public JButton getBtnInformatica() { return btnInformatica; }
    public JButton getBtnContabilidad() { return btnContabilidad; }
    public JButton getBtnMercadotecnia() { return btnMercadotecnia; }
    public JButton getBtnAjustes() { return btnAjustes; }
    public JButton getBtnCreditos() { return btnCreditos; }
    public JButton getBtnTroncoComun() { return btnTroncoComun; }
}
