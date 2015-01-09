package otros;


public class StateGoingUp<T> extends State<T> {

	public StateGoingUp(SpiralIteratorConState<T> iterator) {
		super(iterator);
	}

	@Override
	protected void changeState() {
		if(iterator.getxIndex()+ 1 <= iterator.getRightBoundX()){
			iterator.setState(new StateGoingRight<T>(iterator));
			iterator.setxIndex(iterator.getxIndex() +1 );
			iterator.setUpperBoundY(iterator.getUpperBoundY() +1);
		}else{
			iterator.setState(null);
		}	
	}

	@Override
	public void executeState() {
		if(iterator.getyIndex()-1 >= iterator.getUpperBoundY()){
			iterator.setyIndex(iterator.getyIndex()-1);
		}else{
			changeState();
		} 	
	}

}
