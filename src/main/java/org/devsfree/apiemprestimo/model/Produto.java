package org.devsfree.apiemprestimo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Produto {
    private Emprestimo emprestimo;
    private BigDecimal taxa;
}
