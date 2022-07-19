package org.devsfree.apiemprestimo.model;

import java.math.BigDecimal;

public record Cliente(String name,String cpf,Byte age,String uf,BigDecimal rendaMensal) {
}
