package com.scaler.taskmanager.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity(name="notes")
public class NoteEntity extends BaseEntity {

    @Column(name="body",length = 500)
    private String body;

    // many to one mapping between notes and tasks
    @ManyToOne
    private TaskEntity task;

}
