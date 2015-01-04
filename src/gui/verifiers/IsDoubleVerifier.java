package gui.verifiers;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;


/**
 * @author Eduardo Benito Fernández
 * @version 1.0
 * @since 20-12-2014
 */
public class IsDoubleVerifier extends InputVerifier {

    @Override
    public boolean verify(JComponent input) {
        String valor = ((JTextField)input).getText();
        if (valor.isEmpty()) {
            return false;
        }
        Double valorDouble = null;
        try {
            valorDouble = Double.parseDouble(valor);
        } catch (NumberFormatException e) {
            return false;
        }
        if (valorDouble <= 0) {
            return false;
        }
        return true;
    }
    
}
