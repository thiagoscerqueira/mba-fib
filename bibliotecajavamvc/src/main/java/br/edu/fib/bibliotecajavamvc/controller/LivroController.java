package br.edu.fib.bibliotecajavamvc.controller;

import br.edu.fib.bibliotecajavamvc.model.Livro;
import br.edu.fib.bibliotecajavamvc.repository.AutorRepository;
import br.edu.fib.bibliotecajavamvc.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.Binding;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @GetMapping
    public ModelAndView livros() {
        List<Livro> livros = livroRepository.findAll();
        for (Livro livro : livros) {
            System.out.println(livro.getTitulo());
        }
        return new ModelAndView("livros/list", "livros", livros);
    }

    @GetMapping("/novo")
    public ModelAndView novo(@ModelAttribute Livro livro) {
        return new ModelAndView("livros/form","autores", autorRepository.findAll());
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Long id) {
        Livro livro = this.livroRepository.findOne(id);
        return modelAndViewEdicaoLivro(livro);
    }

    private ModelAndView modelAndViewEdicaoLivro(Livro livro) {
        ModelAndView model = new ModelAndView("livros/form", "livro", livro);
        model.addObject("autores", autorRepository.findAll());
        return model;
    }

    @PostMapping
    public ModelAndView create(@Valid Livro livro, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return modelAndViewEdicaoLivro(livro);
        }

        livro = livroRepository.save(livro);
        return new ModelAndView("redirect:/livros");
    }

    @GetMapping("/excluir/{id}")
    public ModelAndView excluir(@PathVariable("id") Long id) {
        this.livroRepository.delete(id);
        return new ModelAndView("redirect:/livros");
    }

}
