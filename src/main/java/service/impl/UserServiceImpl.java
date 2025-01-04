package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import model.User;
import model.Account;
import repository.UserRepository;
import service.AccountFactory;
import service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AccountFactory accountFactory;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, AccountFactory accountFactory) {
        this.userRepository = userRepository;
        this.accountFactory = accountFactory;
    }

    @Override
    public User save(User user) {
        // Criar a conta automaticamente para o usuário
        Account account = accountFactory.createAccount(user);
        user.setAccount(account); // Associar a conta ao usuário

        // Salvar o usuário no repositório
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
