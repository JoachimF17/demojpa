package be.technifutur.demojpa.data;

import be.technifutur.demojpa.exceptions.ElementAlreadyExistsException;
import be.technifutur.demojpa.models.entities.Professeur;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ProfesseurRepository
{
    private final EntityManager manager;

    public ProfesseurRepository(EntityManager manager)
    {
        this.manager = manager;
    }

    public Professeur getOne(long id)
    {
        return manager.find(Professeur.class, id);
    }

    public List<Professeur> getAll()
    {
        return manager.createQuery("SELECT p FROM Professeur p", Professeur.class).getResultList();
    }

    @Transactional
    public void insert(Professeur toInsert)
    {
        if(getOne(toInsert.getId()) != null) throw new ElementAlreadyExistsException();

        manager.persist(toInsert);
    }

    @Transactional
    public Professeur delete(long id)
    {
        Professeur toDelete = getOne(id);

        if(toDelete != null) manager.remove(toDelete);

        return toDelete;
    }

    @Transactional
    public Professeur update(long id, Professeur updated)
    {
        Professeur toUpdate = getOne(id);

        if(toUpdate != null)
        {
            toUpdate.setName(updated.getName());
            toUpdate.setSurname(updated.getSurname());
            toUpdate.setSectionId(updated.getSectionId());
            toUpdate.setOffice(updated.getOffice());
            toUpdate.setEmail(updated.getEmail());
            toUpdate.setHireDate(updated.getHireDate());
            toUpdate.setWage(updated.getWage());
        }

        return toUpdate;
    }
}
