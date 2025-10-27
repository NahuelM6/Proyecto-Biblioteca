package proyecto;
//GM
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaMiembros extends JFrame {

    Borde borde = new Borde(2);
    Redondeador redondo = new Redondeador("");
    Main controlador = new Main();

    public VentanaMiembros() {

        this.setTitle("Miembros");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setResizable(false);

        Color crema = new Color(255, 240, 203);
        Color verde = new Color(1, 130, 114);

       
        JPanel panelarriba = new JPanel(new GridLayout(1, 3, 10, 10));
        panelarriba.setBackground(verde);
        panelarriba.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JLabel etiquetamiembros = new JLabel("Miembros");
        etiquetamiembros.setForeground(Color.WHITE);
        etiquetamiembros.setFont(new Font("Arial", Font.BOLD, 28));

        JButton volvermenu = new Redondeadorrojo("volver");
        volvermenu.setForeground(Color.WHITE);
        volvermenu.setFont(new Font("Arial", Font.BOLD, 14));

      

        panelarriba.add(etiquetamiembros);
    
        panelarriba.add(volvermenu);

        JPanel panelcentro = new JPanel(new BorderLayout());
        panelcentro.setBackground(crema);
        panelcentro.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 20));

        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        modelo.addColumn("CI");
        modelo.addColumn("Nombre");
        modelo.addColumn("Grupo");

        JTable tablaMiembros = new JTable(modelo);
        tablaMiembros.getTableHeader().setBackground(new Color(255, 230, 203));
        tablaMiembros.getTableHeader().setReorderingAllowed(false);
        tablaMiembros.setBackground(crema);
        tablaMiembros.setFont(new Font("Arial", Font.PLAIN, 14));

     
        
        
        JScrollPane scroll = new JScrollPane(tablaMiembros);
       
        scroll.getViewport().setBackground(new Color(255, 230, 203));

        panelcentro.add(scroll, BorderLayout.CENTER);

     
        JPanel panelabajo = new JPanel();
        panelabajo.setBackground(crema);
        panelabajo.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 15));
        panelabajo.setBorder(BorderFactory.createEmptyBorder(10, 10, 25, 10));

        JButton agregarMiembro = new Redondeador("Registrar");
        agregarMiembro.setForeground(Color.WHITE);
        agregarMiembro.setFont(new Font("Arial", Font.BOLD, 14));

        JButton eliminar = new Redondeadorrojo("Eliminar");
        eliminar.setForeground(Color.WHITE);
        eliminar.setFont(new Font("Arial", Font.BOLD, 14));

        panelabajo.add(agregarMiembro);
        panelabajo.add(eliminar);

 
        this.add(panelarriba, BorderLayout.NORTH);
        this.add(panelcentro, BorderLayout.CENTER);
        this.add(panelabajo, BorderLayout.SOUTH);

 
       

        eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int fila = tablaMiembros.getSelectedRow();
                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "Seleccione un miembro para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String ci = String.valueOf(tablaMiembros.getValueAt(fila, 0));
                int opcion = JOptionPane.showConfirmDialog(null, "Seguro que desea eliminar este miembro?", "Confirmar", JOptionPane.YES_NO_OPTION);
                if (opcion == JOptionPane.YES_OPTION) {
                    controlador.eliminarMiembro(ci);
                    controlador.actualizarMiembros(modelo);
                }
            }
        });

        agregarMiembro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField CI = new JTextField();
                JTextField Nombre = new JTextField();
                JTextField Grupo = new JTextField();

                Object[] mensaje = { "Cedula:", CI,"Nombre:", Nombre, "Grupo:", Grupo
                };

                int opcion = JOptionPane.showConfirmDialog(null, mensaje, "Registrar miembro", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                if (opcion == JOptionPane.OK_OPTION) {
                    try {
                        int ci = Integer.parseInt(CI.getText());
                        String nombre = Nombre.getText();
                        String grupo = Grupo.getText();

                        if (nombre.isEmpty() || grupo.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                       

                        controlador.registrarNuevoMiembro(ci, nombre, grupo);
                        controlador.actualizarMiembros(modelo);
                       

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Rellene todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        
        volvermenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.VentanaMenu();
                VentanaMiembros.this.dispose();
            }
        });


        controlador.actualizarMiembros(modelo);
    }
}
