package game.of.life;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import game.of.life.Cell.CellState;

public class UniverseTest {

	private static final CellState O = CellState.DEAD;
	private static final CellState X = CellState.ALIVE;

	@Test
	public void shouldStoreItsInitialState(){
		CellState[][] original = new CellState[][] {
			{ X, O, X },
			{ O, O, O },
			{ O, X, X },
		};
		Universe uut = new Universe(original);
		
		CellState[][] actual = uut.getState();
		assertArrayEquals(original, actual);
	}
	
	@Test
	public void shouldUpdateCell() {
		Universe uut = new Universe(new CellState[][] { { X } });
		
		uut.update();
		CellState[][] actual = uut.getState();
		
		assertEquals(CellState.DEAD, actual[0][0]);
	}
	
	@Test
	public void shouldUpdateAllCells() {
		Universe uut = new Universe(new CellState[][] {
			{ O, X, X },
			{ X, O, X },
			{ O, O, X }
		});
		CellState[][] expected = new CellState[][] {
			{ O, X, X },
			{ O, O, X },
			{ O, X, O }
		};
		
		uut.update();
		CellState[][] actual = uut.getState();
		
		assertArrayEquals(expected, actual);
	}
	
}
