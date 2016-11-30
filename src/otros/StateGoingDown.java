package otros;

public class StateGoingDown<T> extends State<T>{

	public StateGoingDown(SpiralIteratorConState<T> iterator) {
		super(iterator);
	}

	@Override
	protected void changeState() {
		if(iterator.getxIndex() -1 >= iterator.getLeftBoundX()){
			iterator.setState(new StateGoingLeft<T>(iterator));
			iterator.setxIndex(iterator.getxIndex()-1);
			iterator.setLowerBoundY(iterator.getLowerBoundY()-1);
		}else{
			iterator.setState(null);
		}
	}

	@Override
	public void executeState() {
		if(iterator.getyIndex() + 1 <= iterator.getLowerBoundY()){
			iterator.setyIndex(iterator.getyIndex() + 1);
		}else{
			changeState();
		} 
	}
}
