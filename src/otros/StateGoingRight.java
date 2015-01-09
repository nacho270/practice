package otros;

public class StateGoingRight<T> extends State<T>{

	public StateGoingRight(SpiralIteratorConState<T> iterator) {
		super(iterator);
	}

	@Override
	protected void changeState() {
		if(iterator.getyIndex() + 1 <= iterator.getLowerBoundY()){
			iterator.setState(new StateGoingDown<T>(iterator));
			iterator.setRightBoundX(iterator.getRightBoundX()-1);
			iterator.setyIndex(iterator.getyIndex()+1);
		}else{
			iterator.setState(new StateStop<T>(iterator));
		}
	}

	@Override
	public void executeState() {
		if(iterator.getxIndex() + 1 <= iterator.getRightBoundX()){
			iterator.setxIndex(iterator.getxIndex()+1);
		}else{
			changeState();
		}
	}
}
