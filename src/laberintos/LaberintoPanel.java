/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package laberintos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
/**
 *
 * @author IanDa
 */
public class LaberintoPanel extends JPanel implements KeyListener {

    private int[][][] laberintos;
    private int laberintoActual;
    private int[][] laberinto;
    private int jugadorFila;
    private int jugadorColumna;
    private int metaFila;
    private int metaColumna;
    private int tamCelda = 40; // Tamaño de celdas NO MOVER DE 40 a menos que se ajuste el tamaño del laberinto
    private JLabel nivelLabel;
    
    private int totalNiveles = 10; // Puedes cambiar este valor al número de niveles que desees
    
    
//Advertencia mover tamCelda y la variable laberintos[i] = generarLaberintoDFS();
//puede hacer que no se generen bien los laberintos o se generen con la salida bloqueada
//es mas exerimental, asi que si se ajusta, se tiene que austar a unos valores especificos para
//poder generar un laberinto resolutible so, no le muevas a menos
//que experimentes o sepas ya que valor quieres
    
    
    public LaberintoPanel() {
        initComponents();
        this.setPreferredSize(new Dimension(600, 600));
        this.setBackground(Color.WHITE);
        this.setFocusable(true);
        this.addKeyListener(this);

        generarLaberintos();
        laberintoActual = 0;
        cargarLaberinto(laberintoActual);

        nivelLabel = new JLabel("Nivel: " + (laberintoActual + 1) + "/" + totalNiveles);
        nivelLabel.setFont(new Font("Arial", Font.BOLD, 14));

    }

    public JLabel getNivelLabel() {
        return nivelLabel;
    }

   private void generarLaberintos() {
    laberintos = new int[totalNiveles][][];
    for (int i = 0; i < totalNiveles; i++) {
        laberintos[i] = generarLaberintoDFS(15, 15); // Puedes ajustar el tamaño del laberinto aquí
                                                     //NO MOVER a menos que se ajuste tamCelda 
    }
}

        //ALGORITMO DE GENERACION DE LABERINTOS NO MOVER A MENOS QUE SEA ESTRICTAMENTE NECESARIO
        //O DEJARA DE FUNCIONAR LA GENERACION :c
    private int[][] generarLaberintoDFS(int filas, int columnas) {
        int[][] laberinto = new int[filas][columnas];
        for (int[] fila : laberinto) {
            Arrays.fill(fila, 1); // Inicializar con paredes
        }

        Stack<int[]> stack = new Stack<>();
        int[] inicio = {0, 0};
        laberinto[inicio[0]][inicio[1]] = 0;
        stack.push(inicio);

        Random rand = new Random();

        while (!stack.isEmpty()) {
            int[] actual = stack.pop();
            int fila = actual[0];
            int col = actual[1];

            java.util.List<int[]> vecinos = new java.util.ArrayList<>();
            if (fila - 2 >= 0 && laberinto[fila - 2][col] == 1) {
                vecinos.add(new int[]{fila - 2, col});
            }
            if (fila + 2 < filas && laberinto[fila + 2][col] == 1) {
                vecinos.add(new int[]{fila + 2, col});
            }
            if (col - 2 >= 0 && laberinto[fila][col - 2] == 1) {
                vecinos.add(new int[]{fila, col - 2});
            }
            if (col + 2 < columnas && laberinto[fila][col + 2] == 1) {
                vecinos.add(new int[]{fila, col + 2});
            }

            if (!vecinos.isEmpty()) {
                stack.push(actual);

                int[] vecino = vecinos.get(rand.nextInt(vecinos.size()));
                int nFila = vecino[0];
                int nCol = vecino[1];

                laberinto[(fila + nFila) / 2][(col + nCol) / 2] = 0;
                laberinto[nFila][nCol] = 0;
                stack.push(vecino);
            }
        }

        laberinto[filas - 1][columnas - 1] = 0; // Asegurandose que la meta esté despejada

        return laberinto;
    }

    private void cargarLaberinto(int indice) {
        laberinto = laberintos[indice];
        jugadorFila = 0;
        jugadorColumna = 0;
        metaFila = laberinto.length - 1;
        metaColumna = laberinto[0].length - 1;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibujar laberinto
        for (int fila = 0; fila < laberinto.length; fila++) {
            for (int col = 0; col < laberinto[0].length; col++) {
                int x = col * tamCelda;
                int y = fila * tamCelda;
                if (laberinto[fila][col] == 1) {
                    g.setColor(new Color(46, 46, 46)); // Paredes en negro
                } else {
                    g.setColor(Color.WHITE); // Caminos
                }
                g.fillRect(x, y, tamCelda, tamCelda);
                g.setColor(Color.LIGHT_GRAY);
                g.drawRect(x, y, tamCelda, tamCelda);
            }
        }

        // Dibujar jugador
        int xJugador = jugadorColumna * tamCelda;
        int yJugador = jugadorFila * tamCelda;
        g.setColor(new Color(30, 144, 255)); // Azul 
        g.fillOval(xJugador + tamCelda / 5, yJugador + tamCelda / 5, tamCelda * 3 / 5, tamCelda * 3 / 5);

        // Dibujar meta
        int xMeta = metaColumna * tamCelda;
        int yMeta = metaFila * tamCelda;
        g.setColor(new Color(50, 205, 50)); // Verde (meta)
        g.fillOval(xMeta + tamCelda / 5, yMeta + tamCelda / 5, tamCelda * 3 / 5, tamCelda * 3 / 5);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        int nuevaFila = jugadorFila;
        int nuevaCol = jugadorColumna;

        if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP) {
            nuevaFila--;
        } else if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
            nuevaFila++;
        } else if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
            nuevaCol--;
        } else if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
            nuevaCol++;
        }

        if (nuevaFila >= 0 && nuevaFila < laberinto.length && nuevaCol >= 0 && nuevaCol < laberinto[0].length
                && laberinto[nuevaFila][nuevaCol] == 0) {
            jugadorFila = nuevaFila;
            jugadorColumna = nuevaCol;
            repaint();

            if (jugadorFila == metaFila && jugadorColumna == metaColumna) {
                nivelCompletado();
            }
        }
    }

    private void nivelCompletado() {
        if (laberintoActual < laberintos.length - 1) {
            laberintoActual++;
            cargarLaberinto(laberintoActual);
            nivelLabel.setText("Nivel: " + (laberintoActual + 1) + "/" + totalNiveles);
        } else {
            finDelJuego();
        }
    }

   private void finDelJuego() {
    JOptionPane.showMessageDialog(this, "¡Juego Completado!", "¡Felicidades!", JOptionPane.INFORMATION_MESSAGE);
    //Obtener la ventana principal y cerrarla
    Window ventana = SwingUtilities.getWindowAncestor(this);
    if (ventana != null) {
        ventana.dispose();
        // Terminar la app
        System.exit(0);
    }
}


    @Override
    public void keyReleased(KeyEvent e) {
        // No implementado
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // No implementado
    }
    
    
    
    
    
    
    /**
     * Creates new form LaberintoPanel
     */
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
