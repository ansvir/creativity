package entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity(name = "TUSER")
@NamedQueries({
        @NamedQuery(name = User.FIND_ALL, query = "SELECT u FROM TUSER u"),
        @NamedQuery(name = User.FIND_BY_EMAIL, query = "SELECT u FROM TUSER u WHERE u.email LIKE :email"),
        @NamedQuery(name = User.FIND_BY_NAME, query = "SELECT u FROM TUSER u WHERE u.name LIKE :name")
})
public class User implements Serializable {

    public static final String FIND_ALL = "User.findAllUsers";
    public static final String FIND_BY_EMAIL = "User.findByEmail";
    public static final String FIND_BY_NAME = "User.findByName";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    @NotNull
    private String email;
    @NotNull
    private String password;
    private String name;

    public User() {
    }

    public User(@NotNull String email, @NotNull String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
