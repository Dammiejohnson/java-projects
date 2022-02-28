package turtleGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static turtleGraphics.Direction.*;
import static turtleGraphics.PenState.*;

class TurtleTest {

    Turtle ijapa;
    @BeforeEach
    public void setUp() {
        ijapa = new Turtle();
    }

    @Test
    public void turtleExist() {
        Turtle ijapa = new Turtle();
        assertNotNull(ijapa);
    }

    @Test
    public void turtleHasAPenTest() {
        Pen pen = ijapa.getPen();
        assertNotNull(pen);
    }

    @Test
    public void penIsUpByDefaultTest() {
        Pen pen = ijapa.getPen();
        assertEquals(pen.getState(), UP);
    }

    @Test
    public void turtleCanMovePenDown() {
        Pen pen = ijapa.getPen();
        //GIVEN
        assertSame(ijapa.getPen().getState(), UP);
        //WHEN
        ijapa.penDown();
        //ASSERT
        assertSame(ijapa.getPen().getState(), DOWN);
        //Instead of repeatiine PenState.UP Or PenState.DOWN... WE CAN IMPORT THE STATIC CLASS AND JUST WRITE DOWN OR UP

    }
    @Test
    public void turtleCanMovePenUp() {
        // given
        ijapa.penDown();
        assertSame(ijapa.getPen().getState(), DOWN);
        //WHEN
        ijapa.penUp();
        //assert
        assertSame(ijapa.getPen().getState(), UP);
    }

    @Test
    public void turtleCanTurnRight_whileFacingEastTest(){
        assertSame(ijapa.getCurrentDirection(), Direction.EAST);
        // WHEN
        ijapa.turnRight();
        //ASSERT
        assertSame(ijapa.getCurrentDirection(),SOUTH);
    }

    @Test
    public void turtleCanTurnRight_whileFacingSouthTest(){
        //given
       ijapa.turnRight();
        assertSame(ijapa.getCurrentDirection(),SOUTH);
        //when
        ijapa.turnRight();
        assertSame(WEST, ijapa.getCurrentDirection());
    }
    //todo face west, face north

    @Test
    public void turtleCanTurnRight_whileFacingWestTest(){
        //given
        ijapa.turnRight();
        assertSame(ijapa.getCurrentDirection(),SOUTH);
        //when
        ijapa.turnRight();
        assertSame(WEST, ijapa.getCurrentDirection());
        //ASSERT
        ijapa.turnRight();
        assertSame(NORTH, ijapa.getCurrentDirection());
    }

    @Test
    public void turtleCanTurnRight_whileFacingNorthTest(){
        //given
        ijapa.turnRight();
        ijapa.turnRight();
        ijapa.turnRight();
        assertSame(NORTH, ijapa.getCurrentDirection());
        //WHEN
        ijapa.turnRight();
        //ASSERT
        assertSame(EAST, ijapa.getCurrentDirection());

    }

    @Test
    public void turtleCanTurnLeft_whileFacingEastTest() {
        assertSame(ijapa.getCurrentDirection(), Direction.EAST);
        // WHEN
        ijapa.turnLeft();
        //ASSERT
        assertSame(NORTH, ijapa.getCurrentDirection());
    }

    @Test
    public void turtleCanTurnLeft_whileFacingNorthTest(){
        //given
        ijapa.turnLeft();
        assertSame(NORTH, ijapa.getCurrentDirection());
        //WHEN
        ijapa.turnLeft();
        assertSame(WEST, ijapa.getCurrentDirection());
    }

    @Test
    public void turtleCanTurnLeft_whileFacingWestTest(){
       //given
        ijapa.turnLeft();
        ijapa.turnLeft();
        assertSame(WEST, ijapa.getCurrentDirection());
        //when
        ijapa.turnLeft();
        //assert
        assertSame(SOUTH, ijapa.getCurrentDirection());
    }

    @Test
    public void turtleCanTurnLeft_whileFacingSouthTest(){
        //given
        ijapa.turnLeft();
        ijapa.turnLeft();
        ijapa.turnLeft();
        assertSame(SOUTH, ijapa.getCurrentDirection());
        //when
        ijapa.turnLeft();
        //assert
        assertSame(EAST, ijapa.getCurrentDirection());

    }


    //todo face North, west, south

    @Test
    public void turtleCanMove_whileFacingEastTest(){
        ijapa.moveWithoutWriting(6);
        ijapa.moveWithoutWriting(5);
        APosition position = new APosition(0, 9);
        assertEquals(position, ijapa.getCurrentPosition());

    }

    @Test
    public void turtleCanMove_whileFacingSouthTest(){
        ijapa.turnRight();
        ijapa.moveWithoutWriting(5);
        APosition position = new APosition(4, 0);
        assertEquals(position, ijapa.getCurrentPosition());
    }

    @Test
    public void turtleCanMove_whileFacingWestTest(){
        ijapa.moveWithoutWriting(5);
        ijapa.turnRight();
        ijapa.turnRight();
        ijapa.moveWithoutWriting(5);
        APosition position = new APosition(0, 0);
        assertEquals(position, ijapa.getCurrentPosition());
    }
    @Test
    public void turtleCanMove_whileFacingNorthTest(){
        ijapa.moveWithoutWriting(5);
        ijapa.turnRight();
        ijapa.moveWithoutWriting(5);
        ijapa.turnRight();
        ijapa.turnRight();
        ijapa.moveWithoutWriting(5);
        APosition position = new APosition(0, 4);
        assertEquals(position, ijapa.getCurrentPosition());
    }

    @Test
    public void turtleCanWriteWhenPenIsDownAndFacingEAST(){
        //given
        ijapa.penDown();
        Sketchpad pad = new Sketchpad(5,5);
        //when
        ijapa.move(5, pad);
        //assert
        assertEquals(1, pad.getFloor()[0][0]);
        assertEquals(1, pad.getFloor()[0][1]);
        assertEquals(1, pad.getFloor()[0][2]);
        assertEquals(1, pad.getFloor()[0][3]);
        assertEquals(1, pad.getFloor()[0][4]);

        assertEquals(new APosition(0,4), ijapa.getCurrentPosition());
       pad.display();
    }

    @Test
    public void whenTurtleGoesOutOfSketchpad_exceptionIsThrown(){
        ijapa.penDown();
        Sketchpad sketchpad = new Sketchpad(5,5);
        ijapa.move(5, sketchpad);
        assertThrows(InvalidMoveException.class, () -> ijapa.move(5,sketchpad));
//        try {
//            ijapa.move(5, sketchpad);
//        }
//        catch (InvalidMovetException ex) {
//            assertEquals(InvalidMovetException.class, ex.getClass());
//            assertEquals("ijapa has fallen", ex.getMessage());
//        }
    }

    @Test
    public void whenTurtleGoesOutOfSketchpadTowardsSouth_exceptionIsThrown () {
        ijapa.penDown();
        ijapa.turnRight();
        Sketchpad sketchpad = new Sketchpad(5, 5);
        ijapa.move(5, sketchpad);
        assertThrows(InvalidMoveException.class, () -> ijapa.move(5, sketchpad));
    }

    @Test
    public void turtleCanWriteWhenPenIsDownAndFacingSOUTH(){
        //given
        ijapa.penDown();
        ijapa.turnRight();
        Sketchpad pad = new Sketchpad(5,5);
        //when
        assertEquals(SOUTH, ijapa.getCurrentDirection());
        ijapa.move(5, pad);
        //assert
        assertEquals(1, pad.getFloor()[0][0]);
        assertEquals(1, pad.getFloor()[1][0]);
        assertEquals(1, pad.getFloor()[2][0]);
        assertEquals(1, pad.getFloor()[3][0]);
        assertEquals(1, pad.getFloor()[4][0]);

        assertEquals(new APosition(4,0), ijapa.getCurrentPosition());
        pad.display();
    }


    @Test
    public void turtleCanWriteWhenPenIsDownAndFacingWEST(){
        //given
        ijapa.penDown();
        Sketchpad pad = new Sketchpad(5,5);
        ijapa.move(5, pad);
        ijapa.turnRight();
        ijapa.turnRight();
        //when
        assertEquals(WEST, ijapa.getCurrentDirection());
        ijapa.move(5, pad);
        //assert
        assertEquals(1, pad.getFloor()[0][4]);
        assertEquals(1, pad.getFloor()[0][3]);
        assertEquals(1, pad.getFloor()[0][2]);
        assertEquals(1, pad.getFloor()[0][1]);
        assertEquals(1, pad.getFloor()[0][0]);

        assertEquals(new APosition(0,0), ijapa.getCurrentPosition());
        pad.display();
    }

    @Test
    public void turtleCanWriteWhenPenIsDownAndFacingNORTH(){
        //given
        ijapa.penDown();
        Sketchpad pad = new Sketchpad(5,5);
        ijapa.move(5, pad);
        ijapa.turnRight();
        ijapa.move(5, pad);
        ijapa.turnRight();
        ijapa.move(5, pad);
        ijapa.turnRight();
        //when
        assertEquals(NORTH, ijapa.getCurrentDirection());
        ijapa.move(5, pad);
        //assert
        assertEquals(1, pad.getFloor()[4][0]);
        assertEquals(1, pad.getFloor()[3][0]);
        assertEquals(1, pad.getFloor()[2][0]);
        assertEquals(1, pad.getFloor()[1][0]);
        assertEquals(1, pad.getFloor()[0][0]);

        assertEquals(new APosition(0,0), ijapa.getCurrentPosition());
        pad.display();
    }

    @Test
    public void turtleCanWriteWhenPenIsDownAndNotWriteWhenPenIsUp(){
        //given
        ijapa.penUp();
        Sketchpad pad = new Sketchpad(5,5);
        ijapa.move(5, pad);
        ijapa.turnRight();
        ijapa.turnRight();
        ijapa.penDown();
        ijapa.move(5, pad);
        ijapa.turnLeft();
        ijapa.move(5, pad);
        ijapa.turnLeft();
        ijapa.move(5, pad);
        ijapa.turnLeft();
        ijapa.move(3, pad);
        ijapa.turnLeft();
        //when
        assertEquals(WEST, ijapa.getCurrentDirection());
        ijapa.move(4, pad);
        //assert
        assertEquals(1, pad.getFloor()[2][4]);
        assertEquals(1, pad.getFloor()[2][3]);
        assertEquals(1, pad.getFloor()[2][2]);
        assertEquals(1, pad.getFloor()[2][1]);

      assertEquals(new APosition(2,1), ijapa.getCurrentPosition());
       pad.display();
    }


}
