package com.scaler.taskmanager.entities;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@MappedSuperclass // every entity extends from it. It should be abstract as it doesn't have its own table
// all the columns that are required by all the tables are defined here
@Getter
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name="id",nullable = false)
    private Integer id;

    @CreatedDate
    @Column(name="created_at",nullable = false)
    private Date createdAt;
}
