package br.com.mvcomida.encomenda.controller;

import br.com.mvcomida.encomenda.dao.CadastroDao;
import br.com.mvcomida.encomenda.model.Cadastro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
public class MainController {
    @Autowired
    private CadastroDao cadastroDao;

    @GetMapping("/")
    public String paginaInicial() {
        return "index";
    }

    @GetMapping("/cadastrar")
    public String paginaDeCadastro(@ModelAttribute("cadastro") Cadastro cadastro, BindingResult result) {
        if (result.hasErrors()) {
            return "error";
        } else {
            return "cadastrar";
        }
    }

    @GetMapping("/listar")
    public String listarColaboradores(Model model) {
        model.addAttribute("cadastro", cadastroDao.findAll());
        return "listar";
    }

    @PostMapping("/cadastrar")
    public String salvarColaborador(@ModelAttribute("cadastro") Cadastro cadastro, BindingResult result) {
        if (result.hasErrors()) {
            return "error";
        } else {
            cadastroDao.save(cadastro);
            return "redirect:listar";
        }
    }

    @PostMapping("/deletar/details")
    @ResponseBody
    public RedirectView deletarCadastro(@RequestParam(defaultValue = "id") int id) {
        cadastroDao.deleteById(id);
        return new RedirectView("/listar");
    }

    @RequestMapping(value = "/editar/details", method = RequestMethod.POST)
    @ResponseBody
    public RedirectView editarCadastro(@RequestParam(defaultValue = "id") int id, Model model) {
        //int key = Integer.parseInt(id);
        model.addAttribute("cadastro", cadastroDao.getById(id));
        System.out.println(model);
        return new RedirectView("/cadastrar");
    }
}