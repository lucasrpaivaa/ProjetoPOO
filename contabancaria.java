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
        this.nomeFantasia = "UniCrente";
        this.CNPJ = "00.623.904/0001-73";
        this.nome = "Lucas Paiva";
        this.senha = "adm_control";
    }

    public Empresa(String nomeFantasia, String CNPJ, String nome, String senha) {
        this.nomeFantasia = nomeFantasia;
        this.CNPJ = CNPJ;
        this.nome = nome;
        this.senha = senha;
    }

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

    public boolean autenticar(String nome, String senha) {
        return this.nome.equals(nome) && this.senha.equals(senha);
    }
}

class Cliente {

    private String nome;
    private String contato;

    public Cliente(String nome, String contato) {
        this.nome = nome;
        this.contato = contato;
    }

    public String getNome() {
        return nome;
    }

    public String getContato() {
        return contato;
    }

    public void listar(int identificador, String nome) {
        System.out.println(identificador + " - " + nome);
    }
}

class Funcionario {

    protected String nome;
    protected Float salario;

    public Funcionario(String nome, Float salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    void listar(int numero, String texto) {
        System.out.println("X: " + numero + " | NOME: " + texto);
    }
}

class Atendimento extends Funcionario implements Autenticar {

    private String senha;

    public Atendimento(String nome, Float salario, String senha) {
        super(nome, salario);
        this.senha = senha;
    }

    public boolean autenticar(String nome, String senha) {
        return this.nome.equals(nome) && this.senha.equals(senha);
    }
}

class Dentista extends Funcionario {

    private String sala;

    public Dentista(String nome, Float salario, String sala) {
        super(nome, salario);
        this.sala = sala;
    }

    public String getSala() {
        return sala;
    }

    @Override
    void listar(int identificador, String nome) {
        System.out.println(identificador + " - " + nome);
    }
}

class Consulta {
    private static int contadorId = 1;
    private String dentistaNome;
    private String dentistaSala;
    private String clienteNome;
    private String clienteContato;
    private int idConsulta;
    private String dia;
    private String hora;
    private String tipoConsulta;
    private double valor;

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

    public int getIdConsulta() {
        return idConsulta;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "\t * * * ID Consulta: " + idConsulta + " * * * " +
               "\nDentista: " + dentistaNome + "\tSala: " + dentistaSala +
               "\nCliente: " + clienteNome + "\tContato: " + clienteContato +
               "\nData: " + dia + "\tHora: " + hora + "\tTipo: " + tipoConsulta +
               "\n--------------------------------| Valor: R$" + String.format("%.2f", valor);
    }
}

public class PI_POO_C2 {
    private static final List<Dentista> dentistas = new ArrayList<>();
    private static final List<Cliente> clientes = new ArrayList<>();
    private static final List<Consulta> consultas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        dentistas.add(new Dentista("Dr. Vinicius Cavalcante", 3000.0f, "001"));
        dentistas.add(new Dentista("Dra. Deolane", 2500.0f, "002"));
        clientes.add(new Cliente("Gustavo Mendes", "99999-9999"));
        clientes.add(new Cliente("Italo Teixeira", "99999-9999"));
        clientes.add(new Cliente("Lucas Paiva", "99999-9999"));
        clientes.add(new Cliente("Down", "99999-9999"));

        Empresa empresa = new Empresa();
        Atendimento atendente01 = new Atendimento("Elon Musk", 1500.0f, "file18");
        Atendimento atendente02 = new Atendimento("Barack Obama", 1500.0f, "file24");

        System.out.print("\nNome Fantasia da empresa: ");
        empresa.setNomeFantasia(scanner.nextLine());
        System.out.print("\nDigite o CNPJ da empresa: ");
        empresa.setCNPJ(scanner.nextLine());
        System.out.print("\nNome do dono da empresa: ");
        empresa.setNome(scanner.nextLine());
        System.out.print("\nSenha de acesso do dono: ");
        empresa.setSenha(scanner.nextLine());
        
        System.out.println("\n\n * * * * * AUTENTICAÇÃO " + empresa.getNomeFantasia() + " * * * * * \n");

        while (true) {
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Senha: ");
            String senha = scanner.nextLine();

            boolean acessoPermitido = empresa.autenticar(nome, senha) || atendente01.autenticar(nome, senha) || atendente02.autenticar(nome, senha);
            if (!acessoPermitido) {
                System.out.println("\n\t ERROR: ACESSO NEGADO.\n");
            } else {
                System.out.println("\n\tLOGIN BEM-SUCEDIDO!");
                break;
            }
        }

        while (true) {
            System.out.println("\n\n * * * * * BEM-VINDO " + empresa.getNomeFantasia() + " * * * * * \n");
            System.out.println("1 - Cadastrar uma nova consulta");
            System.out.println("0 - Sair e Exibir todas consultas cadastradas");
            System.out.print("Escolha: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                System.out.println("\n\n * * * * * CADASTRAR CONSULTA * * * * * \n");

                for (int i = 0; i < dentistas.size(); i++) {
                    dentistas.get(i).listar(i+1, dentistas.get(i).getNome());
                }
                System.out.print("\nEscolha um dentista: ");
                int dentistaEscolha = scanner.nextInt() - 1;
                scanner.nextLine();
                Dentista dentista = dentistas.get(dentistaEscolha);

                System.out.println("\n---------------------------------");
                for (int i = 0; i < clientes.size(); i++) {
                    clientes.get(i).listar(i+1, clientes.get(i).getNome());
                }
                System.out.print("\nEscolha um cliente: ");
                int clienteEscolha = scanner.nextInt() - 1;
                scanner.nextLine();
                Cliente cliente = clientes.get(clienteEscolha);

                System.out.println("\n---------------------------------");
                int dia;
                while (true) {
                    System.out.print("Dia da consulta (1 - 31): ");
                    dia = scanner.nextInt();
                    if (dia >= 1 && dia <= 31) {
                        break;
                    }
                    System.out.println("\n\tERROR: DIA INVÁLIDO\n");
                }
                int mes;
                while (true) {
                    System.out.print("Mês da consulta (1 - 12): ");
                    mes = scanner.nextInt();
                    if (mes >= 1 && mes <= 12) {
                        break;
                    }
                    System.out.println("\n\tERROR: MÊS INVÁLIDO\n");
                }
                int ano;
                while (true) {
                    System.out.print("Ano da consulta: ");
                    ano = scanner.nextInt();
                    if (ano >= 2024 && ano <= 2124) {
                        break;
                    }
                    System.out.println("\n\tERROR: ANO INVÁLIDO\n");
                }
                String data = String.format("%02d/%02d/%04d", dia, mes, ano);

                scanner.nextLine();
                System.out.print("Hora da consulta (hh:mm): ");
                String hora = scanner.nextLine();

                System.out.print("Tipo da consulta: ");
                String tipo = scanner.nextLine();

                System.out.print("Valor da consulta: R$");
                double valor = scanner.nextDouble();
                scanner.nextLine();

                Consulta consulta = new Consulta(dentista.getNome(), dentista.getSala(), cliente.getNome(), cliente.getContato(), data, hora, tipo, valor);
                consultas.add(consulta);
            } else if (opcao == 0) {
                System.out.println("\n\n * * * * * CONSULTAS AGENDADAS * * * * * \n");

                for (Consulta consulta : consultas) {
                    System.out.println(consulta);
                }

                double lucro = consultas.stream().mapToDouble(Consulta::getValor).sum();
                int quantidade = consultas.size();

                System.out.println("\nO lucro obtido foi de: R$" + lucro);
                System.out.println("A quantidade de consultas marcadas foi: " + quantidade);
                System.out.println("\n\tSAÍDA DO PROGRAMA!\n");
                break;
            } else {
                System.out.println("\n\tERROR: OPÇÃO INVÁLIDA\n");
            }
        }
        scanner.close();
    }
}
