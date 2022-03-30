package be.technifutur.demojpa.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Course")
@Getter @Setter
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
}