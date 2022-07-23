package org.devsfree.apiemprestimo;

import org.devsfree.apiemprestimo.model.Cliente;
import org.devsfree.apiemprestimo.model.Produto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class EmprestimoService {

    @Autowired
    org.devsfree.apiemprestimo.service.EmprestimoService service;

    @Test
    public void testarCasoUm() {
        Cliente cliente = new Cliente("João", "123.456.789-00", (byte) 20, "SP", new BigDecimal(2000));
        List<Produto> produtos = service.carregarEmprestimos(cliente);
        System.out.println("************************* CASO UM *************************");
        produtos.forEach(System.out::println);
        System.out.println("*************************#########*************************");
        Assertions.assertEquals(2, produtos.size());
    }

    @Test
    public void testarCasoDois() {
        Cliente cliente = new Cliente("João", "123.456.789-00", (byte) 20, "SP", new BigDecimal(4000));
        List<Produto> produtos = service.carregarEmprestimos(cliente);
        System.out.println("************************* CASO DOIS *************************");
        produtos.forEach(System.out::println);
        System.out.println("*************************#########*************************");
        Assertions.assertEquals(2, produtos.size());
    }

    @Test
    public void testarCasoTres() {
        Cliente cliente = new Cliente("João", "123.456.789-00", (byte) 20, "SP", new BigDecimal(6000));
        List<Produto> produtos = service.carregarEmprestimos(cliente);
        System.out.println("************************* CASO TRES *************************");
        produtos.forEach(System.out::println);
        System.out.println("*************************#########*************************");
        Assertions.assertEquals(3, produtos.size());
    }

    @Test
    public void naoDeveConcederEmprestimo() {
        List<Produto> produtos;
        Cliente c2 = new Cliente("João", "123.456.789-00", (byte) 31, "DF", new BigDecimal(4000));
        Assertions.assertEquals(0, service.carregarEmprestimos(c2).size());
        Cliente c3 = new Cliente("João", "123.456.789-00", (byte) 44, "SP", new BigDecimal(2000));
        Assertions.assertEquals(0, service.carregarEmprestimos(c3).size());
        Cliente c4 = new Cliente("João", "123.456.789-00", (byte) 44, "SP", new BigDecimal(1000));
        Assertions.assertEquals(0, service.carregarEmprestimos(c4).size());
        Cliente c5 = new Cliente("João", "123.456.789-00", (byte) 17, "SP", new BigDecimal(0));
        Assertions.assertEquals(0, service.carregarEmprestimos(c5).size());
        Cliente c6 = new Cliente("João", "123.456.789-00", (byte) 90, "RJ", new BigDecimal(-1000));
        Assertions.assertEquals(0, service.carregarEmprestimos(c6).size());
        Cliente c7 = new Cliente("João", "123.456.789-00", (byte) 0, "SP", new BigDecimal(-2000));
        Assertions.assertEquals(0, service.carregarEmprestimos(c7).size());
        Cliente c8 = new Cliente("João", "123.456.789-00", (byte) 3, "AL", new BigDecimal(-3000));
        Assertions.assertEquals(0, service.carregarEmprestimos(c8).size());
        Cliente c9 = new Cliente("João", "123.456.789-00", (byte) 39, "SP", new BigDecimal(-4000));
        Assertions.assertEquals(0, service.carregarEmprestimos(c9).size());
        Cliente c10 = new Cliente("João", "123.456.789-00", (byte) 17, "SP", new BigDecimal(-5000));
        Assertions.assertEquals(0, service.carregarEmprestimos(c10).size());
    }
}