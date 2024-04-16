package exercicio2.tdd;

import java.util.List;
import java.util.ArrayList;

public class PersonDAO {
	public List<String> isValidToInclude(Person person) {
        List<String> errors = new ArrayList<>();

        if (!person.isValidName()) {
            errors.add("O nome deve ser composto por ao menos duas partes e conter apenas letras");
        }

        if (!person.isValidAge()) {
            errors.add("A idade deve estar no intervalo [1, 200]");
        }

        if (!person.hasEmails()) {
            errors.add("A pessoa deve ter pelo menos um e-mail associado");
        }

        return errors;
    }
}
