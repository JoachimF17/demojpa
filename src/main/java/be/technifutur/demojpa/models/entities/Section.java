package be.technifutur.demojpa.models.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Section
{
    @Id @Column(name = "section_id", columnDefinition = "INT(11)")
    private long id;

    @Column(name = "section_name")
    private String name;

    @Column(columnDefinition = "INT(11)")
    private Long delegateId;

    @OneToMany(mappedBy = "section")
    private List<Professeur> professeurs;
}
