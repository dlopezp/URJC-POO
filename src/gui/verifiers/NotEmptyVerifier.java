package gui.verifiers;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 * @author Eduardo Benito Fernández
 */
public class NotEmptyVerifier extends InputVerifier {

    @Override
    public boolean verify(JComponent input) {
        String valor = ((JTextField)input).getText();
        return !valor.isEmpty();
   }
    
}
