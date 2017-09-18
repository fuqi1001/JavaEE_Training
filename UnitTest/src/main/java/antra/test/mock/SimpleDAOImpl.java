package main.java.antra.test.mock;

import main.java.antra.deptemp.entity.Department;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class SimpleDAOImpl implements SimpleDAO{

    @PersistenceContext
    EntityManager em;

    @Override
    public void save(Department dept) {
        em.persist(dept);
    }
}
