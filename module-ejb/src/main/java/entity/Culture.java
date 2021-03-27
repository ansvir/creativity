package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "TCULTURE")
@NamedQueries({
        @NamedQuery(name = Culture.FIND_ALL, query = "SELECT c FROM TCULTURE c"),
})
public class Culture implements Serializable {

    public static final String FIND_ALL = "Culture.findAllCultures";
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Symbol> symbols;

    public Culture() {
    }

    public Culture(String name, List<Symbol> symbols) {
        this.name = name;
        this.symbols = symbols;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Symbol> getSymbols() {
        return symbols;
    }

    public void setSymbols(List<Symbol> symbols) {
        this.symbols = symbols;
    }

    @Override
    public String toString() {
        return "Culture{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", symbols=" + symbols +
                '}';
    }
}

