import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Autenticar {
boolean autenticar(String nome, String senha);
}

class Empresa implements Autenticar {

private String nomeFantasia;
private String CNPJ;
private String nome;
private String senha;

public Empresa() {
this.nomeFantasia = "BITBUILDERS";
this.CNPJ = "00.623.904/0001-73";
this.nome = "Lucas Bastos";
this.senha = "adm_control";
}
// Construtor com parâmetros
public Empresa(String nomeFantasia, String CNPJ, String nome, String senha) {
this.nomeFantasia = nomeFantasia;
this.CNPJ = CNPJ;
this.nome = nome;
this.senha = senha;
}
// Métodos getters e setters
public String getNomeFantasia() {
return nomeFantasia;
}
public void setNomeFantasia(String nomeFantasia) {
this.nomeFantasia = nomeFantasia;
}
public String getCNPJ() {
return CNPJ;
}
public void setCNPJ(String CNPJ) {
this.CNPJ = CNPJ;
}
public String getNome() {
return nome;
}
public void setNome(String nome) {
this.nome = nome;
}
public String getSenha() {
return senha;
}
public void setSenha(String senha) {
this.senha = senha;
}
// Método de autenticação
public boolean autenticar(String nome, String senha) {
return this.nome.equals(nome) && this.senha.equals(senha);
}
}
// Classe que representa um Cliente
class Cliente {
// Atributos de cliente
private String nome;
private String contato;
// Construtor da classe
public Cliente(String nome, String contato) {
this.nome = nome;
this.contato = contato;
}
// Métodos getters
public String getNome() {
return nome;
}
public String getContato() {
return contato;
}
// Método de listar
public void listar(int identificador, String nome) {
System.out.println(identificador + " - " + nome);
}
}
// Classe pai que representa Funcionario
class Funcionario {
// Atributos do Funcionario
protected String nome;
protected Float salario;
// Construtor com parâmetros
public Funcionario(String nome, Float salario) {
this.nome = nome;
this.salario = salario;
}
// Método getter para o nome
public String getNome() {
return nome;
}
// Polimorfismo sobreposição atual
void listar(int numero, String texto) {
System.out.println("X: " + numero + " | NOME" + texto);
}
}
// Classe Filho Atendimento que herda de Funcionario e implementa Autenticar
class Atendimento extends Funcionario implements Autenticar {
// Atributos de Atendimento
private String senha;
// Construtor com parâmetros
public Atendimento(String nome, Float salario, String senha) {
super(nome, salario);
this.senha = senha;
}
// Método de autenticação
public boolean autenticar(String nome, String senha) {
return this.nome.equals(nome) && this.senha.equals(senha);
}
}
// Classe Filho Dentista que herda de Funcionario
class Dentista extends Funcionario{
// Atributos de dentista
private String sala;
// Construtor da classe
public Dentista(String nome, Float salario, String sala) {
super(nome, salario);
this.sala = sala;
}
// Métodos getters e setters
public String getSala() {
return sala;
}
// Implementação de Polimorfismo Sobreposição
@Override
void listar(int identificador, String nome) {
System.out.println(identificador + " - " + nome);
}
}
// Classe que representa um Consulta
class Consulta {
private static int contadorId = 1; // Variável estática para gerar IDs únicos para cada consulta
// Atributos de dentista
private String dentistaNome; // Nome do dentista
private String dentistaSala; // Sala do dentista
// Atributos de cliente
private String clienteNome; // Nome do cliente
private String clienteContato; // Contato do cliente
// Atributos da consulta
private int idConsulta; // ID
private String dia; // Dia
private String hora; // Hora
private String tipoConsulta; // Tipo
private double valor; // consulta
// Construtor da classe Consulta, inicializa os dados da consulta
public Consulta(String dentistaNome, String dentistaSala, String clienteNome, String clienteContato, String dia, String hora, String tipoConsulta, double valor) {
this.idConsulta = contadorId++;
this.dentistaNome = dentistaNome;
this.dentistaSala = dentistaSala;
this.clienteNome = clienteNome;
this.clienteContato = clienteContato;
this.dia = dia;
this.hora = hora;
this.tipoConsulta = tipoConsulta;
this.valor = valor;
}
// Métodos getters
public int ID() {
return 1;
}
public double getValor() {
return valor;
}
// Método para um Polimorfismo de sobrecarga
int somar(int a, int b) {
return a + b;
}
double somar(double a, double b) {
return a + b;
}
// Sobrescreve o método toString para exibir as informações da consulta
public String toString() {
return "\t * * * ID Consulta: " + idConsulta + " * * * " +
"\nDentista: " + dentistaNome + "\tSala: " + dentistaSala +
"\nCliente: " + clienteNome + "\t\tContato: " + clienteContato +
"\nDia: " + dia + "\t| Hora: " + hora + "\t| Tipo: " + tipoConsulta +
"\n--------------------------------| valor: R$" + valor;
}
}
// Classe principal do sistema
public class PI_POO_C2 {
private static final List<Dentista> dentistas = new ArrayList<>();
private static final List<Cliente> clientes = new ArrayList<>();
private static final List<Consulta> consultas = new ArrayList<>();
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
// Cadastrar dentistas e clientes pré-definidos
dentistas.add(new Dentista("Dr. Vinicius Mergalhaes", 3000.0f, "001"));
dentistas.add(new Dentista("Dr. Maria Cristina", 2500.0f, "002"));
clientes.add(new Cliente("Jonatas Carmago", "91234-1234"));
clientes.add(new Cliente("Victor Hugo", "91234-5678"));
clientes.add(new Cliente("Joao Miguel", "92424-6969"));
clientes.add(new Cliente("Gustavo Henrique", "99876-5432"));
// Criando instância da Empresa
Empresa empresa = new Empresa();
Atendimento atendente01 = new Atendimento("Amabile Zukerg", 1500.0f, "file18");
Atendimento atendente02 = new Atendimento("Kaua Barbosa", 1500.0f, "file24");
System.out.println("\nNome Fantasia da empresa: ");
String nomeFantasia = scanner.nextLine();
empresa.setNomeFantasia(nomeFantasia);
System.out.println("\nDigita o CNPJ da empresa: ");
String CNPJ = scanner.nextLine();
empresa.setCNPJ(CNPJ);
System.out.println("\nNome do dono da empresa: ");
String nome = scanner.nextLine();
empresa.setNome(nome);
System.out.println("\nSenha de acesso do dono: ");
String senha = scanner.nextLine();
empresa.setSenha(senha);
System.out.println("\n\n * * * * * AUTENTICAÇÃO " + empresa.getNomeFantasia() + " * * * * * \n");
// Tela de login
while (true) {
System.out.print("Nome: ");
nome = scanner.nextLine();
System.out.print("Senha: ");
senha = scanner.nextLine();
// Verifica se o usuário é autorizado
boolean acessoPermitido = empresa.autenticar(nome, senha) || atendente01.autenticar(nome, senha) || atendente02.autenticar(nome, senha);
if (!acessoPermitido) {
System.out.println("\n\t ERROR: ACESSO NEGADO.\n");
} else {
System.out.println("\n\tLOGIN BEM-SUCEDIDO!");
break;
}
}
// Menu principal
while (true) {
System.out.println("\n\n * * * * * BEM-VINDO " + empresa.getNomeFantasia() + " * * * * * \n");
System.out.println("1 - Cadastrar uma nova consulta");
System.out.println("0 - Sair e Exibir todas consultas cadastradas");
System.out.println("Escolha: ");
int opcao = scanner.nextInt();
scanner.nextLine();
if (opcao == 1) {
System.out.println("\n\n * * * * * CADASTRAR CONSULTA * * * * * \n");
// Selecionar dentista
for (int i = 0; i < dentistas.size(); i++) {
dentistas.get(i).listar(i+1, dentistas.get(i).getNome());
}
System.out.println("\nEscolha um dentista:");
int dentistaEscolha = scanner.nextInt() - 1;
scanner.nextLine();
Dentista dentista = dentistas.get(dentistaEscolha);
// Selecionar cliente
System.out.println("\n---------------------------------");
for (int i = 0; i < clientes.size(); i++) {
clientes.get(i).listar(i+1, clientes.get(i).getNome());
}
System.out.println("\nEscolha um cliente:");
int clienteEscolha = scanner.nextInt() - 1;
scanner.nextLine(); // Consumir o newline
Cliente cliente = clientes.get(clienteEscolha);
// Coletar dados do dia da consulta
System.out.println("\n---------------------------------");
int dia;
while (true) {
System.out.println("Dia da consulta (1 - 31): ");
dia = scanner.nextInt();
if (dia >= 1 && dia <= 31) {
break;
}
System.out.println("\n\tERROR: DIA INVÁLIDO\n");
}
System.out.println("\n");
int mes;
while (true) {
System.out.println("mês da consulta (1 - 12): ");
mes = scanner.nextInt();
if (mes >= 1 && mes <= 12) {
break;
}
System.out.println("\n\tERROR: MÊS INVÁLIDO\n");
}
System.out.println("\n");
int ano;
while (true) {
System.out.println("Ano da consulta: ");
ano = scanner.nextInt();
if (ano >= 2024 && ano <= 2124) {
break;
}
System.out.println("\n\tERROR: ANO INVÁLIDO\n");
}
String data = String.format("%02d/%02d/%04d", dia, mes, ano);
// Coletar dados da hora da consulta
System.out.println("\n---------------------------------");
int hora;
while (true) {
System.out.println("Que horas (9 - 21): ");
hora = scanner.nextInt();
if (hora >= 9 && hora <= 21) {
break;
}
System.out.println("\n\tERROR: HORA INVÁLIDO\n");
}
System.out.println("\n");
int minutos;
while (true) {
System.out.println("Em qual minutos: ");
minutos = scanner.nextInt();
if (minutos >= 1 && minutos <= 59) {
break;
}
System.out.println("\n\tERROR: MINUTOS INVÁLIDO\n");
}
String horadefinida = String.format("%02d:%02d", hora, minutos);
// Escolher o tipo de consulta
System.out.println("\n---------------------------------");
int tipoEscolha = 0;
String tipoConsulta = "";
double limiteMinimo = 50.00, limiteMaximo = 100.00;
// Define o tipo de consulta com base na escolha do usuário
while(tipoEscolha < 1 || tipoEscolha > 3) {
System.out.println("1 - Avaliação Odontológica");
System.out.println("2 - Arrumar Aparelho");
System.out.println("3 - Limpeza de Cárie");
System.out.println("Escolha o tipo de consulta:");
tipoEscolha = scanner.nextInt();
scanner.nextLine(); // Consumir o newline
// condição de ajuste das opção é pre-preparo de valor
if (tipoEscolha >= 1 && tipoEscolha <= 3) {
switch (tipoEscolha) {
case 1:
tipoConsulta = "Avaliação Odontológica";
limiteMinimo = 100.00;
limiteMaximo = 250.00;
break;
case 2:
tipoConsulta = "Arrumar Aparelho";
limiteMinimo = 150.00;
limiteMaximo = 300.00;
break;
case 3:
tipoConsulta = "Limpeza";
limiteMinimo = 150.00;
limiteMaximo = 500.00;
break;
}
break;
} else {
System.out.println("\n\tERROR: OPÇÃO ERRADO\n");
}
}
// Definir o valor de consulta
System.out.println("\n---------------------------------");
double valor;
// Define o o valor com base na escolha do usuário
while(true) {
System.out.print("Digite o valor da consulta, entre " + limiteMinimo + " e " + limiteMaximo + "\n(com virgula): ");
valor = scanner.nextDouble();
if (valor >= limiteMinimo && valor <= limiteMaximo) {
break;
} else {
System.out.println("\n\tERROR: OPÇÃO ERRADO\n");
}
}
// Cria e registra uma nova consulta
Consulta consulta = new Consulta(dentista.getNome(), dentista.getSala(), cliente.getNome(), cliente.getContato(), data, horadefinida, tipoConsulta, valor);
consultas.add(consulta);
System.out.println("\n\tCONSULTA REGISTRADA COM SUCESSO!");
} else if (opcao == 0) {
System.out.println("\n\tCONSULTAS REGISTRADAS:");
// Exbir todas as consultas registrar
for (Consulta consulta : consultas) {
System.out.println("\n" + consulta.toString());
}
// Exibir a quantidade de lucro é quantidade de consultas
System.out.println("\n * * * * * * * * * * * * * * * * * * * * ");
double lucro = 0;
for (int i = 0; i < consultas.size(); i++) {
lucro = consultas.get(i).somar(lucro, consultas.get(i).getValor());
}
System.out.println("\nO lucro obtido foi de: " + lucro);
int quantidade = 0;
for (int i = 0; i < consultas.size(); i++) {
quantidade = consultas.get(i).somar(quantidade, consultas.get(i).ID());
}
System.out.println("A quantidade de consultas marcadas foi: " + quantidade);
System.out.println("\n\tSAIDO DO PROGRAMA!\n");
break;
} else {
System.out.println("\n\tERROR: OPÇÃO INVÁLIDA!");
}
}
scanner.close();
}
}
