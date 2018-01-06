package br.edu.fib.bibliotecajavamvc.controller;

import br.edu.fib.bibliotecajavamvc.model.Autor;
import br.edu.fib.bibliotecajavamvc.model.Usuario;
import br.edu.fib.bibliotecajavamvc.repository.AutorRepository;
import br.edu.fib.bibliotecajavamvc.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ModelAndView usuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return new ModelAndView("usuarios/list", "usuarios", usuarios);
    }

    @GetMapping("/novo")
    public String novo(@ModelAttribute Usuario usuario) {
        return "usuarios/form";
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Long id) {
        Usuario usuario= this.usuarioRepository.findOne(id);
        return new ModelAndView("usuarios/form", "usuario", usuario);
    }

    @PostMapping
    public ModelAndView create(@ModelAttribute @Valid Usuario usuario, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("usuarios/form");
        }

        usuario = usuarioRepository.save(usuario);
        return new ModelAndView("redirect:/usuarios");
    }

    @GetMapping("/excluir/{id}")
    public ModelAndView excluir(@PathVariable("id") Long id) {
        this.usuarioRepository.delete(id);
        return new ModelAndView("redirect:/usuarios");
    }
}
