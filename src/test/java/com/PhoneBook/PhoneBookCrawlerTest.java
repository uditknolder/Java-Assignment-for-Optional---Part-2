package com.PhoneBook;
import com.phonebook.PhoneBookCrawler;
import com.phonebook.PhoneBook;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;


public class PhoneBookCrawlerTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private final PhoneBookCrawler phoneBookCrawler = new PhoneBookCrawler(new PhoneBook());

    @Test
    public void findPhoneNumberByNameAndPunishIfNothingFound()  {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("No phone number found");

        phoneBookCrawler.findPhoneNumberByNameAndPunishIfNothingFound("Udit");
    }

    @Test
    public void findPhoneNumberByName_AndFindSomething(){
        String phoneNumber = phoneBookCrawler.findPhoneNumberByNameAndPrintPhoneBookIfNothingFound("Raj");

        assertThat(phoneNumber).isEqualTo("123");
    }

    @Test
    public void findPhoneNumberByNameOrNameByPhoneNumber_foundByName() {
        String phoneNumber = phoneBookCrawler.findPhoneNumberByNameOrNameByPhoneNumber("udit", "123");

        assertThat(phoneNumber).isEqualTo("123");
    }

}