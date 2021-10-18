package medianotes.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import java.time.Instant;

@Entity
@Getter
@Setter
public class Note {

    @Id
    @SequenceGenerator(name = "note_id_seq_generator",
            sequenceName = "note_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "note_id_seq_generator")
    private Integer id;

    private String title;

    private String content;

    @UpdateTimestamp
    private Instant updatedAt;

    @Column(name = "creator_id")
    private Integer creatorId;

    @ManyToOne
    @JoinColumn(name = "creator_id", insertable = false, updatable = false)
    private User user;

    public Note() {
    }

    public Note(String title, String content, Integer creatorId) {
        this.title = title;
        this.content = content;
        this.creatorId = creatorId;
    }
}
