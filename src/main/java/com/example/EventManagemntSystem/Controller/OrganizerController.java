package com.example.EventManagemntSystem.Controller;

import com.example.EventManagemntSystem.Entity.Organizer;
import com.example.EventManagemntSystem.Service.OrganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/organizers")
public class OrganizerController {
    @Autowired
    private OrganizerService organizerService;

    @GetMapping
    public String getAllOrganizers(Model model) {
        model.addAttribute("organizers", organizerService.getAllOrganizers());
        return "organizers";
    }

    @GetMapping("/{id}")
    public String getOrganizerById(@PathVariable("id") Long id, Model model) {
        Organizer organizer = organizerService.getOrganizerById(id).orElseThrow(() -> new RuntimeException("Organizer not found"));
        model.addAttribute("organizer", organizer);
        return "organizer_detail";
    }

    @GetMapping("/new")
    public String createOrganizerForm(Model model) {
        model.addAttribute("organizer", new Organizer());
        return "create_organizer";
    }

    @PostMapping
    public String saveOrganizer(@ModelAttribute Organizer organizer) {
        organizerService.saveOrganizer(organizer);
        return "redirect:/organizers";
    }

    @GetMapping("/edit/{id}")
    public String editOrganizerForm(@PathVariable("id") Long id, Model model) {
        Organizer organizer = organizerService.getOrganizerById(id).orElseThrow(() -> new RuntimeException("Organizer not found"));
        model.addAttribute("organizer", organizer);
        return "edit_organizer";
    }

    @PostMapping("/update/{id}")
    public String updateOrganizer(@PathVariable("id") Long id, @ModelAttribute Organizer organizer) {
        organizer.setId(id);
        organizerService.saveOrganizer(organizer);
        return "redirect:/organizers";
    }

    @GetMapping("/delete/{id}")
    public String deleteOrganizer(@PathVariable("id") Long id) {
        organizerService.deleteOrganizer(id);
        return "redirect:/organizers";
    }
}
