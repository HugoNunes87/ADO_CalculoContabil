package funcionarios;
import calculocontabil.Ganhos;
import java.util.Scanner;

public class Funcionario {
	static public String nome;
	static public double salario, salarioTributavel, totalVT, totalVR, convenioMedico, totalVA, irpf, inss, horasExtras, jornadaTrabalho, bonus;
	static public int quantDependente;
        
	
	public String GetNome(){
		return nome;
	}
	
	public static void CadastroFuncionario(){
		Scanner reader = new Scanner(System.in);
		String opcaovt;
		String ophrextra;
		String opJornada;
		String opBoni;
		String quantDep;
		
		System.out.println(" _______________________________________________________________");
		System.out.println("|\t\t\t\t\t\t\t\t|");
		System.out.println("|\t\t\t Bem vindo ao Holeri+ \t\t\t|");
		System.out.println("|_______________________________________________________________|");
		//System.out.printf("      Digite quantos funcionarios voc� deseja cadastrar: ");
		//int qtdFuncionarios = reader.nextInt();
		//reader.nextLine();
                
                int qtdFuncionarios = 0; // Vari�vel para armazenar o n�mero de funcion�rios
                
                while (true) {
                    try {
                        System.out.print("Digite quantos funcion�rios voc� deseja cadastrar: ");
                        qtdFuncionarios = Integer.parseInt(reader.nextLine());
                        break; // Sai do loop se a entrada for um n�mero inteiro v�lido
                } catch (NumberFormatException e) {
                    System.out.println("Por favor, insira um n�mero v�lido.");
                    }   
                }        
		
		for(int i = 0; i < qtdFuncionarios; i++){
			Funcionario[] funcionarios = new Funcionario[qtdFuncionarios];
			funcionarios[i] = new Funcionario();
			System.out.printf("|\t\t     Cadastro do %d� funcionario\t\t        |\n", i+1);
			System.out.print("|\t Digite o nome: ");
			funcionarios[i].nome = reader.nextLine();
			System.out.printf("|\tDigite o sal�rio bruto de %s: ", Funcionario.PrimeiroNome(funcionarios[i].nome));
			funcionarios[i].salario = reader.nextDouble();
			reader.nextLine();
			
			do{ // saber se o funcionario recebe o vt e retornando para a pergunta caso a resposta seja invalida
				System.out.printf("O funcion�rio recebe Vale Transporte? (s/n)");
				opcaovt = reader.nextLine();
				//System.out.println(opcaovt);
			switch (opcaovt){
				case "s":
					System.out.printf("|\tDigite o valor total do VT de %s: ", Funcionario.PrimeiroNome(funcionarios[i].nome));
					funcionarios[i].totalVT = reader.nextDouble();
					break;
				case "n":
					funcionarios[i].totalVT = 0;
					break;
				default:
					System.out.println("Resposta Inv�lida, por favor selecione 's' para sim e 'n' para n�o");
				}
			} while (!opcaovt.equals("s") && !opcaovt.equals("n"));
						
			
			
			//precisa saber se ele fez hora extra e se ele tem bonus. dps disso � s� jogar as variaveis nos metodos de descontos e ganhos

                        
                        int horas = 0;
                        do {
                            System.out.println("| --------------------------------------------\n");
                            System.out.println("| Selecione a jornada de horas para o funcion�rio: \n1. 220 horas \n2. 200 horas\n3. 180 horas");
                            System.out.println("| --------------------------------------------\n");
                            System.out.printf("Digite sua escolha: ");
                            horas = reader.nextInt();
                            reader.nextLine();
                            switch (horas) {
                                case 1 : {
                                    funcionarios[i].jornadaTrabalho = 220;
                                    break;
                                }
                                case 2 : {
                                    funcionarios[i].jornadaTrabalho = 200;
                                    break;
                                }
                                case 3 : {
                                    funcionarios[i].jornadaTrabalho = 180;
                                    break;
                                }
                                default :
                                    System.out.println("Op��o inv�lida, selecione numero de 1 a 3!");
                            } 
                        } while (horas != 1 && horas != 2 && horas != 3);

                        
                        
                        System.out.println("| \n--------------------------------------------\n");                       
                        
                                              
                        do { // Calculo Horas Extras
				System.out.print("O funcion�rio possu� horas extras?(s/n)");
				ophrextra = reader.nextLine();
                                
			switch (ophrextra){
				case "s":
                                        System.out.println("\nInforma a quantidade de horas extras realizadas no m�s:");
                                        System.out.printf("Quantidade de horas extras: ");                                      
                                        funcionarios[i].horasExtras= reader.nextDouble();
                                        reader.nextLine();
					break;
				case "n":
                                    System.out.println("Funcionario n�o recebe Horas Extras");
                                    funcionarios[i].horasExtras = 0;
                                    break;
				default:
					System.out.println("Resposta Inv�lida, por favor selecione 's' para sim e 'n' para n�o");
				}
			} while (!ophrextra.equals("s") && !ophrextra.equals("n"));
                        
                        
                        do { // Calculo Bonus
				System.out.print("O funcion�rio possu� alguma Bonifica��o?(s/n)");
				opBoni = reader.nextLine();
                                
			switch (opBoni){
				case "s":
					System.out.printf("|\tDigite o valor da bonica��o R$: ");
					funcionarios[i].bonus = reader.nextDouble();
                                        reader.nextLine();
					break;
				case "n":				
					bonus = 0;
					break;
				default:
					System.out.println("Resposta Inv�lida, por favor selecione 's' para sim e 'n' para n�o");
				}
			} while (!opBoni.equals("s") && !opBoni.equals("n"));
                        
                        

                        do { // Inserir Quantidade de Dependentes
				System.out.print("O funcion�io possui dependentes?(s/n)");
				quantDep = reader.nextLine();
			switch (quantDep){
				case "s":
					System.out.printf("|\t Informa a quantidade de dependentes do funcion�rio: ");
					funcionarios[i].quantDependente = reader.nextInt();
                                        reader.nextLine();
					break;
				case "n":				
					bonus = 0;
					break;
				default:
					System.out.println("Resposta Inv�lida, por favor selecione 's' para sim e 'n' para n�o");
				}
			} while (!quantDep.equals("s") && !quantDep.equals("n"));
                        
                        System.out.println(funcionarios[i].nome +" " + funcionarios[i].salario +" "+ funcionarios[i].totalVT  + " " + funcionarios[i].jornadaTrabalho + " " + funcionarios[i].horasExtras+ " " + funcionarios[i].quantDependente);
                        

                        
                        // Descontos
                        
                        
                        
                        
                       
                        
                        //funcionarios[i].salarioTributavel = Ganhos.GanhosTotais(salarioBruto, , hrExtra, qtdFuncionarios);
                        
                        
                        
            }
        }
        public static String PrimeiroNome(String nome) { //m�todo para pegar o primeiro nome do funcionario
        int index = nome.lastIndexOf(' ');
        if (index == -1) {
            return nome; // Se n�o houver espa�o, retorna o nome completo
        }
        return nome.substring(0, index);
    }
       
}
	


