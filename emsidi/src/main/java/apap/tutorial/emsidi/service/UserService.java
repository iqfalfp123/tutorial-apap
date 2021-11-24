package apap.tutorial.emsidi.service;

import java.util.List;

import apap.tutorial.emsidi.model.UserModel;

public interface UserService {
    UserModel addUser(UserModel user);

    public String encrypt(String password);

    List<UserModel> findAll();

    UserModel getUserByUsername(String username);

    public void deleteUser(UserModel user);

    public void updateUser(UserModel user, String newPassword);
}
