package service;

import model.Funcionario;
import util.FormatUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class FuncionarioService {

    public void imprimirFuncionarios(List<Funcionario> funcionarios) {
        funcionarios.forEach(System.out::println);
    }

    public void aplicarReajuste(List<Funcionario> funcionarios, double percentual) {
        funcionarios.forEach(f ->
                f.setSalario(f.getSalario().multiply(BigDecimal.valueOf(1 + percentual)))
        );
    }

    public Map<String, List<Funcionario>> agruparPorFuncao(List<Funcionario> funcionarios) {
        return funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));
    }

    public void imprimirAgrupados(Map<String, List<Funcionario>> agrupados) {
        agrupados.forEach((funcao, lista) -> {
            System.out.println(funcao + ":");
            lista.forEach(f -> System.out.println(" - " + f.getNome()));
        });
    }

    public void imprimirAniversariantes(List<Funcionario> funcionarios, int... meses) {
        Set<Integer> mesesSet = Arrays.stream(meses).boxed().collect(Collectors.toSet());
        funcionarios.stream()
                .filter(f -> mesesSet.contains(f.getDataNascimento().getMonthValue()))
                .forEach(f -> System.out.println(f.getNome() + " - " + FormatUtils.formatDate(f.getDataNascimento())));
    }

    public Funcionario funcionarioMaisVelho(List<Funcionario> funcionarios) {
        return funcionarios.stream()
                .min(Comparator.comparing(Funcionario::getDataNascimento))
                .orElse(null);
    }

    public void imprimirOrdenados(List<Funcionario> funcionarios) {
        funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .forEach(System.out::println);
    }

    public BigDecimal calcularTotalSalarios(List<Funcionario> funcionarios) {
        return funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void imprimirSalariosMinimos(List<Funcionario> funcionarios, BigDecimal salarioMinimo) {
        funcionarios.forEach(f -> {
            BigDecimal qtd = f.getSalario().divide(salarioMinimo, 2, BigDecimal.ROUND_HALF_UP);
            System.out.println(f.getNome() + ": " + qtd + " salários mínimos");
        });
    }
}
