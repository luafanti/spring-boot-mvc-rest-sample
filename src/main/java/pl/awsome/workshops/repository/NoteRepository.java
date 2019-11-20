package pl.awsome.workshops.repository;

import java.util.Collection;
import java.util.HashMap;
import org.springframework.stereotype.Repository;
import pl.awsome.workshops.service.model.Note;

@Repository
public class NoteRepository {

    private HashMap<String,Note> repo = new HashMap<>();

    public void saveNote(Note note) {
        repo.put(note.getId(), note);
    }

    public void deleteNote(String noteId) {
       repo.remove(noteId);
    }

    public Collection<Note> getNotes() {
        return repo.values();
    }
}
