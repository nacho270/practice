package otros;

import java.util.Iterator;

public class SpiralIterator<T> implements Iterator<T> {

	private Matrix<T> target;
	private int xIndex = 0;
	private int yIndex = 0;
	private int rightBoundX;
	private int lowerBoundY;
	private int leftBoundX;
	private int upperBoundY;

	private Direction direction = Direction.RIGHT;
	
	public SpiralIterator(Matrix<T> target){
		this.target = target;
		this.rightBoundX = target.getWidth() - 1;
		this.lowerBoundY = target.getHeight() - 1;
		this.leftBoundX = 0;
		this.upperBoundY = 1;
	}
	
	@Override
	public boolean hasNext() {
		return direction != Direction.STOP;
	}

	@Override
	public T next() {
		T next = target.get(xIndex, yIndex);
		updateIndexes();
		return next;
	}

	private void updateIndexes() {
		switch(direction){
			case UP:{
				if(yIndex -1 >= upperBoundY){
					yIndex--;
				}else if(xIndex + 1 <= rightBoundX){
					direction = Direction.RIGHT;
					xIndex++;
					upperBoundY++;
				}else{
					direction = Direction.STOP;
				}
				break;
			}
			case DOWN:{
				if(yIndex + 1 <= lowerBoundY){
					yIndex++;
				}else if(xIndex -1 >= leftBoundX){
					direction = Direction.LEFT;
					xIndex--;
					lowerBoundY--;
				}else{
					direction = Direction.STOP;
				}
				break;
			}
			case LEFT:{
				if(xIndex - 1 >= leftBoundX){
					xIndex--;
				}else if(yIndex - 1 >= upperBoundY){
					direction = Direction.UP;
					yIndex--;
					leftBoundX++;
				}else{
					direction = Direction.STOP;
				}
				break;
			}
			case RIGHT:{
				if(xIndex + 1 <= rightBoundX){
					xIndex++;
				}else if(yIndex + 1 <= lowerBoundY){
					direction = Direction.DOWN;
					rightBoundX--;
					yIndex++;
				}else{
					direction = Direction.STOP;
				}
				break;
			}
			default:{
				break;
			}
		}
	}

	@Override
	public void remove() {}

	private enum Direction {
		UP,
		DOWN,
		LEFT,
		RIGHT,
		STOP;
	}
}
