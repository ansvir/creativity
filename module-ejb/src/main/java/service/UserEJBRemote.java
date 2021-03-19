package service;

import entity.User;

import javax.ejb.Remote;
import javax.validation.constraints.NotNull;
import java.util.List;

@Remote
public interface UserEJBRemote {

    List<User> findUsers();

    @NotNull User createUser(@NotNull User user);

    void deleteUser(@NotNull User user);

    @NotNull User updateUser(@NotNull User user);
}
