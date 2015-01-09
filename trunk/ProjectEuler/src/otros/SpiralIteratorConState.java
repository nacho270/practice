package otros;

import java.util.Iterator;

public class SpiralIteratorConState<T> implements Iterator<T> {

	private Matrix<T> target;
	private int xIndex = 0;
	private int yIndex = 0;
	private int rightBoundX;
	private int lowerBoundY;
	private int leftBoundX;
	private int upperBoundY;

	private State<T> state;
	
	public SpiralIteratorConState(Matrix<T> target){
		this.target = target;
		this.state = new StateGoingRight<T>(this);
		this.rightBoundX = target.getWidth() - 1;
		this.lowerBoundY = target.getHeight() - 1;
		this.leftBoundX = 0;
		this.upperBoundY = 1;
	}
	
	@Override
	public boolean hasNext() {
		return !(state instanceof StateStop);
	}

	@Override
	public T next() {
		T next = target.get(xIndex, yIndex);
		this.state.executeState();
		return next;
	}

	@Override
	public void remove() {}

	public Matrix<T> getTarget() {
		return target;
	}

	public void setTarget(Matrix<T> target) {
		this.target = target;
	}

	public int getxIndex() {
		return xIndex;
	}

	public void setxIndex(int xIndex) {
		this.xIndex = xIndex;
	}

	public int getyIndex() {
		return yIndex;
	}

	public void setyIndex(int yIndex) {
		this.yIndex = yIndex;
	}

	public int getRightBoundX() {
		return rightBoundX;
	}

	public void setRightBoundX(int rightBoundX) {
		this.rightBoundX = rightBoundX;
	}

	public int getLowerBoundY() {
		return lowerBoundY;
	}

	public void setLowerBoundY(int lowerBoundY) {
		this.lowerBoundY = lowerBoundY;
	}

	public int getLeftBoundX() {
		return leftBoundX;
	}

	public void setLeftBoundX(int leftBoundX) {
		this.leftBoundX = leftBoundX;
	}

	public int getUpperBoundY() {
		return upperBoundY;
	}

	public void setUpperBoundY(int upperBoundY) {
		this.upperBoundY = upperBoundY;
	}

	public State<T> getState() {
		return state;
	}

	public void setState(State<T> state) {
		this.state = state;
	}
}
