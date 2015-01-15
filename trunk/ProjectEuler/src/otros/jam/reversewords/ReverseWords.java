package otros.jam.reversewords;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class ReverseWords {

	/*
	 * Problem

Given a list of space separated words, reverse the order of the words. Each line of text contains L letters and W words. A line will only consist of letters and space characters. There will be exactly one space character between each pair of consecutive words.

Input

The first line of input gives the number of cases, N.
N test cases follow. For each test case there will a line of letters and space characters indicating a list of space separated words. Spaces will not appear at the start or end of a line.

Output

For each test case, output one line containing "Case #x: " followed by the list of words in reverse order.
	 * */
	
	private int testCases;
	private BufferedReader br;
	
	public ReverseWords(String file) {
		try {
			br = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("otros/jam/reversewords/"+file)));
			this.testCases = Integer.valueOf(br.readLine());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
		} catch (IOException e) {
		}
	}
	
	private void processFile() throws IOException {
		for(int i =0;i<this.testCases;i++){
			Stack<String> s = new Stack<String>();
			s.addAll(Arrays.asList(this.br.readLine().split("\\s+")));
			String output = "Case #"+(i+1)+": ";
			while(!s.isEmpty()){
				output += s.pop()+" ";
			}
			System.out.println(output);
		}
	}

	public static void main(String[] args) throws IOException {
		new ReverseWords("B-large-practice.in").processFile();
	}

	
}
