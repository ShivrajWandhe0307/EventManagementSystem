package com.example.EventManagemntSystem.Entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Venue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    private int capacity;

    @OneToMany(mappedBy = "venue")
    private Set<Event> events;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }
    public Venue()
    {

    }

    public Venue(Long id, String name, String location, int capacity, Set<Event> events) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.events = events;
    }
}
