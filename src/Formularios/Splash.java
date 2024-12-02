package Formularios;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicProgressBarUI;

public final class Splash extends javax.swing.JFrame {
    
    public static int num = 10;
    int X = 0;
    Color Policolor = new Color(208, 13, 78);//se crea variable de la clase Color
    public Splash() {
        
        initComponents();
        setLocationRelativeTo(null);
        jProgressBar1.setUI(new BasicProgressBarUI(){
            @Override
            protected void paintDeterminate(Graphics g, JComponent jc) {//determina los ajustes de la barra de progreso utilizada cuando carga el programa
                Graphics2D gr2d = (Graphics2D)g;
                //indica los tamaños de la barra de progreso
                int ancho = jProgressBar1.getWidth();
                int alto = jProgressBar1.getHeight();
                int espacioAncho = ancho - 10;
                int espacioAlto = alto - 10;
                double porcentajeCarga = jProgressBar1.getPercentComplete();
                //indica el espacio de la carga
                espacioAncho = (int) (espacioAncho * porcentajeCarga);
                //indica el color 
                gr2d.setColor(Policolor);
                Rectangle carga = new Rectangle(2,2,espacioAncho+6,espacioAlto+6);
                gr2d.fill(carga);
            }
        });
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/Icon.jfif")).getImage());
        setAlwaysOnTop(true);
        setTitle("Loading...");
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(132, 0, 45));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Bienvenid@");

        jProgressBar1.setBackground(new java.awt.Color(204, 51, 255));
        jProgressBar1.setForeground(new java.awt.Color(132, 0, 45));
        jProgressBar1.setBorder(null);
        jProgressBar1.setBorderPainted(false);
        jProgressBar1.setFocusable(false);
        jProgressBar1.setOpaque(true);
        jProgressBar1.setPreferredSize(new java.awt.Dimension(10, 8));
        jProgressBar1.setString("");

        jLabel2.setText("0%");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        Splash sp = new Splash();//se hace llamado a la clase Slash
        sp.setVisible(true);//se hace visible la pantalla de la clase Slash
        Usuario Us=new Usuario();//se hace llamado a la clase Usuario
        try {
            for(int i = 0; i<=100; i++){//esta funcion ira incrementando el procentaje de la barra de progreso cada cierto tiempo
                Thread.sleep(num);//indica que espere un cierto tiempo antes de seguir con el proceso
                sp.jLabel2.setText(i + "%");//modifica el texto del label para indicar el nuevo porcentaje
                sp.jProgressBar1.setValue(i);//modifica el procentaje de la barra de progreso
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        MainPage mp = new MainPage(Us);
        sp.setVisible(false);
        mp.setVisible(true);
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
}
