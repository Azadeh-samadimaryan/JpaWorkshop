package se.lexicon.jpaworkshop.data;

import se.lexicon.jpaworkshop.entity.AppUser;

import java.util.Collection;

public interface AppUserDao {
    AppUser findById(int id);
    Collection<AppUser> findAll();
    AppUser create(AppUser appUser);
    AppUser update(AppUser appUser);
    void delete(int id);

}
