package medianotes.service.factory;

import medianotes.entity.Note;
import org.springframework.stereotype.Component;

@Component
public class NoteFactory {

    public Note build(String title, String content, Integer creatorId) {
        return new Note(title, content, creatorId);
    }
}
