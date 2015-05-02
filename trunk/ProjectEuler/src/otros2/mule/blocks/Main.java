package otros2.mule.blocks;

@SuppressWarnings("unused")
public class Main {

	public static void main(String[] args) {
//		testMoveOnto();
//		testMoveOver();
		testPileOnto();
	}

	private static void testPileOnto() {
		BlockWorld blockWorld = new BlockWorld(10);
		blockWorld.moveOnto(9, 1);
		blockWorld.moveOver(8, 1);
		blockWorld.moveOver(7, 1);
		blockWorld.moveOver(6, 1);
		blockWorld.pileOnto(8, 6);
		blockWorld.pileOnto(8, 5);
		blockWorld.moveOver(2, 1);
		blockWorld.moveOver(4, 9);
		blockWorld.pileOnto(8, 9);
		System.out.println(blockWorld.toString());		
	}

	private static void testMoveOver() {
		BlockWorld blockWorld = new BlockWorld(6);
		blockWorld.moveOnto(4, 1);
		blockWorld.moveOnto(3, 2);
		blockWorld.moveOver(2, 1);
		blockWorld.moveOnto(4, 2);
		blockWorld.moveOver(5, 0);
		blockWorld.moveOver(4, 0);
		System.out.println(blockWorld.toString());
	}

	private static void testMoveOnto() {
		BlockWorld blockWorld = new BlockWorld(8);
		blockWorld.moveOnto(7, 1);
		blockWorld.moveOnto(5, 1);
		blockWorld.moveOnto(1, 6);
		blockWorld.moveOnto(4, 3);
		blockWorld.moveOnto(1, 4);
		blockWorld.moveOnto(3, 1);
		blockWorld.moveOnto(5, 2);
		blockWorld.moveOnto(4, 5);
		System.out.println(blockWorld.toString());
	}

}
