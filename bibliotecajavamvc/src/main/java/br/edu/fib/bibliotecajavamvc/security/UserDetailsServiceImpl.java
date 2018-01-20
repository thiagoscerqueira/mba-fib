package br.edu.fib.bibliotecajavamvc.security;

import br.edu.fib.bibliotecajavamvc.model.Usuario;
import br.edu.fib.bibliotecajavamvc.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = usuarioService.findByUsername(username);
        Set<SimpleGrantedAuthority> listAuthority = user.getGrupos()
                .stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getGrupo().name()))
                .collect(toSet());

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                listAuthority);
    }
}
