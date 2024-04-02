package com.mycompany.editordibujo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author John Eduardo V.C
 */
public class FrmInterfaz extends javax.swing.JFrame {

    int x1, y1;

    public FrmInterfaz() {

        String nombreArchivo = System.getProperty("user.dir")+ "/src/datos/coords.txt";
        initComponents();

        x1 = -1;
        y1 = -1;

    }

    private void GuardarCoordenadas(String nombreArchivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            Graphics g = pnlLienzo.getGraphics();
            g.setColor(Color.BLACK);

            int x1 = -1;
            int y1 = -1;

            
            String coordinates[] = null;
            for (int i = 0; i < coordinates.length; i += 2) {
                int x2 = Integer.parseInt(coordinates[i]);
                int y2 = Integer.parseInt(coordinates[i + 1]);

                if (x1 > 0 && y1 > 0) {
                    g.setColor(Color.BLUE);
                    g.drawLine(x1, y1, x2, y2);
                }
                x1 = x2;
                y1 = y2;

                
                bw.write(x2 + ";" + y2);
                bw.newLine();
            }

            
            bw.close();
            System.out.println("Coordinates saved to file: " + "coords.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* public void saveDrawing(JPanel pnlLienzo) {
        
        
        Properties prop = System.getProperties();
        String nombreArchivo = prop.getProperty("user.dir") + "/src/datos/datos.txt";;
        Graphics g = pnlLienzo.getGraphics();
        g.setColor(Color.red);
        BufferedReader br=Archivo.guardarArchivo(nombreArchivo, textos);
        x1 = -1;
        y1 = -1;
        
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLienzo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCoordenadas = new javax.swing.JTextField();
        jToolBar1 = new javax.swing.JToolBar();
        btnAbrir = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnLinea = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        pnlLienzo.setBackground(new java.awt.Color(255, 255, 51));
        pnlLienzo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                pnlLienzoMouseMoved(evt);
            }
        });
        pnlLienzo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlLienzoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlLienzoLayout = new javax.swing.GroupLayout(pnlLienzo);
        pnlLienzo.setLayout(pnlLienzoLayout);
        pnlLienzoLayout.setHorizontalGroup(
            pnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlLienzoLayout.setVerticalGroup(
            pnlLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 222, Short.MAX_VALUE)
        );

        jLabel1.setText("Coordenadas");

        jToolBar1.setRollover(true);

        btnAbrir.setText("Abrir");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAbrir);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnGuardar);

        btnLinea.setText("Linea");
        btnLinea.setToolTipText("Línea");
        btnLinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLineaActionPerformed(evt);
            }
        });
        jToolBar1.add(btnLinea);

        jButton1.setText("jButton1");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlLienzo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtCoordenadas, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCoordenadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlLienzo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnlLienzoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlLienzoMouseClicked

        int x2 = evt.getX();
        int y2 = evt.getY();

        if (x1 > 0 && y1 > 0) {

            Graphics g = pnlLienzo.getGraphics();
            g.setColor(Color.BLUE);
            g.drawLine(x1, y1, x2, y2);
        }
        x1 = x2;
        y1 = y2;
    }//GEN-LAST:event_pnlLienzoMouseClicked

    private void pnlLienzoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlLienzoMouseMoved
        int x = evt.getX();
        int y = evt.getY();

        txtCoordenadas.setText("x=" + x + "y=" + y);

        Graphics g = pnlLienzo.getGraphics();
        g.setColor(Color.red);
        g.drawOval(x, y, x, y);
    }//GEN-LAST:event_pnlLienzoMouseMoved

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        String nombreArchivo = Archivo.elegirArchivo();
        BufferedReader br = Archivo.abrirArchivo(nombreArchivo);
        Graphics g = pnlLienzo.getGraphics();
        g.setColor(Color.red);

        x1 = -1;
        y1 = -1;

        try {
            String linea = br.readLine();
            while (linea != null) {
                String[] textos = linea.split(";");
                int x2 = (Integer.parseInt(textos[0]));
                int y2 = (Integer.parseInt(textos[1]));

                if (x1 > 0 && y1 > 0) {
                    g.setColor(Color.BLUE);
                    g.drawLine(x1, y1, x2, y2);
                }
                x1 = x2;
                y1 = y2;

                linea = br.readLine();
            }

        } catch (Exception ex) {

        }
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        String nombreArchivo = Archivo.elegirArchivo();
        GuardarCoordenadas(nombreArchivo);

        /*String nombreArchivo = System.getProperty("user.dir") + "/src/datos/coords.txt";
         if (Archivo.guardar(nombreArchivo, pnlLienzo)) {
            JOptionPane.showMessageDialog(null, "Los datos fueron guardados exitosamente");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo guardar los datos");
        }
         */
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLineaActionPerformed
        
    }//GEN-LAST:event_btnLineaActionPerformed

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
            java.util.logging.Logger.getLogger(FrmInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmInterfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLinea;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel pnlLienzo;
    private javax.swing.JTextField txtCoordenadas;
    // End of variables declaration//GEN-END:variables
}
