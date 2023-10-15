package org.lab4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddressBookGUIController {

    @Autowired
    AddressBookRepository addressBookRepository;

    @GetMapping("/lab4GuiTemplate")
    public String getAddressBookBuddyInfos(@RequestParam(name = "id", required = false, defaultValue = "1") String id, Model model) {
        model.addAttribute("addressBookResult", addressBookRepository.findById(Long.parseLong(id)));
        return "lab4GuiTemplate";
    }
}
