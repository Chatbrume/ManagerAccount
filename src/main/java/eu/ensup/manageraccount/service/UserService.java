package eu.ensup.manageraccount.service;

import eu.ensup.manageraccount.entity.User;
import eu.ensup.manageraccount.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService implements UserDetailsService
{
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll()
    {
        return userRepository.findAll();
    }

    public User findByUsername(String username)
    {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user = userRepository.findByUsername(username).orElse(null);
        if (user == null) throw new UsernameNotFoundException(username+" not found");
        return user;
    }

    public User findById(int id)
    {
        return userRepository.findById(id).orElse(null);
    }

    public User save(User user)
    {
        return userRepository.save(user);
    }

    public boolean delete(User user)
    {
        userRepository.delete(user);
        return userRepository.findById(user.getId()).orElse(null) == null;
    }

    public boolean deleteById(int id)
    {
        userRepository.deleteById(id);
        return userRepository.findById(id).orElse(null) == null;
    }
}
