import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JTabbedPane principal;
    private JPanel panel1;
    private JPanel agregar;
    private JPanel ordenar;
    private JList lstAgregar;
    private JTextField txtNombre;
    private JSpinner spnId;
    private JButton btnAgregarProducto;
    private JLabel lblNombre;
    private JTextField txtPrecio;
    private JLabel lblPrecio;
    private JList lstOrdenar;
    private JButton btnOrdenIDd;
    private JTextField txtNombreO;
    private JTextField txtIdO;
    private JButton btnBuscar;
    private JLabel lblNombreO;
    private JLabel lblIdO;
    private JTextArea txtBuscarO;
    private JButton btnOrdenPrecio;

    private InventarioProductos miInventario = new InventarioProductos();

    public void llenarJList(){
        DefaultListModel dlm = new DefaultListModel();
        for(Producto producto : miInventario.getInventario()){
            dlm.addElement(producto.toString());
        }
        lstAgregar.setModel(dlm);
        lstOrdenar.setModel(dlm);
    }
    public void vaciarJList(){
        lstOrdenar.setModel(new DefaultListModel());
    }

    public Ventana() {
        llenarJList();
        btnAgregarProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombre = txtNombre.getText();
                    int id = Integer.parseInt(spnId.getValue().toString());
                    if (miInventario.idExiste(id)) {
                        JOptionPane.showMessageDialog(null, "Ya existe un producto con ese id");
                        return;
                    }
                    double precio = Double.parseDouble(txtPrecio.getText());
                    Producto p = new Producto(id, nombre, precio);
                    miInventario.agregar(p);
                    llenarJList();
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "No se puede ingresar el nombre, id o precio del producto");
                }

            }
        });
        btnOrdenIDd.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                miInventario.ordenarID();
                llenarJList();

            }
        });
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idText = txtIdO.getText().trim();
                String nombre = txtNombreO.getText().trim();

                txtBuscarO.setText("");

                if (!idText.isEmpty() && nombre.isEmpty()) {
                    try {
                        int id = Integer.parseInt(idText);

                        miInventario.ordenarID();
                        Producto productoEncontrado = miInventario.buscar(id);

                        if (productoEncontrado != null) {
                            txtBuscarO.append("Búsqueda por ID (Binaria):\n");
                            txtBuscarO.append(productoEncontrado.toString());
                        } else {
                            JOptionPane.showMessageDialog(null, "No existe un producto con el ID: " + id);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Error: El ID debe ser un número entero válido.");
                    }

                } else if (idText.isEmpty() && !nombre.isEmpty()) {

                    Producto productoEncontrado = miInventario.buscarPorNombre(nombre);

                    if (productoEncontrado != null) {
                        txtBuscarO.append("Búsqueda por Nombre (Lineal):\n");
                        txtBuscarO.append(productoEncontrado.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "No existe un producto con el nombre: '" + nombre + "'");
                    }

                } else {
                    JOptionPane.showMessageDialog(null,
                            "Error: Por favor, ingrese un valor SOLO en el campo ID O SOLO en el campo Nombre.");
                }


            }
        });


        btnOrdenPrecio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                miInventario.ordenarPrecio();
                llenarJList();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
