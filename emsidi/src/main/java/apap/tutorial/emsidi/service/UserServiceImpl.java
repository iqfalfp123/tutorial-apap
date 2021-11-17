package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.UserModel;
import apap.tutorial.emsidi.repository.UserDB;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDB userDB;

    @Override
    public UserModel addUser(UserModel user) {
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);
        return userDB.save(user);
    }

    @Override
    public String encrypt(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

    @Override
    public List<UserModel> findAll() {
        return userDB.findAll();
    }

    @Override
    public UserModel getUserByUsername(String username) {
        UserModel user = userDB.findByUsername(username);
        return user;
    }

    @Override
    public void deleteUser(UserModel user) {
        userDB.delete(user);
    }
    @Override
    public void updateUser(UserModel user, String newPassword) {
        String pass = encrypt(newPassword);
        user.setPassword(pass);
        userDB.save(user);
    }

}
