package turtleGraphics;

public class Pen {
    private  PenState state = PenState.UP;

    public PenState getState() {
        return state; // this is initially returning a null state unless we create a constructor or initialised in the instance variable
    }

    public void setState(PenState penState) {
        state = penState; // if we test this first state  will be initialised unless it is initialised uop in the instance variable

    }



}