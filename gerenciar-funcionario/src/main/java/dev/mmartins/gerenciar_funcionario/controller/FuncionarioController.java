package dev.mmartins.gerenciar_funcionario.controller;

import dev.mmartins.gerenciar_funcionario.entity.Funcionario;
import dev.mmartins.gerenciar_funcionario.repository.FuncionarioRepository;
import dev.mmartins.gerenciar_funcionario.service.FuncionarioService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FuncionarioController {
    private final FuncionarioService service;
    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioController(final FuncionarioService service, FuncionarioRepository funcionarioRepository) {
        this.service = service;
        this.funcionarioRepository = funcionarioRepository;
    }

    @GetMapping("/funcionarios")
    public ModelAndView index() {
        final ModelAndView modelAndView = new ModelAndView("/funcionarios");
        modelAndView.addObject("funcionarios", service.findAll());
        return modelAndView;
    }

    @GetMapping("/funcionarios/create")
    public ModelAndView indexCreate(final Funcionario funcionario, final String action) {
        final ModelAndView modelAndView = new ModelAndView("/funcionarios-create");
        modelAndView.addObject("funcionario", funcionario);
        modelAndView.addObject("action", action == null ? "create" : action);
        return modelAndView;
    }

    @PostMapping("/funcionarios/create")
    public ModelAndView create(final Funcionario funcionario, final BindingResult result) {

        try {
            if (result.hasErrors()) {
                return indexCreate(funcionario, "create");
            }

            service.create(funcionario);

            return index();
        } catch (final Exception e) {
            final ModelAndView modelAndView = new ModelAndView("/funcionarios-create");
            modelAndView.addObject("funcionario", funcionario);
            modelAndView.addObject("error", "Falha ao salvar funcionário!");
            modelAndView.addObject("action", "create");
            return modelAndView;
        }
    }

    @GetMapping("/funcionarios/edit/{cpf}")
    public ModelAndView edit(@PathVariable("cpf") String cpf) {
        return indexCreate(service.findOne(cpf), "update");
    }

    @GetMapping("/funcionarios/delete/{cpf}")
    public ModelAndView delete(@PathVariable("cpf") String id) {
        service.delete(id);
        return index();
    }
    
}
