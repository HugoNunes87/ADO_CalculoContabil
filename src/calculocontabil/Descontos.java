package calculocontabil;

public class Descontos {
	public static double IRPF, INSS, VT, VR, convenioMedico, VA;

	public static double descontoINSS(double salario){
		if(salario <= 1412) {
			INSS = salario-(salario*0.075);
			}
			if(salario > 1412 && salario <= 2666.68){
				INSS = salario*0.09;
				
			} else if(salario > 2666.68&& salario <= 4000.03){
				INSS = salario*0.12;

			} else if(salario > 4000.03 && salario <= 7786.02){
				INSS = salario*0.14;

			} else if(salario > 7786.02){
				INSS = 7786.02*0.14;

			} else {
				INSS = 0;
			}
			return INSS;
	}
	
	public static double descontoIRPF(double salario, double dependentes){
		
		descontoINSS(salario);
		
		double descontoDependentes = dependentes*189.59;
		double descontosTotais = INSS + descontoDependentes;
		double salarioFinalIRPF = salario - descontosTotais;
		
		if(salarioFinalIRPF < 2112){
			IRPF = 0;
		} else if(salarioFinalIRPF > 2112 && salario <= 2826.65){
			IRPF = (salarioFinalIRPF*0.075)-158.40;
		} else if(salarioFinalIRPF > 2826.65 && salario <= 3751.05){
			IRPF = (salarioFinalIRPF*0.15)-370.4;
		} else if(salarioFinalIRPF > 3751.06 && salario <= 4664.68){
			IRPF = (salarioFinalIRPF*0.225)-651.73;
		} else {
			IRPF = (salarioFinalIRPF*0.275)-884.96;
		}
		
		return IRPF;
	}
}