package com.project.starterio_version_1.repository;

import com.project.starterio_version_1.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event,Integer> {

    public Event findByEventId(int eventId);
    public List<Event> findByUserId(int userId);
}
