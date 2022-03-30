package be.technifutur.demojpa.data;

import be.technifutur.demojpa.models.entities.Cours;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CoursRepository
{
    private final EntityManager manager;

    public CoursRepository(EntityManager manager)
    {
        this.manager = manager;
    }

    public Cours getOne(String id)
    {
        return manager.find(Cours.class, id);
    }

    public List<Cours> getAll()
    {
        return manager.createQuery("SELECT c FROM Cours c", Cours.class).getResultList();
    }

    public void insert(Cours toInsert)
    {
        manager.persist(toInsert);
    }

    public Cours delete(String id)
    {
        return null;
    }

    public Cours update(String id, Cours updates)
    {
        return null;
    }
}
