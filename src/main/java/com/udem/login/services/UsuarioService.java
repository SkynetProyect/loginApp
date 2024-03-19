package com.udem.login.services;

import com.udem.login.model.User;
import com.udem.login.repository.UserRepository;
import com.udem.login.services.Impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UserRepository userRepository;
    public ArrayList<User> getUsers(){
        return (ArrayList<User>) userRepository.findAll();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public Optional<User> getById(Long id){
        return userRepository.findById(id);
    }

    public User updateById(User request, Long id){
        User user = userRepository.findById(id).get();

        user.setNombre(request.getNombre());
        user.setUsuario(request.getUsuario());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        return user;
    }

    public Boolean deleteUser(Long id){
        try{
            userRepository.deleteById(id);
            return true;
        }catch(Exception e){return false;}
    }
}
