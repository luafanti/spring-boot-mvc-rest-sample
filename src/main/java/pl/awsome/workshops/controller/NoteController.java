package pl.awsome.workshops.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.awsome.workshops.controller.model.NoteDTO;
import pl.awsome.workshops.service.NoteService;
import pl.awsome.workshops.service.model.Note;

@RestController
@RequestMapping(value = "note")
public class NoteController {


    @Autowired
    private NoteService noteService;

    @GetMapping
    public List<Note> getNotes () {
        return noteService.getAllNotes();
    }

    @PostMapping()
    public void createNote(@RequestBody NoteDTO noteDTO) {
        noteService.saveNote(noteDTO);
    }


    @DeleteMapping()
    public void deleteNote (@RequestParam String noteId) {
        noteService.deleteNote(noteId);
    }

}
