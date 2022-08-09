package br.com.fiap.esporte.controller;

import br.com.fiap.esporte.model.Atleta;
import br.com.fiap.esporte.repository.AtletaRepository;
import br.com.fiap.esporte.repository.ModalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("atleta")
public class AtletaController {

    @Autowired
    private AtletaRepository atletaRepository;

    @Autowired
    private ModalidadeRepository modalidadeRepository;

    @GetMapping("buscar")
    public String buscar(String nomeBusca, Model model ){
        model.addAttribute("atletas", atletaRepository.findByNomeContainsIgnoreCase(nomeBusca));
        return "atleta/lista";
    }

    @GetMapping("listar")
    public String listar(Model model){
        model.addAttribute("atletas", atletaRepository.findAll());
        return "atleta/lista";
    }

    @GetMapping("cadastrar")
    public String cadastrar(Atleta atleta, Model model){
        model.addAttribute("modalidades", modalidadeRepository.findAll());
        return "atleta/form";
    }

    @PostMapping("cadastrar")
    public String cadastrar(Atleta atleta, RedirectAttributes redirect){
        atletaRepository.save(atleta);
        redirect.addFlashAttribute("msg", "Cadastrado");
        return "redirect:/atleta/cadastrar";
    }

}
