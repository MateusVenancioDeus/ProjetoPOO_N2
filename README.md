🏦**Projeto BancoApp N2 AT1**☕

BancoApp é um simulador de sistema bancário em Java, implementando conceitos de Programação Orientada a Objetos (POO) como:

- Herança
  
- Polimorfismo
  
- Encapsulamento
  
- Abstração

**Tratamento de exceções:**  
O sistema permite: criar contas, realizar depósitos, saques, transferências, atualizar o saldo e imprimir extratos detalhados.

**Funcionalidades:**

Tipos de contas:
- Conta Corrente: taxa de operação de 0,5% por saque
- Conta Poupança: rendimento mensal de 0,3%

**Operações bancárias:**
- Depositar valores

- Sacar valores (com validação de saldo)

- Transferir valores entre contas

- Atualização de saldo automática

- Impressão de extrato

**Tratamento de exceções:**  
SaldoInsuficienteException para saques ou transferências inválidas

💻**Estrutura do Projeto**💻  

<img width="599" height="268" alt="image" src="https://github.com/user-attachments/assets/86e987cd-67ce-4097-9333-b12799a6d909" />  


 📊 **Classes e Interfaces** 📊

- ContaBancaria (classe abstrata)

- Atributos privados: numero, titular, saldo

- Métodos públicos: depositar(), sacar(), getSaldo(), getNumero(), getTitular()

- Método protegido: setSaldo() (para subclasses)

- Método abstrato: atualizarSaldo()

**ContaCorrente**

- Taxa de operação: 0,5%

- Implementa OperacoesBancarias (transferir(), imprimirExtrato())

- Sobrescreve atualizarSaldo()

- ContaPoupanca

- Rendimento mensal: 0,3%

- Implementa OperacoesBancarias (transferir(), imprimirExtrato())

- Sobrescreve atualizarSaldo()

- OperacoesBancarias (interface)

**Métodos:**

- void transferir(ContaBancaria destino, double valor) throws SaldoInsuficienteException

- void imprimirExtrato()

- SaldoInsuficienteException (exceção personalizada)

- Lançada quando não há saldo suficiente para saque ou transferência

**Como Executar**✔️

1 - Instale o JDK (Java 8 ou superior)

2 - Compile todas as classes:

3- javac src/*.java


Execute a classe principal:

java src.ProjetoBanco


Exemplo de saída esperada:

<img width="457" height="319" alt="image" src="https://github.com/user-attachments/assets/e0415bf5-4ba6-4fd0-92e5-31f21447a624" />

✅**Conceitos de POO aplicados**✅

- Encapsulamento: atributos privados e métodos get/set controlam acesso

- Herança: subclasses herdam de ContaBancaria

- Polimorfismo: operações podem ser chamadas em qualquer tipo de conta

- Abstração: ContaBancaria define métodos genéricos implementados nas subclasses

- Tratamento de Exceções: garante operações seguras e amigáveis  

**Autor:**  
**Mateus Venâncio**

⚠️Obs!⚠️    
**Projeto criado a partir da documentação do Projeto N2 AT1**
