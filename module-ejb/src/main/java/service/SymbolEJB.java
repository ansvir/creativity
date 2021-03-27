package service;

import entity.Symbol;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import java.sql.Blob;
import java.util.List;

import static entity.Symbol.*;

@Stateless
public class SymbolEJB {
    @Inject
    private EntityManager em;
    public List<Symbol> findSymbols() {
        TypedQuery<Symbol> query = em.createNamedQuery(FIND_ALL, Symbol.class);
        return query.getResultList();
    }

    public Symbol findSymbol(@NotNull Symbol symbol) {
        return em.find(Symbol.class, symbol.getId());
    }

    public
    @NotNull
    Symbol createSymbol(@NotNull Symbol symbol) {
        em.persist(symbol);
        return symbol;
    }

    public
    @NotNull
    Symbol updateSymbol(@NotNull Symbol symbol) {
        return em.merge(symbol);
    }

    public void deleteSymbol(@NotNull Symbol symbol) {
        em.remove(em.merge(symbol));
    }
}
