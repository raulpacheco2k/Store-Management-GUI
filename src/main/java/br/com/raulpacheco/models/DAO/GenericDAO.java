package br.com.raulpacheco.models.DAO;

import br.com.raulpacheco.services.InterfaceService;
import br.com.raulpacheco.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public abstract class GenericDAO<Model> implements InterfaceService<Model> {

    private final EntityManager entityManager;

    public GenericDAO() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("loja");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void store(Model model) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(model);
            this.entityManager.getTransaction().commit();
        } catch (Exception exception) {
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
    }

    @Override
    public List<Model> search() {
        return null;
    }

    @Override
    public Model search(int id) {
        return null;
    }

    @Override
    public Model search(String field) {
        return null;
    }

    @Override
    public void update(Model model) {
        this.entityManager.merge(model);
        this.entityManager.getTransaction().commit();
        JPAUtil.close();
    }

    @Override
    public void delete(Model model) {

    }
}
