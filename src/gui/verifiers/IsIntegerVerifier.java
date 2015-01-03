package gui.verifiers;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class IsIntegerVerifier extends InputVerifier {

    @Override
    public boolean verify(JComponent input) {
        String valor = ((JTextField)input).getText();
        if (valor.isEmpty()) {
            return false;
        }
        Integer valorInt = null;
        try {
            valorInt = Integer.parseInt(valor);
        } catch (NumberFormatException e) {
            return false;
        }
        if (valorInt <= 0) {
            return false;
        }
        return true;
    }
    
}
