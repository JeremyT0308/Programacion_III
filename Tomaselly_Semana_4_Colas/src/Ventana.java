import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

public class Ventana {
    private JButton btnRegistrar;
    private JTextArea txtListar;
    private JButton btnAtender;
    private JTextField txtNombre;
    private JSpinner splPrioridad;
    private JComboBox cboEnfermedad;
    private JPanel main;
    Clinica lista= new Clinica();

    public Ventana() {
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int p=Integer.parseInt(splPrioridad.getValue().toString());
                String nombre = txtNombre.getText();
                String enfermedad = cboEnfermedad.getSelectedItem().toString();
                Paciente enfermo = new Paciente(nombre, p, enfermedad);
                lista.encolar(enfermo);
                List<Paciente> resultado = lista.listPaciente();
                Collections.sort(resultado);
                for (Paciente paciente : resultado) {
                    txtListar.append(paciente.toString());
                }
            }
        });
        btnAtender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Paciente paciente = lista.desencolar();
                    txtListar.append(paciente.toString());
                    List<Paciente> resultado=lista.listPaciente();
                    Collections.sort(resultado);
                    for (Paciente p:resultado){
                        txtListar.append(p.toString());
                    }
                    JOptionPane.showMessageDialog(null,paciente.toString()+ "Paciente atendido");
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
