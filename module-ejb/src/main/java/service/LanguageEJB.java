package service;

import entity.Language;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import java.util.List;

import static entity.Language.*;

@Stateless
public class LanguageEJB {
    @Inject
    private EntityManager em;
    public List<Language> findLanguages() {
        TypedQuery<Language> query = em.createNamedQuery(FIND_ALL, Language.class);
        return query.getResultList();
    }

    public Language findLanguage(@NotNull Language language) {
        return em.find(Language.class, language.getId());
    }

    public
    @NotNull
    Language createLanguage(@NotNull Language language) {
        em.persist(language);
        return language;
    }

    public
    @NotNull
    Language updateLanguage(@NotNull Language language) {
        return em.merge(language);
    }

    public void deleteLanguage(@NotNull Language language) {
        em.remove(em.merge(language));
    }
}
