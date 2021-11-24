package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.UserModel;
import apap.tutorial.emsidi.repository.UserDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDb userDb;

    @Override
    public UserModel addUser(UserModel user) {
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);
        return userDb.save(user);
    }

    @Override
    public String encrypt(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

    @Override
    public List<UserModel> getListUser() { return userDb.findAll(); }

    @Override
    public UserModel findByUsername(String username) { return userDb.findByUsername(username); }

    @Override
    public void deleteUser(UserModel user) { userDb.delete(user); }

    @Override
    public boolean passwordMatches(UserModel user, String oldPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(oldPassword, user.getPassword());
    }

    @Override
    public boolean updateUser(UserModel user, String newPassword, String confirmPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(newPassword);
        if (newPassword.equals(confirmPassword) && customPasswordVal(newPassword)) {
            user.setPassword(hashedPassword);
            userDb.save(user);
            return true;
        } else { return false; }
    }

    @Override
    public boolean customPasswordVal(String password) {
        boolean length = false;
        boolean lowerCase = false;
        boolean upperCase = false;
        boolean number = false;
        boolean symbol = false;
        if (password.length() >= 8) {
            length = true;
        }
        for (char i: password.toCharArray()) {
            if(Character.isLowerCase(i)) { lowerCase = true; }
            if(Character.isUpperCase(i)) { upperCase = true; }
            if(Character.isDigit(i)) { number = true; }
            if (Pattern.matches("\\p{Punct}", String.valueOf(i))) { symbol = true; }
        }
        return length && lowerCase && upperCase && number && symbol;
    }
}
