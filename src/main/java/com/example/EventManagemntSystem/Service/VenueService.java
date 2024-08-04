package com.example.EventManagemntSystem.Service;

import com.example.EventManagemntSystem.Entity.Event;
import com.example.EventManagemntSystem.Entity.Venue;
import com.example.EventManagemntSystem.Repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class VenueService {
    @Autowired
    private VenueRepository venueRepository;

    public Venue saveVenue(Venue venue) {
        return venueRepository.save(venue);
    }

    public Optional<Venue> getVenueById(Long id) {
        return venueRepository.findById(id);
    }

    public Venue updateVenue(Venue venue) {
        return venueRepository.save(venue);
    }

    public void deleteVenue(Long id) {
        venueRepository.deleteById(id);
    }

    public List<Venue> getAllVenues() {
        return venueRepository.findAll();
    }

}
