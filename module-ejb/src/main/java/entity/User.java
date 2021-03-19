package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "TUSER")
@NamedQueries({
        @NamedQuery(name = User.FIND_ALL, query = "SELECT u FROM TUSER u"),
        @NamedQuery(name = User.FIND_BY_EMAIL, query = "SELECT u FROM TUSER u WHERE u.email = :email")
})
public class User implements Serializable {

    public static final String FIND_ALL = "User.findAllUsers";
    public static final String FIND_BY_EMAIL = "User.findByEmail";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String email;
    private String password;

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
