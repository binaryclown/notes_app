package binaryclown.petprojects.rest.notesappserver.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "category", schema = "public")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
}
