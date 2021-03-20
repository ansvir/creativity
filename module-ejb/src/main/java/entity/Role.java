package entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity(name="TROLE")
@NamedQueries({
        @NamedQuery(name = Role.FIND_ALL, query = "SELECT r FROM TROLE r"),
        @NamedQuery(name = Role.FIND_BY_NAME, query = "SELECT r FROM TROLE r WHERE r.name LIKE :name")
})
public class Role implements Serializable {

    public static final String FIND_ALL = "Role.findAllRoles";
    public static final String FIND_BY_NAME = "Role.findByName";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique=true)
    @NotNull
    private String name;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
