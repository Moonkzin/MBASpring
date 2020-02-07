package br.com.fiap.cervejaria.service.impl;

import br.com.fiap.cervejaria.entity.User;
import br.com.fiap.cervejaria.repository.UserRepository;
import br.com.fiap.cervejaria.service.CreateUserDTO;
import br.com.fiap.cervejaria.service.UserDTO;
import br.com.fiap.cervejaria.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO create(CreateUserDTO createCervejaDTO) {
        User user = new User();
        user.setUsername(createCervejaDTO.getUsername());
        user.setPassword(createCervejaDTO.getPassword());

        User savedUser = user
    }
}
