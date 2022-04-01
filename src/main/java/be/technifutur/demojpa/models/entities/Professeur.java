package be.technifutur.demojpa.models.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Professor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Professeur
{
    @Id @Column(name = "professor_id", columnDefinition = "int(11)")
    private long id;

    @Column(name = "professor_name", length = 30)
    private String name;

    @Column(name = "professor_surname", length = 30)
    private String surname;

    @Column(columnDefinition = "int(11)")
    private long sectionId;

    @Column(name = "professor_office", columnDefinition = "int(11)")
    private long office;

    @Column(name = "professor_email", length = 30)
    private String email;

    @Column(name = "professor_hire_date", columnDefinition = "datetime")
    private LocalDateTime hireDate;

    @Column(name = "professor_wage", columnDefinition = "int(11)")
    private long wage;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

    @OneToMany(mappedBy = "professeur")
    private List<Cours> coursDonnes;
}
