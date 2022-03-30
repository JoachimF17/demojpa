package be.technifutur.demojpa;

import be.technifutur.demojpa.data.SectionDAO;
import be.technifutur.demojpa.models.entities.Section;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemojpaApplication
{
	public static void main(String[] args)
	{
		ApplicationContext context = SpringApplication.run(DemojpaApplication.class, args);

		SectionDAO dao = context.getBean(SectionDAO.class);

		Section section = dao.getOne(1010);

		System.out.println(section);

		Section toAdd = new Section(10000, "ma section", 1L);

		if(dao.insert(toAdd))
			System.out.println(dao.getOne(10000));
		else
			System.out.println("Pas ajouté");
	}

}
