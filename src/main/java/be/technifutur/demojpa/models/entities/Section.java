package be.technifutur.demojpa.models.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
public class Section
{
    @Id @Column(name = "section_id", columnDefinition = "INT(11)")
    private long id;
    @Column(name = "section_name")
    private String name;
    @Column(columnDefinition = "INT(11)")
    private Long delegateId;
}
