/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;

import APIS.HistorialPedidos;
import APIS.ItemsPedidos;
import APIS.Pedido;
import APIS.PedidoCliente;
import java.io.IOException;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Laura
 */
public class HistorialP extends javax.swing.JFrame {
 private HistorialPedidos historiales;
 private PedidoCliente cliente;
 
    /**
     * Creates new form HistorialP
     */
    public HistorialP(HistorialPedidos historial) {
        initComponents();
        this.historiales= historial!=null?historial:new HistorialPedidos();
        this.cliente=new PedidoCliente();
        cargarHistorial();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(true);
        setLocationRelativeTo(null);

        getContentPane().setLayout(new java.awt.BorderLayout());
        jPanel1.setLayout(new java.awt.BorderLayout());
        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(600, 0));
        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        javax.swing.JPanel panelBotones = new javax.swing.JPanel(new java.awt.GridBagLayout());
        panelBotones.setOpaque(false);

        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
        gbc.insets = new java.awt.Insets(10, 10, 10, 10);
        gbc.gridy = 0;

        if (txtID == null) {
            txtID = new javax.swing.JTextField();
        }
        txtID.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 14));
        txtID.setPreferredSize(new java.awt.Dimension(300, 40));
        gbc.gridx = 0;
        gbc.weightx = 1.0;
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        panelBotones.add(txtID, gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.0;
        gbc.fill = java.awt.GridBagConstraints.NONE;
        panelBotones.add(btnBuscar, gbc);

        java.awt.Dimension tamBotonInicial = new java.awt.Dimension(160, 48);
        javax.swing.JButton[] botones = { btnEditar, btnEliminar, btnTodos, btnTodos1 };
        int col = 2;
        for (javax.swing.JButton b : botones) {
            b.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16));
            b.setPreferredSize(tamBotonInicial);
            b.setBackground(new java.awt.Color(70, 130, 180));
            b.setForeground(java.awt.Color.WHITE);
            b.setFocusPainted(false);

            gbc.gridx = col++;
            gbc.weightx = 0.0;
            gbc.fill = java.awt.GridBagConstraints.NONE;
            panelBotones.add(b, gbc);
        }

        jPanel1.add(panelBotones, java.awt.BorderLayout.SOUTH);

        addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                ajustarEscala();
            }
        });

        jPanel1.revalidate();
        jPanel1.repaint();
    }

    // === MÉTODO DE ESCALADO AUTOMÁTICO ===
    private void ajustarEscala() {
        int anchoVentana = Math.max(800, getWidth());
        int altoVentana = Math.max(600, getHeight());

        int altoBoton = Math.max(38, altoVentana / 18);
        int anchoBoton = Math.max(120, anchoVentana / 10);
        int anchoTxt = Math.max(240, anchoVentana / 4);

        java.awt.Dimension tamBoton = new java.awt.Dimension(anchoBoton, altoBoton);
        java.awt.Dimension tamTxt = new java.awt.Dimension(anchoTxt, altoBoton);

        javax.swing.JButton[] botones = { btnBuscar, btnEditar, btnEliminar, btnTodos, btnTodos1 };
        for (javax.swing.JButton b : botones) {
            if (b != null) b.setPreferredSize(tamBoton);
        }

        if (txtID != null) {
            txtID.setPreferredSize(tamTxt);
        }

        jPanel1.revalidate();
        jPanel1.repaint();
    }
    public HistorialP(){
        initComponents();
        this.cliente=new PedidoCliente();
        this.historiales=new HistorialPedidos();
        
        cargarHistorial();
        
    }
    
    private void cargarHistorial(){
        try{
            DefaultTableModel model=new DefaultTableModel();
            model.setColumnIdentifiers(new Object[]{"pedido N","categorias","nombre","cantidad","precio Unitario","subtotal"});
            
            List<List<ItemsPedidos>> historial=historiales.getHistorial();
            int numPedido = 1;
            for(List<ItemsPedidos>pedido:historial){
                for(ItemsPedidos item:pedido){
                    model.addRow(new Object[]{
                        numPedido,
                        item.getCategoria(),
                        item.getNombre(),
                        item.getCantidad(),
                        "$" +item.getPrecioUnitario(),
                        "$" + item.getSubtotal()
                    });
                }
               
            }
            tblHistorial.setModel(model);
            tblHistorial.revalidate();
            tblHistorial.repaint();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "erroe al cargar historial");
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

        jPanel1 = new javax.swing.JPanel();
        btnTodos = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnTodos1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHistorial = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnTodos.setText("Todos");
        btnTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodosActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lupa.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnTodos1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/devolver (1).png"))); // NOI18N
        btnTodos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodos1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnEditar, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addGap(39, 39, 39))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(btnTodos1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEditar)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar)
                .addGap(18, 18, 18)
                .addComponent(btnTodos)
                .addGap(18, 18, 18)
                .addComponent(btnTodos1)
                .addGap(20, 20, 20))
        );

        tblHistorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblHistorial);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 13, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodosActionPerformed
        // TODO add your handling code here:
         cargarHistorial();
    }//GEN-LAST:event_btnTodosActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
         try{
          int fila = tblHistorial.getSelectedRow();
    if (fila == -1) {
      JOptionPane.showMessageDialog(this,"fila no seleccionada,seleccione fila para eliminar");
    }

    int id = Integer.parseInt(tblHistorial.getValueAt(fila,0).toString());
    
    cliente.eliminarPedido(id);
    JOptionPane.showMessageDialog(this, "pedido eliminado.");
    cargarHistorial();
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
         String texto=txtID.getText();
        if(!texto.isEmpty()){
            try{
               int id=Integer.parseInt(texto);
               Pedido pedido=cliente.buscarPedidoPorId(id);
               DefaultTableModel model1=new DefaultTableModel();
               model1.setColumnIdentifiers(new String[]{"Id","Descripcion de pedido","Subtotal"});
               
               if(pedido!=null){
               model1.addRow(new Object[]{pedido.getId(),pedido.getItems(),pedido.getTotal()});
               
               
               }else{
                   JOptionPane.showMessageDialog(this,"Pedido no encontrado");
               }
               tblHistorial.setModel(model1);
            }catch(IOException e){
                JOptionPane.showMessageDialog(this, e);
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnTodos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodos1ActionPerformed
        // TODO add your handling code here:
        Carrito cr=new Carrito();
        cr.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnTodos1ActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnTodos;
    private javax.swing.JButton btnTodos1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblHistorial;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}
