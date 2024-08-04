package com.example.EventManagemntSystem.Controller;

import com.example.EventManagemntSystem.Entity.Event;
import com.example.EventManagemntSystem.Service.EventService;
import com.example.EventManagemntSystem.Service.OrganizerService;
import com.example.EventManagemntSystem.Service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/events")
public class EventController {
    @Autowired
    private EventService eventService;
    @Autowired
    private OrganizerService organizerService;
    @Autowired
    private VenueService venueService;

    @GetMapping
    public String getAllEvents(Model model) {
        model.addAttribute("events", eventService.getAllEvents());
        return "events";
    }

    @GetMapping("/{id}")
    public String getEventById(@PathVariable("id") Long id, Model model) {
        Event event = eventService.getEventById(id).orElseThrow(() -> new RuntimeException("Event not found"));
        model.addAttribute("event", event);
        return "event_detail";
}

    @GetMapping("/new")
    public String createEventForm(Model model) {
        model.addAttribute("event", new Event());
        model.addAttribute("organizers", organizerService.getAllOrganizers());
        model.addAttribute("venues", venueService.getAllVenues());
        return "create_event";
    }

    @PostMapping
    public String saveEvent(@ModelAttribute Event event) {
        eventService.saveEvent(event);
        return "redirect:/events";
    }

    @GetMapping("/edit/{id}")
    public String editEventForm(@PathVariable("id") Long id, Model model) {
        Event event = eventService.getEventById(id).orElseThrow(() -> new RuntimeException("Event not found"));
        model.addAttribute("event", event);
        model.addAttribute("organizers", organizerService.getAllOrganizers());
        model.addAttribute("venues", venueService.getAllVenues());
        return "edit_event";
    }

    @PostMapping("/update/{id}")
    public String updateEvent(@PathVariable("id") Long id, @ModelAttribute Event event) {
        event.setId(id);
        eventService.saveEvent(event);
        return "redirect:/events";
    }

    @GetMapping("/delete/{id}")
    public String deleteEvent(@PathVariable("id") Long id) {
        eventService.deleteEvent(id);
        return "redirect:/events";
    }
}
