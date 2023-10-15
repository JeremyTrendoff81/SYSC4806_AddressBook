package org.lab5;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.context.WebApplicationContext;

import java.util.Collection;
import java.util.Map;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HttpRequestTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AddressBookRepository addressBookRepository;

    @MockBean
    private BuddyInfoRepository buddyInfoRepository;

    @Test
    public void getAddressBookByID() throws Exception {
        AddressBook testBook = new AddressBook();
        testBook.addBuddy("Test", "Test");

        when(addressBookRepository.findById(1)).thenReturn(testBook);

        this.mockMvc.perform(get("/lab4GuiTemplate")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("AddressBook{buddies=[BuddyInfo{name=Test, phoneNumber=Test}]}")));
    }

    @Test
    public void getBuddyByName() throws Exception {
        BuddyInfo testBuddy = new BuddyInfo("Test2", "Test2");

        when(buddyInfoRepository.findByName("Steve")).thenReturn(testBuddy);

        this.mockMvc.perform(get("/getBuddyByName")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("BuddyInfo{name=Test2, phoneNumber=Test2}")));
    }
}
