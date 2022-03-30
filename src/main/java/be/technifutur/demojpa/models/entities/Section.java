package be.technifutur.demojpa.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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

    @Override
    public String toString()
    {
        return "Section{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", delegateId=" + delegateId +
                '}';
    }
}
