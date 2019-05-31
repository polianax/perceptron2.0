import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

	public static void main(String[] args) {

		List<List> x = new ArrayList<List>();
		List<Integer> d = new ArrayList<Integer>();
		List<Double> pesos = new ArrayList<Double>();
		double bias;
		int epoca = 100; //numero maximo de epocas
		double alfa = 0.01;
		
		//recebendo dados de treinamento
		
		//entradas
		//jeito elegante
		x.add(Arrays.asList(0,0));
		x.add(Arrays.asList(0,1));
		x.add(Arrays.asList(1,0));
		x.add(Arrays.asList(1,1));

		//saídas esperadas (porta AND)
		d.add(-1);
		d.add(-1);
		d.add(-1);
		d.add(1);
		
		
		// inicializando variaveis
		
		Random r = new Random();
		bias = r.nextDouble() + r.nextInt(2) -1;
		pesos.add(r.nextDouble() + r.nextInt(2) -1);
		pesos.add(r.nextDouble() + r.nextInt(2) -1);
		
		Funcoes degrau = new Funcoes();

		int t = 0;
		List<Double> E = new ArrayList<Double>();
		E.add(1.00);
		E.add(0.00);
		E.add(0.00);
		E.add(0.00);
		int y = 0;
		double e = 0;
		double p = 0;
		
		
		while (t < epoca && degrau.count(E) > 0)  {
			
			E.clear();
			
			for (int i = 0; i < x.size() ; i++) {
				
				for (int j = 0; j < x.get(0).size(); j++) {
					p = p + Double.parseDouble(x.get(i).get(j).toString()) * pesos.get(j);
				}
				
				y = degrau.funcaoAtivacao(p + bias);
				//
				e = d.get(i) - y;

				for (int k = 0; k < pesos.size(); k++) {
					pesos.set(k, (pesos.get(k) + (e * Double.parseDouble(x.get(i).get(k).toString()) * alfa)));
				}
				
				bias = bias + (alfa * e);
				
				E.add(e);
			}
			
			t++;
		}
		
		System.out.println(degrau.count(E));
		
		System.out.println("bias: " + bias);
		System.out.println("pesos: " + pesos);
		System.out.println("erros: " + E);
		System.out.println("entradas: " + x);
		System.out.println(Double.parseDouble(x.get(3).get(1).toString()));
		System.out.println("epocas: " + t);
		System.out.println("total = " + (pesos.get(0) * Double.parseDouble(x.get(3).get(1).toString())));
		
		
	}
	

}
