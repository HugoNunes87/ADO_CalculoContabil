package funcionarios;
import java.util.Scanner;

public class Funcionario {
	static public String nome;
	static public double salarioBruto, salarioLiquido, vt, totalVT, vr, convenioMedico, va, irpf, inss, horaExtra, bonus;
	static boolean recebeVT;
	
	public String GetNome(){
		return nome;
	}
	
	public static void CadastroFuncionario(){
		Scanner reader = new Scanner(System.in);
		String opcaovt;
		
		System.out.println(" _______________________________________________________________");
		System.out.println("|\t\t\t\t\t\t\t\t|");
		System.out.println("|\t\t\t Bem vindo ao Holeri+ \t\t\t|");
		System.out.println("|_______________________________________________________________|");
		System.out.printf("      Digite quantos funcionarios você deseja cadastrar: ");
		int qtdFuncionarios = reader.nextInt();
		reader.nextLine();
		
		for(int i = 0; i < qtdFuncionarios; i++){
			Funcionario[] funcionarios = new Funcionario[qtdFuncionarios];
			funcionarios[i] = new Funcionario();
			System.out.printf("|\t\t     Cadastro do %dº funcionario\t\t        |\n", i+1);
			System.out.print("|\t Digite o nome: ");
			funcionarios[i].nome = reader.nextLine();
			System.out.printf("|\tDigite o salário bruto de %s: ", Funcionario.PrimeiroNome(funcionarios[i].nome));
			funcionarios[i].salarioBruto = reader.nextDouble();
			reader.nextLine();
			
			do{ // saber se o funcionario recebe o vt e retornando para a pergunta caso a resposta seja invalida
				System.out.print("O funcionário recebe Vale Transporte? (s/n)");
				opcaovt = reader.nextLine();
				System.out.println(opcaovt);
			switch (opcaovt){
				case "s":
					System.out.printf("|\tDigite o valor total do VT de %s: ", Funcionario.PrimeiroNome(funcionarios[i].nome));
					funcionarios[i].totalVT = reader.nextDouble();
					break;
				case "n":
					funcionarios[i].recebeVT = false;
					totalVT = 0;
					break;
				default:
					System.out.println("Resposta Inválida, por favor selecione 's' para sim e 'n' para não");
				}
			} while (!opcaovt.equals("s") && !opcaovt.equals("n"));
			
			System.out.println(funcionarios[i].nome +" " + funcionarios[i].salarioBruto +" "+ funcionarios[i].totalVT);
			
			
			//precisa saber se ele fez hora extra e se ele tem bonus. dps disso é só jogar as variaveis nos metodos de descontos e ganhos
		}
	}
	
    public static String PrimeiroNome(String nome) { //método para pegar o primeiro nome do funcionario
        int index = nome.lastIndexOf(' ');
        if (index == -1) {
            return nome; // Se não houver espaço, retorna o nome completo
        }
        return nome.substring(0, index);
    }
}
