package com.example.EventManagemntSystem.Repository;

import com.example.EventManagemntSystem.Entity.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizerRepository extends JpaRepository<Organizer, Long> {
}
