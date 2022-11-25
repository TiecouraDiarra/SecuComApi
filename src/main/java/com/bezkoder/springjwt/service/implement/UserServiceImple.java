package com.bezkoder.springjwt.service.implement;

import com.bezkoder.springjwt.models.Role;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.repository.RoleRepository;
import com.bezkoder.springjwt.repository.UserRepository;
import com.bezkoder.springjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImple implements UserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository repositoryUsers;

    @Override
    public String Supprimer(Long id_users) {
        repositoryUsers.deleteById(id_users);
        return "Supprimer avec succes";
    }


    @Override
    public String Modifier(User users) {
        return repositoryUsers.findById(users.getId()).map(
                use ->{
                    use.setEmail(users.getEmail());
                    //use.setName(users.getName());
                    use.setUsername(users.getUsername());
                    use.setPassword(passwordEncoder.encode(users.getPassword()));

                    repositoryUsers.save(use);
                    return "Modification reussie avec succès";
                }
        ).orElseThrow(() -> new RuntimeException("Cet utilisateur n'existe pas"));

    }

    @Override
    public User Ajouter(User utilisateur) {
        return null;
    }
}
