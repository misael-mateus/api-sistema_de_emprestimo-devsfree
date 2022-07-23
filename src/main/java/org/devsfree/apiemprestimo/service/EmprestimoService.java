package org.devsfree.apiemprestimo.service;

import org.devsfree.apiemprestimo.model.Cliente;
import org.devsfree.apiemprestimo.model.Emprestimo;
import org.devsfree.apiemprestimo.model.Produto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.devsfree.apiemprestimo.service.EmprestimoFactory.*;

@Service
public class EmprestimoService {

    public List<Produto> carregarEmprestimos(Cliente cliente) {
        List<Produto> produtos = new ArrayList<>();
        Produto garantia = new Produto(Emprestimo.EMPRESTIMO_GARANTIA, new BigDecimal("0.03"));
        Produto pessoal = new Produto(Emprestimo.EMPRESTIMO_PESSOAL, new BigDecimal("0.04"));
        Produto consignado = new Produto(Emprestimo.EMPRESTIMO_CONSIGNADO, new BigDecimal("0.02"));

        if (verificarSeClienteTemMenosDeTrintaAnos(cliente.age()) && verificaSalarioAcimaDeCincoMil(cliente.rendaMensal())) {
            produtos.add(consignado);
            produtos.add(garantia);
            produtos.add(pessoal);
            return produtos;
        }
        if ((verificaSalarioAbaixoDeTresMil(cliente.rendaMensal()) &&
                verificarRegrasParaRendaAbaixoDeTresMil(cliente.age(), cliente.uf()))
                ||
                (verificaSalarioMaiorQueTresMil(cliente.rendaMensal()) &&
                        verificarSeMoraEmSp(cliente.uf()))) {
            produtos.add(pessoal);
            produtos.add(garantia);
            return produtos;
        }
        return produtos;
    }
}
