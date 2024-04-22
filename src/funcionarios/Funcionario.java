package funcionarios;

import calculocontabil.Descontos;
import calculocontabil.Ganhos;
import java.util.Scanner;

public class Funcionario {
	static public String nome;
	static public double salario, salarioTributavel, totalVT, totalVR, convenioMedico, totalVA, irpf, inss, horasExtras,
			bonus;
	static public int quantDependente, jornadaTrabalho;

	public String GetNome() {
		return nome;
	}

	public static void CadastroFuncionario() {
		Scanner reader = new Scanner(System.in);
		String opcaovt;
		String ophrextra;
		String opJornada;
		String opBoni;
		String quantDep;
		String opVR;
		String opVA;
		String opCV;


		int qtdFuncionarios = 0; // Variável para armazenar o número de
									// funcionários

		while (true) {
			try {
				System.out.println(" _______________________________________________________________ ");
				System.out.print("\tDigite quantos funcionários você deseja cadastrar: ");
				qtdFuncionarios = Integer.parseInt(reader.nextLine());
				break; // Sai do loop se a entrada for um número inteiro válido
			} catch (NumberFormatException e) {
				System.out.println("\t\t Por favor, insira um número válido.");
			}
		}

		for (int i = 0; i < qtdFuncionarios; i++) {
			Funcionario[] funcionarios = new Funcionario[qtdFuncionarios];
			funcionarios[i] = new Funcionario();
			System.out.println(" _______________________________________________________________ ");
			System.out.printf("\t\t     Cadastro do %dº funcionario\t\t        \n", i + 1);
			System.out.print("\t\t Digite o nome: ");
			funcionarios[i].nome = reader.nextLine();
			System.out.printf("\tDigite o salário base de %s: ", Funcionario.PrimeiroNome(funcionarios[i].nome));
			funcionarios[i].salario = reader.nextDouble();
			reader.nextLine();

			int horas = 0;
			do {
				System.out.println(" _______________________________________________________________ ");
				System.out.println(
						" \tSelecione a jornada de horas para o funcionário: \n\t\t\t1. 220 horas \n\t\t\t2. 200 horas\n\t\t\t3. 180 horas");
				System.out.printf(" \t\tDigite sua escolha: ");
				horas = reader.nextInt();
				reader.nextLine();
				switch (horas) {
				case 1: {
					funcionarios[i].jornadaTrabalho = 220;
					break;
				}
				case 2: {
					funcionarios[i].jornadaTrabalho = 200;
					break;
				}
				case 3: {
					funcionarios[i].jornadaTrabalho = 180;
					break;
				}
				default:
					System.out.println("Opção inválida, selecione numero de 1 a 3!");
				}
			} while (horas != 1 && horas != 2 && horas != 3);

			System.out.println(" _______________________________________________________________ ");

			do { // saber se o funcionario recebe o vt e retornando para a
					// pergunta caso a resposta seja invalida
				System.out.printf("\tO funcionário recebe Vale Transporte? (s/n): ");
				opcaovt = reader.nextLine();
				switch (opcaovt) {
				case "s":
					System.out.printf("\tDigite o valor total do VT de %s R$: ",
							Funcionario.PrimeiroNome(funcionarios[i].nome));
					funcionarios[i].totalVT = reader.nextDouble();
					reader.nextLine();
					break;
				case "n":
					funcionarios[i].totalVT = 0;
					break;
				default:
					System.out.println("Resposta Inválida, por favor selecione 's' para sim e 'n' para não");
				}
			} while (!opcaovt.equals("s") && !opcaovt.equals("n"));
			System.out.println(" _______________________________________________________________ ");

			do { // Calculo Horas Extras
				System.out.printf("\tO funcionário possuí horas extras?(s/n): ");
				ophrextra = reader.nextLine();

				switch (ophrextra) {
				case "s":
					System.out.print(" Informe a quantidade de horas extras realizadas no mês: ");
					funcionarios[i].horasExtras = reader.nextDouble();
					reader.nextLine();
					break;
				case "n":
					funcionarios[i].horasExtras = 0;
					break;
				default:
					System.out.println("\t Resposta Inválida, por favor selecione 's' para sim e 'n' para não");
				}
			} while (!ophrextra.equals("s") && !ophrextra.equals("n"));

			System.out.println(" _______________________________________________________________ ");
			do { // Calculo Bonus
				System.out.print("\t O funcionário possuí alguma Bonificação?(s/n): ");
				opBoni = reader.nextLine();

				switch (opBoni) {
				case "s":
					System.out.printf("\tDigite o valor da bonicação R$: ");
					funcionarios[i].bonus = reader.nextDouble();
					reader.nextLine();
					break;
				case "n":
					funcionarios[i].bonus = 0;
					break;
				default:
					System.out.println("\tResposta Inválida, por favor selecione 's' para sim e 'n' para não");
				}
			} while (!opBoni.equals("s") && !opBoni.equals("n"));

			System.out.println(" _______________________________________________________________ ");

			do { // Inserir Quantidade de Dependentes
				System.out.print("\tO funcionáio possui dependentes?(s/n): ");
				quantDep = reader.nextLine();
				switch (quantDep) {
				case "s":
					System.out.printf("  Informe a quantidade de dependentes do funcionário: ");
					funcionarios[i].quantDependente = reader.nextInt();
					reader.nextLine();
					break;
				case "n":
					funcionarios[i].quantDependente = 0;
					break;
				default:
					System.out.println("\tResposta Inválida, por favor selecione 's' para sim e 'n' para não");
				}
			} while (!quantDep.equals("s") && !quantDep.equals("n"));
			
			System.out.println(" _______________________________________________________________ ");

			do { // Desconto do VR
				System.out.print("\tO funcionário possuí Vale-Refeição?(s/n): ");
				opVR = reader.nextLine();

				switch (opVR) {
				case "s":
					System.out.printf("\tDigite o valor do Vale-Refeição R$: ");
					funcionarios[i].totalVR = reader.nextDouble();
					reader.nextLine();
					break;
				case "n":
					funcionarios[i].totalVR = 0;
					break;
				default:
					System.out.println("Resposta Inválida, por favor selecione 's' para sim e 'n' para não");
				}
			} while (!opVR.equals("s") && !opVR.equals("n"));
			
			System.out.println(" _______________________________________________________________ ");

			do { // Desconto do VA
				System.out.print("\tO funcionário possuí Vale-Alimentação?(s/n): ");
				opVR = reader.nextLine();

				switch (opVR) {
				case "s":
					System.out.printf("\tDigite o valor do Vale-Alimentação R$: ");
					funcionarios[i].totalVA = reader.nextDouble();
					reader.nextLine();
					break;
				case "n":
					funcionarios[i].totalVA = 0;
					break;
				default:
					System.out.println("\tResposta Inválida, por favor selecione 's' para sim e 'n' para não");
				}
			} while (!opVR.equals("s") && !opVR.equals("n"));
			
			System.out.println(" _______________________________________________________________ ");

			do { // Desconto do Convenio Medico
				System.out.print("\t O funcionário possuí Convenio Medico?(s/n): ");
				opVR = reader.nextLine();

				switch (opVR) {
				case "s":
					System.out.printf("|\tDigite o valor do Convenio Medico R$: ");
					funcionarios[i].convenioMedico = reader.nextDouble();
					reader.nextLine();
					break;
				case "n":
					funcionarios[i].convenioMedico = 0;
					break;
				default:
					System.out.println("Resposta Inválida, por favor selecione 's' para sim e 'n' para não");
				}
			} while (!opVR.equals("s") && !opVR.equals("n"));
			

			float DescontoVR = (float) Descontos.ValeRefeicao(salario, totalVR); //1º casting

			float totalDescontos = (float) (Descontos.INSS(salario) + Descontos.IRPF(salario, quantDependente) //2º casting
					+ Descontos.ValeTransporte(salario, totalVT) + Descontos.ValeRefeicao(salario, totalVR)
					+ Descontos.ValeAlimentacao(salario, totalVA) + Descontos.ConvenioMedico(salario));
			double salarioBruto = Ganhos.GanhosTotais(salario, bonus, horasExtras, jornadaTrabalho);
			double salarioLiquido = salarioBruto - totalDescontos;

			System.out.println(" _______________________________________________________________");
			System.out.println("|\t\t\t\t\t\t\t\t|");
			System.out.println("|\t\t\t\tHolerite  \t\t\t|");
			System.out.println("|_______________________________________________________________|\n");
			System.out.printf("\t Nome do Funcionário: %s \n", nome);

			System.out.println(" _______________________________________________________________");
			// chamando metodos da classe ganhos
			System.out.printf(" Débitos:\n");
			System.out.printf("\t\t Salário base: R$%.2f \t\t\t\n", salario);
			System.out.printf("\t\t Total horas extras: R$%.2f \t\t\t\n",
					Ganhos.HoraExtra(salario, jornadaTrabalho, horasExtras));
			System.out.printf("\t\t Bonificação: R$%.2f \t\t\t\t \n", bonus);
			System.out.printf("\t\t Salário Bruto: R$%.2f \t\t\t \n",
					Ganhos.GanhosTotais(salario, bonus, horasExtras, jornadaTrabalho));

			// chamando metodos da classe descontos
			System.out.printf(" Créditos:\n");
			System.out.printf("\t\t Desconto INSS: R$%.2f\n", Descontos.INSS(salario));
			System.out.printf("\t\t Desconto IRPF: R$%.2f\n", Descontos.IRPF(salarioBruto, quantDependente));
			System.out.printf("\t\t Desconto Vale Transporte: R$%.2f\n", Descontos.ValeTransporte(salario, totalVT));
			System.out.printf("\t\t Desconto Vale Refeição: R$%.2f\n", Descontos.ValeRefeicao(salario, totalVR));
			System.out.printf("\t\t Desconto Vale Alimentação: R$%.2f\n", Descontos.ValeAlimentacao(salario, totalVA));
			System.out.printf("\t\t Desconto Convenio Médico: R$%.2f\n", Descontos.ConvenioMedico(salario));
			System.out.printf("\t\t Desconto Total descontos: R$%.2f\n", totalDescontos);
			System.out.printf("\t\t Desconto Salário Liquido: R$%.2f\n", salarioLiquido);
			System.out.println(" _______________________________________________________________");
		}

		System.out.println(" _______________________________________________________________");
		System.out.println("|\t\t\t\t\t\t\t\t|");
		System.out.println("|\t\t\t Fim do Cadastro \t\t\t|");
		System.out.println("|_______________________________________________________________|");
		System.out.println("");
		System.out.printf("Você gostaria de adicionar um novo funcionário? (s/n): ");
		String addNovoFuncionario = reader.nextLine();
		switch (addNovoFuncionario) {
		case "s":
			CadastroFuncionario();
			break;
		case "n":
			System.out.println("Fim do programa.");
			System.exit(0);
		}

	}

	public static String PrimeiroNome(String nome) { // método para pegar o primeiro nome do funcionario
		int index = nome.lastIndexOf(' ');
		if (index == -1) {
			return nome; // Se não houver espaço, retorna o nome completo
		}
		return nome.substring(0, index);
	}

}
