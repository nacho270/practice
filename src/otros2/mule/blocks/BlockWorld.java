package otros2.mule.blocks;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class BlockWorld {

	private Stack[] blocks;
	private Map<Integer, Integer> indexMap;

	public BlockWorld(int size) {
		blocks = new Stack[size];
		indexMap = new HashMap<Integer, Integer>();
		init();
	}

	private void init() {
		for (int i = 0; i < blocks.length; i++) {
			blocks[i] = new Stack();
			blocks[i].add(i);
			indexMap.put(i, i);
		}
	}

	public void moveOnto(int origin, int target) {
		if (origin == target) return;
		int locationOrigin = indexMap.get(origin);
		int locationTarget = indexMap.get(target);
		if(locationOrigin==locationTarget) return;
		
		Stack sOrigin = blocks[locationOrigin];
		Stack sTarget = blocks[locationTarget];

		emptyTo(sTarget, target);
		emptyTo(sOrigin, origin);
		Integer elementToMove = (Integer) sOrigin.pop();
		sTarget.push(elementToMove);
		indexMap.put(elementToMove.intValue(), locationTarget);
	}
	
	public void moveOver(int origin, int target) {
		if (origin == target) return;
		int locationOrigin = indexMap.get(origin);
		int locationTarget = indexMap.get(target);
		if(locationOrigin==locationTarget) return;
		
		Stack sOrigin = blocks[locationOrigin];
		Stack sTarget = blocks[locationTarget];

//		emptyTo(sTarget, target);
		emptyTo(sOrigin, origin);
		Integer elementToMove = (Integer) sOrigin.pop();
		sTarget.push(elementToMove);
		indexMap.put(elementToMove.intValue(), locationTarget);
	}
	
	public void pileOnto(int origin, int target) {
		if (origin == target) return;
		int locationOrigin = indexMap.get(origin);
		int locationTarget = indexMap.get(target);
		if(locationOrigin==locationTarget) return;
		
		Stack sOrigin = blocks[locationOrigin];
		Stack sTarget = blocks[locationTarget];

		emptyTo(sTarget, target);
		moveFromTo(sOrigin, sTarget, origin, locationTarget);
	}
	
	private void moveFromTo(Stack origin, Stack target, int from, int targetIndex){
		if(origin.empty()) return;
		Stack temp = new Stack();
		boolean found = false;
		while(!found){
			Integer elementToMove = (Integer) origin.pop();
			temp.push(elementToMove);
			if(elementToMove.intValue() == from){
				found = true;
			}
		}
		while(!temp.empty()){
			Integer elementToMove = (Integer)temp.pop();
			target.push(elementToMove);
			indexMap.put(elementToMove.intValue(), targetIndex);
		}
	}

	private void emptyTo(Stack stack, int to) {
		if(stack.empty()) return;
		while (!stack.peek().equals(to)) {
			Integer elementToMove = (Integer) stack.pop();
			blocks[elementToMove.intValue()].push(elementToMove);
			indexMap.put(elementToMove.intValue(), elementToMove.intValue());
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < blocks.length; i++) {
			sb.append(i + ": ");
			Stack s = blocks[i];
			if (!s.empty()) {
				for (Iterator it = s.iterator(); it.hasNext();) {
					sb.append(it.next() + " ");
				}
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
