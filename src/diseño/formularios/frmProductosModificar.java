/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diseño.formularios;

import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Ricky
 */
public class frmProductosModificar extends javax.swing.JFrame {

    /**
     * Creates new form frmProductosModificar
     */
    public frmProductosModificar() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnBarraSuperior = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lblAtras = new javax.swing.JLabel();
        jpnCompras = new javax.swing.JPanel();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel34 = new javax.swing.JLabel();
        txtNuevoCodBarraProducto = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        btnGuardarModificarProducto = new javax.swing.JButton();
        txtNuevoInventarioProducto = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        txtNuevoNombreProducto = new javax.swing.JTextField();
        txtNuevoCostoProducto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/iconos/home/lanzador.png")).getImage());
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1200, 700));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpnBarraSuperior.setBackground(new java.awt.Color(102, 0, 0));
        jpnBarraSuperior.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jpnBarraSuperiorMouseDragged(evt);
            }
        });
        jpnBarraSuperior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jpnBarraSuperiorMousePressed(evt);
            }
        });
        jpnBarraSuperior.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblLogo.setForeground(new java.awt.Color(255, 255, 255));
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/home/lanzador.png"))); // NOI18N
        lblLogo.setToolTipText("");
        jpnBarraSuperior.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 0, 50, 50));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setToolTipText("");
        jpnBarraSuperior.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 60, 60));

        lblAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Atras.png"))); // NOI18N
        lblAtras.setToolTipText("Atrás");
        lblAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAtrasMouseClicked(evt);
            }
        });
        jpnBarraSuperior.add(lblAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 10, 50, 40));

        getContentPane().add(jpnBarraSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 55));

        jpnCompras.setBackground(new java.awt.Color(0, 0, 0));
        jpnCompras.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jpnCompras.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 0, 20, 50));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(240, 240, 240));
        jLabel34.setText("Modificar un Producto:");
        jpnCompras.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 12, -1, 30));

        txtNuevoCodBarraProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtNuevoCodBarraProducto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNuevoCodBarraProducto.setEnabled(false);
        txtNuevoCodBarraProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNuevoCodBarraProductoKeyTyped(evt);
            }
        });
        jpnCompras.add(txtNuevoCodBarraProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 12, 150, 30));

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Codigo de barra:");
        jpnCompras.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 12, -1, 30));

        getContentPane().add(jpnCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1200, 50));

        btnGuardarModificarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/botones/guardarprov.png"))); // NOI18N
        btnGuardarModificarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardarModificarProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGuardarModificarProductoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGuardarModificarProductoMouseExited(evt);
            }
        });
        btnGuardarModificarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarModificarProductoActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardarModificarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 580, 110, 30));

        txtNuevoInventarioProducto.setForeground(new java.awt.Color(102, 0, 0));
        txtNuevoInventarioProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNuevoInventarioProductoActionPerformed(evt);
            }
        });
        txtNuevoInventarioProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNuevoInventarioProductoKeyTyped(evt);
            }
        });
        getContentPane().add(txtNuevoInventarioProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, 80, 30));

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel43.setText("Nombre:");
        getContentPane().add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, -1, 20));

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel44.setText("Inventario:");
        getContentPane().add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 340, -1, 20));

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel45.setText("Costo:");
        getContentPane().add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 430, -1, 20));

        txtNuevoNombreProducto.setForeground(new java.awt.Color(102, 0, 0));
        txtNuevoNombreProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNuevoNombreProductoActionPerformed(evt);
            }
        });
        txtNuevoNombreProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNuevoNombreProductoKeyTyped(evt);
            }
        });
        getContentPane().add(txtNuevoNombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 250, 410, 30));

        txtNuevoCostoProducto.setForeground(new java.awt.Color(102, 0, 0));
        txtNuevoCostoProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNuevoCostoProductoKeyTyped(evt);
            }
        });
        getContentPane().add(txtNuevoCostoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 430, 90, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAtrasMouseClicked
        frmProductos pd = new frmProductos();
        pd.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblAtrasMouseClicked

    private void jpnBarraSuperiorMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnBarraSuperiorMouseDragged

    }//GEN-LAST:event_jpnBarraSuperiorMouseDragged

    private void jpnBarraSuperiorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnBarraSuperiorMousePressed

    }//GEN-LAST:event_jpnBarraSuperiorMousePressed

    private void btnGuardarModificarProductoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarModificarProductoMouseEntered
        btnGuardarModificarProducto.setIcon(new ImageIcon(getClass().getResource("/iconos/botones/guardarprovB.png")));
    }//GEN-LAST:event_btnGuardarModificarProductoMouseEntered

    private void btnGuardarModificarProductoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarModificarProductoMouseExited
        btnGuardarModificarProducto.setIcon(new ImageIcon(getClass().getResource("/iconos/botones/guardarprov.png")));
    }//GEN-LAST:event_btnGuardarModificarProductoMouseExited

    private void btnGuardarModificarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarModificarProductoActionPerformed
 
    }//GEN-LAST:event_btnGuardarModificarProductoActionPerformed

    private void txtNuevoInventarioProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNuevoInventarioProductoActionPerformed
        txtNuevoCostoProducto.requestFocus();
    }//GEN-LAST:event_txtNuevoInventarioProductoActionPerformed

    private void txtNuevoInventarioProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNuevoInventarioProductoKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {

            if (c != (char) KeyEvent.VK_BEGIN) {
                if (c != (char) KeyEvent.VK_BACK_SPACE) {
                    if (c != (char) KeyEvent.VK_DELETE) {
                        if (c != (char) KeyEvent.VK_ENTER) {
                            evt.consume();
                            JOptionPane.showMessageDialog(null, "Solo Numeros", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_txtNuevoInventarioProductoKeyTyped

    private void txtNuevoNombreProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNuevoNombreProductoActionPerformed
        txtNuevoInventarioProducto.requestFocus();
    }//GEN-LAST:event_txtNuevoNombreProductoActionPerformed

    private void txtNuevoNombreProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNuevoNombreProductoKeyTyped
        char mayu=evt.getKeyChar();
        if (Character.isLowerCase(mayu)) {
            String cadena=(""+mayu).toUpperCase();
            mayu=cadena.charAt(0);
            evt.setKeyChar(mayu);
        }
        else{

        }
    }//GEN-LAST:event_txtNuevoNombreProductoKeyTyped

    private void txtNuevoCostoProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNuevoCostoProductoKeyTyped
        int c=(int) evt.getKeyChar();

        if ((c >=48 && c<=57)  || (c==46) || (c==8)) {
            if (c==46) {
                String cadena=txtNuevoCostoProducto.getText();
                int tamanio=cadena.length();
                for (int i = 0; i <= tamanio; i++) {
                    if (cadena.contains(".")) {
                        evt.setKeyChar((char) KeyEvent.VK_CLEAR);
                        getToolkit().beep();
                        evt.consume();
                    }
                }
            }
        }else{
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtNuevoCostoProductoKeyTyped

    private void txtNuevoCodBarraProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNuevoCodBarraProductoKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {

            if (c != (char) KeyEvent.VK_BEGIN) {
                if (c != (char) KeyEvent.VK_BACK_SPACE) {
                    if (c != (char) KeyEvent.VK_DELETE) {
                        if (c != (char) KeyEvent.VK_ENTER) {
                            evt.consume();
                            JOptionPane.showMessageDialog(null, "Solo Numeros", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_txtNuevoCodBarraProductoKeyTyped

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
            java.util.logging.Logger.getLogger(frmProductosModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmProductosModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmProductosModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmProductosModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmProductosModificar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarModificarProducto;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JPanel jpnBarraSuperior;
    private javax.swing.JPanel jpnCompras;
    private javax.swing.JLabel lblAtras;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JTextField txtNuevoCodBarraProducto;
    private javax.swing.JTextField txtNuevoCostoProducto;
    private javax.swing.JTextField txtNuevoInventarioProducto;
    private javax.swing.JTextField txtNuevoNombreProducto;
    // End of variables declaration//GEN-END:variables
}
