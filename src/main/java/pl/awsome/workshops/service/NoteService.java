package pl.awsome.workshops.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.awsome.workshops.controller.model.NoteDTO;
import pl.awsome.workshops.repository.NotePostgresRepository;
import pl.awsome.workshops.service.model.Note;

@Service
public class NoteService {

    @Autowired
    private NotePostgresRepository noteRepository;

    public void saveNote(NoteDTO noteDTO) {
        Note note = new Note();
        note.setTitle(noteDTO.getTitle());
        note.setMessage(noteDTO.getMessage());
        note.setId(UUID.randomUUID().toString());
        note.setCreateDate(LocalDateTime.now());
        noteRepository.save(note);
    }

    public void deleteNote(String noteId) {
        noteRepository.deleteById(noteId);
    }

   public List<Note> getAllNotes() {
       List<Note> result = new ArrayList<>();
       noteRepository.findAll()
           .forEach(result::add);
       return result;
   }

}
