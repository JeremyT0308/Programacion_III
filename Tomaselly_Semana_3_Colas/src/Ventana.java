import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel principal;
    private JTabbedPane tabbedPane1;
    private JTextField txtPlaca;
    private JTextField txtModelo;
    private JComboBox cmbMarca;
    private JSpinner spiAnio;
    private JButton btnLimpiar;
    private JButton btnAgregar;
    private JTextArea txtListado;
    private JButton btnListar;
    private JButton btnPagar;
    private JLabel lblResultado;
    ColaAutos cola = new ColaAutos();

    public Ventana() {

        spiAnio.setModel(new SpinnerNumberModel(2000, 1950, 2026, 1));
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtPlaca.setText("");
                txtModelo.setText("");
                cmbMarca.setSelectedIndex(0);
            }
        });
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String placa = txtPlaca.getText();
                String marca = cmbMarca.getSelectedItem().toString();
                String modelo = txtModelo.getText();
                int anio = Integer.parseInt(spiAnio.getValue().toString());
                Auto auto = new Auto(placa, marca, modelo, anio);
                cola.encolar(auto);
                JOptionPane.showMessageDialog(null, "se agregó un auto "+auto.toString()+ " a la cola");
            }
        });

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtListado.setText(cola.toString());
            }
        });

        btnPagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    Auto auto = cola.desencolar();
                    txtListado.setText(cola.toString());
                    float valor;
                    if (auto.getAnio() >= 2000){
                        valor = 50.25f;
                    }else {
                        valor = 100.50f;
                    }
                    lblResultado.setText(auto.toString()+" pago: "+valor);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
