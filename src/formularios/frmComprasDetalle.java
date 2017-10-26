/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import clases.Compra;
import clases.ControladorCompra;
import clases.ControladorVenta;
import clases.DetalleCompra;
import clases.ErrorTienda;
import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
public class frmComprasDetalle extends javax.swing.JFrame {

    boolean estadoMenu;
    JTableHeader tHeadVentas;
    public DefaultTableModel modeloDCompras = new DefaultTableModel();
    public int seleccion;
    double subTotales;
    DecimalFormat decimal = new DecimalFormat("0.00");
    
    public frmComprasDetalle() {
        initComponents();
        this.setSize(1200, 700);
        this.setLocationRelativeTo(null);
        tHeadVentas = tblCompras.getTableHeader();
        Font fuente = new Font("Tahoma", Font.BOLD, 12);
        tHeadVentas.setBackground(jpnBarraSuperior.getBackground());
        tHeadVentas.setForeground(Color.WHITE);
        tHeadVentas.setFont(fuente);

        modeloDCompras = (DefaultTableModel) tblComprasDetalladas.getModel();
        //actualizarTablaDetalleCompra();
    }

   //---------------------------Llenar tabla de Detalle Compra----------------------------------------
      /*  public void actualizarTablaDetalleCompra(){
            modeloDCompras.setRowCount(0);
            
            ArrayList<DetalleCompra> listaDetalleCompra=new ArrayList();
            Object fila[]=new Object[5];
            
        
            try {
            listaDetalleCompra=ControladorCompra.ObtenerCompra();
            String[] nombreDetalleCompra = new String []{"IdCompra","Producto","Cantidad","Costo Unitario"};
            modeloDCompras.setColumnIdentifiers(nombreDetalleCompra);
            Iterator<DetalleCompra> dc=listaDetalleCompra.iterator();
                while(dc.hasNext()){
                    fila[0]= dc.next();
                    fila[1]= dc.next();
                    fila[2]= dc.next();
                    fila[3]= dc.next();
                    modeloDCompras.addRow(fila);
                    tblCompras.setModel(modeloDCompras);
                }
            }
            
         catch (ErrorTienda ex) {
             Logger.getLogger(frmProveedores.class.getName()).log(Level.SEVERE, null, ex);
         }
    } */
        public void SumarSubTotales(){
        int filas = modeloDCompras.getRowCount();
        subTotales=0;
        for(int i=0;i<filas;i++){
            subTotales+=Double.parseDouble(String.valueOf(modeloDCompras.getValueAt(i, 3)));
        }
        
    }
        public void limpiar(){
            txtIdCompra.setText("");
            txtTipoCompra.setText("");
            txtSucursal.setText("");
            txtFecha.setText("");
            txtSumas.setText("");
            txtIVA.setText("");
            txtTotalCompra.setText("");
            modeloDCompras.setRowCount(0);
            tblComprasDetalladas.removeAll();
        }
    
     public void estableciendoDatos(int id){
        Object[] fila=new Object[4];
        
        modeloDCompras=new DefaultTableModel();
        String[] campos = {"IdCompra","Producto","Cantidad","Costo Unitario"};
        
        System.out.println(id);
        
        try {
            ArrayList<DetalleCompra> miscompras=ControladorCompra.ObtenerCompra(id);
            modeloDCompras.setColumnIdentifiers(campos);
            Iterator iterador=miscompras.iterator();
            
            while (iterador.hasNext()) {
                fila[0]=iterador.next();
                fila[1]=iterador.next();
                fila[2]=iterador.next();
                fila[3]=iterador.next();
                
                modeloDCompras.addRow(fila);
                tblComprasDetalladas.setModel(modeloDCompras);
            }
        } catch (ErrorTienda ex) {
            Logger.getLogger(frmVentasDetalladas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        frmComprasDetalladas2 = new javax.swing.JFrame();
        jLabel11 = new javax.swing.JLabel();
        txtIdCompra = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTipoCompra = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtSucursal = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblComprasDetalladas = new javax.swing.JTable();
        jpnAgregarCompra1 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jpnBarraSuperior1 = new javax.swing.JPanel();
        lblLogo1 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        btnAtras1 = new javax.swing.JLabel();
        lblSumas = new javax.swing.JLabel();
        txtSumas = new javax.swing.JTextField();
        lblIVA = new javax.swing.JLabel();
        txtIVA = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        txtTotalCompra = new javax.swing.JTextField();
        jpnMenu = new javax.swing.JPanel();
        lblSucursales = new javax.swing.JLabel();
        lblProveedores = new javax.swing.JLabel();
        lblProductos = new javax.swing.JLabel();
        lblVentas = new javax.swing.JLabel();
        lblMenuCerrar = new javax.swing.JLabel();
        lblParametro = new javax.swing.JLabel();
        lblCompras = new javax.swing.JLabel();
        jpnBarraSuperior = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        home = new javax.swing.JLabel();
        lblBotonCerrar2 = new javax.swing.JLabel();
        jpnAgregarCompra = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCompras = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        btnDetalles = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jdcFecha = new com.toedter.calendar.JDateChooser();
        btnBuscar = new javax.swing.JButton();

        frmComprasDetalladas2.setMinimumSize(new java.awt.Dimension(1200, 700));
        frmComprasDetalladas2.setUndecorated(true);
        frmComprasDetalladas2.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Id de la compra:");
        frmComprasDetalladas2.getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 130, -1));

        txtIdCompra.setEditable(false);
        txtIdCompra.setText(" ");
        txtIdCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdCompraActionPerformed(evt);
            }
        });
        frmComprasDetalladas2.getContentPane().add(txtIdCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 50, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Fue una compra con:");
        frmComprasDetalladas2.getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 170, -1));

        txtTipoCompra.setEditable(false);
        txtTipoCompra.setText(" ");
        txtTipoCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoCompraActionPerformed(evt);
            }
        });
        frmComprasDetalladas2.getContentPane().add(txtTipoCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 170, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Sucursal:");
        frmComprasDetalladas2.getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 190, 70, -1));

        txtSucursal.setEditable(false);
        txtSucursal.setText(" ");
        txtSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSucursalActionPerformed(evt);
            }
        });
        frmComprasDetalladas2.getContentPane().add(txtSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 190, 240, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Fecha:");
        frmComprasDetalladas2.getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 190, 50, -1));

        txtFecha.setEditable(false);
        txtFecha.setText(" ");
        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });
        frmComprasDetalladas2.getContentPane().add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 190, 190, -1));

        tblComprasDetalladas =new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblComprasDetalladas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Cantidad", "Precio Unitario $", "Sub total $"
            }
        ));
        tblComprasDetalladas.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblComprasDetalladas);

        frmComprasDetalladas2.getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 960, 220));

        jpnAgregarCompra1.setBackground(new java.awt.Color(0, 0, 0));
        jpnAgregarCompra1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(240, 240, 240));
        jLabel35.setText("Detalles de Compras:");
        jpnAgregarCompra1.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 12, -1, 30));

        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jpnAgregarCompra1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 0, 20, 50));

        frmComprasDetalladas2.getContentPane().add(jpnAgregarCompra1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1200, 50));

        jpnBarraSuperior1.setBackground(new java.awt.Color(102, 0, 0));
        jpnBarraSuperior1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jpnBarraSuperior1MouseDragged(evt);
            }
        });
        jpnBarraSuperior1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jpnBarraSuperior1MousePressed(evt);
            }
        });
        jpnBarraSuperior1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogo1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblLogo1.setForeground(new java.awt.Color(255, 255, 255));
        lblLogo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/home/lanzador.png"))); // NOI18N
        lblLogo1.setToolTipText("");
        jpnBarraSuperior1.add(lblLogo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 0, 50, 50));

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator3.setToolTipText("");
        jpnBarraSuperior1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 60, 60));

        btnAtras1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Atras.png"))); // NOI18N
        btnAtras1.setToolTipText("Volver atrás");
        btnAtras1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtras1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAtras1MouseClicked(evt);
            }
        });
        jpnBarraSuperior1.add(btnAtras1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 10, 50, 40));

        frmComprasDetalladas2.getContentPane().add(jpnBarraSuperior1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 55));

        lblSumas.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblSumas.setText("Sumas");
        frmComprasDetalladas2.getContentPane().add(lblSumas, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 500, -1, -1));

        txtSumas.setEditable(false);
        txtSumas.setBackground(new java.awt.Color(255, 255, 255));
        txtSumas.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtSumas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        frmComprasDetalladas2.getContentPane().add(txtSumas, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 490, 120, 40));

        lblIVA.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblIVA.setText("13% IVA");
        frmComprasDetalladas2.getContentPane().add(lblIVA, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 500, -1, -1));

        txtIVA.setEditable(false);
        txtIVA.setBackground(new java.awt.Color(255, 255, 255));
        txtIVA.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtIVA.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        frmComprasDetalladas2.getContentPane().add(txtIVA, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 490, 120, 40));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 3, 0));
        jLabel38.setText("Total");
        frmComprasDetalladas2.getContentPane().add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 500, -1, 20));

        txtTotalCompra.setEditable(false);
        txtTotalCompra.setBackground(new java.awt.Color(255, 255, 255));
        txtTotalCompra.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtTotalCompra.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        frmComprasDetalladas2.getContentPane().add(txtTotalCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 490, 120, 40));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/iconos/home/lanzador.png")).getImage());
        setMinimumSize(new java.awt.Dimension(1200, 700));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpnMenu.setBackground(new java.awt.Color(102, 0, 0));
        jpnMenu.setPreferredSize(new java.awt.Dimension(80, 304));
        jpnMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpnMenuMouseExited(evt);
            }
        });
        jpnMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSucursales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Sucursales.png"))); // NOI18N
        lblSucursales.setToolTipText("Sucursales");
        lblSucursales.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSucursales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSucursalesMouseClicked(evt);
            }
        });
        jpnMenu.add(lblSucursales, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 230, -1, 30));

        lblProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Proveedores.png"))); // NOI18N
        lblProveedores.setToolTipText("Proveedores");
        lblProveedores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblProveedoresMouseClicked(evt);
            }
        });
        jpnMenu.add(lblProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 190, -1, 30));

        lblProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Productos.png"))); // NOI18N
        lblProductos.setToolTipText("Productos");
        lblProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblProductosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblProductosMouseEntered(evt);
            }
        });
        jpnMenu.add(lblProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 150, -1, 30));

        lblVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Ventas.png"))); // NOI18N
        lblVentas.setToolTipText("Ventas");
        lblVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVentasMouseClicked(evt);
            }
        });
        jpnMenu.add(lblVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 110, -1, 30));

        lblMenuCerrar.setBackground(new java.awt.Color(0, 0, 0));
        lblMenuCerrar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblMenuCerrar.setForeground(new java.awt.Color(255, 255, 255));
        lblMenuCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenuCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Menu.png"))); // NOI18N
        lblMenuCerrar.setToolTipText("Cerrar");
        lblMenuCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMenuCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMenuCerrarMouseClicked(evt);
            }
        });
        jpnMenu.add(lblMenuCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 55));

        lblParametro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Parametro.png"))); // NOI18N
        lblParametro.setToolTipText("Sucursales");
        lblParametro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblParametro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblParametroMouseClicked(evt);
            }
        });
        jpnMenu.add(lblParametro, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 270, -1, 30));

        lblCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Compras.png"))); // NOI18N
        lblCompras.setToolTipText("Compras");
        lblCompras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblComprasMouseClicked(evt);
            }
        });
        jpnMenu.add(lblCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 70, -1, 30));

        getContentPane().add(jpnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -360, 80, 318));

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

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setToolTipText("");
        jpnBarraSuperior.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 60, 60));

        home.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Home.png"))); // NOI18N
        home.setToolTipText("Ir a Home");
        home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeMouseClicked(evt);
            }
        });
        jpnBarraSuperior.add(home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 55));

        lblBotonCerrar2.setBackground(new java.awt.Color(102, 0, 0));
        lblBotonCerrar2.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        lblBotonCerrar2.setForeground(new java.awt.Color(102, 0, 0));
        lblBotonCerrar2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBotonCerrar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/home/exit32.png"))); // NOI18N
        lblBotonCerrar2.setToolTipText("Salir");
        lblBotonCerrar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBotonCerrar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBotonCerrar2MouseClicked(evt);
            }
        });
        jpnBarraSuperior.add(lblBotonCerrar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 0, 40, 50));

        getContentPane().add(jpnBarraSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 55));

        jpnAgregarCompra.setBackground(new java.awt.Color(0, 0, 0));
        jpnAgregarCompra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(240, 240, 240));
        jLabel34.setText("Compras");
        jpnAgregarCompra.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 12, -1, 30));

        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jpnAgregarCompra.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 0, 20, 50));

        getContentPane().add(jpnAgregarCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1200, 50));

        tblCompras =new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idCompra", "Sucursal", "Proveedor", "TipoCompra", "Fecha"
            }
        ));
        tblCompras.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblCompras);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 920, 320));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Lista de las Compras:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, -1, -1));

        jSeparator5.setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 1200, 10));

        btnDetalles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/botones/detalles2.png"))); // NOI18N
        btnDetalles.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDetalles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDetallesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDetallesMouseExited(evt);
            }
        });
        btnDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetallesActionPerformed(evt);
            }
        });
        getContentPane().add(btnDetalles, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 640, 110, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Fecha:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, -1, 30));

        jdcFecha.setDateFormatString("yyyy-dd-MM");
        getContentPane().add(jdcFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 200, 30));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/botones/buscar.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 110, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jpnBarraSuperiorMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnBarraSuperiorMouseDragged

    }//GEN-LAST:event_jpnBarraSuperiorMouseDragged

    private void jpnBarraSuperiorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnBarraSuperiorMousePressed

    }//GEN-LAST:event_jpnBarraSuperiorMousePressed

    private void lblSucursalesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSucursalesMouseClicked
        frmSucursales sc = new frmSucursales();
        sc.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblSucursalesMouseClicked

    private void lblProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProveedoresMouseClicked
        frmProveedores pv = new frmProveedores();
        pv.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblProveedoresMouseClicked

    private void lblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProductosMouseClicked
        frmProductos pd = new frmProductos();
        pd.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblProductosMouseClicked
    
    private void lblProductosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProductosMouseEntered

    }//GEN-LAST:event_lblProductosMouseEntered

    private void lblVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVentasMouseClicked
        try {
            frmVentas vt = new frmVentas();
            vt.setVisible(true);
            this.setVisible(false);
        } catch (ErrorTienda ex) {
            Logger.getLogger(frmComprasDetalle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblVentasMouseClicked

    private void lblMenuCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMenuCerrarMouseClicked
        if(estadoMenu==true){
            Animacion.Animacion.subir(0, -360, 1, 2, jpnMenu);
            estadoMenu=false;
        }
    }//GEN-LAST:event_lblMenuCerrarMouseClicked

    private void lblParametroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblParametroMouseClicked
        frmParametroModificar pt = new frmParametroModificar();
        pt.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblParametroMouseClicked

    private void lblComprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblComprasMouseClicked
        frmCompras cm = new frmCompras();
        cm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblComprasMouseClicked

    private void jpnMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnMenuMouseExited

    }//GEN-LAST:event_jpnMenuMouseExited

    private void btnDetallesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDetallesMouseExited
        btnDetalles.setIcon(new ImageIcon(getClass().getResource("/iconos/botones/detalles2.png")));
    }//GEN-LAST:event_btnDetallesMouseExited

    private void btnDetallesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDetallesMouseEntered
        btnDetalles.setIcon(new ImageIcon(getClass().getResource("/iconos/botones/detalles2B.png")));
    }//GEN-LAST:event_btnDetallesMouseEntered

    private void btnDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetallesActionPerformed
        if(tblCompras.getSelectedRow()!=-1){
            
            this.hide();
            frmComprasDetalladas2.show();
            frmComprasDetalladas2.setLocation(this.getLocation());
            limpiar();
            seleccion=tblCompras.getSelectedRow();
            
            if ((tblCompras.getValueAt(seleccion, 4).toString()).equals("F")) {
                    
                    System.out.println(Integer.parseInt(tblCompras.getValueAt(seleccion, 0).toString()));
                    txtIdCompra.setText(tblCompras.getValueAt(seleccion, 0).toString());
                    txtFecha.setText((tblCompras.getValueAt(seleccion, 4).toString()));
                    txtSucursal.setText((tblCompras.getValueAt(seleccion, 1).toString()));
                    txtTipoCompra.setText("Factura");
                    
                    estableciendoDatos(Integer.parseInt(tblCompras.getValueAt(seleccion, 0).toString()));
                    SumarSubTotales();
                    lblSumas.setVisible(false);
                    txtSumas.setVisible(false);
                    lblIVA.setVisible(false);
                    txtIVA.setVisible(false);
                    txtTotalCompra.setText(""+decimal.format(subTotales));
                  
                
            }else{
                txtIdCompra.setText(tblCompras.getValueAt(seleccion, 0).toString());
                txtFecha.setText((tblCompras.getValueAt(seleccion, 4).toString()));
                txtSucursal.setText((tblCompras.getValueAt(seleccion, 1).toString()));
                txtTipoCompra.setText("Crédito Fiscal");
                
                estableciendoDatos(Integer.parseInt(tblCompras.getValueAt(seleccion, 0).toString()));
                SumarSubTotales();
                
                txtSumas.setText(""+decimal.format(subTotales));
                double iva=subTotales*0.13;
                txtIVA.setText(""+decimal.format(iva));
                double total=iva+subTotales;
                txtTotalCompra.setText(""+decimal.format(total));
            }
            
            
            
            
            
        }else{
            JOptionPane.showMessageDialog(null, "No ha seleccionado en la tabla");
        }
    }//GEN-LAST:event_btnDetallesActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        
        SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");

        String fecha=sd.format(jdcFecha.getDate());

        DefaultTableModel modeloDetalles = new DefaultTableModel();
        ArrayList<Compra> compras = new ArrayList();
        Object[] fila = new Object[5];

        if (fecha.equals("")) {
            JOptionPane.showMessageDialog(null, "No ha seleccionado una fecha");
        }else{
            String[] campos = {"IdCompra", "Sucursal", "ID Proveedor", "Tipo de Compra","Fecha"};
            modeloDetalles.setColumnIdentifiers(campos);
            try {

                compras=ControladorCompra.obteniendoCompras(fecha);
                Object x ;
                Iterator iterador=compras.iterator();
                while (iterador.hasNext()) {
                    fila[0]=iterador.next();
                    fila[1]=iterador.next();
                    fila[2]=iterador.next();
                    x=iterador.next();
                    if (x.equals("F")) {
                        fila[3]="Factura";
                    }else if(x.equals("C")){
                        fila[3]="Crédito Fiscal";
                    }else{
                        fila[3]="Libre";
                    }
                    fila[4]=iterador.next();

                    modeloDetalles.addRow(fila);
                    tblCompras.setModel(modeloDetalles);
                }

            } catch (ErrorTienda ex) {
                Logger.getLogger(frmVentasDetalle.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtIdCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdCompraActionPerformed

    private void txtTipoCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoCompraActionPerformed

    private void txtSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSucursalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSucursalActionPerformed

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

    private void btnAtras1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtras1MouseClicked
        frmComprasDetalladas2.dispose();
        this.show();
    }//GEN-LAST:event_btnAtras1MouseClicked

    private void jpnBarraSuperior1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnBarraSuperior1MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_jpnBarraSuperior1MouseDragged

    private void jpnBarraSuperior1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnBarraSuperior1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jpnBarraSuperior1MousePressed

    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked
        frmHome home = new frmHome();
        home.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_homeMouseClicked

    private void lblBotonCerrar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBotonCerrar2MouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblBotonCerrar2MouseClicked

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
            java.util.logging.Logger.getLogger(frmComprasDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmComprasDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmComprasDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmComprasDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmComprasDetalle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAtras1;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDetalles;
    private javax.swing.JFrame frmComprasDetalladas2;
    private javax.swing.JLabel home;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private com.toedter.calendar.JDateChooser jdcFecha;
    private javax.swing.JPanel jpnAgregarCompra;
    private javax.swing.JPanel jpnAgregarCompra1;
    private javax.swing.JPanel jpnBarraSuperior;
    private javax.swing.JPanel jpnBarraSuperior1;
    private javax.swing.JPanel jpnMenu;
    private javax.swing.JLabel lblBotonCerrar;
    private javax.swing.JLabel lblBotonCerrar1;
    public static javax.swing.JLabel lblBotonCerrar2;
    private javax.swing.JLabel lblCompras;
    private javax.swing.JLabel lblIVA;
    private javax.swing.JLabel lblLogo1;
    private javax.swing.JLabel lblMenuCerrar;
    private javax.swing.JLabel lblParametro;
    private javax.swing.JLabel lblProductos;
    private javax.swing.JLabel lblProveedores;
    private javax.swing.JLabel lblSucursales;
    private javax.swing.JLabel lblSumas;
    private javax.swing.JLabel lblVentas;
    private javax.swing.JTable tblCompras;
    public javax.swing.JTable tblComprasDetalladas;
    public javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtIVA;
    public javax.swing.JTextField txtIdCompra;
    public javax.swing.JTextField txtSucursal;
    private javax.swing.JTextField txtSumas;
    public javax.swing.JTextField txtTipoCompra;
    private javax.swing.JTextField txtTotalCompra;
    // End of variables declaration//GEN-END:variables
}
