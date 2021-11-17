package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.UserModel;

import java.util.List;

public interface UserService {
    UserModel addUser(UserModel user);
    public String encrypt(String password);
    List<UserModel> getListUser();
    UserModel findByUsername(String username);
    void deleteUser(UserModel user);
    boolean passwordMatches(UserModel user, String oldPassword);
    boolean updateUser(UserModel user, String newPassword, String confirmPassword);
    boolean customPasswordVal(String password);
}
