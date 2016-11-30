package otros;

public class StateGoingLeft<T> extends State<T> {

	public StateGoingLeft(SpiralIteratorConState<T> iterator) {
		super(iterator);
	}

	@Override
	protected void changeState() {
		if(iterator.getyIndex()- 1 >= iterator.getUpperBoundY()){
			iterator.setState(new StateGoingUp<T>(iterator));
			iterator.setyIndex(iterator.getyIndex()-1);
			iterator.setLeftBoundX(iterator.getLeftBoundX()+1);
		}else{
			iterator.setState(null);
		}
	}

	@Override
	public void executeState() {
		if(iterator.getxIndex() - 1 >= iterator.getLeftBoundX()){
			iterator.setxIndex(iterator.getxIndex()-1);
		}else{
			changeState();
		}
	}

}
