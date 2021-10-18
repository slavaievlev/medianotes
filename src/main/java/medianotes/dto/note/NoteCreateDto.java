package medianotes.dto.note;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class NoteCreateDto {

    private final String name;

    private final String text;

    public NoteCreateDto(@JsonProperty("name") String name,
                         @JsonProperty("text") String text) {
        this.name = name;
        this.text = text;
    }
}
