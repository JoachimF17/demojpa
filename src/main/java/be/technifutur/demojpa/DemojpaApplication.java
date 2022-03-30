package be.technifutur.demojpa;

import be.technifutur.demojpa.data.CoursRepository;
import be.technifutur.demojpa.data.SectionRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemojpaApplication
{
	public static void main(String[] args)
	{
		ApplicationContext context = SpringApplication.run(DemojpaApplication.class, args);
		SectionRepository dao = context.getBean(SectionRepository.class);
		CoursRepository coursRepository = context.getBean(CoursRepository.class);

		/*Section section = dao.getOne(1010);

		System.out.println(section);

		Section toAdd = new Section(10000, "ma section", 1L);

		if(dao.insert(toAdd))
			System.out.println(dao.getOne(10000));
		else
			System.out.println("Pas ajouté");

		Section toUpdate = dao.getOne(10000);
		toUpdate.setName("testzzzzzzz to update");
		toUpdate.setDelegateId(2L);

		dao.update(10000, toUpdate);
		System.out.println(dao.getOne(10000));

		dao.getAll().forEach(System.out::println);*/

		System.out.println(coursRepository.getOne("EG1010"));
		coursRepository.getAll().forEach(System.out::println);
	}

}
