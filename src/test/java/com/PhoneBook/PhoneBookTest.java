package com.PhoneBook;
import com.phonebook.PhoneBook;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
public class PhoneBookTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private final PhoneBook phoneBook_Test = new PhoneBook();

    @Test
    public void findPhoneNumberByName() {
        Optional<String> phoneNumber = phoneBook_Test.findPhoneNumberByName("Raj");
        assertThat(phoneNumber.get()).isEqualTo("123");
    }
    @Test
    public void findPhoneNumberByName_NotFound(){
        expectedException.expect(NoSuchElementException.class);
        Optional<String> phoneNumber = phoneBook_Test.findPhoneNumberByName("Udit");
        phoneNumber.get();
    }
    @Test
    public void findNameByPhoneNumber(){
        Optional<String> name=phoneBook_Test.findNameByPhoneNumber("123");
        assertThat(name.get()).isEqualTo("Udit");
    }
    @Test
    public void findNameByPhoneNumber_NotFound(){
        expectedException.expect(NoSuchElementException.class);
        Optional<String> phoneNumber = phoneBook_Test.findNameByPhoneNumber("123");
        phoneNumber.get();
    }
}
