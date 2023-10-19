package se.lexicon.jpaworkshop.data;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import se.lexicon.jpaworkshop.entity.AppUser;

import java.util.Collection;
@Repository
public class AppUserDaoImpl implements AppUserDao{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public AppUser findById(int id) {
        return entityManager.find(AppUser.class, id);
    }

    @Override
    public Collection<AppUser> findAll() {
        return entityManager.createQuery("select a from AppUser a", AppUser.class)
                .getResultList();
    }

    @Override
    @Transactional
    public AppUser create(AppUser appUser) {
        entityManager.persist(appUser);
        return appUser;
    }

    @Override
    @Transactional
    public AppUser update(AppUser appUser) {
        entityManager.merge(appUser);
        return null;
    }

    @Override
    @Transactional
    public void delete(int id) {
        AppUser foundUser = entityManager.find(AppUser.class, id);
        if (foundUser != null){
            entityManager.remove(foundUser);
        } else { throw new NullPointerException("Use doesn't exist");}
    }
}
