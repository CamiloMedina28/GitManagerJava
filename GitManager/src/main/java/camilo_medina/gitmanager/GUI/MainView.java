/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package camilo_medina.gitmanager.GUI;
import camilo_medina.gitmanager.execCommand.SelectDir;
import camilo_medina.gitmanager.DBAdmin.LeerComandos;
import camilo_medina.gitmanager.DBAdmin.ParametroInvalidoException;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Camilo Medina
 */
public class MainView extends javax.swing.JFrame {
    
    public MainView() {
        initComponents();
    }
    
    class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    class ButtonEditor extends DefaultCellEditor {
        protected JButton button;
        private String label;
        private boolean isPushed;
        private Object id;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                    EjecutarComando(id);
                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value,
                                                     boolean isSelected, int row, int column) {
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            id = table.getValueAt(row, 0);
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            isPushed = false;
            return label;
        }

        @Override
        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }

        @Override
        protected void fireEditingStopped() {
            super.fireEditingStopped();
        } 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Background = new javax.swing.JPanel();
        TitleBar = new javax.swing.JPanel();
        DirLabel = new javax.swing.JLabel();
        DirectorioPathLabel = new javax.swing.JLabel();
        ContentBar = new javax.swing.JPanel();
        EjecutarComandos = new javax.swing.JPanel();
        EjecutarComandosLabel = new javax.swing.JLabel();
        IdComandoLabelTitulo = new javax.swing.JLabel();
        IdComandoValueLabel = new javax.swing.JLabel();
        NombreComandoLabelTitulo = new javax.swing.JLabel();
        NombreComandoValueLabel = new javax.swing.JLabel();
        VistaGrafica = new javax.swing.JPanel();
        VistaGraficaLabel = new javax.swing.JLabel();
        Informacion = new javax.swing.JPanel();
        InfoLabel = new javax.swing.JLabel();
        PanelComandos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        SideBar = new javax.swing.JPanel();
        Titulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        BotonVerComandos = new javax.swing.JButton();
        SeleccionarDirectorioBoton = new javax.swing.JButton();
        BotonVistaGrafica = new javax.swing.JButton();
        Info = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        TitleBar.setBackground(new java.awt.Color(255, 255, 255));

        DirLabel.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        DirLabel.setForeground(new java.awt.Color(0, 0, 0));
        DirLabel.setText("Directorio:");

        DirectorioPathLabel.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        DirectorioPathLabel.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout TitleBarLayout = new javax.swing.GroupLayout(TitleBar);
        TitleBar.setLayout(TitleBarLayout);
        TitleBarLayout.setHorizontalGroup(
            TitleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TitleBarLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(DirLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DirectorioPathLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 778, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TitleBarLayout.setVerticalGroup(
            TitleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TitleBarLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(TitleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DirectorioPathLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DirLabel))
                .addContainerGap(98, Short.MAX_VALUE))
        );

        ContentBar.setBackground(new java.awt.Color(239, 240, 246));
        ContentBar.setPreferredSize(new java.awt.Dimension(1230, 620));
        ContentBar.setLayout(new java.awt.CardLayout());

        EjecutarComandos.setBackground(new java.awt.Color(239, 240, 246));

        EjecutarComandosLabel.setText("Ejecutar comandos");

        IdComandoLabelTitulo.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        IdComandoLabelTitulo.setForeground(new java.awt.Color(0, 0, 0));
        IdComandoLabelTitulo.setText("id del comando: ");

        NombreComandoLabelTitulo.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        NombreComandoLabelTitulo.setForeground(new java.awt.Color(0, 0, 0));
        NombreComandoLabelTitulo.setText("Nombre del comando: ");

        javax.swing.GroupLayout EjecutarComandosLayout = new javax.swing.GroupLayout(EjecutarComandos);
        EjecutarComandos.setLayout(EjecutarComandosLayout);
        EjecutarComandosLayout.setHorizontalGroup(
            EjecutarComandosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EjecutarComandosLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(EjecutarComandosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EjecutarComandosLabel)
                    .addGroup(EjecutarComandosLayout.createSequentialGroup()
                        .addComponent(IdComandoLabelTitulo)
                        .addGap(18, 18, 18)
                        .addComponent(IdComandoValueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(EjecutarComandosLayout.createSequentialGroup()
                        .addComponent(NombreComandoLabelTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NombreComandoValueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        EjecutarComandosLayout.setVerticalGroup(
            EjecutarComandosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EjecutarComandosLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(EjecutarComandosLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(EjecutarComandosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IdComandoLabelTitulo)
                    .addComponent(IdComandoValueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(EjecutarComandosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombreComandoLabelTitulo)
                    .addComponent(NombreComandoValueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(704, Short.MAX_VALUE))
        );

        ContentBar.add(EjecutarComandos, "card3");

        VistaGrafica.setBackground(new java.awt.Color(239, 240, 246));

        VistaGraficaLabel.setText("Vista Gráfica");

        javax.swing.GroupLayout VistaGraficaLayout = new javax.swing.GroupLayout(VistaGrafica);
        VistaGrafica.setLayout(VistaGraficaLayout);
        VistaGraficaLayout.setHorizontalGroup(
            VistaGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VistaGraficaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(VistaGraficaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(905, Short.MAX_VALUE))
        );
        VistaGraficaLayout.setVerticalGroup(
            VistaGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VistaGraficaLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(VistaGraficaLabel)
                .addContainerGap(768, Short.MAX_VALUE))
        );

        ContentBar.add(VistaGrafica, "card4");

        Informacion.setBackground(new java.awt.Color(239, 240, 246));

        InfoLabel.setText("Información");

        javax.swing.GroupLayout InformacionLayout = new javax.swing.GroupLayout(Informacion);
        Informacion.setLayout(InformacionLayout);
        InformacionLayout.setHorizontalGroup(
            InformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InformacionLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(InfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(862, Short.MAX_VALUE))
        );
        InformacionLayout.setVerticalGroup(
            InformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InformacionLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(InfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(741, Short.MAX_VALUE))
        );

        ContentBar.add(Informacion, "card5");

        PanelComandos.setBackground(new java.awt.Color(239, 240, 246));
        PanelComandos.setForeground(new java.awt.Color(0, 0, 0));

        jLabel1.setText("Comandos disponibles");

        Tabla.setBackground(new java.awt.Color(239, 240, 246));
        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Descripción", "Sintaxis", "Ejecutar"
            }
        ));
        Tabla.setGridColor(new java.awt.Color(239, 240, 246));
        jScrollPane1.setViewportView(Tabla);

        javax.swing.GroupLayout PanelComandosLayout = new javax.swing.GroupLayout(PanelComandos);
        PanelComandos.setLayout(PanelComandosLayout);
        PanelComandosLayout.setHorizontalGroup(
            PanelComandosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelComandosLayout.createSequentialGroup()
                .addGroup(PanelComandosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelComandosLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelComandosLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 929, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        PanelComandosLayout.setVerticalGroup(
            PanelComandosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelComandosLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
                .addContainerGap())
        );

        ContentBar.add(PanelComandos, "card2");
        PanelComandos.setVisible(false);

        SideBar.setBackground(new java.awt.Color(0, 97, 247));

        Titulo.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        Titulo.setText("Administrador de GIT gráfico");

        jSeparator1.setBackground(new java.awt.Color(239, 240, 246));
        jSeparator1.setForeground(new java.awt.Color(239, 240, 246));

        BotonVerComandos.setBackground(new java.awt.Color(0, 97, 247));
        BotonVerComandos.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        BotonVerComandos.setForeground(new java.awt.Color(255, 255, 255));
        BotonVerComandos.setText("Ver Comandos");
        BotonVerComandos.setBorder(null);
        BotonVerComandos.setContentAreaFilled(false);
        BotonVerComandos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonVerComandosMouseClicked(evt);
            }
        });
        BotonVerComandos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonVerComandosActionPerformed(evt);
            }
        });

        SeleccionarDirectorioBoton.setBackground(new java.awt.Color(0, 97, 247));
        SeleccionarDirectorioBoton.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        SeleccionarDirectorioBoton.setForeground(new java.awt.Color(255, 255, 255));
        SeleccionarDirectorioBoton.setText("Seleccionar Directorio");
        SeleccionarDirectorioBoton.setBorder(null);
        SeleccionarDirectorioBoton.setContentAreaFilled(false);
        SeleccionarDirectorioBoton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SeleccionarDirectorioBotonMouseClicked(evt);
            }
        });

        BotonVistaGrafica.setBackground(new java.awt.Color(0, 97, 247));
        BotonVistaGrafica.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        BotonVistaGrafica.setForeground(new java.awt.Color(255, 255, 255));
        BotonVistaGrafica.setText("Vista Gráfica");
        BotonVistaGrafica.setToolTipText("");
        BotonVistaGrafica.setBorder(null);
        BotonVistaGrafica.setContentAreaFilled(false);
        BotonVistaGrafica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonVistaGraficaActionPerformed(evt);
            }
        });

        Info.setBackground(new java.awt.Color(0, 97, 247));
        Info.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        Info.setForeground(new java.awt.Color(255, 255, 255));
        Info.setText("Información Adicional");
        Info.setBorder(null);
        Info.setContentAreaFilled(false);
        Info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SideBarLayout = new javax.swing.GroupLayout(SideBar);
        SideBar.setLayout(SideBarLayout);
        SideBarLayout.setHorizontalGroup(
            SideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SideBarLayout.createSequentialGroup()
                .addGroup(SideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SideBarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addComponent(BotonVerComandos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SeleccionarDirectorioBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(SideBarLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(Titulo)
                        .addGap(0, 27, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(BotonVistaGrafica, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Info, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        SideBarLayout.setVerticalGroup(
            SideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SideBarLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129)
                .addComponent(SeleccionarDirectorioBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BotonVerComandos, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(BotonVistaGrafica, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Info, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(549, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout BackgroundLayout = new javax.swing.GroupLayout(Background);
        Background.setLayout(BackgroundLayout);
        BackgroundLayout.setHorizontalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addComponent(SideBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(ContentBar, javax.swing.GroupLayout.PREFERRED_SIZE, 1020, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addComponent(TitleBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        BackgroundLayout.setVerticalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SideBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(ContentBar, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(TitleBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonVerComandosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonVerComandosMouseClicked
        if (SelectDir.getDirectorio() != null){
            DefaultTableModel modelo;
            LeerComandos Lector = new LeerComandos();
            modelo = (DefaultTableModel) Tabla.getModel();
            for (int j = 0; j < Tabla.getRowCount(); j++){
                modelo.removeRow(j);
                j -= 1;
            }
            try {
                String [][] comandos = Lector.ListarComandos();
                Object [] DatosFila = new Object[4];
                for(int i = 0; i < comandos.length; i++){
                    DatosFila[0] = comandos[i][0];
                    DatosFila[1] = comandos[i][1];
                    DatosFila[2] = comandos[i][2];
                    DatosFila[3] = "Ejecutar";
                    modelo.addRow(DatosFila);
                }
            } catch (ParametroInvalidoException ex) {
                System.out.println("Error" +
                    ex.getLocalizedMessage());
            }
            Tabla.setModel(modelo);
            Tabla.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer());
            Tabla.getColumnModel().getColumn(3).setCellEditor(new ButtonEditor(new JCheckBox()));
            ContentBar.removeAll();
            ContentBar.add(PanelComandos);
            ContentBar.repaint();
            ContentBar.revalidate();
        }else{
            JOptionPane.showMessageDialog(PanelComandos, 
     "Usted debe seleccionar un directorio antes de continuar.",
     "Seleccione un directorio", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BotonVerComandosMouseClicked

    private void SeleccionarDirectorioBotonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SeleccionarDirectorioBotonMouseClicked
        // TODO add your handling code here:
        SelectDir.seleccion();
        String DirPath = SelectDir.getDirectorio();
        DirectorioPathLabel.setText(DirPath);
    }//GEN-LAST:event_SeleccionarDirectorioBotonMouseClicked

    private void BotonVerComandosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonVerComandosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonVerComandosActionPerformed

    private void BotonVistaGraficaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonVistaGraficaActionPerformed
        if (SelectDir.getDirectorio() != null){
            ContentBar.removeAll();
            ContentBar.add(VistaGrafica);
            ContentBar.repaint();
            ContentBar.revalidate();
        }else{
            JOptionPane.showMessageDialog(PanelComandos, 
     "Usted debe seleccionar un directorio antes de continuar.",
     "Seleccione un directorio", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BotonVistaGraficaActionPerformed

    private void InfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InfoActionPerformed
        if (SelectDir.getDirectorio() != null){
            ContentBar.removeAll();
            ContentBar.add(Informacion);
            ContentBar.repaint();
            ContentBar.revalidate();
        }else{
            JOptionPane.showMessageDialog(PanelComandos, 
     "Usted debe seleccionar un directorio antes de continuar.",
     "Seleccione un directorio", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_InfoActionPerformed

    private void EjecutarComando(Object id) {
        IdComandoValueLabel.setText((String) id);
        System.out.println("Hola: " + id);
        
        
        ContentBar.removeAll();
        ContentBar.add(EjecutarComandos);
        ContentBar.repaint();
        ContentBar.revalidate();
    }
    
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
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JButton BotonVerComandos;
    private javax.swing.JButton BotonVistaGrafica;
    private javax.swing.JPanel ContentBar;
    private javax.swing.JLabel DirLabel;
    private javax.swing.JLabel DirectorioPathLabel;
    private javax.swing.JPanel EjecutarComandos;
    private javax.swing.JLabel EjecutarComandosLabel;
    private javax.swing.JLabel IdComandoLabelTitulo;
    private javax.swing.JLabel IdComandoValueLabel;
    private javax.swing.JButton Info;
    private javax.swing.JLabel InfoLabel;
    private javax.swing.JPanel Informacion;
    private javax.swing.JLabel NombreComandoLabelTitulo;
    private javax.swing.JLabel NombreComandoValueLabel;
    private javax.swing.JPanel PanelComandos;
    private javax.swing.JButton SeleccionarDirectorioBoton;
    private javax.swing.JPanel SideBar;
    private javax.swing.JTable Tabla;
    private javax.swing.JPanel TitleBar;
    private javax.swing.JLabel Titulo;
    private javax.swing.JPanel VistaGrafica;
    private javax.swing.JLabel VistaGraficaLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
