package medianotes.service.mapper;

import medianotes.dto.NoteDto;
import medianotes.entity.Note;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class NoteMapper {

    public NoteDto mapNoteToNoteDto(Note model) {
        return new NoteDto(
                model.getId(),
                model.getTitle(),
                model.getContent()
        );
    }

    public List<NoteDto> mapNoteToNoteDto(Collection<Note> model) {
        return model.stream()
                .map(this::mapNoteToNoteDto)
                .collect(Collectors.toList());
    }
}
