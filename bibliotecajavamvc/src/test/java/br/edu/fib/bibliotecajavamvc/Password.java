package br.edu.fib.bibliotecajavamvc;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Password {

    @Test
    public void printPass() {
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }
}
