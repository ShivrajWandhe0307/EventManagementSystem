package com.example.EventManagemntSystem.Repository;

import com.example.EventManagemntSystem.Entity.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenueRepository extends JpaRepository<Venue, Long> {
}
