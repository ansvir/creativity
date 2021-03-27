package entity;

import logic.name.generation.Letter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "TLANGUAGE")
@NamedQueries({
        @NamedQuery(name = Language.FIND_ALL, query = "SELECT l FROM TLANGUAGE l"),
})
public class Language implements Serializable {

    public static final String FIND_ALL = "Language.findAllLanguages";
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Culture> cultures;
    public Language() {
    }

    public Language(String name, String description, List<Culture> cultures) {
        this.name = name;
        this.description = description;
        this.cultures = cultures;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Culture> getCultures() {
        return cultures;
    }

    public void setCultures(List<Culture> cultures) {
        this.cultures = cultures;
    }

    @Override
    public String toString() {
        return "Language{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cultures=" + cultures +
                '}';
    }
}
