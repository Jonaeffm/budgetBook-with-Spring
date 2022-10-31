package service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import domain.AuthenticatedUser;
import domain.ProgramUser;

import repositories.ProgramUserRepository;

 
@Service
public class AuthenticatedUserService implements UserDetailsService {
 
    @Autowired
    private ProgramUserRepository userRepository;
 
    @Override
    public UserDetails loadUserByUsername(String username) {
        ProgramUser user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("The user " + username + " does not exist");
        }
        return new AuthenticatedUser(user);
    }
}