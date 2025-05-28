package Formularios;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InformaticaMenuPanel extends JPanel {

    private JButton btnModeladoSistemas;
    private JButton btnPddm;
    private JButton btnBaseDatos;
    private JButton btnHerramientasProg;
    private JButton btnTeleinformatica;
    private JButton btnSistemasOperativos;
    private JButton btnInteraccionUsuarioComp;
    private JButton btnEnsamblado;
    private JButton btnPoo;
    private JButton btnMenuPrincipal;

    public InformaticaMenuPanel() {
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Menú Informática", JLabel.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(5, 2, 10, 10)); // 5 rows, 2 columns

        btnModeladoSistemas = new JButton("Modelado de sistemas");
        btnPddm = new JButton("PDDM");
        btnBaseDatos = new JButton("Base de Datos");
        btnHerramientasProg = new JButton("Herramientas de Programación");
        btnTeleinformatica = new JButton("Teleinformática");
        btnSistemasOperativos = new JButton("Sistemas Operativos");
        btnInteraccionUsuarioComp = new JButton("Interacción Usuario Computadora");
        btnEnsamblado = new JButton("Ensamblado");
        btnPoo = new JButton("POO");
        btnMenuPrincipal = new JButton("Menú Principal");

        // Add ActionListeners
        btnModeladoSistemas.addActionListener(e -> System.out.println("Modelado de sistemas button clicked"));
        btnPddm.addActionListener(e -> System.out.println("PDDM button clicked"));
        btnBaseDatos.addActionListener(e -> System.out.println("Base de Datos button clicked"));
        btnHerramientasProg.addActionListener(e -> System.out.println("Herramientas de Programación button clicked"));
        btnTeleinformatica.addActionListener(e -> System.out.println("Teleinformática button clicked"));
        btnSistemasOperativos.addActionListener(e -> System.out.println("Sistemas Operativos button clicked"));
        btnInteraccionUsuarioComp.addActionListener(e -> System.out.println("Interacción Usuario Computadora button clicked"));
        btnEnsamblado.addActionListener(e -> System.out.println("Ensamblado button clicked"));
        btnPoo.addActionListener(e -> System.out.println("POO button clicked"));
        btnMenuPrincipal.addActionListener(e -> System.out.println("Menú Principal from Informática clicked"));

        // Add buttons to the panel
        buttonPanel.add(btnModeladoSistemas);
        buttonPanel.add(btnPddm);
        buttonPanel.add(btnBaseDatos);
        buttonPanel.add(btnHerramientasProg);
        buttonPanel.add(btnTeleinformatica);
        buttonPanel.add(btnSistemasOperativos);
        buttonPanel.add(btnInteraccionUsuarioComp);
        buttonPanel.add(btnEnsamblado);
        buttonPanel.add(btnPoo);
        buttonPanel.add(btnMenuPrincipal);
        
        add(buttonPanel, BorderLayout.CENTER);
    }

    // Getter methods
    public JButton getBtnModeladoSistemas() { return btnModeladoSistemas; }
    public JButton getBtnPddm() { return btnPddm; }
    public JButton getBtnBaseDatos() { return btnBaseDatos; }
    public JButton getBtnHerramientasProg() { return btnHerramientasProg; }
    public JButton getBtnTeleinformatica() { return btnTeleinformatica; }
    public JButton getBtnSistemasOperativos() { return btnSistemasOperativos; }
    public JButton getBtnInteraccionUsuarioComp() { return btnInteraccionUsuarioComp; }
    public JButton getBtnEnsamblado() { return btnEnsamblado; }
    public JButton getBtnPoo() { return btnPoo; }
    public JButton getBtnMenuPrincipal() { return btnMenuPrincipal; }
}
