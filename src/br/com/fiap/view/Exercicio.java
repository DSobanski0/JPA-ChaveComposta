package br.com.fiap.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.exception.EntityNotFoundException;
import br.com.fiap.exercicio.dao.AlunoCourseDao;
import br.com.fiap.exercicio.dao.impl.AlunoCourseDaoImpl;
import br.com.fiap.exercicio.entity.Aluno;
import br.com.fiap.exercicio.entity.AlunoCourse;
import br.com.fiap.exercicio.entity.AlunoCoursePK;
import br.com.fiap.exercicio.entity.NanoCourse;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Exercicio {

	public static void main(String[] args) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		AlunoCourseDao alunoCourseDao = new AlunoCourseDaoImpl(em);
		
		NanoCourse nanoCourse = new NanoCourse("Spring");
		
		Aluno aluno = new Aluno("Daniel");
		
		AlunoCourse alunoCourse = new AlunoCourse(aluno, nanoCourse, new GregorianCalendar(2021, Calendar.MAY, 25), 9.6F);
		
		try {
			alunoCourseDao.create(alunoCourse);
			alunoCourseDao.commit();
			System.out.println("Sucesso!!!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			AlunoCoursePK pk = new AlunoCoursePK(1, 1);
			alunoCourse = alunoCourseDao.read(pk);
			System.out.println(alunoCourse.getAluno().getNome() + " " + alunoCourse.getNano().getNome());
		} catch (EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}
}
