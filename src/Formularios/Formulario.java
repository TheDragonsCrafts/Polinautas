/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Formularios;

import data.UserRepository; // Added import
import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.FlowLayout; // Added import
import java.awt.event.ActionEvent; // Added import
import java.awt.event.ActionListener; // Added import
import javax.swing.ImageIcon;
import javax.swing.JButton; // Added import
import javax.swing.JLabel; // Added import
import javax.swing.JOptionPane; // Added import
import laberintos.LaberintoPanel;
import laberintos.MazeListener; // Added import
import Materias.Materias; // Added for Materias class
import javax.swing.BoxLayout; // Added for BoxLayout
import javax.swing.JRadioButton; // Added for JRadioButton
import javax.swing.ButtonGroup; // Added for ButtonGroup


public class Formulario extends javax.swing.JFrame implements MazeListener { // Implemented MazeListener
    //variables
    private Point point;
    // private JLabel questionLabel; // Will be created in loadQuestion
    // private JButton answerButton; // Will be created in loadQuestion
    // int retrocesoamenu = 0; // Seems unused
    private Usuario Us;
    private UserRepository userRepository;
    private Materias materias; 
    private int currentMateriaId; 
    private int currentQuestionIndex = 0; 
    private JRadioButton[] answerRadioButtons; // Field to hold radio buttons

    LaberintoPanel labP;
    MainSound sound = new MainSound();
    Boolean Maximized = false;
    int cancion=2;

    // Updated Constructor
    public Formulario(Usuario U, Materias materias, int id_materia) {
        this.Us = U;
        this.materias = materias;
        this.currentMateriaId = id_materia;
        this.userRepository = new UserRepository(); 
        
        setUndecorated(true);
        initComponents();
        cargar_laberinto();
        jLabel1.setText("pts: "+Us.pts); // Display initial points
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/Icon.jfif")).getImage());
        setTitle("Prueba del Conocimiento: " + this.materias.getNombreMateria(this.currentMateriaId));
        setLocationRelativeTo(null);
        setResizable(false);
        jSlider1.addChangeListener(e -> {
            float vol=jSlider1.getValue();
            sound.setVolumen(vol);
        });

        loadQuestion(currentQuestionIndex); // Load the first question
    }

    private void loadQuestion(int questionIndex) {
        JintFrame2.getContentPane().removeAll();
        JintFrame2.getContentPane().setLayout(new BoxLayout(JintFrame2.getContentPane(), BoxLayout.Y_AXIS));

        String subjectName = materias.getNombreMateria(currentMateriaId);
        String questionText = materias.reg_M(currentMateriaId, questionIndex);
        
        // Create and add question panel first, as it also handles "Question not found"
        JPanel questionPanel = createQuestionPanel(subjectName, questionText);
        JintFrame2.getContentPane().add(questionPanel);

        // Early exit if question text itself indicates an issue (handled in createQuestionPanel's display logic)
        if (questionText == null || questionText.equals("Question not found") || questionText.isEmpty()) {
            JintFrame2.revalidate();
            JintFrame2.repaint();
            return;
        }

        // Now fetch answers and points, only if question is valid
        String[] answers = materias.reg_R(currentMateriaId, questionIndex); // answers[0] is the correct one
        final int points = materias.reg_Pts(currentMateriaId, questionIndex);

        if (answers == null || answers.length == 0) {
            JLabel noAnswersLabel = new JLabel("No answers available for this question.");
            JintFrame2.getContentPane().add(noAnswersLabel);
        } else {
            // If answers are present, even if less than 4, proceed.
            // Log a warning if answer count is unusual but not 0.
            if (answers.length < 4 && answers.length > 0) {
                 System.err.println("Warning: Incomplete answer set for question '" + questionText + "' (" + answers.length + " answers provided). Displaying available answers.");
            }

            JPanel answersPanel = createAnswersPanel(answers);
            JintFrame2.getContentPane().add(answersPanel);

            // The first answer is always considered the correct one by design of reg_R
            JButton submitButton = createSubmitButton(answers[0], points);
            JintFrame2.getContentPane().add(submitButton);
        }

        JintFrame2.revalidate();
        JintFrame2.repaint();
    }

    private JPanel createQuestionPanel(String subjectName, String questionText) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel questionLabelDisplay = new JLabel();
        if (questionText != null && !questionText.equals("Question not found") && !questionText.isEmpty()) {
            questionLabelDisplay.setText("<html><body style='width: 250px'>" + subjectName + ":<br>" + questionText + "</body></html>");
        } else {
            questionLabelDisplay.setText("<html><body style='width: 250px'>No question available for " + subjectName + " (Q:" + currentQuestionIndex + ").</body></html>");
        }
        panel.add(questionLabelDisplay);
        return panel;
    }

    private JPanel createAnswersPanel(String[] allAnswers) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        // Size answerRadioButtons based on the actual number of answers provided
        answerRadioButtons = new JRadioButton[allAnswers.length]; 
        ButtonGroup answerGroup = new ButtonGroup();
            
        for (int i = 0; i < allAnswers.length; i++) {
            // Guard against unexpectedly null answer strings within the array, though ideally reg_R ensures this.
            String answerText = allAnswers[i] != null ? allAnswers[i] : "Error: Null answer option";
            answerRadioButtons[i] = new JRadioButton(answerText);
            answerGroup.add(answerRadioButtons[i]);
            panel.add(answerRadioButtons[i]);
        }
        return panel;
    }

    private JButton createSubmitButton(final String correctAnswer, final int points) {
        JButton submitButton = new JButton("Submit Answer");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedAnswerText = null;
                // Check if answerRadioButtons has been initialized and is not empty
                if (answerRadioButtons == null || answerRadioButtons.length == 0) {
                     JOptionPane.showMessageDialog(Formulario.this, "No answers were loaded to select from.", "Error", JOptionPane.ERROR_MESSAGE);
                    return; 
                }

                for(JRadioButton rb : answerRadioButtons) {
                    if (rb.isSelected()) {
                        selectedAnswerText = rb.getText();
                        break;
                    }
                }

                if (selectedAnswerText != null) {
                    if (selectedAnswerText.equals(correctAnswer)) {
                        Us.pts += points;
                        userRepository.saveUsuario(Us);
                        jLabel1.setText("pts: " + Us.pts);
                        JOptionPane.showMessageDialog(Formulario.this, "Correct! You earned " + points + " points.", "Question Answered", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(Formulario.this, "Incorrect. The correct answer was: " + correctAnswer, "Question Answered", JOptionPane.ERROR_MESSAGE);
                    }
                    
                    for(JRadioButton rb : answerRadioButtons) rb.setEnabled(false);
                    submitButton.setEnabled(false); // Disable this button
                    
                    // Optional: Logic to load next question or finish
                    // currentQuestionIndex++;
                    // String nextQuestion = materias.reg_M(currentMateriaId, currentQuestionIndex);
                    // if (nextQuestion != null && !nextQuestion.equals("Question not found") && !nextQuestion.isEmpty()) {
                    //     loadQuestion(currentQuestionIndex);
                    // } else {
                    //     JOptionPane.showMessageDialog(Formulario.this, "No more questions for this subject!", "End of Subject", JOptionPane.INFORMATION_MESSAGE);
                    // }

                } else {
                    JOptionPane.showMessageDialog(Formulario.this, "Please select an answer.", "No Answer Selected", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        return submitButton;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jSlider1 = new javax.swing.JSlider();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        JintFrame1 = new javax.swing.JInternalFrame();
        jLabel3 = new javax.swing.JLabel();
        JintFrame2 = new javax.swing.JInternalFrame();
        jLabel2 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jProgressBar2 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSlider1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        JintFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        JintFrame1.setFocusable(false);
        JintFrame1.setVisible(true);

        jLabel3.setText("aqui aparecera el laberinto");

        javax.swing.GroupLayout JintFrame1Layout = new javax.swing.GroupLayout(JintFrame1.getContentPane());
        JintFrame1.getContentPane().setLayout(JintFrame1Layout);
        JintFrame1Layout.setHorizontalGroup(
            JintFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JintFrame1Layout.createSequentialGroup()
                .addContainerGap(133, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127))
        );
        JintFrame1Layout.setVerticalGroup(
            JintFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JintFrame1Layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(jLabel3)
                .addContainerGap(246, Short.MAX_VALUE))
        );

        JintFrame2.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        JintFrame2.setVisible(true);

        jLabel2.setText("aqui apareceran las preguntas");

        jProgressBar1.setBackground(new java.awt.Color(102, 0, 0));
        jProgressBar1.setForeground(new java.awt.Color(102, 102, 102));
        jProgressBar1.setMaximum(3);
        jProgressBar1.setValue(3);

        javax.swing.GroupLayout JintFrame2Layout = new javax.swing.GroupLayout(JintFrame2.getContentPane());
        JintFrame2.getContentPane().setLayout(JintFrame2Layout);
        JintFrame2Layout.setHorizontalGroup(
            JintFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JintFrame2Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addGroup(JintFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        JintFrame2Layout.setVerticalGroup(
            JintFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JintFrame2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(262, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JintFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JintFrame2))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JintFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JintFrame2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //este metodo se ocupa para maximizar y minimizar la pantalla y cambiar la imagemn del boton
        if(Maximized == false){
            setExtendedState(MAXIMIZED_BOTH);
            jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/minimize.png")));

            Maximized = true;
        }else{
            this.setSize(876, 492);
            setLocationRelativeTo(null);
            jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/maximize.png")));
            Maximized = false;
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        setExtendedState(ICONIFIED);
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/maximize.png")));
        Maximized = false;
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        //este se encarga de decir que si se arrastra el panel rojo este movera toda la pantalla
        int CurrentX = this.getLocation().x;
        int CurrentY = this.getLocation().y;

        int MoveX = (CurrentX + evt.getX()) - (CurrentX + point.x);
        int MoveY = (CurrentY + evt.getY()) - (CurrentY + point.y);

        int x = CurrentX + MoveX;
        int y = CurrentY + MoveY;

        this.setLocation(x, y);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        point = evt.getPoint();
        getComponentAt(point);
    }//GEN-LAST:event_jPanel1MousePressed

    public void cargar_laberinto(){//este metodo cargara un laberinto
        if (labP == null){ 
            labP = new LaberintoPanel();
            labP.setMazeListener(this); // Set listener
        }
        jLabel3.setVisible(false); // Hide placeholder
        JintFrame1.add(labP, BorderLayout.CENTER); 
        labP.requestFocusInWindow(); 
        JintFrame1.revalidate();
    }

    @Override
    public void mazeCompleted(int points) {
        if (Us != null) { // Check if Us (Usuario object) exists
            Us.pts += points; // Directly add points
            userRepository.saveUsuario(Us); // Replaced Us.guardar_datos()
            jLabel1.setText("pts: " + Us.pts);
            JOptionPane.showMessageDialog(this, "Maze Cleared! You earned " + points + " points.", "Success", JOptionPane.INFORMATION_MESSAGE);
        }

        // Reset the maze display area
        if (labP != null) {
            JintFrame1.remove(labP);
            labP = null; // Nullify to allow reloading a fresh one if needed
        }
        jLabel3.setVisible(true); // Show the placeholder text again
        JintFrame1.revalidate();
        JintFrame1.repaint();
        
        // Optionally, re-enable buttons or navigate back
        // For now, this just clears the maze area.
    }

    /**
     * @param args the command line arguments
     */
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
        java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>
    
    Usuario U = new Usuario();
    // Optional: Load user data for testing
    try {
        data.UserRepository userRepository = new data.UserRepository();
        Usuario loadedU = userRepository.loadUsuario();
        U.nombre = loadedU.nombre;
        U.pts = loadedU.pts;
    } catch (Exception e) {
        System.err.println("Error loading user for Formulario main: " + e.getMessage());
        // Continue with default U if loading fails
    }

    final Materias M = new Materias(); // final to be accessible in Runnable
    final int defaultMateriaId = 1;   // final to be accessible in Runnable
                                      // This ID (1) corresponds to "Teleinformática" in Materias_informatica.
                                      // Ensure Materias_informatica populates data for ID 1 if real questions are expected.
                                      // For now, it will show "No question available..." if data arrays are empty.

    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new Formulario(U, M, defaultMateriaId).setVisible(true);
        }
    });
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JInternalFrame JintFrame1;
    private javax.swing.JInternalFrame JintFrame2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    public javax.swing.JSlider jSlider1;
    // End of variables declaration//GEN-END:variables
}
