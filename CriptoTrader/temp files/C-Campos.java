package controller;

import java.text.ParseException;
import javax.swing.JFormattedTextField;

// Lê números de JFormattedTextField (usado pelas telas Caixa e Trade). */
public class ValidaCampos {

    //Lê o número digitado no campo, mesmo que o usuário não tenha apertado Enter.

    public static double lerNumero(JFormattedTextField campo) {
        try {campo.commitEdit();   // transforma o texto digitado em valor
        } catch (ParseException e) {
            return -1;
        }

        Object valor = campo.getValue();
        if (!(valor instanceof Number)) {
            return -1;
        }

        double numero = ((Number) valor).doubleValue();
        return Double.isFinite(numero) ? numero : -1;
    }
}
