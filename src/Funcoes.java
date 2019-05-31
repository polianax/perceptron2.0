import java.util.ArrayList;
import java.util.List;

public class Funcoes {


	
	
	public int funcaoAtivacao (double y){
		
		int saida = 0;
		
		if (y>0) {
			saida = 1;
		} else {
			saida = -1;
		}
		
		return saida;
	}
	
	public int count (List E) {
		int contador = 0;
		for (int i = 0; i < E.size(); i++) {
			
			if (Double.parseDouble(E.get(i).toString()) == 0){
				
			} else {
				contador = contador + 1;
			}
			
		}
		
		return contador;
	}
}
