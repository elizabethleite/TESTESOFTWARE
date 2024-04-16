package exercicio2.tdd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PersonDAOTest {

	@Test
    public void testIsValidName_TwoPartsAndLetters() {
        Person person = new Person(1, "Lucas Nadalete", 25, "lucas@fatec.com.br", "lucas@fatec.com.br");
        assertTrue(person.isValidName());
    }

    @Test
    public void testIsValidName_InvalidNameFormat() {
        Person person = new Person(1, "Lucas123", 25, "lucas@fatec.com.br", "lucas@fatec.com.br");
        assertFalse(person.isValidName());
    }

    @Test
    public void testIsValidAge_ValidAge() {
        Person person = new Person(1, "Lucas Nadalete", 25, "lucas@fatec.com.br", "lucas@fatec.com.br");
        assertTrue(person.isValidAge());
    }

    @Test
    public void testHasEmails_AtLeastOneEmail() {
        Person person = new Person(1, "Lucas Nadalete", 25, "lucas@fatec.com.br", "lucas@fatec.com.br");
        assertTrue(person.hasEmails());
    }

    @Test
    public void testHasEmails_NoEmails() {
        Person person = new Person(1, "Lucas Nadalete", 25, null, null);
        assertFalse(person.hasEmails());
    }

}
