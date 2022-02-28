package turtleGraphics;

public class Sketchpad {
    int floor [][];
    public Sketchpad(int row, int column) {
        floor = new int[row][column];
    }

    public int[][] getFloor() {
        return floor;
    }

    public void display(){
        for (var row : floor){
            for (var column : row){
                if (column == 1){
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();

        }

    }
}
