package proyecto;
//GM
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.time.LocalDate;
import java.awt.event.ActionListener;
public class VentanaPrestamo extends JFrame {

    Borde borde = new Borde(2);
    Redondeador redondo = new Redondeador("");
    Main controlador = new Main();

    public VentanaPrestamo() {
        setTitle("Préstamos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);

        Color crema = new Color(255, 240, 203);
        Color verde = new Color(1, 130, 114);

        JPanel panelfondo = new JPanel(new BorderLayout());
        panelfondo.setBackground(crema);

      
        JPanel panelarriba = new JPanel(new GridLayout(1, 3, 10, 10));
        panelarriba.setBackground(verde);
        panelarriba.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

        JLabel etiquetamenu = new JLabel("Prestamos", SwingConstants.CENTER);
        etiquetamenu.setFont(new Font("Arial", Font.BOLD, 16));
        etiquetamenu.setForeground(Color.WHITE);

        JButton botonvolver = new Redondeadorrojo("Volver");
        botonvolver.setForeground(Color.WHITE);
        botonvolver.setFont(new Font("Arial", Font.BOLD, 14));
        botonvolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.VentanaMenu();
                VentanaPrestamo.this.dispose();
            }
        });


        panelarriba.add(etiquetamenu);
        panelarriba.add(new JLabel()); // espacio
        panelarriba.add(botonvolver);

    
        JTabbedPane pestañas = new JTabbedPane();
        pestañas.setBackground(new Color(255, 230, 203));

       
        JPanel panelLibros = new JPanel(new GridLayout(7, 2, 20, 20));
        panelLibros.setBackground(new Color(255, 230, 203));

        JLabel ciLabel = new JLabel("CI del Estudiante", SwingConstants.CENTER);
        JTextField txtCI = new JTextField(7);
        JLabel isbnLabel = new JLabel("ISBN del Libro", SwingConstants.CENTER);
        JTextField txtISBN = new JTextField(7);

        panelLibros.add(ciLabel);
        panelLibros.add(txtCI);
        panelLibros.add(isbnLabel);
        panelLibros.add(txtISBN);

      
        JPanel panelLaptops = new JPanel(new GridLayout(7, 2, 20, 20));
        panelLaptops.setBackground(new Color(255, 230, 203));

        JLabel lblCI = new JLabel("CI del Estudiante", SwingConstants.CENTER);
        JTextField txtCI1 = new JTextField(7);
        JLabel IDLa = new JLabel("ID de la Laptop", SwingConstants.CENTER);
        JTextField txtIDLa = new JTextField(7);

        panelLaptops.add(lblCI);
        panelLaptops.add(txtCI1);
        panelLaptops.add(IDLa);
        panelLaptops.add(txtIDLa);

        pestañas.addTab("Libros", panelLibros);
        pestañas.addTab("Laptops", panelLaptops);

        
        JPanel panelabajo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelabajo.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        panelabajo.setBackground(crema);

        JButton realizarP = new Redondeador("Realizar Prestamo");
        realizarP.setForeground(Color.WHITE);
        realizarP.setFont(new Font("Arial", Font.BOLD, 14));

        panelabajo.add(realizarP);
      
        realizarP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int fila = pestañas.getSelectedIndex(); // 0 = Libros  1 = Laptops
                    LocalDate hoy = LocalDate.now();
                    LocalDate devolucion = hoy.plusDays(7);

                    if (fila== 0) {
                       
                        int ci = Integer.parseInt(txtCI.getText().trim());
                        String isbn = txtISBN.getText().trim();

                        if (isbn.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Ingrese el ISBN del libro.");
                            return;
                        }

                        controlador.realizarPrestamoLibro(ci, isbn, Date.valueOf(hoy), Date.valueOf(devolucion));
                        JOptionPane.showMessageDialog(null, "se realizo el prestamo del libro");

                    } else if (fila == 1) {
                       
                        int ci = Integer.parseInt(txtCI1.getText().trim());
                        int idLaptop = Integer.parseInt(txtIDLa.getText().trim());

                        controlador.realizarprestamolaptop(ci, idLaptop, "N/A", String.valueOf(hoy), String.valueOf(devolucion));
                        JOptionPane.showMessageDialog(null, "Se realizo el prestamo de la laptop");
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Rellene todos los campos");
                } 
            }
        });


      
        panelfondo.add(panelarriba, BorderLayout.NORTH);
        panelfondo.add(pestañas, BorderLayout.CENTER);
        panelfondo.add(panelabajo, BorderLayout.SOUTH);

        add(panelfondo);
        setVisible(true);
    }
}
