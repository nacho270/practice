package problems;

import java.util.ArrayList;
import java.util.List;


public class Problem3 {
	
	private static List<Long> primosHasta(long N){
		List<Long> primos = new ArrayList<Long>();
		for(long i = 2l;i<=N;i++){
			boolean primo = true;
			for(long j = 2;j<=i;j++){
				if(i%j==0 && i!=j){
					primo = false;
					break;
				}
			}
			if(primo){
				primos.add(i);
			}
		}
		return primos;
	}
	
	public static void main(String[] args) {
		long N = 600851475143l;
		List<Long> primosHasta = primosHasta(N);
		Long ultimoFactor = primosHasta.get(0);
		for(Long p : primosHasta){
			if(N%p==0 && p>ultimoFactor){
				ultimoFactor = p;
			}
		}
		System.out.println(ultimoFactor);
		
	}
}
