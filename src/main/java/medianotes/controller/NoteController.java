package medianotes.controller;

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

    @GetMapping
    public List<NoteDto> getAllNotes() {
        return noteService.getAllNotes();
    }

    @PostMapping
    public NoteDto createNote(@RequestBody NoteCreateDto noteCreateDto) {
        return noteService.createNote(noteCreateDto);
    }

    @PutMapping("/v1/test/{id}/hdawho")
    public NoteDto editNote(@RequestBody NoteEditDto noteEditDto,
                            @PathVariable("id") Integer noteId) {
        return noteService.editNote(noteId, noteEditDto);
    }
}
