/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import clases.Bitacora;
import clases.ControladorBitacora;
import clases.ControladorUsuario;
import clases.ControladorVenta;
import clases.ErrorTienda;
import clases.Producto;
import clases.Usuario;
import clases.Venta;
import facadeshop.Diseño;
import static formularios.frmLogin.txtUser;
import static formularios.frmVentas.lblUser;
import static formularios.frmVentas.lblUser1;
import formulariosReportes.frmComprasReportes;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Ricky
 */
public class frmVentasDetalle extends javax.swing.JFrame {

    boolean estadoMenu;
    public int seleccion;
    public int id;
    String rol, password;
    DefaultTableModel modeloDetalle,modelo;
    double subTotales;
    DateFormat df=DateFormat.getDateInstance();
    DecimalFormat formateo=new DecimalFormat("#.##");
    Date fdate=new Date();
    JTableHeader tHeadVentas,tHeadDetalles;
    Object datosFaltantes[];
    SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
    
    public frmVentasDetalle() {
        initComponents();
        this.setSize(1200, 700);
        this.setLocationRelativeTo(null);
        modeloDetalle=(DefaultTableModel) tblVentasDetalladas.getModel();
        modelo = (DefaultTableModel) tblVentas.getModel();
        jdcFecha.setDateFormatString("dd-MM-yyyy");
        jdcFecha.setDate(fdate);
                lblCo1.setVisible(false);
        lblCo2.setVisible(false);
        lblCo3.setVisible(false);
        lblCo4.setVisible(false);
        lblCo5.setVisible(false);
        lblCo6.setVisible(false);
        lblCo7.setVisible(false);
        lblCo8.setVisible(false);
        lblCo9.setVisible(false);
        lblCo10.setVisible(false);
        lblCo11.setVisible(false);
        tHeadVentas = tblVentas.getTableHeader();
        tHeadDetalles = tblVentasDetalladas.getTableHeader();
        Font fuente = new Font("Tahoma", Font.BOLD, 12);
        tHeadVentas.setBackground(jpnBarraSuperior.getBackground());
        tHeadVentas.setForeground(Color.WHITE);
        tHeadVentas.setFont(fuente);
        tHeadDetalles.setBackground(jpnBarraSuperior.getBackground());
        tHeadDetalles.setForeground(Color.WHITE);
        tHeadDetalles.setFont(fuente);
        obtenerUsuario();
        lblMensajito.setVisible(false);
        ObtenerVentas(sd.format(fdate));
        
    }
    
      //CAMBIAR CONTRASEÑA DEL USUARIO
    public void comprobarPass(){
        try {
            password = ControladorUsuario.ObtenerPass(Diseño.user);
        } catch (ErrorTienda ex) {
            Logger.getLogger(frmHome.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(password.equals(pwdAntigua.getText())){
            comprobarNuevaPass();
        }else{
            pwdAntigua.requestFocus();
            mensajeNotificacion("¡Contraseña actual errónea!", "Error");
        }
    }
    
    public void comprobarNuevaPass(){
        if(pwdNueva.getText().equals(pwdNueva2.getText())){
            cambiarPassword();
        }else{
            pwdNueva.requestFocus();
            mensajeNotificacion("¡Contraseñas no coinciden!", "Error");
        }
    }
    
    public void cambiarPassword(){
        Usuario user = new Usuario();
        user.setClave(pwdNueva.getText());
        user.setUsuario(Diseño.user);
        try {

            ControladorUsuario.ModificarPass(user);
            mensajeNotificacion("¡Contraseña cambiada correctamente!", "Ok");
            pwdAntigua.setText("");
            pwdNueva.setText("");
            pwdNueva2.setText("");
            Animacion.Animacion.subir(55, -195, 1, 2, jpnPass);
        } catch (ErrorTienda ex) {
            Logger.getLogger(frmHome.class.getName()).log(Level.SEVERE, null, ex);
        }

    }  
   public void estableciendoDatos(int id){
        Object[] fila=new Object[5];
        
//        modeloDetalle=new DefaultTableModel();
//        String[] campos = {"CodBara","Producto", "Cantidad", "Precio Unitario $", "Sub total $"};
        
        System.out.println(id);
        
        try {
            ArrayList<Venta> misventas=ControladorVenta.ObtenerVenta(id);
//            modeloDetalle.setColumnIdentifiers(campos);
            Iterator iterador=misventas.iterator();
            
            while (iterador.hasNext()) {
                fila[0]=iterador.next();
                fila[1]=iterador.next();
                fila[2]=iterador.next();
                fila[3]=iterador.next();
                 if ((tblVentas.getValueAt(seleccion, 3).toString()).equals("Factura")) {
                     fila[4]=formateo.format((Integer.parseInt(fila[2].toString())*Double.parseDouble(fila[3].toString())));
                 }else{
                     fila[4]=formateo.format(Integer.parseInt(fila[2].toString())*Double.parseDouble(fila[3].toString()));
                 }
                
                
                modeloDetalle.addRow(fila);
                tblVentasDetalladas.setModel(modeloDetalle);
            }
        } catch (ErrorTienda ex) {
            Logger.getLogger(frmVentasDetalle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
   //CALCULAR SUMA DE SUB TOTALES
    public void SumarSubTotales(){
        int filas = modeloDetalle.getRowCount();
        subTotales=0;
        for(int i=0;i<filas;i++){
            subTotales+=Double.parseDouble(String.valueOf(modeloDetalle.getValueAt(i, 4)));
        }
        
    }
    
    //METODO GENERAL PARA ENVIAR MENSAJES POR NOTIFICAICON DE FRMNOTIFICACION
    public void mensajeNotificacion(String mensaje, String tipo){
        if(tipo.equals("Error")){
        frmNotificacion not = new frmNotificacion();
        not.Mensaje(mensaje);
        not.setVisible(true);
        not.lblIcono.setIcon(new ImageIcon(getClass().getResource("/iconos/Error.png")));
        //not.setIcon(new ImageIcon(getClass().getResource("/iconos/botones/eliminar.png")));
        }else if(tipo == "Ok"){
        frmNotificacion not = new frmNotificacion();
        not.Mensaje(mensaje);
        not.setVisible(true);
        not.lblIcono.setIcon(new ImageIcon(getClass().getResource("/iconos/Ok.png")));
        }else if(tipo == "Adv"){
        frmNotificacion not = new frmNotificacion();
        not.Mensaje(mensaje);
        not.setVisible(true);
        not.lblIcono.setIcon(new ImageIcon(getClass().getResource("/iconos/Adv.png")));
        }       
    }
    //Seteando datos
    public void cambio(boolean cambio){
        txtSumas.setVisible(cambio);
        txtIVA.setVisible(cambio);
        lblSumas.setVisible(cambio);
        lblIVA.setVisible(cambio);
        
    }
    
    public void seteando(){
        txtCliente.setText("");
        txtIVA.setText("");
        txtIdVenta.setText("");
        txtSucursal.setText("");
        txtTotalventa.setText("");
        txtSumas.setText("");
    }
    
    public void obtenerUsuario(){
        lblUser.setText(Diseño.user);
        lblUser1.setText(Diseño.user);
        jpnUser.setVisible(false);
        jpnWhite.setVisible(false);
        obtenerRol();
    }
    public void obtenerRol(){
        try {
            rol = ControladorUsuario.obtenerRol(txtUser.getText());
            if(rol.equals("A")){
                lblRolUsuario.setText("ADMINISTRADOR");
                lblAgregarUsuario.setVisible(true);
            }
            else if(rol.equals("V")){
                lblRolUsuario.setText("VENDEDOR");
                            lblAgregarUsuario.setVisible(false);}
            else if(rol.equals("C")){
                lblRolUsuario.setText("COMPRADOR");

            }
            
            } catch (ErrorTienda ex) {
                Logger.getLogger(frmLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    public void ObtenerVentas(String fecha){
        ArrayList<Venta> ventas = new ArrayList();
        Object[] fila = new Object[5];
        datosFaltantes=new Object[2];
        
        
        if (fecha.equals("")) {
            JOptionPane.showMessageDialog(null, "No ha seleccionado una fecha");
        }else{ 
                       
            String[] campos = {"IdVenta", "Sucursal", "Cliente", "Tipo de Venta","Fecha"};
            modelo.setColumnIdentifiers(campos);
            try {
                
                
                ventas=ControladorVenta.obteniendoVentas(fecha);
                
                Object x;
                Iterator iterador=ventas.iterator();
                while (iterador.hasNext()) {
                    
                    
                    fila[0]=iterador.next();
                    fila[1]=iterador.next();
                    fila[2]=iterador.next();
                    x=iterador.next();
                    if (x.equals("F")) {
                        fila[3]="Factura";
                    }else if(x.equals("C")){
                        fila[3]="Credito Fiscal";
                    }
                    
                    
                    fila[4]=iterador.next();
                    datosFaltantes[0]=iterador.next();
                    datosFaltantes[1]=iterador.next();
                    
                    modelo.addRow(fila);
                    tblVentas.setModel(modelo);
                }
                
            } catch (ErrorTienda ex) {
                Logger.getLogger(frmVentasDetalle.class.getName()).log(Level.SEVERE, null, ex);
            } 
        
        
        
        }
        if(modelo.getRowCount()==0){
            lblMensajito.setVisible(true);
        }else{
            lblMensajito.setVisible(false);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        frmVentasDetalladas2 = new javax.swing.JFrame();
        jLabel11 = new javax.swing.JLabel();
        txtIdVenta = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTipoVenta = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtSucursal = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVentasDetalladas = new javax.swing.JTable();
        lblSumas = new javax.swing.JLabel();
        txtSumas = new javax.swing.JTextField();
        lblIVA = new javax.swing.JLabel();
        txtIVA = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        txtTotalventa = new javax.swing.JTextField();
        lblDetallesVentas1 = new javax.swing.JLabel();
        lblVentasBorrador1 = new javax.swing.JLabel();
        lblVender1 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        jpnBarraSuperior2 = new javax.swing.JPanel();
        lblLogo2 = new javax.swing.JLabel();
        jpnBarraMenu1 = new javax.swing.JPanel();
        lblMenu1 = new javax.swing.JLabel();
        btnHome1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtPac = new javax.swing.JTextField();
        txtFecha2 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtUtilidad = new javax.swing.JTextField();
        jpnPass = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        pwdAntigua = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        pwdNueva = new javax.swing.JPasswordField();
        jLabel15 = new javax.swing.JLabel();
        pwdNueva2 = new javax.swing.JPasswordField();
        btnAtrasPwd = new javax.swing.JLabel();
        btnCambiarPwd = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jpnUser = new javax.swing.JPanel();
        lblRolUsuario = new javax.swing.JLabel();
        lblCambiarPwd = new javax.swing.JLabel();
        lblCerrarSesion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVentas = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jdcFecha = new com.toedter.calendar.JDateChooser();
        btnBuscar = new javax.swing.JButton();
        btnDetalle1 = new javax.swing.JButton();
        jpnBarraSuperior = new javax.swing.JPanel();
        jpnWhite = new javax.swing.JPanel();
        lblUser1 = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        lblAgregarUsuario = new javax.swing.JLabel();
        jpnBarraMenu = new javax.swing.JPanel();
        btnHome = new javax.swing.JLabel();
        lblMenu = new javax.swing.JLabel();
        jpnSubMenu = new javax.swing.JPanel();
        lblCo11 = new javax.swing.JLabel();
        lblCo1 = new javax.swing.JLabel();
        lblCo2 = new javax.swing.JLabel();
        lblCo3 = new javax.swing.JLabel();
        lblCo4 = new javax.swing.JLabel();
        lblCo5 = new javax.swing.JLabel();
        lblCo6 = new javax.swing.JLabel();
        lblCo7 = new javax.swing.JLabel();
        lblCo8 = new javax.swing.JLabel();
        lblCo9 = new javax.swing.JLabel();
        lblCo10 = new javax.swing.JLabel();
        btnCompras = new javax.swing.JButton();
        btnVentas = new javax.swing.JButton();
        btnProductos = new javax.swing.JButton();
        btnTipoPrecio = new javax.swing.JButton();
        btnParametro = new javax.swing.JButton();
        btnProveedores = new javax.swing.JButton();
        btnSucursales = new javax.swing.JButton();
        btnDetalleCompras = new javax.swing.JButton();
        btnDetalleVentas = new javax.swing.JButton();
        btnReportes = new javax.swing.JButton();
        btnBitacoras = new javax.swing.JButton();
        lblVender = new javax.swing.JLabel();
        lblVentasBorrador = new javax.swing.JLabel();
        lblDetallesVentas = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        lblMensajito = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cmbBuscarPor = new javax.swing.JComboBox<>();

        frmVentasDetalladas2.setMinimumSize(new java.awt.Dimension(1200, 700));
        frmVentasDetalladas2.setUndecorated(true);
        frmVentasDetalladas2.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Id de la venta:");
        frmVentasDetalladas2.getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 110, 30));

        txtIdVenta.setEditable(false);
        txtIdVenta.setText(" ");
        txtIdVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdVentaActionPerformed(evt);
            }
        });
        frmVentasDetalladas2.getContentPane().add(txtIdVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 60, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Tipo Venta");
        frmVentasDetalladas2.getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 140, 30));

        txtTipoVenta.setEditable(false);
        txtTipoVenta.setText(" ");
        txtTipoVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoVentaActionPerformed(evt);
            }
        });
        frmVentasDetalladas2.getContentPane().add(txtTipoVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 170, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Sucursal");
        frmVentasDetalladas2.getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, 70, 30));

        txtSucursal.setEditable(false);
        txtSucursal.setText(" ");
        txtSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSucursalActionPerformed(evt);
            }
        });
        frmVentasDetalladas2.getContentPane().add(txtSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 360, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Pago a cuenta");
        frmVentasDetalladas2.getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 240, 120, 30));

        txtCliente.setEditable(false);
        txtCliente.setText(" ");
        txtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClienteActionPerformed(evt);
            }
        });
        frmVentasDetalladas2.getContentPane().add(txtCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, 250, 30));

        tblVentasDetalladas =new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblVentasDetalladas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CodBarra", "Producto", "Cantidad", "Precio Unitario $", "Sub total $"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblVentasDetalladas.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblVentasDetalladas);
        if (tblVentasDetalladas.getColumnModel().getColumnCount() > 0) {
            tblVentasDetalladas.getColumnModel().getColumn(0).setResizable(false);
            tblVentasDetalladas.getColumnModel().getColumn(1).setResizable(false);
            tblVentasDetalladas.getColumnModel().getColumn(1).setPreferredWidth(350);
            tblVentasDetalladas.getColumnModel().getColumn(2).setResizable(false);
            tblVentasDetalladas.getColumnModel().getColumn(3).setResizable(false);
            tblVentasDetalladas.getColumnModel().getColumn(4).setResizable(false);
        }

        frmVentasDetalladas2.getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, 960, 220));

        lblSumas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSumas.setText("Sumas $");
        frmVentasDetalladas2.getContentPane().add(lblSumas, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 570, -1, 30));

        txtSumas.setEditable(false);
        txtSumas.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtSumas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        frmVentasDetalladas2.getContentPane().add(txtSumas, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 570, 120, 30));

        lblIVA.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblIVA.setText("13% IVA $");
        frmVentasDetalladas2.getContentPane().add(lblIVA, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 570, -1, 30));

        txtIVA.setEditable(false);
        txtIVA.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtIVA.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        frmVentasDetalladas2.getContentPane().add(txtIVA, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 570, 120, 30));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 3, 0));
        jLabel38.setText("Total $");
        frmVentasDetalladas2.getContentPane().add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 570, -1, 30));

        txtTotalventa.setEditable(false);
        txtTotalventa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtTotalventa.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        frmVentasDetalladas2.getContentPane().add(txtTotalventa, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 570, 120, 30));

        lblDetallesVentas1.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lblDetallesVentas1.setForeground(new java.awt.Color(153, 153, 153));
        lblDetallesVentas1.setText("Detalles de Ventas");
        lblDetallesVentas1.setToolTipText("Ver los detalles de ventas realizadas.");
        lblDetallesVentas1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblDetallesVentas1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDetallesVentas1MouseClicked(evt);
            }
        });
        frmVentasDetalladas2.getContentPane().add(lblDetallesVentas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 60, -1, 50));

        lblVentasBorrador1.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lblVentasBorrador1.setForeground(new java.awt.Color(153, 153, 153));
        lblVentasBorrador1.setText("Ventas Borrador");
        lblVentasBorrador1.setToolTipText("Ver las ventas en borrador disponibles.");
        lblVentasBorrador1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblVentasBorrador1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVentasBorrador1MouseClicked(evt);
            }
        });
        frmVentasDetalladas2.getContentPane().add(lblVentasBorrador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 60, -1, 50));

        lblVender1.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lblVender1.setForeground(new java.awt.Color(153, 153, 153));
        lblVender1.setText("Vender");
        lblVender1.setToolTipText("Realizar una venta.");
        lblVender1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblVender1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVender1MouseClicked(evt);
            }
        });
        frmVentasDetalladas2.getContentPane().add(lblVender1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, -1, 50));

        jSeparator10.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator10.setForeground(new java.awt.Color(102, 0, 0));
        frmVentasDetalladas2.getContentPane().add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 117, 1020, 10));

        jpnBarraSuperior2.setBackground(new java.awt.Color(0, 0, 0));
        jpnBarraSuperior2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jpnBarraSuperior2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jpnBarraSuperior2MouseDragged(evt);
            }
        });
        jpnBarraSuperior2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jpnBarraSuperior2MousePressed(evt);
            }
        });
        jpnBarraSuperior2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogo2.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        lblLogo2.setForeground(new java.awt.Color(255, 255, 255));
        lblLogo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/home/lanzador.png"))); // NOI18N
        lblLogo2.setText("iShop 3.0");
        lblLogo2.setToolTipText("");
        jpnBarraSuperior2.add(lblLogo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 150, 50));

        frmVentasDetalladas2.getContentPane().add(jpnBarraSuperior2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 55));

        jpnBarraMenu1.setBackground(new java.awt.Color(102, 0, 0));
        jpnBarraMenu1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jpnBarraMenu1PropertyChange(evt);
            }
        });
        jpnBarraMenu1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMenu1.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        lblMenu1.setForeground(new java.awt.Color(255, 255, 255));
        lblMenu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Menu.png"))); // NOI18N
        lblMenu1.setText("Menu");
        jpnBarraMenu1.add(lblMenu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 15, 170, 50));

        btnHome1.setToolTipText("Inicio");
        btnHome1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpnBarraMenu1.add(btnHome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 540, -1, -1));

        frmVentasDetalladas2.getContentPane().add(jpnBarraMenu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 190, 650));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Cliente:");
        frmVentasDetalladas2.getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 70, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Fecha");
        frmVentasDetalladas2.getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 240, 50, 30));

        txtPac.setEditable(false);
        txtPac.setText(" ");
        txtPac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPacActionPerformed(evt);
            }
        });
        frmVentasDetalladas2.getContentPane().add(txtPac, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 270, 110, 30));

        txtFecha2.setEditable(false);
        txtFecha2.setText(" ");
        txtFecha2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFecha2ActionPerformed(evt);
            }
        });
        frmVentasDetalladas2.getContentPane().add(txtFecha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 270, 150, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Utilidad");
        frmVentasDetalladas2.getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 240, 90, 30));

        txtUtilidad.setEditable(false);
        txtUtilidad.setText(" ");
        txtUtilidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUtilidadActionPerformed(evt);
            }
        });
        frmVentasDetalladas2.getContentPane().add(txtUtilidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 270, 90, 30));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Detalles Ventas");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/iconos/home/lanzador.png")).getImage());
        setMinimumSize(new java.awt.Dimension(1200, 700));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpnPass.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), null));
        jpnPass.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 0));
        jLabel3.setText("Repita nueva contraseña:");
        jpnPass.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 115, -1, -1));

        pwdAntigua.setBackground(new java.awt.Color(240, 240, 240));
        pwdAntigua.setBorder(null);
        pwdAntigua.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pwdAntiguaFocusGained(evt);
            }
        });
        pwdAntigua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwdAntiguaActionPerformed(evt);
            }
        });
        jpnPass.add(pwdAntigua, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 35, 190, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel4.setText("Contraseña antigua:");
        jpnPass.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, -1, -1));

        pwdNueva.setBackground(new java.awt.Color(240, 240, 240));
        pwdNueva.setBorder(null);
        pwdNueva.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pwdNuevaFocusGained(evt);
            }
        });
        pwdNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwdNuevaActionPerformed(evt);
            }
        });
        jpnPass.add(pwdNueva, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 85, 190, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 0, 0));
        jLabel15.setText("Nueva contraseña:");
        jpnPass.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 65, -1, -1));

        pwdNueva2.setBackground(new java.awt.Color(240, 240, 240));
        pwdNueva2.setBorder(null);
        pwdNueva2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pwdNueva2FocusGained(evt);
            }
        });
        jpnPass.add(pwdNueva2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 135, 190, -1));

        btnAtrasPwd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Atras2.png"))); // NOI18N
        btnAtrasPwd.setToolTipText("Volver atrás.");
        btnAtrasPwd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtrasPwd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAtrasPwdMouseClicked(evt);
            }
        });
        jpnPass.add(btnAtrasPwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 155, 30, 30));

        btnCambiarPwd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Aceptar.png"))); // NOI18N
        btnCambiarPwd.setToolTipText("Cambiar Contraseña.");
        btnCambiarPwd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCambiarPwd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCambiarPwdMouseClicked(evt);
            }
        });
        jpnPass.add(btnCambiarPwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 155, 30, 30));

        jSeparator1.setBackground(new java.awt.Color(102, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(102, 0, 0));
        jpnPass.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 190, 10));

        jSeparator2.setBackground(new java.awt.Color(102, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(102, 0, 0));
        jpnPass.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 190, 10));

        jSeparator4.setBackground(new java.awt.Color(102, 0, 0));
        jSeparator4.setForeground(new java.awt.Color(102, 0, 0));
        jpnPass.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 190, 10));

        getContentPane().add(jpnPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, -195, 230, 190));

        jpnUser.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), null));
        jpnUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpnUserMouseExited(evt);
            }
        });
        jpnUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblRolUsuario.setFont(new java.awt.Font("Segoe UI Light", 0, 11)); // NOI18N
        lblRolUsuario.setForeground(new java.awt.Color(102, 0, 0));
        lblRolUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRolUsuario.setText("Nombres + Apellidos");
        jpnUser.add(lblRolUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, 230, 30));

        lblCambiarPwd.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        lblCambiarPwd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/login/pin.png"))); // NOI18N
        lblCambiarPwd.setText("Cambiar contraseña");
        lblCambiarPwd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCambiarPwd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCambiarPwdMouseClicked(evt);
            }
        });
        jpnUser.add(lblCambiarPwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 75, 180, 20));

        lblCerrarSesion.setBackground(new java.awt.Color(0, 0, 0));
        lblCerrarSesion.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        lblCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/login/usuario.png"))); // NOI18N
        lblCerrarSesion.setText("Cerrar sesión");
        lblCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrarSesionMouseClicked(evt);
            }
        });
        jpnUser.add(lblCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 45, 110, 20));

        getContentPane().add(jpnUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 55, 230, 110));

        tblVentas =new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idVenta", "Sucursal", "Cliente", "Tipo de venta", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblVentas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblVentas);
        if (tblVentas.getColumnModel().getColumnCount() > 0) {
            tblVentas.getColumnModel().getColumn(0).setResizable(false);
            tblVentas.getColumnModel().getColumn(1).setResizable(false);
            tblVentas.getColumnModel().getColumn(2).setResizable(false);
            tblVentas.getColumnModel().getColumn(3).setResizable(false);
            tblVentas.getColumnModel().getColumn(4).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 920, 320));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Lista de las Ventas:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Fecha:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, -1, 30));

        jdcFecha.setDateFormatString("yyyy-dd-MM");
        getContentPane().add(jdcFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 200, 30));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/botones/buscar.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 180, 110, 30));

        btnDetalle1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/botones/detalles2.png"))); // NOI18N
        btnDetalle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalle1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnDetalle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 640, 110, 30));

        jpnBarraSuperior.setBackground(new java.awt.Color(0, 0, 0));
        jpnBarraSuperior.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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

        jpnWhite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpnWhiteMouseClicked(evt);
            }
        });
        jpnWhite.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUser1.setBackground(new java.awt.Color(0, 0, 0));
        lblUser1.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lblUser1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUser1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/home/configb.png"))); // NOI18N
        lblUser1.setText("USER");
        lblUser1.setToolTipText("Configuración");
        lblUser1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblUser1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUser1MouseClicked(evt);
            }
        });
        jpnWhite.add(lblUser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 50));

        jpnBarraSuperior.add(jpnWhite, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 0, 130, 60));

        lblUser.setBackground(new java.awt.Color(222, 222, 222));
        lblUser.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lblUser.setForeground(new java.awt.Color(204, 204, 204));
        lblUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/home/config.png"))); // NOI18N
        lblUser.setText("USER");
        lblUser.setToolTipText("Configuración");
        lblUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUserMouseClicked(evt);
            }
        });
        jpnBarraSuperior.add(lblUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 0, 130, 50));

        lblLogo.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        lblLogo.setForeground(new java.awt.Color(255, 255, 255));
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/home/lanzador.png"))); // NOI18N
        lblLogo.setText("iShop 3.0");
        lblLogo.setToolTipText("");
        jpnBarraSuperior.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 150, 50));

        lblAgregarUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAgregarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/home/agus.png"))); // NOI18N
        lblAgregarUsuario.setToolTipText("Agregar Usuario");
        lblAgregarUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAgregarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAgregarUsuarioMouseClicked(evt);
            }
        });
        jpnBarraSuperior.add(lblAgregarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 0, 60, 50));

        getContentPane().add(jpnBarraSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 55));

        jpnBarraMenu.setBackground(new java.awt.Color(102, 0, 0));
        jpnBarraMenu.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jpnBarraMenuPropertyChange(evt);
            }
        });
        jpnBarraMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnHome.setToolTipText("Inicio");
        btnHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpnBarraMenu.add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 540, -1, -1));

        lblMenu.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lblMenu.setForeground(new java.awt.Color(255, 255, 255));
        lblMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Atras.png"))); // NOI18N
        lblMenu.setText("Volver a Home");
        lblMenu.setToolTipText("");
        lblMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMenu.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMenuMouseClicked(evt);
            }
        });
        jpnBarraMenu.add(lblMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 15, 180, 50));

        jpnSubMenu.setBackground(new java.awt.Color(102, 0, 0));
        jpnSubMenu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jpnSubMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCo11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCo11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Entypo_25b8(0)_32.png"))); // NOI18N
        jpnSubMenu.add(lblCo11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 30, 40));

        lblCo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Entypo_25b8(0)_32.png"))); // NOI18N
        jpnSubMenu.add(lblCo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 30, 40));

        lblCo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Entypo_25b8(0)_32.png"))); // NOI18N
        jpnSubMenu.add(lblCo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 30, 40));

        lblCo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Entypo_25b8(0)_32.png"))); // NOI18N
        jpnSubMenu.add(lblCo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 30, 40));

        lblCo4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Entypo_25b8(0)_32.png"))); // NOI18N
        jpnSubMenu.add(lblCo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 30, 40));

        lblCo5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCo5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Entypo_25b8(0)_32.png"))); // NOI18N
        jpnSubMenu.add(lblCo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 30, 40));

        lblCo6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCo6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Entypo_25b8(0)_32.png"))); // NOI18N
        jpnSubMenu.add(lblCo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 30, 40));

        lblCo7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCo7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Entypo_25b8(0)_32.png"))); // NOI18N
        jpnSubMenu.add(lblCo7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 30, 40));

        lblCo8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCo8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Entypo_25b8(0)_32.png"))); // NOI18N
        jpnSubMenu.add(lblCo8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 30, 40));

        lblCo9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCo9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Entypo_25b8(0)_32.png"))); // NOI18N
        jpnSubMenu.add(lblCo9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 30, 40));

        lblCo10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCo10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Entypo_25b8(0)_32.png"))); // NOI18N
        jpnSubMenu.add(lblCo10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 30, 40));

        btnCompras.setBackground(new java.awt.Color(102, 0, 0));
        btnCompras.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnCompras.setForeground(new java.awt.Color(255, 255, 255));
        btnCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Compras.png"))); // NOI18N
        btnCompras.setText("Compras");
        btnCompras.setBorderPainted(false);
        btnCompras.setContentAreaFilled(false);
        btnCompras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCompras.setFocusPainted(false);
        btnCompras.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnCompras.setIconTextGap(35);
        btnCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnComprasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnComprasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnComprasMouseExited(evt);
            }
        });
        btnCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprasActionPerformed(evt);
            }
        });
        jpnSubMenu.add(btnCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 10, 190, 40));

        btnVentas.setBackground(new java.awt.Color(102, 0, 0));
        btnVentas.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnVentas.setForeground(new java.awt.Color(255, 255, 255));
        btnVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Ventas.png"))); // NOI18N
        btnVentas.setText("Ventas");
        btnVentas.setBorderPainted(false);
        btnVentas.setContentAreaFilled(false);
        btnVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVentas.setFocusPainted(false);
        btnVentas.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnVentas.setIconTextGap(50);
        btnVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVentasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnVentasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVentasMouseExited(evt);
            }
        });
        btnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasActionPerformed(evt);
            }
        });
        jpnSubMenu.add(btnVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 110, 190, 40));

        btnProductos.setBackground(new java.awt.Color(102, 0, 0));
        btnProductos.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnProductos.setForeground(new java.awt.Color(255, 255, 255));
        btnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Productos.png"))); // NOI18N
        btnProductos.setText("Productos");
        btnProductos.setBorderPainted(false);
        btnProductos.setContentAreaFilled(false);
        btnProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProductos.setFocusPainted(false);
        btnProductos.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnProductos.setIconTextGap(25);
        btnProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProductosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnProductosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnProductosMouseExited(evt);
            }
        });
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });
        jpnSubMenu.add(btnProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 210, 190, 40));

        btnTipoPrecio.setBackground(new java.awt.Color(102, 0, 0));
        btnTipoPrecio.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnTipoPrecio.setForeground(new java.awt.Color(255, 255, 255));
        btnTipoPrecio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/tipoPrecio.png"))); // NOI18N
        btnTipoPrecio.setText("Tipo Precio");
        btnTipoPrecio.setBorderPainted(false);
        btnTipoPrecio.setContentAreaFilled(false);
        btnTipoPrecio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTipoPrecio.setFocusPainted(false);
        btnTipoPrecio.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnTipoPrecio.setIconTextGap(15);
        btnTipoPrecio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTipoPrecioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTipoPrecioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTipoPrecioMouseExited(evt);
            }
        });
        btnTipoPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTipoPrecioActionPerformed(evt);
            }
        });
        jpnSubMenu.add(btnTipoPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 410, 190, 40));

        btnParametro.setBackground(new java.awt.Color(102, 0, 0));
        btnParametro.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnParametro.setForeground(new java.awt.Color(255, 255, 255));
        btnParametro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Parametro.png"))); // NOI18N
        btnParametro.setText("Parámetro");
        btnParametro.setBorderPainted(false);
        btnParametro.setContentAreaFilled(false);
        btnParametro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnParametro.setFocusPainted(false);
        btnParametro.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnParametro.setIconTextGap(20);
        btnParametro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnParametroMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnParametroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnParametroMouseExited(evt);
            }
        });
        btnParametro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParametroActionPerformed(evt);
            }
        });
        jpnSubMenu.add(btnParametro, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 360, 190, 40));

        btnProveedores.setBackground(new java.awt.Color(102, 0, 0));
        btnProveedores.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnProveedores.setForeground(new java.awt.Color(255, 255, 255));
        btnProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Proveedores.png"))); // NOI18N
        btnProveedores.setText("Proveedores");
        btnProveedores.setBorderPainted(false);
        btnProveedores.setContentAreaFilled(false);
        btnProveedores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProveedores.setFocusPainted(false);
        btnProveedores.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnProveedores.setIconTextGap(5);
        btnProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProveedoresMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnProveedoresMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnProveedoresMouseExited(evt);
            }
        });
        jpnSubMenu.add(btnProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 260, 190, 40));

        btnSucursales.setBackground(new java.awt.Color(102, 0, 0));
        btnSucursales.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnSucursales.setForeground(new java.awt.Color(255, 255, 255));
        btnSucursales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Sucursales.png"))); // NOI18N
        btnSucursales.setText("Sucursales");
        btnSucursales.setBorderPainted(false);
        btnSucursales.setContentAreaFilled(false);
        btnSucursales.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSucursales.setFocusPainted(false);
        btnSucursales.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnSucursales.setIconTextGap(20);
        btnSucursales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSucursalesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSucursalesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSucursalesMouseExited(evt);
            }
        });
        jpnSubMenu.add(btnSucursales, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 310, 190, 40));

        btnDetalleCompras.setBackground(new java.awt.Color(102, 0, 0));
        btnDetalleCompras.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnDetalleCompras.setForeground(new java.awt.Color(255, 255, 255));
        btnDetalleCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Entypo_e731(0)_32.png"))); // NOI18N
        btnDetalleCompras.setText("Det.Compra");
        btnDetalleCompras.setBorderPainted(false);
        btnDetalleCompras.setContentAreaFilled(false);
        btnDetalleCompras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDetalleCompras.setFocusPainted(false);
        btnDetalleCompras.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnDetalleCompras.setIconTextGap(10);
        btnDetalleCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDetalleComprasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDetalleComprasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDetalleComprasMouseExited(evt);
            }
        });
        btnDetalleCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalleComprasActionPerformed(evt);
            }
        });
        jpnSubMenu.add(btnDetalleCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 60, 190, 40));

        btnDetalleVentas.setBackground(new java.awt.Color(102, 0, 0));
        btnDetalleVentas.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnDetalleVentas.setForeground(new java.awt.Color(255, 255, 255));
        btnDetalleVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Entypo_e731(0)_32.png"))); // NOI18N
        btnDetalleVentas.setText("Det.Venta");
        btnDetalleVentas.setBorderPainted(false);
        btnDetalleVentas.setContentAreaFilled(false);
        btnDetalleVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDetalleVentas.setFocusPainted(false);
        btnDetalleVentas.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnDetalleVentas.setIconTextGap(25);
        btnDetalleVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDetalleVentasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDetalleVentasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDetalleVentasMouseExited(evt);
            }
        });
        btnDetalleVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalleVentasActionPerformed(evt);
            }
        });
        jpnSubMenu.add(btnDetalleVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 190, 40));

        btnReportes.setBackground(new java.awt.Color(102, 0, 0));
        btnReportes.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnReportes.setForeground(new java.awt.Color(255, 255, 255));
        btnReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Entypo_d83d(1)_32.png"))); // NOI18N
        btnReportes.setText("Reportes");
        btnReportes.setBorderPainted(false);
        btnReportes.setContentAreaFilled(false);
        btnReportes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReportes.setFocusPainted(false);
        btnReportes.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnReportes.setIconTextGap(32);
        btnReportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReportesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReportesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReportesMouseExited(evt);
            }
        });
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });
        jpnSubMenu.add(btnReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 460, 190, 40));

        btnBitacoras.setBackground(new java.awt.Color(102, 0, 0));
        btnBitacoras.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnBitacoras.setForeground(new java.awt.Color(255, 255, 255));
        btnBitacoras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Entypo_e727(0)_32.png"))); // NOI18N
        btnBitacoras.setText("Bitácoras");
        btnBitacoras.setBorderPainted(false);
        btnBitacoras.setContentAreaFilled(false);
        btnBitacoras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBitacoras.setFocusPainted(false);
        btnBitacoras.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnBitacoras.setIconTextGap(30);
        btnBitacoras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBitacorasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBitacorasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBitacorasMouseExited(evt);
            }
        });
        btnBitacoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBitacorasActionPerformed(evt);
            }
        });
        jpnSubMenu.add(btnBitacoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 510, 190, 40));

        jpnBarraMenu.add(jpnSubMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 77, 190, 560));

        getContentPane().add(jpnBarraMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 190, 650));

        lblVender.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lblVender.setForeground(new java.awt.Color(153, 153, 153));
        lblVender.setText("Vender");
        lblVender.setToolTipText("Realizar una venta.");
        lblVender.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblVender.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVenderMouseClicked(evt);
            }
        });
        getContentPane().add(lblVender, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, -1, 50));

        lblVentasBorrador.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lblVentasBorrador.setForeground(new java.awt.Color(153, 153, 153));
        lblVentasBorrador.setText("Ventas Borrador");
        lblVentasBorrador.setToolTipText("Ver las ventas en borrador disponibles.");
        lblVentasBorrador.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblVentasBorrador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVentasBorradorMouseClicked(evt);
            }
        });
        getContentPane().add(lblVentasBorrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 60, -1, 50));

        lblDetallesVentas.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lblDetallesVentas.setText("Detalles de Ventas");
        lblDetallesVentas.setToolTipText("");
        lblDetallesVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblDetallesVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDetallesVentasMouseClicked(evt);
            }
        });
        getContentPane().add(lblDetallesVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 60, -1, 50));

        jSeparator9.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator9.setForeground(new java.awt.Color(102, 0, 0));
        getContentPane().add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 117, 1020, 10));

        lblMensajito.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblMensajito.setForeground(new java.awt.Color(255, 51, 0));
        lblMensajito.setText("No se encontraron resultados");
        getContentPane().add(lblMensajito, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 260, 250, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Mostrar por:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 190, -1, -1));

        cmbBuscarPor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmbBuscarPor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dia", "Mes", "Año" }));
        cmbBuscarPor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbBuscarPorItemStateChanged(evt);
            }
        });
        cmbBuscarPor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBuscarPorActionPerformed(evt);
            }
        });
        getContentPane().add(cmbBuscarPor, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 180, 110, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        
        
        
        modelo.setRowCount(0);
        String fecha=sd.format(jdcFecha.getDate());
        
        ObtenerVentas(fecha);
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnDetalle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalle1ActionPerformed
        if(tblVentas.getSelectedRow()!=-1){
            
            this.hide();
            frmVentasDetalladas2.show();
            frmVentasDetalladas2.setLocation(this.getLocation());
            
            tblVentasDetalladas.removeAll();
            modeloDetalle.setRowCount(0);
            seteando();
            
            seleccion=tblVentas.getSelectedRow();
            ArrayList<Venta> ventas = new ArrayList();
            Object [] fila=new Object[7];
            
            if ((tblVentas.getValueAt(seleccion, 3).toString()).equals("Factura")) {
                    
                    try{
                    ventas=ControladorVenta.obteniendoVentas(tblVentas.getValueAt(seleccion, 4).toString());
                    Iterator ite=ventas.iterator();
                    
                    while (ite.hasNext()) {
                        fila[0]=ite.next();
                        fila[1]=ite.next();
                        fila[2]=ite.next();
                        fila[3]=ite.next();
                        fila[4]=ite.next();
                        fila[5]=ite.next();
                        fila[6]=ite.next();
                        
                        if (tblVentas.getValueAt(seleccion, 0).equals(fila[0])) {
                           System.out.println(Integer.parseInt(tblVentas.getValueAt(seleccion, 0).toString()));
                           
                           
                           txtIdVenta.setText(tblVentas.getValueAt(seleccion, 0).toString());
                           txtCliente.setText(tblVentas.getValueAt(seleccion, 2).toString());
                           txtFecha2.setText((tblVentas.getValueAt(seleccion, 4).toString()));
                           txtSucursal.setText((tblVentas.getValueAt(seleccion, 1).toString()));
                           txtTipoVenta.setText("Factura");
                           txtPac.setText(fila[5].toString());
                           txtUtilidad.setText(fila[6].toString());

                           estableciendoDatos(Integer.parseInt(tblVentas.getValueAt(seleccion, 0).toString()));
                           SumarSubTotales();
                           cambio(false);

                           txtTotalventa.setText(""+formateo.format(subTotales));
                        }
                        
                    }
                    
                }catch(ErrorTienda e){
                    
                }
                  
                
            }else{
                try{
                    ventas=ControladorVenta.obteniendoVentas(tblVentas.getValueAt(seleccion, 4).toString());
                    Iterator ite=ventas.iterator();
                    
                    while (ite.hasNext()) {
                        fila[0]=ite.next();
                        fila[1]=ite.next();
                        fila[2]=ite.next();
                        fila[3]=ite.next();
                        fila[4]=ite.next();
                        fila[5]=ite.next();
                        fila[6]=ite.next();
                        
                        if (tblVentas.getValueAt(seleccion, 0).equals(fila[0])) {
                            txtIdVenta.setText(tblVentas.getValueAt(seleccion, 0).toString());
                            txtFecha2.setText((tblVentas.getValueAt(seleccion, 4).toString()));
                            txtCliente.setText(tblVentas.getValueAt(seleccion, 2).toString());
                            txtSucursal.setText((tblVentas.getValueAt(seleccion, 1).toString()));
                            txtTipoVenta.setText("Crédito Fiscal");
                            txtPac.setText(fila[5].toString());
                            txtUtilidad.setText(fila[6].toString());

                            cambio(true);
                            estableciendoDatos(Integer.parseInt(tblVentas.getValueAt(seleccion, 0).toString()));
                            SumarSubTotales();

                            txtSumas.setText(""+formateo.format(subTotales/1.13));

                            double total=subTotales;
                            txtTotalventa.setText(""+formateo.format(total));
                            double iva=total-(subTotales/1.13);
                            txtIVA.setText(""+formateo.format(iva));
                        }
                      }
                    }catch(ErrorTienda e){
                                
                   }
            }
            
            
            
            
            
        }else{
            mensajeNotificacion("Debe seleccionar una venta de la tabla", "Adv");
        }
    }//GEN-LAST:event_btnDetalle1ActionPerformed

    private void txtIdVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdVentaActionPerformed

    private void txtTipoVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoVentaActionPerformed

    private void txtSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSucursalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSucursalActionPerformed

    private void txtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClienteActionPerformed

    private void lblUser1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUser1MouseClicked
        jpnWhite.setVisible(false);
        jpnUser.setVisible(false);
    }//GEN-LAST:event_lblUser1MouseClicked

    private void jpnWhiteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnWhiteMouseClicked
        jpnWhite.setVisible(false);
        jpnUser.setVisible(false);
    }//GEN-LAST:event_jpnWhiteMouseClicked

    private void lblUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUserMouseClicked
        obtenerRol();
        if(jpnUser.isVisible()){
            jpnUser.setVisible(false);
            jpnWhite.setVisible(false);
        }
        else if(!jpnUser.isVisible()){
            jpnUser.setVisible(true);
            jpnWhite.setVisible(true);
        }
    }//GEN-LAST:event_lblUserMouseClicked

    private void jpnBarraSuperiorMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnBarraSuperiorMouseDragged

    }//GEN-LAST:event_jpnBarraSuperiorMouseDragged

    private void jpnBarraSuperiorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnBarraSuperiorMousePressed

    }//GEN-LAST:event_jpnBarraSuperiorMousePressed

    private void jpnBarraMenuPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jpnBarraMenuPropertyChange

    }//GEN-LAST:event_jpnBarraMenuPropertyChange

    private void lblVenderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVenderMouseClicked
        try {
            frmVentas ve = new frmVentas();
            ve.setVisible(true);
            this.setVisible(false);
            lblVender.setForeground(java.awt.Color.black);
            lblVentasBorrador.setForeground(java.awt.Color.lightGray);
        } catch (ErrorTienda ex) {
            Logger.getLogger(frmVentasDetalle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblVenderMouseClicked

    private void lblVentasBorradorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVentasBorradorMouseClicked
        try {
            frmVentasBorrador vb = new frmVentasBorrador();
            vb.setVisible(true);
            this.setVisible(false);
            lblVentasBorrador.setForeground(java.awt.Color.black);
            lblVender.setForeground(java.awt.Color.lightGray);
        } catch (ErrorTienda ex) {
            Logger.getLogger(frmVentas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(frmVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblVentasBorradorMouseClicked

    private void lblDetallesVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDetallesVentasMouseClicked

    }//GEN-LAST:event_lblDetallesVentasMouseClicked

    private void lblDetallesVentas1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDetallesVentas1MouseClicked
        frmVentasDetalle vd = new frmVentasDetalle();
        vd.setVisible(true);
        frmVentasDetalladas2.setVisible(false);
    }//GEN-LAST:event_lblDetallesVentas1MouseClicked

    private void lblVentasBorrador1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVentasBorrador1MouseClicked
        try {
            frmVentasBorrador vb = new frmVentasBorrador();
            vb.setVisible(true);
            frmVentasDetalladas2.setVisible(false);
        } catch (ErrorTienda ex) {
            Logger.getLogger(frmVentasDetalle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(frmVentasDetalle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblVentasBorrador1MouseClicked

    private void lblVender1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVender1MouseClicked
        try {
            frmVentas ve = new frmVentas();
            ve.setVisible(true);
            frmVentasDetalladas2.setVisible(false);
            lblVender.setForeground(java.awt.Color.black);
            lblVentasBorrador.setForeground(java.awt.Color.lightGray);
        } catch (ErrorTienda ex) {
            Logger.getLogger(frmVentasDetalle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblVender1MouseClicked

    private void jpnBarraSuperior2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnBarraSuperior2MouseDragged

    }//GEN-LAST:event_jpnBarraSuperior2MouseDragged

    private void jpnBarraSuperior2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnBarraSuperior2MousePressed

    }//GEN-LAST:event_jpnBarraSuperior2MousePressed

    private void jpnBarraMenu1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jpnBarraMenu1PropertyChange

    }//GEN-LAST:event_jpnBarraMenu1PropertyChange

    private void lblMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMenuMouseClicked
        frmHome home = new frmHome();
        home.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblMenuMouseClicked

    private void txtPacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPacActionPerformed

    private void txtFecha2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFecha2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFecha2ActionPerformed

    private void txtUtilidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUtilidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUtilidadActionPerformed

    private void pwdAntiguaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pwdAntiguaFocusGained
        pwdAntigua.selectAll();
    }//GEN-LAST:event_pwdAntiguaFocusGained

    private void pwdAntiguaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwdAntiguaActionPerformed
        pwdNueva.requestFocus();
    }//GEN-LAST:event_pwdAntiguaActionPerformed

    private void pwdNuevaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pwdNuevaFocusGained
        pwdNueva.selectAll();
    }//GEN-LAST:event_pwdNuevaFocusGained

    private void pwdNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwdNuevaActionPerformed
        pwdNueva2.requestFocus();
    }//GEN-LAST:event_pwdNuevaActionPerformed

    private void pwdNueva2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pwdNueva2FocusGained
        pwdNueva2.selectAll();
    }//GEN-LAST:event_pwdNueva2FocusGained

    private void btnAtrasPwdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasPwdMouseClicked
        Animacion.Animacion.subir(55, -195, 1, 2, jpnPass);
    }//GEN-LAST:event_btnAtrasPwdMouseClicked

    private void btnCambiarPwdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCambiarPwdMouseClicked
        comprobarPass();
    }//GEN-LAST:event_btnCambiarPwdMouseClicked

    private void lblCambiarPwdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCambiarPwdMouseClicked
        jpnPass.setVisible(true);
        Animacion.Animacion.bajar(-195, 55, 1, 2, jpnPass);
        pwdAntigua.requestFocus();
    }//GEN-LAST:event_lblCambiarPwdMouseClicked

    private void lblCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarSesionMouseClicked
        frmLogin lg = new frmLogin();
        lg.setVisible(true);
        this.setVisible(false);
        Bitacora bitacora = new Bitacora();
        Date date = new Date();
        SimpleDateFormat hora = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        bitacora.setAccion("Cerró sesión.");
        bitacora.setFecha(hora.format(date));
        try {
            bitacora.setIdUsuario(ControladorUsuario.ObtenerIdUser(lblUser1.getText()));
            ControladorBitacora.Agregar(bitacora);
        } catch (ErrorTienda ex) {
            Logger.getLogger(frmLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        mensajeNotificacion("¡Has cerrado sesión!", "Error");
    }//GEN-LAST:event_lblCerrarSesionMouseClicked

    private void jpnUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnUserMouseExited
        //jpnUser.setVisible(false);
        //jpnWhite.setVisible(false);
    }//GEN-LAST:event_jpnUserMouseExited

    private void lblAgregarUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgregarUsuarioMouseClicked
        frmRegistrarUsuario ru = new frmRegistrarUsuario();
        ru.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblAgregarUsuarioMouseClicked

    private void cmbBuscarPorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbBuscarPorItemStateChanged

        
    }//GEN-LAST:event_cmbBuscarPorItemStateChanged

    private void cmbBuscarPorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBuscarPorActionPerformed
       String fecha=sd.format(jdcFecha.getDate());
        modelo.setRowCount(0);
        if(cmbBuscarPor.getSelectedIndex()==0){
            System.err.println("Dia "+fecha);
            ObtenerVentas(fecha);
        }else if(cmbBuscarPor.getSelectedIndex()==1){
            System.err.println("Mes "+fecha.substring(0,7));
            ObtenerVentas(fecha.substring(0,7));
        }else{
            System.err.println("Año "+fecha.substring(0,4));
            ObtenerVentas(fecha.substring(0,4));
        }
    }//GEN-LAST:event_cmbBuscarPorActionPerformed

    private void btnComprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnComprasMouseClicked

        frmCompras cm = new frmCompras();
        cm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnComprasMouseClicked

    private void btnComprasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnComprasMouseEntered
        lblCo1.setVisible(true);
    }//GEN-LAST:event_btnComprasMouseEntered

    private void btnComprasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnComprasMouseExited
        lblCo1.setVisible(false);
    }//GEN-LAST:event_btnComprasMouseExited

    private void btnComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprasActionPerformed

    }//GEN-LAST:event_btnComprasActionPerformed

    private void btnVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVentasMouseClicked
        try {
            frmVentas vt = new frmVentas();
            vt.setVisible(true);
            this.setVisible(false);
        } catch (ErrorTienda ex) {
            Logger.getLogger(frmHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnVentasMouseClicked

    private void btnVentasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVentasMouseEntered
        lblCo3.setVisible(true);
    }//GEN-LAST:event_btnVentasMouseEntered

    private void btnVentasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVentasMouseExited
        lblCo3.setVisible(false);
    }//GEN-LAST:event_btnVentasMouseExited

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed

    }//GEN-LAST:event_btnVentasActionPerformed

    private void btnProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductosMouseClicked
        frmProductos pd = new frmProductos();
        pd.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnProductosMouseClicked

    private void btnProductosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductosMouseEntered
        lblCo5.setVisible(true);
    }//GEN-LAST:event_btnProductosMouseEntered

    private void btnProductosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductosMouseExited
        lblCo5.setVisible(false);
    }//GEN-LAST:event_btnProductosMouseExited

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed

    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnTipoPrecioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTipoPrecioMouseClicked
        frmTipoPrecio tp = new frmTipoPrecio();
        tp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnTipoPrecioMouseClicked

    private void btnTipoPrecioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTipoPrecioMouseEntered
        lblCo9.setVisible(true);
    }//GEN-LAST:event_btnTipoPrecioMouseEntered

    private void btnTipoPrecioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTipoPrecioMouseExited
        lblCo9.setVisible(false);
    }//GEN-LAST:event_btnTipoPrecioMouseExited

    private void btnTipoPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTipoPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTipoPrecioActionPerformed

    private void btnParametroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnParametroMouseClicked

        frmParametro pr = new frmParametro();
        pr.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnParametroMouseClicked

    private void btnParametroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnParametroMouseEntered
        lblCo8.setVisible(true);
    }//GEN-LAST:event_btnParametroMouseEntered

    private void btnParametroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnParametroMouseExited
        lblCo8.setVisible(false);
    }//GEN-LAST:event_btnParametroMouseExited

    private void btnParametroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParametroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnParametroActionPerformed

    private void btnProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProveedoresMouseClicked

        frmProveedores pv = new frmProveedores();
        pv.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnProveedoresMouseClicked

    private void btnProveedoresMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProveedoresMouseEntered
        lblCo6.setVisible(true);
    }//GEN-LAST:event_btnProveedoresMouseEntered

    private void btnProveedoresMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProveedoresMouseExited
        lblCo6.setVisible(false);
    }//GEN-LAST:event_btnProveedoresMouseExited

    private void btnSucursalesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSucursalesMouseClicked
        frmSucursales su = new frmSucursales();
        su.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnSucursalesMouseClicked

    private void btnSucursalesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSucursalesMouseEntered
        lblCo7.setVisible(true);
    }//GEN-LAST:event_btnSucursalesMouseEntered

    private void btnSucursalesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSucursalesMouseExited
        lblCo7.setVisible(false);
    }//GEN-LAST:event_btnSucursalesMouseExited

    private void btnDetalleComprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDetalleComprasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDetalleComprasMouseClicked

    private void btnDetalleComprasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDetalleComprasMouseEntered
        lblCo2.setVisible(true);
    }//GEN-LAST:event_btnDetalleComprasMouseEntered

    private void btnDetalleComprasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDetalleComprasMouseExited
        lblCo2.setVisible(false);
    }//GEN-LAST:event_btnDetalleComprasMouseExited

    private void btnDetalleComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalleComprasActionPerformed
        frmComprasDetalle cd = new frmComprasDetalle();
        cd.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnDetalleComprasActionPerformed

    private void btnDetalleVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDetalleVentasMouseClicked

    }//GEN-LAST:event_btnDetalleVentasMouseClicked

    private void btnDetalleVentasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDetalleVentasMouseEntered
        lblCo4.setVisible(true);
    }//GEN-LAST:event_btnDetalleVentasMouseEntered

    private void btnDetalleVentasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDetalleVentasMouseExited
        lblCo4.setVisible(false);
    }//GEN-LAST:event_btnDetalleVentasMouseExited

    private void btnDetalleVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalleVentasActionPerformed
        frmVentasDetalle vd = new frmVentasDetalle();
        vd.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnDetalleVentasActionPerformed

    private void btnReportesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReportesMouseClicked

    private void btnReportesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportesMouseEntered
        lblCo10.setVisible(true);
    }//GEN-LAST:event_btnReportesMouseEntered

    private void btnReportesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportesMouseExited
        lblCo10.setVisible(false);
    }//GEN-LAST:event_btnReportesMouseExited

    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed
        frmComprasReportes cr = new frmComprasReportes();
        cr.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnReportesActionPerformed

    private void btnBitacorasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBitacorasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBitacorasMouseClicked

    private void btnBitacorasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBitacorasMouseEntered
        lblCo11.setVisible(true);
    }//GEN-LAST:event_btnBitacorasMouseEntered

    private void btnBitacorasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBitacorasMouseExited
        lblCo11.setVisible(false);
    }//GEN-LAST:event_btnBitacorasMouseExited

    private void btnBitacorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBitacorasActionPerformed
        frmBitacoras bi = new frmBitacoras();
        bi.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBitacorasActionPerformed

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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmVentasDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmVentasDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmVentasDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmVentasDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmVentasDetalle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAtrasPwd;
    private javax.swing.JButton btnBitacoras;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel btnCambiarPwd;
    private javax.swing.JButton btnCompras;
    private javax.swing.JButton btnDetalle1;
    private javax.swing.JButton btnDetalleCompras;
    private javax.swing.JButton btnDetalleVentas;
    private javax.swing.JLabel btnHome;
    private javax.swing.JLabel btnHome1;
    private javax.swing.JButton btnParametro;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnProveedores;
    private javax.swing.JButton btnReportes;
    private javax.swing.JButton btnSucursales;
    private javax.swing.JButton btnTipoPrecio;
    private javax.swing.JButton btnVentas;
    private javax.swing.JComboBox<String> cmbBuscarPor;
    private javax.swing.JFrame frmVentasDetalladas2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator9;
    private com.toedter.calendar.JDateChooser jdcFecha;
    private javax.swing.JPanel jpnBarraMenu;
    private javax.swing.JPanel jpnBarraMenu1;
    private javax.swing.JPanel jpnBarraSuperior;
    private javax.swing.JPanel jpnBarraSuperior2;
    private javax.swing.JPanel jpnPass;
    private javax.swing.JPanel jpnSubMenu;
    private javax.swing.JPanel jpnUser;
    private javax.swing.JPanel jpnWhite;
    private javax.swing.JLabel lblAgregarUsuario;
    private javax.swing.JLabel lblCambiarPwd;
    private javax.swing.JLabel lblCerrarSesion;
    private javax.swing.JLabel lblCo1;
    private javax.swing.JLabel lblCo10;
    private javax.swing.JLabel lblCo11;
    private javax.swing.JLabel lblCo2;
    private javax.swing.JLabel lblCo3;
    private javax.swing.JLabel lblCo4;
    private javax.swing.JLabel lblCo5;
    private javax.swing.JLabel lblCo6;
    private javax.swing.JLabel lblCo7;
    private javax.swing.JLabel lblCo8;
    private javax.swing.JLabel lblCo9;
    private javax.swing.JLabel lblDetallesVentas;
    private javax.swing.JLabel lblDetallesVentas1;
    private javax.swing.JLabel lblIVA;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblLogo2;
    private javax.swing.JLabel lblMensajito;
    private javax.swing.JLabel lblMenu;
    private javax.swing.JLabel lblMenu1;
    private javax.swing.JLabel lblRolUsuario;
    private javax.swing.JLabel lblSumas;
    public static javax.swing.JLabel lblUser;
    public static javax.swing.JLabel lblUser1;
    private javax.swing.JLabel lblVender;
    private javax.swing.JLabel lblVender1;
    private javax.swing.JLabel lblVentasBorrador;
    private javax.swing.JLabel lblVentasBorrador1;
    private javax.swing.JPasswordField pwdAntigua;
    private javax.swing.JPasswordField pwdNueva;
    private javax.swing.JPasswordField pwdNueva2;
    public javax.swing.JTable tblVentas;
    public javax.swing.JTable tblVentasDetalladas;
    public javax.swing.JTextField txtCliente;
    public javax.swing.JTextField txtFecha2;
    private javax.swing.JTextField txtIVA;
    public javax.swing.JTextField txtIdVenta;
    public javax.swing.JTextField txtPac;
    public javax.swing.JTextField txtSucursal;
    private javax.swing.JTextField txtSumas;
    public javax.swing.JTextField txtTipoVenta;
    private javax.swing.JTextField txtTotalventa;
    public javax.swing.JTextField txtUtilidad;
    // End of variables declaration//GEN-END:variables
}
