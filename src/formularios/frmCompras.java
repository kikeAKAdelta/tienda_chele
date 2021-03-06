/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import AppPackage.AnimationClass;
import clases.Bitacora;
import clases.Compra;
import clases.ControladorBitacora;
import clases.ControladorCompra;
import clases.ControladorProducto;
import clases.ControladorProveedor;
import clases.ControladorSucursal;
import clases.ControladorUsuario;
import clases.DetalleCompra;
import clases.ErrorTienda;
import clases.Producto;
import clases.Proveedor;
import clases.Sucursal;
import clases.TipoPrecio;
import clases.Usuario;
import facadeshop.Diseño;
import static formularios.frmHome.lblUser;
import static formularios.frmHome.lblUser1;
import static formularios.frmLogin.txtUser;
import formulariosReportes.frmComprasReportes;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


/**
 *
 * @author Ricky
 */
public class frmCompras extends javax.swing.JFrame {

    Character s;
    boolean estadoMenu,estadoProd, exprod, encontrado;
    DecimalFormat decimalProductos = new DecimalFormat("0.0000");
    DefaultTableModel tablaModel= new DefaultTableModel();
    DecimalFormat decimal = new DecimalFormat("0.00");
    JTableHeader tHeadVentas;
    double percepcio =0, totalFinal;
    String rol, password;
    Date date = new Date();
    
    public frmCompras() {
        initComponents();
        this.setSize(1200, 700);
        this.setLocationRelativeTo(null);
        LlenarCompras();
        TableModel();
        
        tHeadVentas = tblCompra.getTableHeader();
        Font fuente = new Font("Tahoma", Font.BOLD, 12);
        tHeadVentas.setBackground(jpnBarraSuperior.getBackground());
        tHeadVentas.setForeground(Color.WHITE);
        tHeadVentas.setFont(fuente);
        lblUser.setText(Diseño.user);
        lblUser1.setText(Diseño.user);
        jpnUser.setVisible(false);
        jpnWhite.setVisible(false);
        obtenerRol();
        
            
        
        dtcFecha.setDateFormatString("dd-MM-yyyy");
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jpnPass = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        pwdAntigua = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        pwdNueva = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
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
        jpnAgregarCompra = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        lblnumdoc = new javax.swing.JLabel();
        cmbTipoCompra = new javax.swing.JComboBox<>();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel35 = new javax.swing.JLabel();
        cmbSucursalCompra = new javax.swing.JComboBox<>();
        txtNumeroDoc = new javax.swing.JTextField();
        btnGuardarVenta = new javax.swing.JButton();
        txtIdCompra = new javax.swing.JTextField();
        cmbProveedor = new javax.swing.JComboBox();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblCompra = new javax.swing.JTable();
        lblFecha = new javax.swing.JLabel();
        lblIdCompra = new javax.swing.JLabel();
        lblProveedor = new javax.swing.JLabel();
        lblCodBarraProd = new javax.swing.JLabel();
        lblNomProd = new javax.swing.JLabel();
        txtNomProd = new javax.swing.JTextField();
        lblCantidad = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        lblCostoProd = new javax.swing.JLabel();
        txtCostoProd = new javax.swing.JTextField();
        btnCancelarVenta = new javax.swing.JButton();
        jSeparator37 = new javax.swing.JSeparator();
        lblTotal1 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        txtCodBarraProd1 = new javax.swing.JTextField();
        dtcFecha = new com.toedter.calendar.JDateChooser();
        lblNomProd1 = new javax.swing.JLabel();
        jpnBarraSuperior = new javax.swing.JPanel();
        jpnWhite = new javax.swing.JPanel();
        lblUser1 = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        lblAgregarUsuario = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
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
        lblComprar = new javax.swing.JLabel();
        lblDetallesCompras = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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

        jLabel7.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 0, 0));
        jLabel7.setText("Nueva contraseña:");
        jpnPass.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 65, -1, -1));

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

        jpnAgregarCompra.setBackground(new java.awt.Color(0, 0, 0));
        jpnAgregarCompra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(240, 240, 240));
        jLabel33.setText("Tipo de compra:");
        jpnAgregarCompra.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, -1, 30));

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jpnAgregarCompra.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 20, 50));

        lblnumdoc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblnumdoc.setForeground(new java.awt.Color(240, 240, 240));
        lblnumdoc.setText("Número Documento:");
        jpnAgregarCompra.add(lblnumdoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 30));

        cmbTipoCompra.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmbTipoCompra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Crédito Fiscal", "Factura", "Libre" }));
        cmbTipoCompra.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cmbTipoCompra.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTipoCompraItemStateChanged(evt);
            }
        });
        jpnAgregarCompra.add(cmbTipoCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 10, 150, 30));

        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jpnAgregarCompra.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 20, 50));

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(240, 240, 240));
        jLabel35.setText("Sucursal:");
        jpnAgregarCompra.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, -1, 30));

        cmbSucursalCompra.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmbSucursalCompra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sucursal1", "Sucursal2", "Sucursal3" }));
        jpnAgregarCompra.add(cmbSucursalCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 160, 30));

        txtNumeroDoc.setEditable(false);
        txtNumeroDoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumeroDocKeyTyped(evt);
            }
        });
        jpnAgregarCompra.add(txtNumeroDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 180, 30));

        getContentPane().add(jpnAgregarCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 1010, 50));

        btnGuardarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/botones/guardarprov.png"))); // NOI18N
        btnGuardarVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardarVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGuardarVentaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGuardarVentaMouseExited(evt);
            }
        });
        btnGuardarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarVentaActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 610, 110, 30));

        txtIdCompra.setEditable(false);
        getContentPane().add(txtIdCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, 60, 30));

        getContentPane().add(cmbProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 190, 200, 30));

        tblCompra =new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id producto", "Producto", "Cantidad", "Costo", "SubTotal"
            }
        ));
        tblCompra.getTableHeader().setReorderingAllowed(false);
        tblCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblCompraKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tblCompraKeyTyped(evt);
            }
        });
        jScrollPane6.setViewportView(tblCompra);

        getContentPane().add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, 960, 200));

        lblFecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblFecha.setText("Fecha:");
        getContentPane().add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, 60, 30));

        lblIdCompra.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblIdCompra.setText("Id Compra:");
        getContentPane().add(lblIdCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 80, 30));

        lblProveedor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblProveedor.setText("Proveedor:");
        getContentPane().add(lblProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 190, 90, 30));

        lblCodBarraProd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCodBarraProd.setText("Cod Barra:");
        getContentPane().add(lblCodBarraProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, 80, 30));

        lblNomProd.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblNomProd.setForeground(new java.awt.Color(124, 20, 20));
        lblNomProd.setText("$");
        getContentPane().add(lblNomProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 630, 30, 40));

        txtNomProd.setEditable(false);
        txtNomProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomProdActionPerformed(evt);
            }
        });
        txtNomProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNomProdKeyTyped(evt);
            }
        });
        getContentPane().add(txtNomProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 250, 140, 30));

        lblCantidad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCantidad.setText("Cantidad:");
        getContentPane().add(lblCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 250, 70, 30));

        txtCantidad.setText("1");
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });
        getContentPane().add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 250, 40, 30));

        jSeparator5.setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 1010, 10));

        lblCostoProd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCostoProd.setText("Costo:");
        getContentPane().add(lblCostoProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 250, 60, 30));

        txtCostoProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCostoProdKeyTyped(evt);
            }
        });
        getContentPane().add(txtCostoProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 250, 80, 30));

        btnCancelarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/botones/cancelar.png"))); // NOI18N
        btnCancelarVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelarVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelarVentaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelarVentaMouseExited(evt);
            }
        });
        btnCancelarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarVentaActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 610, 110, 30));

        jSeparator37.setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jSeparator37, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 1010, 10));

        lblTotal1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTotal1.setText("TOTAL:");
        getContentPane().add(lblTotal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 630, 50, 40));

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(102, 0, 0));
        getContentPane().add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 630, 100, 40));

        txtCodBarraProd1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodBarraProd1KeyTyped(evt);
            }
        });
        getContentPane().add(txtCodBarraProd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, 120, 30));

        dtcFecha.setDateFormatString("dd/MM/yyyy");
        getContentPane().add(dtcFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 190, 150, 30));

        lblNomProd1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNomProd1.setText("Producto:");
        getContentPane().add(lblNomProd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 250, 70, 30));

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

        lblLogo.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        lblLogo.setForeground(new java.awt.Color(255, 255, 255));
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/home/lanzador.png"))); // NOI18N
        lblLogo.setToolTipText("");
        jpnBarraSuperior.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, -10, 100, 60));

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

        lblComprar.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lblComprar.setText("Comprar");
        lblComprar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblComprar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblComprarMouseClicked(evt);
            }
        });
        getContentPane().add(lblComprar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, -1, 50));

        lblDetallesCompras.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lblDetallesCompras.setForeground(new java.awt.Color(153, 153, 153));
        lblDetallesCompras.setText("Detalles de Compras");
        lblDetallesCompras.setToolTipText("Ver los detalles de compras realizadas.");
        lblDetallesCompras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblDetallesCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDetallesComprasMouseClicked(evt);
            }
        });
        getContentPane().add(lblDetallesCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 60, -1, 50));

        jSeparator8.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator8.setForeground(new java.awt.Color(102, 0, 0));
        getContentPane().add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 117, 1020, 10));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void obtenerRol(){
        try {
            rol = ControladorUsuario.obtenerRol(txtUser.getText());
            if(rol.equals("A")){
                lblRolUsuario.setText("ADMINISTRADOR");
                jpnSubMenu.setVisible(true);
                lblDetallesCompras.setVisible(true);
                lblMenu.setVisible(true);
                lblAgregarUsuario.setVisible(true);
                cmbTipoCompra.setSelectedIndex(1);
            }
            else if(rol.equals("V")){
                lblRolUsuario.setText("VENDEDOR");
                cmbTipoCompra.setSelectedIndex(2);
                lblMenu.setVisible(false);
                lblAgregarUsuario.setVisible(false);
                                lblDetallesCompras.setVisible(false);
                btnCompras.setVisible(true);
                btnVentas.setVisible(true);
                btnBitacoras.setVisible(false);
                btnDetalleCompras.setVisible(false);
                btnDetalleVentas.setVisible(false);
                btnHome.setVisible(false);
                btnParametro.setVisible(false);
                btnProductos.setVisible(false);
                btnProveedores.setVisible(false);
                btnReportes.setVisible(false);
                btnTipoPrecio.setVisible(false);
                btnSucursales.setVisible(false);
            lblAgregarUsuario.setVisible(false);}
            else if(rol.equals("C")){
                lblRolUsuario.setText("COMPRADOR");
                jpnSubMenu.setVisible(false);
                lblDetallesCompras.setVisible(false);
                lblMenu.setVisible(false);
                lblAgregarUsuario.setVisible(false);
            }
            
            } catch (ErrorTienda ex) {
                Logger.getLogger(frmLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    public void LlenarCompras(){        
        try {
            ArrayList<Sucursal> sucursal = ControladorSucursal.obtener();
            cmbSucursalCompra.removeAllItems();
            int idCompra;
            idCompra = ControladorCompra.ObtenerIdCompra();
            txtIdCompra.setText(String.valueOf(idCompra+1));
            txtNumeroDoc.setText(String.valueOf(idCompra+1));
            //GENERAR FECHA 
            Date utilDate=new Date();
            dtcFecha.setDate(utilDate);
             //AGREGAR PROVEEDORES AL COMBO BOX
            Object vector1[] = new Object[4];
            if (cmbSucursalCompra.getItemCount()==0) {
                Iterator<Sucursal> iterador= sucursal.iterator();
                while(iterador.hasNext()){
                    vector1[0]=iterador.next();
                    vector1[1]=iterador.next();  
                    vector1[2]=iterador.next();
                    vector1[3]=iterador.next();
                    cmbSucursalCompra.addItem((String) vector1[1]);
                }
            } 
            ArrayList<Proveedor> proveedor = ControladorProveedor.Obtener();
            cmbProveedor.removeAllItems();
            Object vector[] = new Object[7];
            if (cmbProveedor.getItemCount() == 0) {
                Iterator<Proveedor> pro = proveedor.iterator();
                while (pro.hasNext()) {
                    vector[0] = pro.next();
                    vector[1] = pro.next();
                    vector[2] = pro.next();
                    vector[3] = pro.next();
                    vector[4] = pro.next();
                    vector[5] = pro.next();
                    vector[6] = pro.next();
                    cmbProveedor.addItem((String) vector[1]);
                }
            }
            
        } catch (Exception e) {
        }
        
    } 
    public void eliminarCompras(){
        int fila = tblCompra.getSelectedRow();
        if (fila != -1) {
            int opcion1=JOptionPane.showConfirmDialog(this, "¿Esta seguro que desea eliminar el producto seleccionado?", "Eliminar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon("src/iconos/pregunta.png"));
    
        if (opcion1 == 0) {
            tablaModel.removeRow(tblCompra.getSelectedRow());
        }
        }
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
    public void TableModel(){
        String headers[] = {"Cod Barra","Producto","Cantidad","Costo","Subtotal"};
        tablaModel.setColumnIdentifiers(headers);
        tblCompra.setModel(tablaModel);
    }
    
    public void AgregarBitacora(String Accion) throws ErrorTienda{
        Date date = new Date();
        Bitacora bitacora = new Bitacora();
        bitacora.setIdUsuario(ControladorUsuario.ObtenerIdUser(lblUser1.getText()));
        DateFormat hora = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        bitacora.setFecha(hora.format(date));
        bitacora.setAccion(Accion);
        ControladorBitacora.Agregar(bitacora);
    
    }
    public void AgregarProductoCompras() throws ErrorTienda{
        Producto pr = new Producto();
        pr.setCodBarra(txtCodBarraProd1.getText());
        pr.setNombre(txtNomProd.getText());
        pr.setInventario(0);
        pr.setCosto(Double.parseDouble(txtCostoProd.getText()));
        pr.setIdSucursal(ControladorSucursal.ObtenerIdSucursal(cmbSucursalCompra.getSelectedItem()));
        
        try {
            ControladorProducto.Agregar(pr);
        } catch (ErrorTienda ex) {

        }
        exprod=true;
        txtNomProd.setEditable(false);
        AgregarProductoTablaCompras();
        mensajeNotificacion("¡Producto agregado exitosamente!", "Ok");
    }
    public void AgregarProductoTablaCompras(){
        int TipoCompra = cmbTipoCompra.getSelectedIndex();
        if (tblCompra.getRowCount()>0) {
            int i = 0;
            while (encontrado==false&&i<tblCompra.getRowCount()) {
                encontrado = tblCompra.getValueAt(i, 0).equals(txtCodBarraProd1.getText());
                i++;
            }
        }


        if(encontrado == false){//verificar si el producto ya esta en la tabla
            String fila[]  = new String[5];
            fila[0]=txtCodBarraProd1.getText();
            fila[1]=txtNomProd.getText();
            fila[2]=txtCantidad.getText();
            //System.out.println(decimalProductos.format(txtCostoProd.getText().toString()));
            
            fila[3]=decimalProductos.format(Double.parseDouble(txtCostoProd.getText()));
            
            fila[4]=String.valueOf(decimalProductos.format((Double.parseDouble(txtCantidad.getText()))*(Double.parseDouble(txtCostoProd.getText()))));
            tablaModel.addRow(fila);
            tblCompra.setModel(tablaModel);
        }else{
            boolean buscar=false;
            int j=0;
            int nuevaCantidad;
            double nuevoCosto;
            while (buscar==false) {
                buscar = tblCompra.getValueAt(j, 0).equals(txtCodBarraProd1.getText());
                j++;
            }
            nuevaCantidad = Integer.parseInt(txtCantidad.getText()) + Integer.parseInt(tblCompra.getValueAt(j-1, 2).toString());
            nuevoCosto = (Double.parseDouble(txtCostoProd.getText()) + Double.parseDouble(tblCompra.getValueAt(j-1, 3).toString()))/2;
            //System.out.println(j);
            tablaModel.setValueAt(nuevaCantidad, j-1, 2);
            tablaModel.setValueAt(decimalProductos.format(nuevoCosto), j-1, 3);
            tablaModel.setValueAt(decimalProductos.format(nuevaCantidad*nuevoCosto), j-1, 4);
            tblCompra.setModel(tablaModel);
        }
        encontrado = false;
        //LIMPIAR LOS TXT
        txtCodBarraProd1.setText("");
        
        txtNomProd.setText("");
        txtCantidad.setText("1");
        txtCostoProd.setText("");
        txtCodBarraProd1.requestFocus();

        int filas = tablaModel.getRowCount();
        int iteraciones=0;
        double total=0;
        while(iteraciones<filas){
            total+= Double.parseDouble(String.valueOf(tablaModel.getValueAt(iteraciones, 4)));
            //System.out.println(tablaModel.getValueAt(iteraciones, 4));
            iteraciones++;
        }
        //System.out.println(total);
        totalFinal=Double.parseDouble(decimal.format(total));
        
        if (TipoCompra==0) {
            
            percepcio = 0.0;
            txtTotal.setText(decimal.format(totalFinal));
        }else{
            txtTotal.setText("$"+totalFinal);
        }
}
    
    private void btnGuardarVentaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarVentaMouseEntered
        btnGuardarVenta.setIcon(new ImageIcon(getClass().getResource("/iconos/botones/guardarprovB.png")));
    }//GEN-LAST:event_btnGuardarVentaMouseEntered

    private void btnGuardarVentaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarVentaMouseExited
        btnGuardarVenta.setIcon(new ImageIcon(getClass().getResource("/iconos/botones/guardarprov.png")));
    }//GEN-LAST:event_btnGuardarVentaMouseExited

    private void btnGuardarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarVentaActionPerformed
        ArrayList<Proveedor> Proveedor = new ArrayList();
        Object IdProveedor;
        Object[] llenarProveedor = new Object[6];
        ArrayList<DetalleCompra> Articulos = new ArrayList();
        DetalleCompra detalleCompra = new DetalleCompra();
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Compra compra = new Compra();
        ControladorProducto producto = new ControladorProducto();
        Proveedor proveedor = new Proveedor();
        int Tipocompra = cmbTipoCompra.getSelectedIndex();
        try {
            Proveedor = ControladorProveedor.Buscar(cmbProveedor.getSelectedItem().toString());
            Iterator<Proveedor> prov = Proveedor.iterator();
            IdProveedor = prov.next();                       
            if (tblCompra.getRowCount()>0) {
               String IDprov=IdProveedor.toString();
               int idSucursal = ControladorSucursal.ObtenerIdSucursal(cmbSucursalCompra.getSelectedItem());
               double subtotal=0.0;
                for (int i = 0; i < tblCompra.getRowCount(); i++) {
                    detalleCompra.setCostoUnitario(Double.parseDouble(decimal.format(Double.parseDouble(tblCompra.getValueAt(i, 3).toString()))));
                    detalleCompra.setCantidad(Integer.parseInt(tblCompra.getValueAt(i, 2).toString()));
                    detalleCompra.setPRODUCTO(ControladorProducto.Obtener(tblCompra.getValueAt(i, 0).toString(),idSucursal));
                    //System.out.println("PENDEJADA");
                    //System.out.println("pendejada"+subtotal +(double) tblCompra.getValueAt(i, 4));
                    
                    subtotal = subtotal +Double.parseDouble(tblCompra.getValueAt(i, 4).toString());
                    Articulos.add(detalleCompra);
                }
                while (prov.hasNext()) {
                    llenarProveedor[0] = prov.next();
                    llenarProveedor[1] = prov.next();
                    llenarProveedor[2] = prov.next();
                    llenarProveedor[3] = prov.next();
                    llenarProveedor[4] = prov.next();
                    llenarProveedor[5] = prov.next();
                    
                    
                    
                }    
                proveedor.setIdProveedor(Integer.parseInt(IdProveedor.toString()));
                proveedor.setNombre(llenarProveedor[0].toString());
                proveedor.setTelefono(llenarProveedor[1].toString());
                proveedor.setDireccion(llenarProveedor[2].toString());
                proveedor.setNIT(llenarProveedor[3].toString());
                proveedor.setEmail(llenarProveedor[4].toString());
                proveedor.setNRC(llenarProveedor[5].toString());

                String total="";

                for (int j = 1; j < txtTotal.getText().length(); j++) {
                    total = total + txtTotal.getText().charAt(j);
                }

                compra.setIdCompra(Integer.parseInt(txtIdCompra.getText()));
                //compra.setIdUsuario(ControladorUsuario.ObtenerIdUser(lblUsuario.getText()));
                //System.out.println(ControladorUsuario.ObtenerIdUser(lblUsuario.getText()));
                compra.setPROVEEDOR(proveedor);
                switch (Tipocompra) {                    
                    case 0:                        
                        compra.setTipoCompra('C');                        
                        break;
                    case 1:
                        compra.setTipoCompra('F');
                        break;
                    case 2:
                        compra.setTipoCompra('L');
                        break;
                }
                compra.setIdSucursal(ControladorSucursal.ObtenerIdSucursal(cmbSucursalCompra.getSelectedItem()));
                compra.setFecha(dtcFecha.getDate());
                if (Tipocompra==0) {
                    compra.setPercepcion(0.0);
                    compra.setIVA(0.0);
                    compra.setTotal(Double.parseDouble(txtTotal.getText()));
                }else{
                    compra.setTotal(Double.parseDouble(decimal.format(Double.parseDouble(total))));
                }
                compra.setARTICULOS(Articulos);
                compra.setSubTotal(subtotal);
                compra.setNumDocumento(txtNumeroDoc.getText());
                //System.out.println(txtNumeroDoc.getText());
                Object [][] detallesCompra;
                
                int filas = tablaModel.getRowCount();
                detallesCompra = new Object[filas][5];
                for(int x=0;x<filas;x++){
                    detallesCompra[x][0]=Integer.parseInt(txtIdCompra.getText());
                    detallesCompra[x][1]=tablaModel.getValueAt(x, 0);
                    detallesCompra[x][2]=Integer.parseInt(String.valueOf(tablaModel.getValueAt(x, 2)));
                    detallesCompra[x][3]=Double.parseDouble(String.valueOf(tablaModel.getValueAt(x, 3)));
                    detallesCompra[x][4]=ControladorSucursal.ObtenerIdSucursal(cmbSucursalCompra.getSelectedItem());
                }
                ControladorCompra.Agregar(compra,detallesCompra);
                ControladorCompra.ActualizarPrecioPromedioProducto(detallesCompra);
                ControladorCompra.ActualizarInventario(detallesCompra, ControladorSucursal.ObtenerIdSucursal(cmbSucursalCompra.getSelectedItem()));
                AgregarBitacora("Realizó la compra que tiene como ID: "+txtIdCompra.getText()+" de "+txtTotal.getText());
                Diseño.Apertura = Diseño.Apertura - Double.parseDouble(txtTotal.getText().substring(1));  
                
                mensajeNotificacion("Compra Agregada", "Ok");
                
                }
            if (tblCompra.getRowCount()==0) {
                mensajeNotificacion("Llenar detalle compra", "Error");
            }
            
            int idCompra;
            idCompra = ControladorCompra.ObtenerIdCompra();
            //limpiarCompra();
            txtIdCompra.setText(String.valueOf(idCompra+1));
            txtNumeroDoc.setText(String.valueOf(idCompra+1));
            tablaModel.setNumRows(0);
            txtTotal.setText("$");
            
            
            cmbSucursalCompra.setEnabled(true);
            cmbSucursalCompra.setEnabled(true);
            cmbProveedor.setEnabled(true);
            cmbTipoCompra.setEnabled(true);
        } catch (ErrorTienda ex) {
            
        }
        
    }//GEN-LAST:event_btnGuardarVentaActionPerformed

    private void tblCompraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblCompraKeyPressed
        char c=evt.getKeyChar();      
        int iteraciones=0;
         
         if (c == (char) KeyEvent.VK_DELETE) {
             eliminarCompras();
             int filas = tablaModel.getRowCount();
            
            double total=0;
            while(iteraciones<filas){
               total+=Double.parseDouble(String.valueOf(tablaModel.getValueAt(iteraciones, 4)));
               iteraciones++;}
            
            double totalFinal=Double.parseDouble(decimal.format(total));
            txtTotal.setText("$"+totalFinal);
            
            
        }
    }//GEN-LAST:event_tblCompraKeyPressed

    private void tblCompraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblCompraKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tblCompraKeyTyped

    private void txtNumeroDocKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroDocKeyTyped
        

    }//GEN-LAST:event_txtNumeroDocKeyTyped

    private void txtNomProdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomProdKeyTyped
        // TODO add your handling code here:
        char ch = evt.getKeyChar();

        if (ch == (char) KeyEvent.VK_ENTER) {
            
            txtCantidad.requestFocus();
            txtCantidad.selectAll();

        }
        int c=(int) evt.getKeyChar();
        char mayu=evt.getKeyChar();

        if ((c>=65 && c<=90) || (c>=97 && c<=122)  || (c==32) || (c >=48 && c<=57) || (c== (char)KeyEvent.VK_BACK_SPACE) || (c== (char)KeyEvent.VK_ENTER)) {
            if (Character.isLowerCase(mayu)) {
                String cadena=(""+mayu).toUpperCase();
                mayu=cadena.charAt(0);
                evt.setKeyChar(mayu);
            }
        }else{
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            getToolkit().beep();
            evt.consume();
        }

    }//GEN-LAST:event_txtNomProdKeyTyped

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        // TODO add your handling code here:
        s = evt.getKeyChar();
        if (!Character.isDigit(s)&&s!=KeyEvent.VK_ENTER&&s!=KeyEvent.VK_BACK_SPACE) {
            getToolkit().beep();
            evt.consume();

        }
        if (s == KeyEvent.VK_ENTER && Integer.parseInt(txtCantidad.getText())>0) {

            txtCostoProd.requestFocus();
        }

    }//GEN-LAST:event_txtCantidadKeyTyped

    private void txtCostoProdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoProdKeyTyped
        // TODO add your handling code here:

        s = evt.getKeyChar();
        int p=(int) evt.getKeyChar();

        // double actualizarPrecio = ((((CantidadActual)*(PrecioActual))+((detalleCompra.get(i).getCantidad())*(detalleCompra.get(i).getCostoUnitario())))/((detalleCompra.get(i).getCantidad())+CantidadActual));
        if (!Character.isDigit(s) && s != KeyEvent.VK_PERIOD && s!=KeyEvent.VK_BACK_SPACE && s!= KeyEvent.VK_ENTER) {
            getToolkit().beep();
            evt.consume();
        }else{
            if (p==46) {
                String cadena=txtCostoProd.getText();
                int tamanio=cadena.length();
                for (int i = 0; i <= tamanio; i++) {
                    if (cadena.contains(".")) {
                        evt.setKeyChar((char) KeyEvent.VK_CLEAR);
                        getToolkit().beep();
                        evt.consume();
                    }
                }
            }
        }
        if (s == KeyEvent.VK_ENTER) {
           if (txtCodBarraProd1.getText().equals("")||txtNomProd.getText().equals("")||txtCostoProd.getText().equals("")||txtCantidad.getText().equals("")) {
                mensajeNotificacion("Debe de rellenar todos los campos.", "Error");
           
            }else{    if(Double.parseDouble(txtCostoProd.getText()) > 0){
                    if (exprod==false){
                        try {
                            AgregarProductoCompras();
                        } catch (ErrorTienda ex) {
                            
                        }
                    }else{
                       AgregarProductoTablaCompras();
                    }
                    cmbTipoCompra.setEnabled(false);
                    cmbSucursalCompra.setEnabled(false);
                    cmbProveedor.setEnabled(false);
                    //txtPercepcion.setEnabled(false);
                }else{
                    mensajeNotificacion("El Costo debe ser mayor a 0.", "Error");
                }
            } 
        }

    }//GEN-LAST:event_txtCostoProdKeyTyped

    private void btnCancelarVentaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarVentaMouseEntered
        btnCancelarVenta.setIcon(new ImageIcon(getClass().getResource("/iconos/botones/cancelarB.png")));
    }//GEN-LAST:event_btnCancelarVentaMouseEntered

    private void btnCancelarVentaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarVentaMouseExited
        btnCancelarVenta.setIcon(new ImageIcon(getClass().getResource("/iconos/botones/cancelar.png")));
    }//GEN-LAST:event_btnCancelarVentaMouseExited

    private void btnCancelarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarVentaActionPerformed
        tablaModel.setRowCount(0);
        //txtNumeroDoc.setText("");
        txtNomProd.setText("");
        txtCantidad.setText("1");
        txtCostoProd.setText("");
        cmbProveedor.setEnabled(true);
        cmbSucursalCompra.setEnabled(true);
        cmbTipoCompra.setEnabled(true);

    }//GEN-LAST:event_btnCancelarVentaActionPerformed

    private void cmbTipoCompraItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTipoCompraItemStateChanged
        if(cmbTipoCompra.getSelectedIndex()==0){
            lblnumdoc.setVisible(true);
            
            txtNumeroDoc.setVisible(true);
            
            
        }else if(cmbTipoCompra.getSelectedIndex()==2){
            lblProveedor.setVisible(false);
            cmbProveedor.setVisible(false);
        
        }else{
            lblnumdoc.setVisible(false);
            txtNumeroDoc.setVisible(false);
        }
            
        
    }//GEN-LAST:event_cmbTipoCompraItemStateChanged

    private void txtCodBarraProd1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodBarraProd1KeyTyped
        int idSucursal=0;
        char ch = evt.getKeyChar();
        if(txtCodBarraProd1.getText().length()>=13){
           evt.consume();
        }else{
            if (ch < '0' || ch > '9') {

                if (ch != (char) KeyEvent.VK_BEGIN) {
                    if (ch != (char) KeyEvent.VK_BACK_SPACE) {
                        if (ch != (char) KeyEvent.VK_DELETE) {
                            if(ch != (char) KeyEvent.VK_ENTER){

                                evt.consume();
                                mensajeNotificacion("¡Error! Solo números.", "Error");

                            }
                        }
                    }
                }
            }   
        }
        char c = evt.getKeyChar();               
        if (c == (char) KeyEvent.VK_ENTER) {
            String codBarra=txtCodBarraProd1.getText();
            Producto producto;
            
            try {
                if (codBarra.equals("")) {
                    mensajeNotificacion("¡Ingrese un código de barras!", "Error");
                } else {
                    idSucursal = ControladorSucursal.ObtenerIdSucursal(cmbSucursalCompra.getSelectedItem());
                    
                    producto = ControladorProducto.BuscarProducto(codBarra);
                    //PARA SABER SI EXISTE O NO EXISTE UN PRODUCTO
                    //System.out.println(producto.getNombre());
                    if (producto.getNombre().equals("")) {
                        txtNomProd.setEditable(true);
                        txtNomProd.requestFocus();                          
                        mensajeNotificacion("Ese producto no está, ¡Agregue!", "Adv");
                        exprod=false;
                    } else {
                        txtNomProd.setText(producto.getNombre());
                        txtCantidad.requestFocus();
                        txtCantidad.selectAll();
                        exprod=true;
                    }
                }
            } catch (ErrorTienda ex) {

            }
                
        }
    }//GEN-LAST:event_txtCodBarraProd1KeyTyped

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

    private void lblComprarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblComprarMouseClicked
        // TODO add your handling code here:
        lblComprar.setForeground(java.awt.Color.black);
        lblDetallesCompras.setForeground(java.awt.Color.lightGray);
    }//GEN-LAST:event_lblComprarMouseClicked

    private void lblDetallesComprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDetallesComprasMouseClicked
        frmComprasDetalle cd = new frmComprasDetalle();
        cd.setVisible(true);
        this.setVisible(false);
        lblDetallesCompras.setForeground(java.awt.Color.black);
        lblComprar.setForeground(java.awt.Color.lightGray);
    }//GEN-LAST:event_lblDetallesComprasMouseClicked

    private void lblMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMenuMouseClicked
        frmHome home = new frmHome();
        home.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblMenuMouseClicked

    private void txtNomProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomProdActionPerformed

    private void lblAgregarUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgregarUsuarioMouseClicked
        frmRegistrarUsuario ru = new frmRegistrarUsuario();
        ru.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblAgregarUsuarioMouseClicked

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
        bitacora.setAccion("Ha finalizado el día con $"+decimal.format(Diseño.Apertura));
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
            java.util.logging.Logger.getLogger(frmCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCompras().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAtrasPwd;
    private javax.swing.JButton btnBitacoras;
    private javax.swing.JLabel btnCambiarPwd;
    private javax.swing.JButton btnCancelarVenta;
    private javax.swing.JButton btnCompras;
    private javax.swing.JButton btnDetalleCompras;
    private javax.swing.JButton btnDetalleVentas;
    private javax.swing.JButton btnGuardarVenta;
    private javax.swing.JLabel btnHome;
    private javax.swing.JButton btnParametro;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnProveedores;
    private javax.swing.JButton btnReportes;
    private javax.swing.JButton btnSucursales;
    private javax.swing.JButton btnTipoPrecio;
    private javax.swing.JButton btnVentas;
    private javax.swing.JComboBox cmbProveedor;
    private javax.swing.JComboBox<String> cmbSucursalCompra;
    private javax.swing.JComboBox<String> cmbTipoCompra;
    private com.toedter.calendar.JDateChooser dtcFecha;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator37;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JPanel jpnAgregarCompra;
    private javax.swing.JPanel jpnBarraMenu;
    private javax.swing.JPanel jpnBarraSuperior;
    private javax.swing.JPanel jpnPass;
    private javax.swing.JPanel jpnSubMenu;
    private javax.swing.JPanel jpnUser;
    private javax.swing.JPanel jpnWhite;
    private javax.swing.JLabel lblAgregarUsuario;
    private javax.swing.JLabel lblCambiarPwd;
    private javax.swing.JLabel lblCantidad;
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
    private javax.swing.JLabel lblCodBarraProd;
    private javax.swing.JLabel lblComprar;
    private javax.swing.JLabel lblCostoProd;
    private javax.swing.JLabel lblDetallesCompras;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblIdCompra;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblMenu;
    private javax.swing.JLabel lblNomProd;
    private javax.swing.JLabel lblNomProd1;
    private javax.swing.JLabel lblProveedor;
    private javax.swing.JLabel lblRolUsuario;
    private javax.swing.JLabel lblTotal1;
    public static javax.swing.JLabel lblUser;
    public static javax.swing.JLabel lblUser1;
    private javax.swing.JLabel lblnumdoc;
    private javax.swing.JPasswordField pwdAntigua;
    private javax.swing.JPasswordField pwdNueva;
    private javax.swing.JPasswordField pwdNueva2;
    private javax.swing.JTable tblCompra;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodBarraProd1;
    private javax.swing.JTextField txtCostoProd;
    private javax.swing.JTextField txtIdCompra;
    private javax.swing.JTextField txtNomProd;
    private javax.swing.JTextField txtNumeroDoc;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
