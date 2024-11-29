package Formularios;

import Materias.Materias;
import java.awt.Point;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public final class MainPage extends javax.swing.JFrame {
    //variables iniciales
    private Point point;
    int retrocesoamenu = 0;
    private Usuario U;//se crea un objeto de la clase usuario
    Materias M=new Materias();//se crea un objeto de la clase materias
    MainSound sound = new MainSound();//se hace llamado a la clase MainSound
    Boolean Maximized = false;
    int cancion=1;
    FondoPanel fondo = new FondoPanel();//se hace llamado a la clase fondo panel
    public MainPage(Usuario Us) {
        this.setContentPane(fondo);//este establecera como ajustes del panel los atributos del objeto "fondo"
        this.U=Us;//iguala los datos del objeto de la clase usuario del panel anterior con el actual
        setUndecorated(true);
        initComponents();
        setSize(800, 433);//indica el espacio predeterminado del panel
        jLabel1.setText("pts: "+U.pts);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/Icon.jfif")).getImage());//imprime una imagen en el icono del programa
        setTitle("Prueba del Conocimiento");
        setLocationRelativeTo(null);
        setResizable(false);
        jSlider1.addChangeListener(e -> {//metodo utilizado para calcular el volumen deseado
            float vol=jSlider1.getValue();
            sound.setVolumen(vol);
        });
        Splash.num = 20;
        menuPrincipal();
        sound.identificarCancion(cancion);//identidica que cancion se quiere usar atraves del valor de la variable cancion
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FondoPanel fondo=new FondoPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jSlider1 = new javax.swing.JSlider();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));

        jPanel2=fondo;
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(132, 0, 45), null));

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        jButton5.setText("Informática");
        jButton5.setMaximumSize(new java.awt.Dimension(97, 23));
        jButton5.setMinimumSize(new java.awt.Dimension(97, 23));
        jButton5.setPreferredSize(new java.awt.Dimension(97, 23));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Contabilidad");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Mercadotécnia digital");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Ajustes");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Créditos");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Tronco Común");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setText("Menú Principal");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("Retroceder");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("jButton13");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setText("jButton14");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setText("jButton15");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setText("jButton16");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setText("jButton17");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setText("jButton18");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(filler2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(72, 72, 72)))
                .addComponent(filler3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton8)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filler4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                    .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 109, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton8)
                            .addComponent(jButton9))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(58, 58, 58)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jButton6)
                                            .addComponent(jButton13)))
                                    .addComponent(jButton14, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(39, 39, 39)
                                        .addComponent(jButton15)
                                        .addGap(62, 62, 62)
                                        .addComponent(jButton18)
                                        .addGap(39, 39, 39)
                                        .addComponent(jButton11))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(45, 45, 45)
                                                .addComponent(jButton7))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addComponent(jButton16)))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(57, 57, 57)
                                                .addComponent(jButton10))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(54, 54, 54)
                                                .addComponent(jButton17))))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton12))))
                    .addComponent(filler4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(filler3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        menuPrincipal();//hace llamado al metodo menuprincipal cuando se le hace click al boton
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        menuPrincipal();//hace llamado al metodo menuprincipal cuando se le hace click al boton
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        //este metodo se encarga de evaluar que funcion hara a travez del texto que se le imprimio con algun metodo
        switch(jButton10.getText()){
            case "Tronco Comun": tronco_comun(); break;//hace llamado al metodo troncocomun cuando se le da click al boton
            case "Base de Datos": M.id_materia=8; ForP(U); break;//hace llamado al metodo ForP he indica que la materia seleccionada es de id 8
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        creditos();//hace llamado al metodo creditos cuando se le da click al boton
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        ajustes();//hace llamado al metodo ajustes cuando se le da click al boton
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        //este metodo se encarga de evaluar que funcion hara a travez del texto que se le imprimio con algun metodo
        switch(jButton7.getText()){
            case "Mercadotecnia digital": Mensaje(); break;
            case "Herramientas de Porgramacion": M.id_materia=5; ForP(U); break;//hace llamado al metodo ForP he indica que la materia seleccionada es de id 5
            case "Cálculo Integral": M.id_materia=14; ForP(U); break;//hace llamado al metodo ForP he indica que la materia seleccionada es de id 14
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        //este metodo se encarga de evaluar que funcion hara a travez del texto que se le imprimio con algun metodo
        switch(jButton6.getText()){
            case "Contabilidad": Mensaje(); break;
            case "Modelado de sistemas": M.id_materia=2; ForP(U); break;//hace llamado al metodo ForP he indica que la materia seleccionada es de id 2
            case "Orientacion Juvenil y Profecional III": M.id_materia=11; ForP(U); break;//hace llamado al metodo ForP he indica que la materia seleccionada es de id 11
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        informática();//hace llamado al metodo informatica cuando se le hace click al boton
    }//GEN-LAST:event_jButton5ActionPerformed

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
        //este metodo se ocupa para maximizar y minimizar la pantalla y cambiar la imagemn del boton
        if(Maximized == false){
            setExtendedState(MAXIMIZED_BOTH);
            jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/minimize.png")));

            Maximized = true;
        }else{
            this.setSize(713, 400);
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
        // este metodo sew ocupa para mutear el sonido si este una variable dentro del sistema de sonido se lo permite
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
    
    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        //este metodo se encarga de evaluar que funcion hara a travez del texto que se le imprimio con algun metodo
        switch(jButton13.getText()){
            case "PDDM": M.id_materia=3; ForP(U); break;//hace llamado al metodo ForP he indica que la materia seleccionada es de id 3
            case "Contabilidad III": M.id_materia=12; ForP(U); break;//hace llamado al metodo ForP he indica que la materia seleccionada es de id 12
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        //este metodo se encarga de evaluar que funcion hara a travez del texto que se le imprimio con algun metodo
        switch(jButton14.getText()){
            case "Interacción Usuario Computadora": M.id_materia=1; ForP(U); break;//hace llamado al metodo ForP he indica que la materia seleccionada es de id 1
            case "Inglés V": M.id_materia=10; ForP(U); break;//hace llamado al metodo ForP he indica que la materia seleccionada es de id 10
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        //este metodo se encarga de evaluar que funcion hara a travez del texto que se le imprimio con algun metodo
        switch(jButton15.getText()){
            case "Sistemas Operativos": M.id_materia=4; ForP(U); break;//hace llamado al metodo ForP he indica que la materia seleccionada es de id 4
            case "Microeconomía": M.id_materia=13; ForP(U); break;//hace llamado al metodo ForP he indica que la materia seleccionada es de id 13
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        //este metodo se encarga de evaluar que funcion hara a travez del texto que se le imprimio con algun metodo
        switch(jButton16.getText()){
            case "Teleinformactica": M.id_materia=6; ForP(U);  break;//hace llamado al metodo ForP he indica que la materia seleccionada es de id 6
            case "Derecho Mercantil": M.id_materia=15; ForP(U); break;//hace llamado al metodo ForP he indica que la materia seleccionada es de id 15
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        //este metodo se encarga de evaluar que funcion hara a travez del texto que se le imprimio con algun metodo
        M.id_materia=7;ForP(U);//hace llamado al metodo ForP he indica que la materia seleccionada es de id 7
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        //este metodo se encarga de evaluar que funcion hara a travez del texto que se le imprimio con algun metodo
        M.id_materia=9;ForP(U);//hace llamado al metodo ForP he indica que la materia seleccionada es de id 9
    }//GEN-LAST:event_jButton17ActionPerformed
    private void menuPrincipal(){//este metodo indica que componentes seran visibles y los textos que son necesarios para el menu
        jButton5.setVisible(true);
        jButton5.setText("Informatica");
        jButton6.setVisible(true);
        jButton6.setText("Contabilidad");
        jButton7.setVisible(true);
        jButton7.setText("Mercadotecnia digital");
        jButton8.setVisible(true);
        jButton9.setVisible(true);
        jButton10.setVisible(true);
        jButton10.setText("Tronco Comun");
        jButton11.setVisible(false);
        jButton12.setVisible(false);
        jButton13.setVisible(false);
        jButton14.setVisible(false);
        jButton15.setVisible(false);
        jButton16.setVisible(false);
        jButton17.setVisible(false);
        jButton18.setVisible(false);
        retrocesoamenu = 0;
    }
    private void ajustes(){//este metodo indica que componentes seran visibles y los textos que son necesarios para el menu de ajustes
        jButton5.setVisible(false);
        jButton6.setVisible(false);
        jButton7.setVisible(false);
        jButton8.setVisible(false);
        jButton9.setVisible(false);
        jButton10.setVisible(false);
        jButton11.setVisible(false);
        jButton12.setVisible(true);
        jButton13.setVisible(false);
        jButton14.setVisible(false);
        jButton15.setVisible(false);
        jButton16.setVisible(false);
        jButton17.setVisible(false);
        jButton18.setVisible(false);
        retrocesoamenu = 1;
    }
    private void informática(){//este metodo indica que componentes seran visibles y los textos que son necesarios para el menu de materias de informatica
        jButton5.setVisible(false);
        jButton6.setVisible(true);
        jButton7.setVisible(true);
        jButton8.setVisible(false);
        jButton9.setVisible(false);
        jButton10.setVisible(true);
        jButton11.setVisible(true);
        jButton12.setVisible(false);
        jButton13.setVisible(true);
        jButton14.setVisible(true);
        jButton15.setVisible(true);
        jButton16.setVisible(true);
        jButton17.setVisible(true);
        jButton18.setVisible(true);
        jButton6.setText("Modelado de sistemas");
        jButton14.setText("Teleinformactica");
        jButton13.setText("Herramientas de Porgramacion");
        jButton15.setText("Sistemas Operativos");
        jButton7.setText("PDDM");
        jButton16.setText("Interacción Usuario Computadora");
        jButton17.setText("Ensamblado y Mantenimiento de pc´s");
        jButton10.setText("Base de Datos");
        jButton18.setText("POO");
        retrocesoamenu = 2;
    }
    private void Mensaje (){//mostrara un mensaje
        JOptionPane.showMessageDialog(rootPane, "Proximamente");
    }
    private void tronco_comun(){//este metodo indica que componentes seran visibles y los textos que son necesarios para el menu de materias de tronco comun
        jButton5.setVisible(false);
        jButton6.setVisible(true);
        jButton7.setVisible(true);
        jButton8.setVisible(false);
        jButton9.setVisible(false);
        jButton10.setVisible(false);
        jButton11.setVisible(true);
        jButton12.setVisible(false);
        jButton13.setVisible(true);
        jButton14.setVisible(true);
        jButton15.setVisible(true);
        jButton16.setVisible(true);
        jButton17.setVisible(false);
        jButton18.setVisible(false);
        jButton6.setText("Orientacion Juvenil y Profecional III");
        jButton7.setText("Cálculo Integral");
        jButton14.setText("Inglés V");
        jButton13.setText("Contabilidad III");
        jButton15.setText("Microeconomía");
        jButton16.setText("Derecho Mercantil");
        retrocesoamenu = 3;
    }
    private void creditos(){//este metodo indica que componentes seran visibles y los textos que son necesarios para la pantalla de creditos
        jButton5.setVisible(false);
        jButton6.setVisible(false);
        jButton7.setVisible(false);
        jButton8.setVisible(false);
        jButton9.setVisible(false);
        jButton10.setVisible(false);
        jButton11.setVisible(false);
        jButton12.setVisible(true);
        jButton13.setVisible(false);
        jButton14.setVisible(false);
        jButton15.setVisible(false);
        jButton16.setVisible(false);
        retrocesoamenu = 4;
    }
    public void ForP(Usuario Us){//hace llamado a la clase Formularios y la hace visible
        Formulario FP=new Formulario(U);//hace llamado de la clase
        FP.setVisible(true);//hace visible la clase
        sound.stop(); sound.close();//quita la musica de la pantalla actual
        dispose();//cierra la pantalla actual
    }
    public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
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
    //</editor-fold>
    
    Usuario u = new Usuario();
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new MainPage(u).setVisible(true);
        }
    });
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JSlider jSlider1;
    // End of variables declaration//GEN-END:variables
    class FondoPanel extends JPanel{//crea una clase que hereda los atributos de la clase JPanel
        private Image imagen;//crea una variable de la clase imagen
        @Override
        public void paint(Graphics g) {//este metodo se encargara de indicar que imagen se imprimira y el tamaño que debe tener
            imagen = new ImageIcon(getClass().getResource("/Imagenes/Fondito.jpg")).getImage();            
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);            
            setOpaque(false);
            super.paint(g);
        }
    }
}
