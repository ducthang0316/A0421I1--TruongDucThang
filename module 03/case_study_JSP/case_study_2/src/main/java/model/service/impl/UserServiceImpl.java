package model.service.impl;

import model.bean.User;
import model.repository.UserRepository;
import model.repository.impl.UserRepositoryImpl;
import model.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserRepository userRepository = new UserRepositoryImpl();
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean isUser(User user) {
        List<User> userList = userRepository.findAll();
        boolean check = false;
        for (User registeredUser: userList) {
            if (user.getUsername().equals(registeredUser.getUsername()) && user.getPassword().equals(registeredUser.getPassword())){
                check = true;
                break;
            }
        }
        return check;
    }
}
