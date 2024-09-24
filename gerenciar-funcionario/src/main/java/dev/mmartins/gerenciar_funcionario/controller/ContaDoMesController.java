package dev.mmartins.gerenciar_funcionario.controller;

import dev.mmartins.gerenciar_funcionario.entity.ContasDoMes;
import dev.mmartins.gerenciar_funcionario.service.ContaDoMesService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/contas")
public class ContaDoMesController {
    private final ContaDoMesService service;

    public ContaDoMesController(final ContaDoMesService contaDoMesService) {
        this.service = contaDoMesService;
    }

    @GetMapping
    public ModelAndView index() {
        final ModelAndView modelAndView = new ModelAndView("/contas");
        modelAndView.addObject("contas", service.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView indexCreate(final ContasDoMes conta) {
        final ModelAndView modelAndView = new ModelAndView("/contas-create");
        modelAndView.addObject("conta", conta);
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(final ContasDoMes conta, final BindingResult result) {

        if(result.hasErrors()) {
            return indexCreate(conta);
        }

        service.create(conta);

        return index();
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
        return indexCreate(service.findOne(id));
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("cpf") Long id) {
        service.delete(id);
        return index();
    }

}
