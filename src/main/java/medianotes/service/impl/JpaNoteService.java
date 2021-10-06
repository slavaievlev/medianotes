package medianotes.service.impl;

import medianotes.dto.NoteCreateDto;
import medianotes.dto.NoteDto;
import medianotes.dto.NoteEditDto;
import medianotes.entity.Note;
import medianotes.repository.NoteRepository;
import medianotes.repository.UserRepository;
import medianotes.service.NoteService;
import medianotes.service.context.UserContext;
import medianotes.service.factory.NoteFactory;
import medianotes.service.mapper.NoteMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaNoteService implements NoteService {

    private final UserContext userContext;

    private final NoteRepository noteRepository;
    private final UserRepository userRepository;
    private final NoteMapper noteMapper;
    private final NoteFactory noteFactory;

    public JpaNoteService(UserContext userContext,
                          NoteRepository noteRepository,
                          UserRepository userRepository,
                          NoteMapper noteMapper,
                          NoteFactory noteFactory) {
        this.userContext = userContext;
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
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
        String email = userContext.getEmail();
        Integer userId = userRepository.findByEmail(email).orElseThrow().getId();

        Note note = noteFactory.build(
                noteCreateDto.getName(),
                noteCreateDto.getText(),
                userId
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
