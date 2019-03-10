package ua.andrew.certifie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.andrew.certifie.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

}
