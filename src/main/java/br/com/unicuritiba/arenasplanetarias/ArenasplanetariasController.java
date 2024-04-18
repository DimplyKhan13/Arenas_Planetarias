package br.com.unicuritiba.arenasplanetarias;

import br.com.unicuritiba.arenasplanetarias.models.*;
import br.com.unicuritiba.arenasplanetarias.repositories.*;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.List;

@Controller
public class ArenasplanetariasController {

    @Autowired
    private ArenaRepository repositorio;

    @GetMapping({ "/" })
    public ModelAndView listArenas(Model model) {

        List<Arena> arenas = repositorio.findAll();

        ModelAndView view = new ModelAndView("arenaList");
        view.addObject("arenas", arenas);

        return view;

    }

    @GetMapping("/cadastro")
    public ModelAndView createArenaForm(Model model) {

        ModelAndView view = new ModelAndView("cadastro");
        view.addObject("arena", new Arena());

        return view;

    }

    @PostMapping("/cadastro")
    public String addArena(
            Arena arena,
            Model model,
            BindingResult result) {

        repositorio.save(arena);
        return "redirect:/";
    }

}
