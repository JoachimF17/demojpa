package be.technifutur.demojpa.data;

import be.technifutur.demojpa.exceptions.ElementAlreadyExistsException;
import be.technifutur.demojpa.models.entities.Professeur;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public class ProfesseurRepository
{
    private final EntityManager manager;

    public ProfesseurRepository(EntityManager manager)
    {
        this.manager = manager;
    }

    public Optional<Professeur> getOne(long id)
    {
        return Optional.ofNullable(manager.find(Professeur.class, id));
    }

    public List<Professeur> getAll()
    {
        return manager.createQuery("SELECT p FROM Professeur p", Professeur.class).getResultList();
    }

    @Transactional
    public void insert(Professeur toInsert)
    {
        if(getOne(toInsert.getId()).isPresent()) throw new ElementAlreadyExistsException();

        manager.persist(toInsert);
    }

    @Transactional
    public void delete(long id)
    {
        Optional<Professeur> toDelete = getOne(id);

        toDelete.ifPresent(manager::remove);
        manager.flush();
        manager.close();
    }

    @Transactional
    public void update(Professeur updated)
    {
        Optional<Professeur> toUpdate = getOne(updated.getId());

        toUpdate.ifPresent((value) -> {
            value.setName(updated.getName());
            value.setSurname(updated.getSurname());
            value.setSectionId(updated.getSectionId());
            value.setOffice(updated.getOffice());
            value.setEmail(updated.getEmail());
            value.setHireDate(updated.getHireDate());
            value.setWage(updated.getWage());
            manager.merge(value);
            manager.flush();
            manager.close();
        });
    }
}
