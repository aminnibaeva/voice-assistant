package ru.kpfu.voice_assistant.security;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.kpfu.voice_assistant.entity.User;
import ru.kpfu.voice_assistant.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(
            () -> new UsernameNotFoundException("Пользователь с такой почтой не найден"));
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
            user.getPassword(), mapRolesToAuthorities(user.getRole())
        );
    }

    private List<SimpleGrantedAuthority> mapRolesToAuthorities(User.Role role) {
        return Collections.singletonList(new SimpleGrantedAuthority(role.name()));
    }
}

