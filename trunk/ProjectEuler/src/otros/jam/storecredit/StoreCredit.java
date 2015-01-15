package otros.jam.storecredit;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class StoreCredit {

	/*
	 *
Problem

You receive a credit C at a local store and would like to buy two items. You first walk through the store and create a list L of all available items. From this list you would like to buy two items that add up to the entire value of the credit. The solution you provide will consist of the two integers indicating the positions of the items in your list (smaller number first).

Input

The first line of input gives the number of cases, N. N test cases follow. For each test case there will be:

One line containing the value C, the amount of credit you have at the store.
One line containing the value I, the number of items in the store.
One line containing a space separated list of I integers. Each integer P indicates the price of an item in the store.
Each test case will have exactly one solution.
Output

For each test case, output one line containing "Case #x: " followed by the indices of the two items whose price adds up to the store credit. The lower index should be output first.
	 * */

	private int testCases;
	private BufferedReader br;
	
	public StoreCredit(String file) {
		try {
			br = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("otros/jam/storecredit/"+file)));
			this.testCases = Integer.valueOf(br.readLine());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
		} catch (IOException e) {
		}
	}
	
	private void processFile() throws NumberFormatException, IOException {
		for(int i = 0; i<this.testCases;i++){
			int targetAmmount = Integer.valueOf(this.br.readLine());
			this.br.readLine();
			String[] prices = this.br.readLine().split(" ");
			System.out.println("Case #"+(i+1)+": " + findSum(targetAmmount,prices));
		}
	}
	
	private String findSum(int targetAmmount, String[] prices) {
		for(int j = 0; j<prices.length;j++){
			for(int k = j +1; k<prices.length;k++){
				if(Integer.valueOf(prices[j]).intValue() + Integer.valueOf(prices[k]).intValue() == targetAmmount){
					return (j+1) + " " + (k+1);
				}
			}
		}
		return null;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		new StoreCredit("A-large-practice.in").processFile();
	}
	
}
