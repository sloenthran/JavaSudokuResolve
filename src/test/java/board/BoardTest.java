package board;

import org.junit.Assert;
import org.junit.Test;
import pl.nogacz.sudoku.board.Board;

/**
 * @author Dawid Nogacz on 23.06.2019
 */
public class BoardTest {
    @Test
    public void testX() {
        //Given
        Board board = new Board();
        board.setNumberInCell(1, 1, 1);

        //When
        boolean falseAllowed = board.isAllowedNumber(2, 1, 1);
        boolean trueAllowed = board.isAllowedNumber(2, 1, 3);

        //Then
        Assert.assertFalse(falseAllowed);
        Assert.assertTrue(trueAllowed);
    }

    @Test
    public void testY() {
        //Given
        Board board = new Board();
        board.setNumberInCell(1, 2, 1);

        //When
        boolean falseAllowed = board.isAllowedNumber(1, 2, 1);
        boolean trueAllowed = board.isAllowedNumber(1, 2, 3);

        //Then
        Assert.assertFalse(falseAllowed);
        Assert.assertTrue(trueAllowed);
    }

    @Test
    public void testBox() {
        //Given
        Board board = new Board();
        board.setNumberInCell(1, 1, 1);

        //When
        boolean falseAllowed = board.isAllowedNumber(2, 2, 1);
        boolean trueAllowed = board.isAllowedNumber(2, 2, 3);

        //Then
        Assert.assertFalse(falseAllowed);
        Assert.assertTrue(trueAllowed);
    }
}
