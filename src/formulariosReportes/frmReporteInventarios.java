/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulariosReportes;

import clases.Conexion;
import clases.ControladorSucursal;
import clases.ErrorTienda;
import clases.Sucursal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author oscar
 */
public class frmReporteInventarios extends javax.swing.JFrame {

    /**
     * Creates new form frmReporteInventarios
     */
    
        ArrayList<Sucursal> sucursales = new ArrayList();
        Object miSucursal[][];
        Iterator<Sucursal> Iterador;

    public frmReporteInventarios() throws ErrorTienda {
        initComponents();
        rbtnTodasS.setSelected(true);
        CargarSucursales();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        rbtnTodasS = new javax.swing.JRadioButton();
        rbtnUnaS = new javax.swing.JRadioButton();
        btnGenerar = new javax.swing.JButton();
        cmbSucursalReporte = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup1.add(rbtnTodasS);
        rbtnTodasS.setSelected(true);
        rbtnTodasS.setText("INVENTARIO TODAS LAS SUCURSALES");
        getContentPane().add(rbtnTodasS, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 63, -1, -1));

        buttonGroup1.add(rbtnUnaS);
        rbtnUnaS.setText("UNA SUCURSAL EN ESPECIFICO");
        getContentPane().add(rbtnUnaS, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        btnGenerar.setText("GENERAR REPORTE");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGenerar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, -1, -1));

        getContentPane().add(cmbSucursalReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

     public void CargarSucursales() throws ErrorTienda{
        sucursales = ControladorSucursal.obtener();
        miSucursal = new Object[sucursales.size()/4][4];
        
        int contador=0,fila=0;
        Iterator<Sucursal> iterador= sucursales.iterator();
        String temporal="";
        while (iterador.hasNext()){
            miSucursal[fila][0]=iterador.next();
            miSucursal[fila][1]=iterador.next();
            miSucursal[fila][2]=iterador.next();
            miSucursal[fila][3]=iterador.next();
            cmbSucursalReporte.addItem(""+miSucursal[fila][1]);
            fila++;
        }
       
    }
    
    
    
    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        
        
        if (rbtnTodasS.isSelected()) {
            
            try {
                Conexion cn = new Conexion();
                JasperReport reporteinventarios = JasperCompileManager.compileReport("reporteInventarios.jrxml");
                JasperPrint print = JasperFillManager.fillReport(reporteinventarios, null, cn.conexion);
                JasperViewer view = new JasperViewer (print,false);
                view.setVisible(true);
            } catch (JRException ex) {
                Logger.getLogger(frmReporteInventarios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ErrorTienda ex) {
                Logger.getLogger(frmReporteInventarios.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else {
            Conexion cn;
            try {
                cn = new Conexion();
                Map parametrosucursal = new HashMap();
                parametrosucursal.put("sucursales",cmbSucursalReporte.getSelectedItem() );
                 JasperReport reporteinventario = JasperCompileManager.compileReport("reporteInventario.jrxml");
                JasperPrint print = JasperFillManager.fillReport(reporteinventario, parametrosucursal, cn.conexion);
                JasperViewer view = new JasperViewer (print,false);
                view.setVisible(true);
            } catch (ErrorTienda ex) {
                Logger.getLogger(frmReporteInventarios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JRException ex) {
                Logger.getLogger(frmReporteInventarios.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            }
       
        
        
    }//GEN-LAST:event_btnGenerarActionPerformed

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
            java.util.logging.Logger.getLogger(frmReporteInventarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmReporteInventarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmReporteInventarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmReporteInventarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new frmReporteInventarios().setVisible(true);
                } catch (ErrorTienda ex) {
                    Logger.getLogger(frmReporteInventarios.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbSucursalReporte;
    private javax.swing.JRadioButton rbtnTodasS;
    private javax.swing.JRadioButton rbtnUnaS;
    // End of variables declaration//GEN-END:variables
}
