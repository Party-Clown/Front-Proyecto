/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;

import APIS.HistorialPedidos;
import APIS.ItemsPedidos;
import APIS.Pedido;
import APIS.PedidoCliente;
import APIS.SesionUsuario;
import APIS.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
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
 private ItemsPedidos pedido;
 
    /**
     * Creates new form HistorialP
     */
    public HistorialP(HistorialPedidos historial) {
        initComponents();
        this.historiales= historial!=null?historial:new HistorialPedidos();
        this.cliente=new PedidoCliente();
        cargarHistorial();
        
        
    }

    // === MÉTODO DE ESCALADO AUTOMÁTICO ===
    
    public HistorialP(){
        initComponents();
        this.cliente=new PedidoCliente();
        this.historiales=new HistorialPedidos();
        this.pedido=pedido;
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
        javax.swing.JButton[] botones = { btnEditar, btnEliminar, btnTodos, BtnTerminar,btnRegresar };
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
    private void ajustarEscala() {
        int anchoVentana = Math.max(800, getWidth());
        int altoVentana = Math.max(600, getHeight());

        int altoBoton = Math.max(38, altoVentana / 18);
        int anchoBoton = Math.max(120, anchoVentana / 10);
        int anchoTxt = Math.max(240, anchoVentana / 4);

        java.awt.Dimension tamBoton = new java.awt.Dimension(anchoBoton, altoBoton);
        java.awt.Dimension tamTxt = new java.awt.Dimension(anchoTxt, altoBoton);

        javax.swing.JButton[] botones = { btnBuscar, btnEditar, btnEliminar, btnTodos, BtnTerminar,btnRegresar };
        for (javax.swing.JButton b : botones) {
            if (b != null) b.setPreferredSize(tamBoton);
        }

        if (txtID != null) {
            txtID.setPreferredSize(tamTxt);
        }

        jPanel1.revalidate();
        jPanel1.repaint();
    }
    
    public void cargarHistorial(){
        try {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{
           "N° Pedido", "Categoría", "Nombre", "Cantidad", "Precio Unitario", "Subtotal","Estado"
        });
           String correoActual=SesionUsuario.getNombreUsuario();
           List<Pedido> pedidos=cliente.listarTodosPedidos();
        // ✅ Ahora tomamos los pedidos desde la API
        List<Pedido> pedidosusuario = new ArrayList<>();

        for (Pedido pedido : pedidos) {
            int idPedido = pedido.getId();
            
            String nombreUsuario=pedido.getCorreoUsuario();
            for (ItemsPedidos item : pedido.getItems()) {
                model.addRow(new Object[]{
                    
                    idPedido,
                    item.getCategoria(),
                    item.getNombre(),
                    item.getCantidad(),
                    "$" + item.getPrecioUnitario(),
                    "$" + item.getSubtotal(),
                    item.getEstado(),
                        
                });
            }
        }

        tblHistorial.setModel(model);
        tblHistorial.revalidate();
        tblHistorial.repaint();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "❌ Error al cargar historial: " + e.getMessage());
        e.printStackTrace();
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
        BtnTerminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHistorial = new javax.swing.JTable();
        btnRegresar = new javax.swing.JButton();

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
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lupa.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        BtnTerminar.setText("Terminar");
        BtnTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTerminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnTerminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(BtnTerminar)
                .addGap(18, 18, 18)
                .addComponent(btnEditar)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar)
                .addGap(18, 18, 18)
                .addComponent(btnTodos)
                .addGap(61, 61, 61))
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

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/devolver (1).png"))); // NOI18N
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 13, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRegresar)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
         String texto = txtID.getText().trim();

    if (!texto.isEmpty()) {
        try {
            int id = Integer.parseInt(texto);

            // 🔹 Buscar el pedido por ID en el backend
            Pedido pedido = cliente.buscarPedidoPorId(id);

            // 🔹 Crear modelo con las mismas columnas del historial
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new Object[]{
                "N° Pedido", "Categoría", "Nombre", "Cantidad", "Precio Unitario", "Subtotal","Estado"
            });

            // 🔹 Si el pedido existe, agregar sus ítems
            if (pedido != null && pedido.getItems() != null) {
                for (ItemsPedidos item : pedido.getItems()) {
                    model.addRow(new Object[]{
                        pedido.getId(),
                        item.getCategoria(),
                        item.getNombre(),
                        item.getCantidad(),
                        "$" + item.getPrecioUnitario(),
                        "$" + item.getSubtotal(),
                        item.getEstado(),
                    });
                }
            } else {
                JOptionPane.showMessageDialog(this, "⚠️ No se encontró ningún pedido con ese ID.");
            }

            // 🔹 Mostrar en la tabla
            tblHistorial.setModel(model);
            tblHistorial.revalidate();
            tblHistorial.repaint();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "⚠️ El ID debe ser un número válido.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "⚠️ Error al buscar el pedido: " + e.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(this, "Por favor ingresa un ID de pedido.");
    }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        VeantanaGestion Vs=new VeantanaGestion();
        Vs.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarActionPerformed

    private void BtnTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTerminarActionPerformed
        // TODO add your handling code here:
      int fila = tblHistorial.getSelectedRow();
    if (fila == -1) {
        JOptionPane.showMessageDialog(this, "⚠️ Seleccione un pedido para terminar.");
        return;
    }

    int idPedido = Integer.parseInt(tblHistorial.getValueAt(fila, 0).toString());

    try {
        // 1️⃣ Cambiamos el estado del pedido a 'Terminado' en el backend
        cliente.actualizarEstadoPedido(idPedido, "Terminado");

        // 2️⃣ Obtenemos el pedido actualizado desde el backend
        Pedido pedidoTerminado = cliente.buscarPedidoPorId(idPedido);

        // 3️⃣ Eliminamos de la tabla actual (Historial)
        DefaultTableModel modelo = (DefaultTableModel) tblHistorial.getModel();
        modelo.removeRow(fila);

        // 4️⃣ Lo enviamos a la tabla de terminados
        VentanaPedidosTermi ventanaTermi = new VentanaPedidosTermi(pedidoTerminado,this);
        ventanaTermi.setVisible(true);
        ventanaTermi.setLocationRelativeTo(null);

        JOptionPane.showMessageDialog(this, "✅ Pedido terminado correctamente.");

    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "❌ Error al actualizar el estado: " + e.getMessage());
        e.printStackTrace();
    }
   
    }//GEN-LAST:event_BtnTerminarActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnTerminar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnTodos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblHistorial;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}
