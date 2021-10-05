package medianotes.service.impl;

import medianotes.dto.NoteCreateDto;
import medianotes.dto.NoteDto;
import medianotes.dto.NoteEditDto;
import medianotes.entity.Note;
import medianotes.repository.NoteRepository;
import medianotes.service.NoteService;
import medianotes.service.factory.NoteFactory;
import medianotes.service.mapper.NoteMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaNoteService implements NoteService {

    private final NoteRepository noteRepository;
    private final NoteMapper noteMapper;
    private final NoteFactory noteFactory;

    public JpaNoteService(NoteRepository noteRepository,
                          NoteMapper noteMapper,
                          NoteFactory noteFactory) {
        this.noteRepository = noteRepository;
        this.noteMapper = noteMapper;
        this.noteFactory = noteFactory;
    }

    @Override
    public List<NoteDto> getAllNotes() {
        List<Note> notes = noteRepository.findAll();
        return noteMapper.mapNoteToNoteDto(notes);
    }

    @Override
    public NoteDto createNote(NoteCreateDto noteCreateDto) {
        Note note = noteFactory.build(
                noteCreateDto.getName(),
                noteCreateDto.getText(),

                // todo когда-нибудь нужно прописать реального инициатора создания заметки.
                1
        );

        note = noteRepository.saveAndFlush(note);

        return noteMapper.mapNoteToNoteDto(note);
    }

    @Override
    public NoteDto editNote(Integer noteId, NoteEditDto noteEditDto) {
        Note note = noteRepository.findById(noteId).orElseThrow();

        note.setContent(noteEditDto.getText());

        noteRepository.saveAndFlush(note);

        return noteMapper.mapNoteToNoteDto(note);
    }
}
