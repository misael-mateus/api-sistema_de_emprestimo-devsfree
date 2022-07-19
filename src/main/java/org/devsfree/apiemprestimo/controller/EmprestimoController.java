package org.devsfree.apiemprestimo.controller;

import org.devsfree.apiemprestimo.model.Cliente;
import org.devsfree.apiemprestimo.model.Produto;
import org.devsfree.apiemprestimo.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @PostMapping("/cliente")
    public ResponseEntity<List<Produto>> apresentarEmprestimos(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(emprestimoService.carregarEmprestimos(cliente));
    }

    @GetMapping("/modelo")
    public Cliente cliente() {
        return new Cliente("João", "SP", (byte) 18, "SP",new BigDecimal("3000") );
    }
}
