package otros.jam.T9Spelling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class T9Spelling {

	private int testCases;
	private BufferedReader br;
	private Map<String, String> keyMap = new HashMap<String, String>();
	
	public T9Spelling(String file) {
		try {
			br = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("otros/jam/T9Spelling/"+file)));
			this.testCases = Integer.valueOf(br.readLine());
			initKeyMap();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
		} catch (IOException e) {
		}
	}
	
	private void initKeyMap() {
		this.keyMap.put(" ", "0");
		this.keyMap.put("a", "2");
		this.keyMap.put("b", "22");
		this.keyMap.put("c", "222");
		this.keyMap.put("d", "3");
		this.keyMap.put("e", "33");
		this.keyMap.put("f", "333");
		this.keyMap.put("g", "4");
		this.keyMap.put("h", "44");
		this.keyMap.put("i", "444");
		this.keyMap.put("j", "5");
		this.keyMap.put("k", "55");
		this.keyMap.put("l", "555");
		this.keyMap.put("m", "6");
		this.keyMap.put("n", "66");
		this.keyMap.put("o", "666");
		this.keyMap.put("p", "7");
		this.keyMap.put("q", "77");
		this.keyMap.put("r", "777");
		this.keyMap.put("s", "7777");
		this.keyMap.put("t", "8");
		this.keyMap.put("u", "88");
		this.keyMap.put("v", "888");
		this.keyMap.put("w", "9");
		this.keyMap.put("x", "99");
		this.keyMap.put("y", "999");
		this.keyMap.put("z", "9999");
	}

	private void processFile() throws IOException {
		for(int i = 0;i<this.testCases;i++){
			String msg = this.br.readLine();
			System.out.println("Case #"+(i+1)+": " + convertMsg(msg));
		}
	}
	
	private String convertMsg(String msg) {
		String ret = "";
		for(int i=0;i<msg.length();i++){
			ret += this.keyMap.get(msg.charAt(i));
		}
		return null;
	}

	public static void main(String[] args) throws IOException {
		new T9Spelling("C-large-practice.in").processFile();
	}
}
