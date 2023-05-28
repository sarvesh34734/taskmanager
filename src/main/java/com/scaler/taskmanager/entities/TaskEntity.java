package com.scaler.taskmanager.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity(name="tasks") // name here is the name of the table. Name of the table should ideally be plural
// entity class should be singular - TaskEntity as it represents a single task
@Getter
@Setter
@Table(indexes = @Index(columnList = "title"))
public class TaskEntity extends BaseEntity{
    @Column(name="title",nullable = false,length = 150)
    private String title;

    @Column(name="description",length = 500)
    private String description;

    @Column(name="completed",nullable = false,columnDefinition = "boolean default false")
    private Boolean completed;

    @Column(name="due_date")
    private Date dueDate;

    @OneToMany(mappedBy = "task") // we need to write mappedBy because the mapping is created only on notes. To create it on task we need to provide this.
    // we can provide fetch type like fetch = FetchType.LAZY to denote fetch type as LAZY. Not all databases support it though.
    private List<NoteEntity> notes;
}
