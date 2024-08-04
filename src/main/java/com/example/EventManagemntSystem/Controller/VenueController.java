package com.example.EventManagemntSystem.Controller;

import com.example.EventManagemntSystem.Entity.Venue;
import com.example.EventManagemntSystem.Service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/venues")
public class VenueController {
    @Autowired
    private VenueService venueService;

    @GetMapping
    public String getAllVenues(Model model) {
        model.addAttribute("venues", venueService.getAllVenues());
        return "venues";
    }

    @GetMapping("/{id}")
    public String getVenueById(@PathVariable("id") Long id, Model model) {
        Venue venue = venueService.getVenueById(id).orElseThrow(() -> new RuntimeException("Venue not found"));
        model.addAttribute("venue", venue);
        return "venue_detail";
    }

    @GetMapping("/new")
    public String createVenueForm(Model model) {
        model.addAttribute("venue", new Venue());
        return "create_venue";
    }

    @PostMapping
    public String saveVenue(@ModelAttribute Venue venue) {
        venueService.saveVenue(venue);
        return "redirect:/venues";
    }

    @GetMapping("/edit/{id}")
    public String editVenueForm(@PathVariable("id") Long id, Model model) {
        Venue venue = venueService.getVenueById(id).orElseThrow(() -> new RuntimeException("Venue not found"));
        model.addAttribute("venue", venue);
        return "edit_venue";
    }

    @PostMapping("/update/{id}")
    public String updateVenue(@PathVariable("id") Long id, @ModelAttribute Venue venue) {
        venue.setId(id);
        venueService.saveVenue(venue);
        return "redirect:/venues";
    }

    @GetMapping("/delete/{id}")
    public String deleteVenue(@PathVariable("id") Long id) {
        venueService.deleteVenue(id);
        return "redirect:/venues";
    }
}
