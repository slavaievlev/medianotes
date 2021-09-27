package medianotes.dto;

import lombok.Getter;

@Getter
public class NoteDto {

    private final Integer id;

    private final String name;

    private final String text;

    public NoteDto(Integer id,
                   String name,
                   String text) {
        this.id = id;
        this.name = name;
        this.text = text;
    }
}
