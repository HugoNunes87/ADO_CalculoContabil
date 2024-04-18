package funcionarios;
import java.util.Scanner;

public class Funcionario {
	public String nomeFuncionario;
	public double salarioBruto, salarioLiquido, vt, vr, convenioMedico, va, irpf, inss, horaExtra, bonus;
	
	public String GetNome(){
		return nomeFuncionario;
	}
	
	public static void CadastroFuncionario(){
		Scanner reader = new Scanner(System.in);
		System.out.println(" _______________________________________________________________");
		System.out.println("|\t\t\t\t\t\t\t\t|");
		System.out.println("|\t\t\t Bem vindo ao Holeri+ \t\t\t|");
		System.out.println("|_______________________________________________________________|");
		System.out.printf("\tDigite quantos funcionarios você deseja cadastrar: ");
		int qtdFuncionarios = reader.nextInt();
		
		for(int i = 0; i < qtdFuncionarios; i++){
			Funcionario f1 = new Funcionario();
			System.out.printf("|\t\t     Cadastro do %dº funcionario\t\t        |\n", i+1);
		}
	}
	
}
