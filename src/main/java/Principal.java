import model.Funcionario;
import service.FuncionarioService;
import util.FormatUtils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class Principal {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();
        FuncionarioService service = new FuncionarioService();

        // Inserindo funcionários
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));

        // Remover João
        funcionarios.removeIf(f -> f.getNome().equals("João"));

        // Imprimir
        System.out.println("==== Lista de Funcionários ====");
        service.imprimirFuncionarios(funcionarios);

        // Reajuste 10%
        service.aplicarReajuste(funcionarios, 0.10);

        // Agrupar por função
        System.out.println("\n==== Funcionários agrupados por função ====");
        service.imprimirAgrupados(service.agruparPorFuncao(funcionarios));

        // Aniversariantes
        System.out.println("\n==== Aniversariantes Outubro e Dezembro ====");
        service.imprimirAniversariantes(funcionarios, 10, 12);

        // Mais velho
        var maisVelho = service.funcionarioMaisVelho(funcionarios);
        if (maisVelho != null) {
            int idade = java.time.Period.between(maisVelho.getDataNascimento(), LocalDate.now()).getYears();
            System.out.println("\nMais velho: " + maisVelho.getNome() + " - " + idade + " anos");
        }

        // Ordenados
        System.out.println("\n==== Ordem Alfabética ====");
        service.imprimirOrdenados(funcionarios);

        // Total salários
        System.out.println("\nTotal salários: " + FormatUtils.formatCurrency(service.calcularTotalSalarios(funcionarios)));

        // Salários mínimos
        System.out.println("\n==== Salários Mínimos ====");
        service.imprimirSalariosMinimos(funcionarios, new BigDecimal("1212.00"));
    }
}
