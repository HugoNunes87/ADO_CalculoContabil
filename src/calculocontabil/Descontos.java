package calculocontabil;

public class Descontos {
	float IRPF, VT, VR, convenioMedico;
	double INSS;

	public static double descontoINSS(double salario){ //Calcular o IRPF precisa dos ganhos somados, descontar o INSS antes
		if(salario <= 1412) { //Descontando o INSS
			salario -= salario*0.075;
			return salario;
		} else{
			return 0;
		}
	}
}
