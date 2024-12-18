package Vista;

import Controlador.ControladorAlimento;
import Modelo.Alimento;
import java.awt.Color;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public final class FrmAlimento extends javax.swing.JFrame {

    DefaultTableModel dtm = new DefaultTableModel(); //tabla
    int id; //variable global id
    /**
     * Creates new form FrmAlimento
     */
    
    public FrmAlimento() {
        this.id = 0; //inicializo id en 0
        initComponents();
        estiloFrmAlimento();
        this.controlador = new ControladorAlimento(); //CONTROLADOR
        controlador.llenarTablaConListaAlimentos(dtm, tblTabla); // CARGO LA TABLA
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTabla = new javax.swing.JTable();
        lbTitulo = new javax.swing.JLabel();
        lbSeleccionar = new javax.swing.JLabel();
        lbNombre = new javax.swing.JLabel();
        lbPrecio = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));
        setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        setForeground(java.awt.Color.white);

        btnLimpiar.setFont(new java.awt.Font("SansSerif", 3, 12)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(26, 26, 29));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setToolTipText("");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        tblTabla = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int vColIndex){
                return false;
            }
        };
        tblTabla.setBackground(new java.awt.Color(102, 102, 102));
        tblTabla.setBorder(new javax.swing.border.MatteBorder(null));
        tblTabla.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tblTabla.setForeground(new java.awt.Color(255, 255, 255));
        tblTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblTabla.setToolTipText("");
        tblTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTabla);

        lbTitulo.setFont(new java.awt.Font("SansSerif", 3, 24)); // NOI18N
        lbTitulo.setForeground(new java.awt.Color(26, 26, 29));
        lbTitulo.setText("ALIMENTOS");

        lbSeleccionar.setFont(new java.awt.Font("SansSerif", 3, 18)); // NOI18N
        lbSeleccionar.setForeground(new java.awt.Color(26, 26, 29));
        lbSeleccionar.setText("Elija un alimento para modificar/eliminar");

        lbNombre.setFont(new java.awt.Font("SansSerif", 3, 12)); // NOI18N
        lbNombre.setForeground(new java.awt.Color(26, 26, 29));
        lbNombre.setText("Nombre:");

        lbPrecio.setFont(new java.awt.Font("SansSerif", 3, 12)); // NOI18N
        lbPrecio.setForeground(new java.awt.Color(26, 26, 29));
        lbPrecio.setText("Precio:");

        txtNombre.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        txtNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNombreMouseClicked(evt);
            }
        });

        txtPrecio.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N

        btnAgregar.setFont(new java.awt.Font("SansSerif", 3, 12)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(26, 26, 29));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("SansSerif", 3, 12)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(26, 26, 29));
        btnActualizar.setText("Modificar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("SansSerif", 3, 12)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(26, 26, 29));
        btnEliminar.setText("Borrar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnVolver.setFont(new java.awt.Font("SansSerif", 3, 12)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(26, 26, 29));
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbSeleccionar)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbTitulo)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbPrecio)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lbNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPrecio)
                                    .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(144, 144, 144))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lbTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbNombre)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbPrecio)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVolver, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(8, 8, 8)
                .addComponent(btnLimpiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbSeleccionar)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
     
    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        this.txtNombre.setText("");
        this.txtPrecio.setText("");
        id = 0;
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void tblTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTablaMouseClicked

        JTable target = (JTable) evt.getSource();
        id = (int) this.tblTabla.getModel().getValueAt(target.getSelectedRow(), 0); //pongo el numero del id en la variable global id
        this.txtNombre.setText(this.tblTabla.getModel().getValueAt(target.getSelectedRow(), 1).toString());
        this.txtPrecio.setText(this.tblTabla.getModel().getValueAt(target.getSelectedRow(), 2).toString());
    }//GEN-LAST:event_tblTablaMouseClicked

    private void txtNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreMouseClicked

    }//GEN-LAST:event_txtNombreMouseClicked

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String nombre;
        String precio;

        nombre = txtNombre.getText();
        precio = txtPrecio.getText();

        if (controlador.agregarAlimento(nombre, precio) == true) {
            dtm.setRowCount(0); //para evitar que se repitan los alimentos en la tabla al mostrarse, se vacia la tabla
            controlador.llenarTablaConListaAlimentos(dtm, tblTabla);
        }

        btnLimpiarActionPerformed(evt);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        String nombre;
        String precio;

        nombre = txtNombre.getText();
        precio = txtPrecio.getText();

        if (controlador.actualizarAlimento(id, nombre, precio) == true) {

            
            dtm.setRowCount(0);

            controlador.llenarTablaConListaAlimentos(dtm, tblTabla);

        }
        btnLimpiarActionPerformed(evt);
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        int i = 1;

        List<Alimento> listaAlimentos = controlador.listarAlimentos();
        for (Alimento alimento : listaAlimentos) {
            //System.out.println("valor de id q ya hay: " + tipotortilla.getId());
            if ((id) == alimento.getId()) { //si el id coincide con uno de los de la lista, lo borra, tiene que pasar el true
                if (controlador.borrarAlimento(id) == true) {
                    dtm.removeRow(i - 1); // aca lo borra
                    //System.out.println("entro al remove");
                }
            }
            i++;
        }

        btnLimpiarActionPerformed(evt);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void estiloFrmAlimento(){
        Color rosaClaro=new Color(202,202,202); 
        this.getContentPane().setBackground(rosaClaro);
        this.setResizable(false);
        /*tblTabla.setFont(new java.awt.Font("Sans Serif",0, 13));
        JTableHeader thAlimento;
        thAlimento = tblTabla.getTableHeader();
        thAlimento.setFont(new java.awt.Font("Sans Serif",0, 14)); */
    }
    
    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);
        this.dispose(); //para que se cierre la actual
    }//GEN-LAST:event_btnVolverActionPerformed

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
            java.util.logging.Logger.getLogger(FrmAlimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAlimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAlimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAlimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAlimento().setVisible(true);
            }
        });
        
        try {
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbPrecio;
    private javax.swing.JLabel lbSeleccionar;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JTable tblTabla;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
     private ControladorAlimento controlador;
}
