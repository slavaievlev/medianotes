package medianotes.dto.note;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class NoteEditDto {

    private final String text;

    public NoteEditDto(@JsonProperty("text") String text) {
        this.text = text;
    }
}
