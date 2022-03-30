package be.technifutur.demojpa.data;

import be.technifutur.demojpa.exceptions.ElementAlreadyExistsException;
import be.technifutur.demojpa.models.entities.Cours;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
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

    @Transactional
    public void insert(Cours toInsert)
    {
        if(getOne(toInsert.getId()) != null) throw new ElementAlreadyExistsException();

        manager.persist(toInsert);
    }

    @Transactional
    public Cours delete(String id)
    {
        Cours toDelete = getOne(id);

        if(toDelete != null) manager.remove(toDelete);

        return toDelete;
    }

    @Transactional
    public Cours update(String id, Cours updated)
    {
        Cours toUpdate = getOne(id);

        if(toUpdate != null)
        {
            toUpdate.setName(updated.getName());
            toUpdate.setEcts(updated.getEcts());
            toUpdate.setProfessorId(updated.getProfessorId());
        }

        return toUpdate;
    }
}
