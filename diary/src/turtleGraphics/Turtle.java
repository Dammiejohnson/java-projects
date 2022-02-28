package turtleGraphics;

import static turtleGraphics.Direction.*;
import static turtleGraphics.PenState.DOWN;

public class Turtle {
    private Pen biro = new Pen();
    private Direction currentDirection = EAST;
    private APosition currentPosition = new APosition(0, 0);

    public Pen getPen() {
        return biro;
    }

    public void penDown() {
        biro.setState(DOWN);
    }

    public void penUp() {
        biro.setState(PenState.UP);
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void turnRight() {
        if (currentDirection == EAST) face(SOUTH);
        else if (currentDirection == SOUTH) face(WEST);
        else if (currentDirection == WEST) face(NORTH);
        else if (currentDirection == NORTH) face(EAST);

    }

    private void face(Direction direction) {
        currentDirection = direction;
    }

    public void turnLeft() {
        if (currentDirection == EAST) face(NORTH);
        else if (currentDirection == NORTH) face(WEST);
        else if (currentDirection == WEST) face(SOUTH);
        else if (currentDirection == SOUTH) face(EAST);
    }

    public void moveWithoutWriting(int numberOfSteps) {
        if (currentDirection == EAST) increaseColumnBy(numberOfSteps - 1);
        if (currentDirection == SOUTH) increaseRowBy(numberOfSteps - 1);
        if (currentDirection == WEST) decreaseColumnBy(numberOfSteps - 1);
        if (currentDirection == NORTH) decreaseRowBy(numberOfSteps - 1);
    }

    private void increaseRowBy(int increase) {
        int currentRow = currentPosition.getRow();
        currentPosition.setRow(currentRow + increase);
    }

    private void decreaseRowBy(int decrease) {
        int currentRow = currentPosition.getRow();
        currentPosition.setRow(currentRow - decrease);
    }

    private void increaseColumnBy(int increase) {
        currentPosition.setColumn(currentPosition.getColumn() + increase);
    }

    private void decreaseColumnBy(int decrease) {
        currentPosition.setColumn(currentPosition.getColumn() - decrease);
    }

    public APosition getCurrentPosition() {
        return currentPosition;
    }

    public void move(int numberOfSteps, Sketchpad sketchpad) {
        validateMove(numberOfSteps, sketchpad);
        if (biro.getState().equals(DOWN)) {
            //WRITE
            write(numberOfSteps, sketchpad);
        }
        //MOVE
        moveWithoutWriting(numberOfSteps);
    }

    private void validateMove(int numberOfSteps, Sketchpad sketchpad) {
        int row = currentPosition.getRow();
        int column = currentPosition.getColumn();
        switch (currentDirection) {
            case EAST -> {
                int newMove = column + numberOfSteps;
                int sketchpadColumnLength = sketchpad.getFloor()[row].length;
                if (newMove > sketchpadColumnLength) {
                    throw new InvalidMoveException("ijapa has fallen");
                }
            }
            case SOUTH -> {
                int newMove = row + numberOfSteps;
                int sketchpadRowLength = sketchpad.getFloor()[column].length;
                if (newMove > sketchpadRowLength) {
                    throw new InvalidMoveException("ijapa has fallen");
                }
            }
        }
    }

    private void write(int numberOfSteps, Sketchpad sketchpad) {
        int[][] floor = sketchpad.getFloor();
        int row = currentPosition.getRow();
        int column = currentPosition.getColumn();
        switch (currentDirection) {
            case EAST -> {
                for (int i = column; i < column + numberOfSteps; i++) {
                    floor[row][i] = 1; //[row][i] means that.. the row is the same but column is the one increasing
                }
            }
            case SOUTH -> {
                for (int i = row; i < row + numberOfSteps; i++) {
                    floor[i][column] = 1;
                }
            }
            case WEST -> {
                for (int i = column; i > column - numberOfSteps; i--) {
                    floor[row][i] = 1;
                }
            }
                case NORTH -> {
                    for (int i = row; i > row - numberOfSteps; i--) {
                        floor[i][column] = 1;
                    }
                }
            }
        }
    }



