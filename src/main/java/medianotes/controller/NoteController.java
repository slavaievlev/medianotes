package medianotes.controller;

import medianotes.annotation.Loggable;
import medianotes.dto.NoteCreateDto;
import medianotes.dto.NoteDto;
import medianotes.dto.NoteEditDto;
import medianotes.service.NoteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @Loggable
    @GetMapping
    public List<NoteDto> getAllNotes() {
        return noteService.getAllNotes();
    }

    @PostMapping
    public NoteDto createNote(@RequestBody NoteCreateDto noteCreateDto) {
        return noteService.createNote(noteCreateDto);
    }

    @PutMapping("/{id}")
    public NoteDto editNote(@PathVariable("id") Integer noteId, @RequestBody NoteEditDto noteEditDto) {
        return noteService.editNote(noteId, noteEditDto);
    }
}
