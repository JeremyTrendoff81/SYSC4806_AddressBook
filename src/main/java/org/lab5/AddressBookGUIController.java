package org.lab5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddressBookGUIController {

    @Autowired
    AddressBookRepository addressBookRepository;

    @Autowired
    BuddyInfoRepository buddyInfoRepository;

    @GetMapping("/lab4GuiTemplate")
    public String getAddressBookBuddyInfos(@RequestParam(name = "id", required = false, defaultValue = "1") String id, Model model) {
        model.addAttribute("addressBookResult", addressBookRepository.findById(Long.parseLong(id)));
        return "lab4GuiTemplate";
    }

    @GetMapping("/getBuddyByName")
    public String getBuddyByName(@RequestParam(name = "name", required = false, defaultValue = "Steve") String name, Model model) {
        model.addAttribute("buddyByNameResult", buddyInfoRepository.findByName(name));
        return "getBuddyByName";
    }

    @GetMapping("/getBuddyByAddress")
    public String getBuddyByAddress(@RequestParam(name = "address", required = false, defaultValue = "100 Street St") String address, Model model) {
        model.addAttribute("buddyByAddressResult", buddyInfoRepository.findByAddress(address));
        return "getBuddyByAddress";
    }
}
