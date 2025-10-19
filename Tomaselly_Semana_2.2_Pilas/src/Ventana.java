import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JTextArea txtCodigo;
    private JButton btnComprobar;
    private JPanel principal;
    private JLabel lblResultado;

    public Ventana() {
        btnComprobar.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pila pila = new Pila();
                try{
                    String code= txtCodigo.getText();
                    if(pila.balance(code)){
                        lblResultado.setText("balance");
                    }else {
                        lblResultado.setText("No balance");
                    }
                }catch(Exception ex){
                    lblResultado.setText(ex.getMessage());
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

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
