package gui.verifiers;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 * @author Eduardo Benito Fernández
 * @version 1.0
 * @since 20-12-2014
 */
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
