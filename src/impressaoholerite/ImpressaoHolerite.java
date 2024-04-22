package impressaoholerite;

import funcionarios.Funcionario;
import java.util.Scanner;

public class ImpressaoHolerite {

	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);
		String iniciarPrograma;

		System.out.println(" _______________________________________________________________");
		System.out.println("|\t\t\t\t\t\t\t\t|");
		System.out.println("|\t\t\t Bem vindo ao Holeri+ \t\t\t|");
		System.out.println("|_______________________________________________________________|");

		do { 
			System.out.printf("\tVocê quer iniciar o programa? (s/n): ");
			iniciarPrograma = reader.nextLine();

			switch (iniciarPrograma) {
			case "s":
				Funcionario.CadastroFuncionario();
				break;
			case "n":
				System.out.println("Fim do programa.");
				System.exit(0);
				break;
			default:
				System.out.println("Resposta Inválida, por favor selecione 's' para sim e 'n' para não");
			}
		} while (!iniciarPrograma.equals("s") && !iniciarPrograma.equals("n"));

	}
}
