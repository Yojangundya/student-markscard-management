package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Teacher;

public class TeacherDao {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();

	public void saveTeacher(Teacher teacher) {
		transaction.begin();
		manager.persist(teacher);
		transaction.commit();
	}

	public Teacher findTeacher(String email) {
		List<Teacher> list = manager.createQuery("select x from Teacher x where email=?1").setParameter(1, email)
				.getResultList();
		if (list.isEmpty()) {
			return null;
		} else
			return list.get(0);

	}

	public Teacher findTeacher(long mob) {
		List<Teacher> list = manager.createQuery("select x from Teacher x where mobile=?1").setParameter(1, mob)
				.getResultList();
		if (list.isEmpty()) {
			return null;
		} else
			return list.get(0);

	}
}
