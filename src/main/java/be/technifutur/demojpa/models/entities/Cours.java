package be.technifutur.demojpa.models.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Course")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Cours
{
    @Id @Column(name = "course_id", length = 8)
    private String id;

    @Column(name = "course_name", length = 200)
    private String name;

    @Column(name = "course_ects", columnDefinition = "decimal(3,1)")
    private double ects;

    @Column(columnDefinition = "int(11)")
    private Long professorId;

    @ManyToOne
    private Professeur professeur;
}
