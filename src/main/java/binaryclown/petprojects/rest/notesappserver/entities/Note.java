package binaryclown.petprojects.rest.notesappserver.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "note", schema = "public")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column
    private String name;

    @Column
    private String text;
}
