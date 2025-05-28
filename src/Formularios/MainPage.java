package Formularios;

import Materias.Materias;
import java.awt.Point;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Image;
import Materias.Materias;
import java.awt.Point;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.CardLayout; // Added for CardLayout
import java.awt.BorderLayout; // Added for BorderLayout

public final class MainPage extends javax.swing.JFrame {
    //variables iniciales
    private Point point;
    // int retrocesoamenu = 0; // Removed
    private Usuario U;//se crea un objeto de la clase usuario
    Materias M=new Materias();//se crea un objeto de la clase materias
    MainSound sound = new MainSound();//se hace llamado a la clase MainSound
    Boolean Maximized = false;
    int cancion=1;
    FondoPanel fondoPanel = new FondoPanel(); // Renamed for clarity and consistency

    // Panels for CardLayout
    private JPanel cardPanel;
    private CardLayout cardLayout;
    private MenuPrincipalPanel menuPrincipalPanel;
    private InformaticaMenuPanel informaticaMenuPanel;
    private TroncoComunMenuPanel troncoComunMenuPanel;
    private AjustesPanel ajustesPanel;
    private CreditosPanel creditosPanel;
    
    public MainPage(Usuario Us) {
        this.setContentPane(fondoPanel); // Use the class member
        this.U=Us;
        setUndecorated(true);
        initComponents(); // This will initialize jPanel1, jPanel2 (as FondoPanel), and btnIdioma

        // CardLayout setup
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.setOpaque(false); // Make cardPanel transparent to see fondoPanel

        // Instantiate panels
        menuPrincipalPanel = new MenuPrincipalPanel();
        menuPrincipalPanel.setOpaque(false); // Make sub-panels transparent
        informaticaMenuPanel = new InformaticaMenuPanel();
        informaticaMenuPanel.setOpaque(false);
        troncoComunMenuPanel = new TroncoComunMenuPanel();
        troncoComunMenuPanel.setOpaque(false);
        ajustesPanel = new AjustesPanel();
        ajustesPanel.setOpaque(false);
        creditosPanel = new CreditosPanel();
        creditosPanel.setOpaque(false);
        
        // Add panels to CardLayout
        cardPanel.add(menuPrincipalPanel, "MENU_PRINCIPAL");
        cardPanel.add(informaticaMenuPanel, "MENU_INFORMATICA");
        cardPanel.add(troncoComunMenuPanel, "MENU_TRONCO_COMUN");
        cardPanel.add(ajustesPanel, "MENU_AJUSTES");
        cardPanel.add(creditosPanel, "MENU_CREDITOS");

        // Add cardPanel to jPanel2 (which is our FondoPanel instance)
        jPanel2.setLayout(new BorderLayout()); 
        jPanel2.add(cardPanel, BorderLayout.CENTER);

        setSize(800, 433);
        jLabel1.setText("pts: "+U.pts);
        if (usernameLabel != null) { 
            usernameLabel.setText("User: " + U.nombre);
            usernameLabel.setForeground(java.awt.Color.WHITE); 
        }
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/Icon.jfif")).getImage());
        setTitle("Prueba del Conocimiento");
        setLocationRelativeTo(null);
        setResizable(false);
        jSlider1.addChangeListener(e -> {
            float vol=jSlider1.getValue();
            sound.setVolumen(vol);
        });
        Splash.num = 20;
        
        setupNavigation(); 
        
        Idioma.registrarComponente("idioma", btnIdioma); // This remains
        // Idioma.actualizarTextos(); // Called within showMenuPrincipal and other navigation methods

        showMenuPrincipal(); // Show main menu initially, this will also handle Idioma for it
        sound.identificarCancion(cancion);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        // Removed: FondoPanel fondo=new FondoPanel(); // This was shadowing the class member
        jPanel2 = fondoPanel; // Use the class member fondoPanel directly
        jPanel1 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jSlider1 = new javax.swing.JSlider();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel(); // Initialize usernameLabel
        btnIdioma = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(132, 0, 45), null));
        // jPanel2 will have BorderLayout set in constructor after calling initComponents()

        jPanel1.setBackground(new java.awt.Color(132, 0, 45));
        jPanel1.setFocusable(false);
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(132, 0, 45));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/volume.png"))); // NOI18N
        jButton4.setBorderPainted(false);
        jButton4.setFocusable(false);
        jButton4.setMaximumSize(new java.awt.Dimension(30, 30));
        jButton4.setMinimumSize(new java.awt.Dimension(30, 30));
        jButton4.setPreferredSize(new java.awt.Dimension(30, 30));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jSlider1.setBackground(new java.awt.Color(255, 255, 255));
        jSlider1.setMajorTickSpacing(14);
        jSlider1.setMaximum(6);
        jSlider1.setMinimum(-80);
        jSlider1.setMinorTickSpacing(7);
        jSlider1.setPaintTicks(true);
        jSlider1.setSnapToTicks(true);
        jSlider1.setToolTipText("");
        jSlider1.setValue(-40);
        jSlider1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSlider1.setFocusable(false);
        jSlider1.setMaximumSize(new java.awt.Dimension(200, 20));
        jSlider1.setMinimumSize(new java.awt.Dimension(200, 20));

        jButton1.setBackground(new java.awt.Color(132, 0, 45));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/close.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton1.setMargin(new java.awt.Insets(2, 14, 2, 14));
        jButton1.setMaximumSize(new java.awt.Dimension(30, 30));
        jButton1.setMinimumSize(new java.awt.Dimension(30, 30));
        jButton1.setPreferredSize(new java.awt.Dimension(30, 30));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(132, 0, 45));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/maximize.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton2.setMargin(new java.awt.Insets(2, 14, 2, 14));
        jButton2.setMaximumSize(new java.awt.Dimension(30, 30));
        jButton2.setMinimumSize(new java.awt.Dimension(30, 30));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(132, 0, 45));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/hide.png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setMargin(new java.awt.Insets(2, 14, 2, 14));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 285, Short.MAX_VALUE)
                .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE) 
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED) 
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usernameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE) 
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSlider1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        btnIdioma.setText("idioma");
        btnIdioma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIdiomaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnIdioma)
                .addGap(34, 34, 34))
            // Removed button layout code from here
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 311, Short.MAX_VALUE) // Placeholder for cardPanel
                .addComponent(btnIdioma)
                .addContainerGap())
            // Removed button layout code from here
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        point = evt.getPoint();
        getComponentAt(point);
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int CurrentX = this.getLocation().x;
        int CurrentY = this.getLocation().y;

        int MoveX = (CurrentX + evt.getX()) - (CurrentX + point.x);
        int MoveY = (CurrentY + evt.getY()) - (CurrentY + point.y);

        int x = CurrentX + MoveX;
        int y = CurrentY + MoveY;

        this.setLocation(x, y);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        setExtendedState(ICONIFIED);
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/maximize.png")));
        Maximized = false;
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(Maximized == false){
            setExtendedState(MAXIMIZED_BOTH);
            jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/minimize.png")));
            Maximized = true;
        }else{
            this.setSize(800, 433);
            setLocationRelativeTo(null);
            jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/maximize.png")));
            Maximized = false;
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        sound.stop(); sound.close();
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        float vol=-40;
        try{
            sound.mute(vol);
            if(sound.mut==false){
                jSlider1.setValue((int)vol);
            }else if(sound.mut==true){
                jSlider1.setValue(-80);
            }
        }catch(Exception e){
            System.out.println("error en el volumen");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnIdiomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIdiomaActionPerformed
        Idioma.cambiarIdioma();
        updateVisiblePanelTexts(); 
    }//GEN-LAST:event_btnIdiomaActionPerformed
   
    private void Mensaje (){
        JOptionPane.showMessageDialog(rootPane, Idioma.getTexto("proximamente"));
    }

    public void ForP(Usuario Us){ 
        // Ensure M.id_materia is correctly set by the calling button's ActionListener in setupNavigation()
        Formulario FP = new Formulario(this.U, this.M, this.M.id_materia); 
        FP.setVisible(true);
        sound.stop(); sound.close();//quita la musica
        dispose();//cierra la pantalla actual
    }

    private void setupNavigation() {
        // MenuPrincipalPanel Actions
        menuPrincipalPanel.getBtnInformatica().addActionListener(e -> {
            cardLayout.show(cardPanel, "MENU_INFORMATICA");
            Idioma.registrarComponente("modelado_sistemas", informaticaMenuPanel.getBtnModeladoSistemas());
            Idioma.registrarComponente("pddm", informaticaMenuPanel.getBtnPddm());
            Idioma.registrarComponente("base_datos", informaticaMenuPanel.getBtnBaseDatos());
            Idioma.registrarComponente("menu_principal", informaticaMenuPanel.getBtnMenuPrincipal()); // This is key for "Menú Principal" text
            Idioma.registrarComponente("herramientas_programacion", informaticaMenuPanel.getBtnHerramientasProg());
            Idioma.registrarComponente("teleinformactica", informaticaMenuPanel.getBtnTeleinformatica());
            Idioma.registrarComponente("sistemas_operativos", informaticaMenuPanel.getBtnSistemasOperativos());
            Idioma.registrarComponente("iu_computadora", informaticaMenuPanel.getBtnInteraccionUsuarioComp());
            Idioma.registrarComponente("ensamblado", informaticaMenuPanel.getBtnEnsamblado());
            Idioma.registrarComponente("poo", informaticaMenuPanel.getBtnPoo());
            Idioma.actualizarTextos();
        });
        menuPrincipalPanel.getBtnContabilidad().addActionListener(e -> Mensaje());
        menuPrincipalPanel.getBtnMercadotecnia().addActionListener(e -> Mensaje());
        menuPrincipalPanel.getBtnAjustes().addActionListener(e -> {
            cardLayout.show(cardPanel, "MENU_AJUSTES");
            Idioma.registrarComponente("retroceder", ajustesPanel.getBtnRetroceder());
            Idioma.actualizarTextos();
        });
        menuPrincipalPanel.getBtnCreditos().addActionListener(e -> {
            cardLayout.show(cardPanel, "MENU_CREDITOS");
            Idioma.registrarComponente("retroceder", creditosPanel.getBtnRetroceder());
            Idioma.actualizarTextos();
        });
        menuPrincipalPanel.getBtnTroncoComun().addActionListener(e -> {
            cardLayout.show(cardPanel, "MENU_TRONCO_COMUN");
            Idioma.registrarComponente("orientacion_juv_prof", troncoComunMenuPanel.getBtnOrientacionJuvProf());
            Idioma.registrarComponente("calculo_integral", troncoComunMenuPanel.getBtnCalculoIntegral());
            Idioma.registrarComponente("menu_principal", troncoComunMenuPanel.getBtnMenuPrincipal()); // This is key
            Idioma.registrarComponente("contabilidad_iii", troncoComunMenuPanel.getBtnContabilidadIII());
            Idioma.registrarComponente("inglés_v", troncoComunMenuPanel.getBtnInglesV());
            Idioma.registrarComponente("microeconomia", troncoComunMenuPanel.getBtnMicroeconomia());
            Idioma.registrarComponente("derecho_mercantil", troncoComunMenuPanel.getBtnDerechoMercantil());
            Idioma.actualizarTextos();
        });

        // InformaticaMenuPanel Actions
        informaticaMenuPanel.getBtnMenuPrincipal().addActionListener(e -> showMenuPrincipal());
        informaticaMenuPanel.getBtnModeladoSistemas().addActionListener(e -> { M.id_materia=2; ForP(U); }); 
        informaticaMenuPanel.getBtnPddm().addActionListener(e -> { M.id_materia=3; ForP(U); }); 
        informaticaMenuPanel.getBtnBaseDatos().addActionListener(e -> { M.id_materia=8; ForP(U); }); 
        informaticaMenuPanel.getBtnHerramientasProg().addActionListener(e -> { M.id_materia=5; ForP(U); }); 
        informaticaMenuPanel.getBtnTeleinformatica().addActionListener(e -> { M.id_materia=1; ForP(U); }); 
        informaticaMenuPanel.getBtnSistemasOperativos().addActionListener(e -> { M.id_materia=4; ForP(U); }); 
        informaticaMenuPanel.getBtnInteraccionUsuarioComp().addActionListener(e -> { M.id_materia=6; ForP(U); });
        informaticaMenuPanel.getBtnEnsamblado().addActionListener(e -> { M.id_materia=9; ForP(U); }); 
        informaticaMenuPanel.getBtnPoo().addActionListener(e -> { M.id_materia=7; ForP(U); }); 
        
        // TroncoComunMenuPanel Actions
        troncoComunMenuPanel.getBtnMenuPrincipal().addActionListener(e -> showMenuPrincipal());
        troncoComunMenuPanel.getBtnOrientacionJuvProf().addActionListener(e -> { M.id_materia=11; ForP(U); }); 
        troncoComunMenuPanel.getBtnCalculoIntegral().addActionListener(e -> { M.id_materia=14; ForP(U); }); 
        troncoComunMenuPanel.getBtnContabilidadIII().addActionListener(e -> { M.id_materia=12; ForP(U); }); 
        troncoComunMenuPanel.getBtnInglesV().addActionListener(e -> { M.id_materia=10; ForP(U); }); 
        troncoComunMenuPanel.getBtnMicroeconomia().addActionListener(e -> { M.id_materia=13; ForP(U); }); 
        troncoComunMenuPanel.getBtnDerechoMercantil().addActionListener(e -> { M.id_materia=15; ForP(U); }); 

        // AjustesPanel Actions
        ajustesPanel.getBtnRetroceder().addActionListener(e -> showMenuPrincipal());

        // CreditosPanel Actions
        creditosPanel.getBtnRetroceder().addActionListener(e -> showMenuPrincipal());
    }

    private void showMenuPrincipal() {
        cardLayout.show(cardPanel, "MENU_PRINCIPAL");
        Idioma.registrarComponente("informatica", menuPrincipalPanel.getBtnInformatica());
        Idioma.registrarComponente("contabilidad", menuPrincipalPanel.getBtnContabilidad());
        Idioma.registrarComponente("mercadotecnia_digital", menuPrincipalPanel.getBtnMercadotecnia());
        Idioma.registrarComponente("ajustes", menuPrincipalPanel.getBtnAjustes());
        Idioma.registrarComponente("creditos", menuPrincipalPanel.getBtnCreditos());
        Idioma.registrarComponente("tronco_comun", menuPrincipalPanel.getBtnTroncoComun());
        Idioma.actualizarTextos();
    }
    
    private void updateVisiblePanelTexts() {
        // This method ensures that when the language is changed, 
        // the text on the *currently visible* panel's components are updated.
        // It's called from btnIdiomaActionPerformed.
        JPanel visiblePanel = null;
        for (java.awt.Component comp : cardPanel.getComponents()) {
            if (comp.isVisible() && comp instanceof JPanel) {
                visiblePanel = (JPanel) comp;
                break;
            }
        }

        if (visiblePanel == menuPrincipalPanel) {
            showMenuPrincipal(); // Re-registers and updates main menu
        } else if (visiblePanel == informaticaMenuPanel) {
            // Re-register components for Informatica menu
            Idioma.registrarComponente("modelado_sistemas", informaticaMenuPanel.getBtnModeladoSistemas());
            Idioma.registrarComponente("pddm", informaticaMenuPanel.getBtnPddm());
            Idioma.registrarComponente("base_datos", informaticaMenuPanel.getBtnBaseDatos());
            Idioma.registrarComponente("menu_principal", informaticaMenuPanel.getBtnMenuPrincipal());
            Idioma.registrarComponente("herramientas_programacion", informaticaMenuPanel.getBtnHerramientasProg());
            Idioma.registrarComponente("teleinformactica", informaticaMenuPanel.getBtnTeleinformatica());
            Idioma.registrarComponente("sistemas_operativos", informaticaMenuPanel.getBtnSistemasOperativos());
            Idioma.registrarComponente("iu_computadora", informaticaMenuPanel.getBtnInteraccionUsuarioComp());
            Idioma.registrarComponente("ensamblado", informaticaMenuPanel.getBtnEnsamblado());
            Idioma.registrarComponente("poo", informaticaMenuPanel.getBtnPoo());
            Idioma.actualizarTextos();
        } else if (visiblePanel == troncoComunMenuPanel) {
            // Re-register components for Tronco Comun menu
            Idioma.registrarComponente("orientacion_juv_prof", troncoComunMenuPanel.getBtnOrientacionJuvProf());
            Idioma.registrarComponente("calculo_integral", troncoComunMenuPanel.getBtnCalculoIntegral());
            Idioma.registrarComponente("menu_principal", troncoComunMenuPanel.getBtnMenuPrincipal());
            Idioma.registrarComponente("contabilidad_iii", troncoComunMenuPanel.getBtnContabilidadIII());
            Idioma.registrarComponente("inglés_v", troncoComunMenuPanel.getBtnInglesV());
            Idioma.registrarComponente("microeconomia", troncoComunMenuPanel.getBtnMicroeconomia());
            Idioma.registrarComponente("derecho_mercantil", troncoComunMenuPanel.getBtnDerechoMercantil());
            Idioma.actualizarTextos();
        } else if (visiblePanel == ajustesPanel) {
            Idioma.registrarComponente("retroceder", ajustesPanel.getBtnRetroceder());
            Idioma.actualizarTextos();
        } else if (visiblePanel == creditosPanel) {
            Idioma.registrarComponente("retroceder", creditosPanel.getBtnRetroceder());
            Idioma.actualizarTextos();
        }
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        Usuario u; // Declare Usuario object
        // Attempt to load user data using UserRepository.
        // If loading fails (e.g., file not found, corrupt data),
        // a default Usuario object will be used.
        try {
            data.UserRepository userRepository = new data.UserRepository();
            u = userRepository.loadUsuario();
        } catch (Exception e) { // Catch a broader range of exceptions for robustness
            System.err.println("Error loading user data for MainPage main: " + e.getMessage());
            u = new Usuario(); // Fallback to default user if loading fails
        }

        // 'finalUser' is used in the lambda. This variable captures the state of 'u'
        // after attempting to load data, ensuring the correct Usuario object is passed
        // to the MainPage constructor. This is necessary because variables used in
        // lambdas must be final or effectively final.
        final Usuario finalUser = u;

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPage(finalUser).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIdioma;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JSlider jSlider1;
    // End of variables declaration//GEN-END:variables
    class FondoPanel extends JPanel{
        private Image imagen;
        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/Imagenes/Fondito.jpg")).getImage();            
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);            
            setOpaque(false);
            super.paint(g);
        }
    }
}
