package funcionarios;
import calculocontabil.Ganhos;
import java.util.Scanner;

public class Funcionario {
	static public String nome;
	static public double salarioBruto, salarioLiquido, vt, totalVT, vr, convenioMedico, va, irpf, inss, hrExtra, bonus, jnHora;
	static boolean recebeVT;
	
	public String GetNome(){
		return nome;
	}
	
	public static void CadastroFuncionario(){
		Scanner reader = new Scanner(System.in);
		String opcaovt;
		String ophrextra;
		String opJornada;
		String opBoni;
		
		System.out.println(" _______________________________________________________________");
		System.out.println("|\t\t\t\t\t\t\t\t|");
		System.out.println("|\t\t\t Bem vindo ao Holeri+ \t\t\t|");
		System.out.println("|_______________________________________________________________|");
		//System.out.printf("      Digite quantos funcionarios você deseja cadastrar: ");
		//int qtdFuncionarios = reader.nextInt();
		//reader.nextLine();
                
                int qtdFuncionarios = 0; // Variável para armazenar o número de funcionários
                
                while (true) {
                    try {
                        System.out.print("Digite quantos funcionários você deseja cadastrar: ");
                        qtdFuncionarios = Integer.parseInt(reader.nextLine());
                        break; // Sai do loop se a entrada for um número inteiro válido
                } catch (NumberFormatException e) {
                    System.out.println("Por favor, insira um número válido.");
                    }   
                }        
		
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
				System.out.printf("O funcionário recebe Vale Transporte? (s/n)");
				opcaovt = reader.nextLine();
				//System.out.println(opcaovt);
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
			
			//System.out.println(funcionarios[i].nome +" " + funcionarios[i].salarioBruto +" "+ funcionarios[i].totalVT);
			
			
			//precisa saber se ele fez hora extra e se ele tem bonus. dps disso é só jogar as variaveis nos metodos de descontos e ganhos

                        
                        int HR = 1;                       
                        while (HR == 1) {
                            System.out.println("| --------------------------------------------\n");
                            System.out.println("| Selecione a jornada de horas para o funcionário: \n1. 220 horas \n2. 200 horas\n3. 180 horas");
                            System.out.println("| --------------------------------------------\n");
                            System.out.printf("Digite sua escolha: ");
                            int horas = reader.nextInt();
                            reader.nextLine();
                            switch (horas) {
                                case 1 -> {
                                    funcionarios[i].jnHora = 220;
                                    HR = 0;
                                }
                                case 2 -> {
                                    funcionarios[i].jnHora = 200;
                                    HR = 0;
                                }
                                case 3 -> {
                                    funcionarios[i].jnHora = 180;
                                    HR = 0;
                                }
                                default ->
                                    System.out.println("Opção inválida.");
                            }

                        }
                        System.out.println("| \n--------------------------------------------\n");                       
                        
                                              
                        do { // Calculo Horas Extras
				System.out.print("O funcionário possuí horas extras?(s/n)");
				ophrextra = reader.nextLine();
			switch (ophrextra){
				case "s":
                                        System.out.println("\nInforma a quantidade de horas extras realizadas no mês:");
                                        System.out.printf("Quantidade de horas extras: ");
                                        
                                        double HRExtra = reader.nextDouble();
                                        Ganhos.HoraExtra(funcionarios[i].salarioBruto, funcionarios[i].jnHora, HRExtra);                                  
					break;
				case "n":
                                    System.out.println("Funcionario não recebe Horas Extras");
				default:
					System.out.println("Resposta Inválida, por favor selecione 's' para sim e 'n' para não");
				}
			} while (!ophrextra.equals("s") && !ophrextra.equals("n"));
                        
                        
                        do { // Calculo Bonus
				System.out.print("O funcionário possuí alguma Bonificação?(s/n)");
				opBoni = reader.nextLine();
			switch (opBoni){
				case "s":
					System.out.printf("|\tDigite o valor da bonicação R$: ");
					funcionarios[i].bonus = reader.nextDouble();
                                        reader.nextLine();
					break;
				case "n":				
					bonus = 0;
					break;
				default:
					System.out.println("Resposta Inválida, por favor selecione 's' para sim e 'n' para não");
				}
			} while (!opBoni.equals("s") && !opBoni.equals("n"));
                        
                        
                        
                        // Descontos
                        // 
                        
                        
                        
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
