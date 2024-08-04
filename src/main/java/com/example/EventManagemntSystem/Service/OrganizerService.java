package com.example.EventManagemntSystem.Service;

import com.example.EventManagemntSystem.Entity.Event;
import com.example.EventManagemntSystem.Entity.Organizer;
import com.example.EventManagemntSystem.Repository.OrganizerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizerService {
    @Autowired
    private OrganizerRepository organizerRepository;

    public Organizer saveOrganizer(Organizer organizer) {
        return organizerRepository.save(organizer);
    }

    public Optional<Organizer> getOrganizerById(Long id) {
        return organizerRepository.findById(id);
    }

    public Organizer updateOrganizer(Organizer organizer) {
        return organizerRepository.save(organizer);
    }

    public void deleteOrganizer(Long id) {
        organizerRepository.deleteById(id);
    }
    public List<Organizer> getAllOrganizers() {
        return organizerRepository.findAll();
    }


}
