package otros;


public class Matrix<T>{

	private T[][] elements;

	public Matrix(T[][] elements) {
		this.elements = elements;
	}
	
	public T get(int x, int y){
		return elements[y][x];
	}
	
	public int getHeight(){
		return elements.length;
	}
	
	public int getWidth(){
		return elements[0].length;
	}
}
