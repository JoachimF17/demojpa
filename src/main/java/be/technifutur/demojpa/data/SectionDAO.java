package be.technifutur.demojpa.data;

import be.technifutur.demojpa.models.entities.Section;
import org.springframework.stereotype.Component;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Component
public class SectionDAO
{
    private final EntityManagerFactory managerFactory;

    public SectionDAO(EntityManagerFactory managerFactory)
    {
        this.managerFactory = managerFactory;
    }

    public Section getOne(long id)
    {
        EntityManager manager = managerFactory.createEntityManager();
        Section section = manager.find(Section.class, id);
        manager.close();
        return section;
    }

    public boolean insert(Section toInsert)
    {
        EntityManager manager = managerFactory.createEntityManager();
        manager.getTransaction().begin();

        try
        {
            manager.persist(toInsert);
            manager.getTransaction().commit();
            return true;
        }catch (EntityExistsException e)
        {
            manager.getTransaction().rollback();
            return false;
        }finally
        {
            manager.close();
        }
    }

    public boolean delete(long id)
    {
        EntityManager manager = managerFactory.createEntityManager();

        manager.getTransaction().begin();

        try
        {
            manager.remove(getOne(id));
            manager.getTransaction().commit();
            return true;
        }catch (Exception e)
        {
            return false;
        }finally
        {
            manager.close();
        }
    }
}
