package br.com.vbdev.beleza_agendada.util;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;

public class Formatters {

    /**
     * @description: O CNPJ provavelmente virá formatado, porém caso não, essa função existe
     * */
    public static String cnpjFormated(String cnpj) {
        String formatted = "";
        try {
            MaskFormatter mask = new MaskFormatter("##.###.###/####-##");
            mask.setValueContainsLiteralCharacters(false);
            formatted = mask.valueToString(cnpj);

            if(cnpj != formatted)
                return formatted;
        } catch (ParseException e) {
            e.printStackTrace();
            formatted = cnpj;
            //O cnpj já virá formatado, mas pra facilitar essa função existe
        }
        return formatted;
    }

    public static String phoneFormatter(String phone) {
        String formatted = "";
        try {
            MaskFormatter mask = new MaskFormatter("(##) #####-####");
            mask.setValueContainsLiteralCharacters(false);
            formatted = mask.valueToString(phone);

            if(phone != formatted)
                return formatted;
        } catch (ParseException e) {
            e.printStackTrace();
            formatted = phone;
        }
        return formatted;
    }

    public static String cpfFormatter(String cpf) {
        String formatted = "";
        try {
            MaskFormatter mask = new MaskFormatter("###.###.###-##");
            mask.setValueContainsLiteralCharacters(false);
            formatted = mask.valueToString(cpf);

            if(cpf != formatted)
                return formatted;
        } catch (ParseException e) {
            e.printStackTrace();
            formatted = cpf;
        }
        return formatted;
    }

}
