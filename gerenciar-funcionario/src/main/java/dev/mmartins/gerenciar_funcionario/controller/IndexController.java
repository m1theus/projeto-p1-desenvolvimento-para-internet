package dev.mmartins.gerenciar_funcionario.controller;

import dev.mmartins.gerenciar_funcionario.service.ContaDoMesService;
import dev.mmartins.gerenciar_funcionario.service.FuncionarioService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class IndexController {
    private final ContaDoMesService contaDoMesService;
    private final FuncionarioService funcionarioService;

    public IndexController(final ContaDoMesService contaDoMesService, final FuncionarioService funcionarioService) {
        this.contaDoMesService = contaDoMesService;
        this.funcionarioService = funcionarioService;
    }

    @GetMapping
    public ModelAndView index() {
        final ModelAndView modelAndView = new ModelAndView("/dashboard");
        modelAndView.addObject("contas", contaDoMesService.count());
        modelAndView.addObject("funcionarios", funcionarioService.count());
        modelAndView.addObject("topDespesas", contaDoMesService.findTopContas());
        modelAndView.addObject("topSalarios", funcionarioService.findTopSalarios());
        return modelAndView;
    }
}
