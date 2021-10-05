package medianotes.service;

import medianotes.dto.NoteCreateDto;
import medianotes.dto.NoteDto;
import medianotes.dto.NoteEditDto;

import java.util.List;

public interface NoteService {

    List<NoteDto> getAllNotes();

    NoteDto createNote(NoteCreateDto noteCreateDto);

    NoteDto editNote(Integer noteId, NoteEditDto noteEditDto);
}
