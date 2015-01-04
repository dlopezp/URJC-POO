package gui.verifiers;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 * @author Eduardo Benito Fernández
 * @version 1.0
 * @since 20-12-2014
 */
public class NotEmptyVerifier extends InputVerifier {

    @Override
    public boolean verify(JComponent input) {
        String valor = ((JTextField)input).getText();
        return !valor.isEmpty();
   }
    
}
