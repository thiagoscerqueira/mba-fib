package br.edu.fib.bibliotecajavamvc.controller;

import br.edu.fib.bibliotecajavamvc.model.Autor;
import br.edu.fib.bibliotecajavamvc.model.Livro;
import br.edu.fib.bibliotecajavamvc.repository.AutorRepository;
import br.edu.fib.bibliotecajavamvc.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @GetMapping
    public ModelAndView autores() {
        List<Autor> autores = autorRepository.findAll();
        return new ModelAndView("autores/list", "autores", autores);
    }

    @GetMapping("/novo")
    public String novo(@ModelAttribute Autor autor) {
        return "autores/form";
    }

    @GetMapping("/{id}")
    public ModelAndView alterar(@PathVariable("id") Long id) {
        Autor autor= this.autorRepository.findOne(id);
        return new ModelAndView("autores/form", "autor", autor);
    }

    @PostMapping
    public ModelAndView create(@ModelAttribute @Valid Autor autor, BindingResult bindingResult, RedirectAttributes attributes) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("autores/form");
        }
        autorRepository.save(autor);
        attributes.addFlashAttribute("mensagem", "Autor salvo com sucesso");
        return new ModelAndView("redirect:/autores");
    }

    @GetMapping("/excluir/{id}")
    public ModelAndView excluir(@PathVariable("id") Long id) {
        this.autorRepository.delete(id);
        return new ModelAndView("redirect:/autores");
    }
}
