package org.devsfree.apiemprestimo.service;

import java.math.BigDecimal;

public class EmprestimoFactory {
    public static boolean verificaSalarioAbaixoDeTresMil(BigDecimal bigDecimal) {
        return bigDecimal.compareTo(new BigDecimal(3000)) <= 0 &&
                bigDecimal.compareTo(new BigDecimal(0)) >= 0;
    }

    public static boolean verificarRegrasParaRendaAbaixoDeTresMil(Byte age, String uf) {
        return verificarSeClienteTemMenosDeTrintaAnos(age) && uf.equals("SP");
    }

    public static boolean verificaSalarioMaiorQueTresMil(BigDecimal bigDecimal) {
        return bigDecimal.compareTo(new BigDecimal(3000)) > 0;
    }

    public static boolean verificarSeMoraEmSp(String uf) {
        return uf.equals("SP");
    }

    public static boolean verificaSalarioAcimaDeCincoMil(BigDecimal bigDecimal) {
        return bigDecimal.compareTo(new BigDecimal(5000)) >= 0;
    }

    public static boolean verificarSeClienteTemMenosDeTrintaAnos(Byte age) {
        return age < 30 && age > 17;
    }

    public static boolean verificarMaiorIdade(Byte age) {
        return age >= 18;
    }
}
