package service.impl;

import model.User;
import service.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private final List<User> users = new ArrayList<>();

    @Override
    public User save(User user) {
        users.add(user);
        return user; // Retorna o objeto salvo
    }

    @Override
    public User update(User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == user.getId()) {
                users.set(i, user);
                return user; // Retorna o objeto atualizado
            }
        }
        return null; // Se não encontrado
    }

    @Override
    public void delete(Long id) {
        users.removeIf(user -> user.getId() == id);
    }

    @Override
    public User findById(Long id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users);
    }
}