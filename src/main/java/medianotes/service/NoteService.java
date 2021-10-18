package medianotes.service;

import medianotes.dto.note.NoteCreateDto;
import medianotes.dto.note.NoteDto;
import medianotes.dto.note.NoteEditDto;

import java.util.List;

public interface NoteService {

    List<NoteDto> getAllNotes();

    NoteDto createNote(NoteCreateDto noteCreateDto);

    NoteDto editNote(Integer noteId, NoteEditDto noteEditDto);
}
