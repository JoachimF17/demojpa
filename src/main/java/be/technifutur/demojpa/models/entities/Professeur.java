package be.technifutur.demojpa.models.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "Professor")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Professeur
{
    @Id @Column(name = "professor_id", columnDefinition = "int(11)")
    private long id;

    @Column(name = "professor_name")
    private String name;

    @Column(name = "professor_surname")
    private String surname;

    @Column(columnDefinition = "int(11)")
    private long sectionId;

    @Column(name = "professor_office", columnDefinition = "int(11)")
    private long office;

    @Column(name = "professor_email")
    private String email;

    @Column(name = "professor_hire_date", columnDefinition = "datetime")
    private LocalDateTime hireDate;

    @Column(name = "professor_wage", columnDefinition = "int(11)")
    private long wage;
}
