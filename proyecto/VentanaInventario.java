package proyecto;
//GM 
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaInventario extends JFrame {

    Borde borde = new Borde(2);
    Redondeador redondo = new Redondeador("");
    Main controlador = new Main();

    public VentanaInventario() {

        
        this.setTitle("Inventario");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setResizable(false);

      
        Color crema = new Color(255, 240, 203);
        Color verde = new Color(1, 130, 114);

       
        JPanel panelfondo = new JPanel(new BorderLayout());
        panelfondo.setBackground(Color.BLACK);

       
        JPanel panelarriba = new JPanel(new GridLayout(1, 6));
        panelarriba.setBackground(verde);
        panelarriba.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

        JLabel lblinv = new JLabel("Inventario");
        lblinv.setForeground(Color.WHITE);
        lblinv.setFont(new Font("Arial", Font.BOLD, 32));

        JButton botonvolver = new Redondeadorrojo("Volver");
        botonvolver.setForeground(Color.WHITE);
        botonvolver.setFont(new Font("Arial", Font.BOLD, 14));

        panelarriba.add(lblinv);
        panelarriba.add(new JLabel()); // espacio
        panelarriba.add(new JLabel());
        panelarriba.add(new JLabel());
        panelarriba.add(botonvolver);

        
        JPanel panelcentro = new JPanel(new BorderLayout());
        panelcentro.setBackground(crema);
        panelcentro.setBorder(BorderFactory.createEmptyBorder(20, 10, 0, 10));

        
        JPanel panelbotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelbotones.setBackground(crema);
        panelbotones.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

       
        JButton agregar1 = new Redondeador("Agregar libro/laptop");
        agregar1.setBackground(new Color(0, 128, 128));
        agregar1.setForeground(Color.WHITE);
        JButton modificar1 = new Redondeador("Modificar libro");
        modificar1.setBackground(new Color(0, 153, 153));
        modificar1.setForeground(Color.WHITE);
        JButton eliminar1 = new Redondeadorrojo("Eliminar libro/laptop");
        eliminar1.setBackground(new Color(165, 42, 42));
        eliminar1.setForeground(Color.WHITE);
        
       
       

        panelbotones.add(agregar1);
        panelbotones.add(modificar1);
        panelbotones.add(eliminar1);

       
        DefaultTableModel modeloLib = new DefaultTableModel() {
            @Override public boolean isCellEditable(int row, int column) { return false; }
        };
        modeloLib.addColumn("Título");
        modeloLib.addColumn("Autor");
        modeloLib.addColumn("Año");
        modeloLib.addColumn("Tipo");
        modeloLib.addColumn("Género");
        modeloLib.addColumn("ISBN");
        JTable tablainventarioLib = new JTable(modeloLib);
        tablainventarioLib.getTableHeader().setReorderingAllowed(false);
        JScrollPane scrollLib = new JScrollPane(tablainventarioLib);
        tablainventarioLib.setBackground(null);
        tablainventarioLib.setBackground(crema);

        DefaultTableModel modeloLap = new DefaultTableModel() {
            @Override public boolean isCellEditable(int row, int column) { return false; }
        };
        modeloLap.addColumn("Número de serie");
        modeloLap.addColumn("ID");

        JTable tablainventarioLap = new JTable(modeloLap);
        tablainventarioLap.getTableHeader().setReorderingAllowed(false);
        JScrollPane scrollLap = new JScrollPane(tablainventarioLap);

      
        JTabbedPane pestañas = new JTabbedPane();
        pestañas.addTab("Libros", scrollLib);
        pestañas.addTab("Laptops", scrollLap);
        
        //visual Tabla libros
        
        
        pestañas.setBackground(null);
pestañas.setBackground(crema);
scrollLib.getViewport().setBackground(crema);
tablainventarioLib.setBackground(crema);



tablainventarioLib.setBackground(crema);
tablainventarioLib.getTableHeader().setBackground(new Color(255, 230, 203));
tablainventarioLib.getTableHeader().setReorderingAllowed(false);
scrollLib.getViewport().setBackground(new Color(255, 230, 203));



//visual tabla laptop

scrollLap.getViewport().setBackground(crema);
tablainventarioLap.setBackground(crema);
scrollLap.getViewport().setBackground(crema);
tablainventarioLap.setBackground(crema);

tablainventarioLap.setBackground(crema);
tablainventarioLap.getTableHeader().setBackground(new Color(255, 230, 203));
tablainventarioLap.getTableHeader().setReorderingAllowed(false);
scrollLap.getViewport().setBackground(new Color(255, 230, 203));
tablainventarioLap.setBackground(null);
tablainventarioLap.setBackground(crema);
tablainventarioLap.setOpaque(false);


scrollLap.setOpaque(false);



pestañas.setUI(new javax.swing.plaf.basic.BasicTabbedPaneUI() {
	 @Override
    protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {
        // no dibuja el borde del contenido
    }  
});
        panelcentro.add(pestañas, BorderLayout.CENTER);

        
        
        
        
        
        
        
        
        agregar1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.AltaLibro();
                VentanaInventario.this.dispose();
            }
        });
        
        
        
        
        
        

        modificar1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.ModificarInventario();
                VentanaInventario.this.dispose();
            }
        });
        
        
        
        
        
        
        
        
        
        

        botonvolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.VentanaMenu();
                VentanaInventario.this.dispose();
            }
        });
        
        


        eliminar1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int pestaña = pestañas.getSelectedIndex();

                if (pestaña == 0) {
                    
                    int fila = tablainventarioLib.getSelectedRow();
                    if (fila == -1) {
                        JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    String isbn = String.valueOf(tablainventarioLib.getValueAt(fila, 5));

                    int op = JOptionPane.showConfirmDialog(null,
                            "¿Eliminar libro? ",
                            "Eliminar",
                            JOptionPane.YES_NO_OPTION);

                    if (op == JOptionPane.YES_OPTION) {
                        controlador.eliminarinventarioLib(isbn);
                        controlador.actualizarInventariolibro(modeloLib);
                        JOptionPane.showMessageDialog(null, "Libro eliminado");
                    }

                } else {
                  
                    int fila = tablainventarioLap.getSelectedRow();
                    if (fila == -1) {
                        JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    
                    int id = Integer.parseInt(String.valueOf(tablainventarioLap.getValueAt(fila, 1)));

                    int op = JOptionPane.showConfirmDialog(null,
                            "Eliminar laptop del inventario?",
                            "Eliminar",
                            JOptionPane.YES_NO_OPTION);

                    if (op == JOptionPane.YES_OPTION) {
                        controlador.eliminarinventarioLap(id);
                        controlador.actualizarInventarioLaptop(modeloLap);
                        JOptionPane.showMessageDialog(null, "Laptop eliminada");
                    }
                }
            }
        });




       
        controlador.actualizarInventariolibro(modeloLib);
        controlador.actualizarInventarioLaptop(modeloLap);

     
        panelfondo.add(panelarriba, BorderLayout.NORTH);
        panelfondo.add(panelcentro, BorderLayout.CENTER);
        panelfondo.add(panelbotones, BorderLayout.SOUTH);
        this.add(panelfondo);
    }
}
