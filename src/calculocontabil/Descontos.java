package calculocontabil;

public class Descontos {
	public static double IRPF, INSS, VT, VR, convenioMedico, VA;

	public static double descontoINSS(double salario){
		if(salario <= 1412) {
			salario -= salario*0.075;
			return salario;
			}
			if(salario > 1412 && salario <= 2666.68){
				salario -= salario*0.09;
				return salario;
			} if(salario > 2666.68&& salario <= 4000.03){
				salario -= salario*0.12;
				return salario;
			} if(salario > 4000.03 && salario <= 7786.02){
				salario -= salario*0.14;
				return salario;
			} if(salario > 7786.02){
				salario -= 7786.02*0.14;
				return salario;
			} else {
				return salario;
			}
	}
	
	public static double descontoIRPF(double ganhos){
		
	}
}