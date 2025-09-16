# 🏭 Teste Prático – Programação em Java  

Este projeto foi desenvolvido como parte de um **teste prático de programação em Java**.
O sistema gerencia informações de funcionários e executa operações como cálculos salariais, agrupamentos e relatórios.  

---

## 📂 Estrutura do Projeto  

```text
src/
└── main/java/
    ├── model/
    │   ├── Pessoa.java          # Classe base para representar pessoas
    │   └── Funcionario.java     # Extensão de Pessoa com salário e função
    ├── service/
    │   └── FuncionarioService.java  # Regras de negócio do sistema
    ├── util/
    │   └── FormatUtils.java     # Utilitários para formatação de datas e valores
    └── Principal.java           # Classe principal que executa os requisitos
```
---

## 🚀 Funcionalidades Implementadas  

- ✅ Cadastro inicial dos funcionários (conforme tabela fornecida)  
- ✅ Remoção de funcionário por nome  
- ✅ Impressão formatada (datas e salários em formato brasileiro)  
- ✅ Reajuste salarial de 10%  
- ✅ Agrupamento de funcionários por função  
- ✅ Filtros de aniversariantes (meses 10 e 12)  
- ✅ Identificação do funcionário mais velho  
- ✅ Ordenação alfabética  
- ✅ Cálculo do total dos salários  
- ✅ Quantos salários mínimos cada funcionário recebe (base: R$1212,00)  

---

## 🛠 Tecnologias  

- **Java 17+**  
- **Maven** (gerenciamento de dependências)  

---

## ▶️ Como Executar  

1. Clonar ou baixar o projeto  
git clone https://github.com/MatteusP/teste-java.git 
cd java-teste-pratico  

2. Compilar com Maven  
mvn compile  

3. Executar  
mvn exec:java -Dexec.mainClass=Principal  

> Ou, se estiver usando **VS Code / IntelliJ / Eclipse**, basta rodar a classe `Principal.java`.

---

## 🎨 Diferenciais do Projeto  

- Estrutura organizada em camadas (**model**, **service**, **util**)  
- Métodos reutilizáveis para facilitar manutenção  
- Código comentado e autoexplicativo  
- Uso de **Java Streams** e **API de Datas** para clareza e performance  
- Foco em boas práticas e legibilidade  

---

## ✨ Autor  

**Mateus Paiva Alves**  
Engenheiro de Computação | Desenvolvedor
📧 mateuspaivadev@gmail.com
💼 [LinkedIn](https://www.linkedin.com/in/matteusp)
