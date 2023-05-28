package com.scaler.taskmanager.repositories;

import com.scaler.taskmanager.entities.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// in JPARepository<> we need to provide table type and id type
@Repository
public interface NotesRepository extends JpaRepository<NoteEntity,Integer> {
}
