package turtleGraphics;

import java.util.Objects;

public class APosition {
    private int row;
    private int column;

    public APosition(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public boolean equals(Object o) {
        if(!o.getClass().equals(this.getClass())) return false;
        APosition compared = (APosition) o;
        if(this.row == compared.row && this.column == compared.column){
            return true;
        }
        return false;
    }
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        APosition aPosition = (APosition) o;
//        return row == aPosition.row && column == aPosition.column;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(row, column);
//    }

    @Override
    public String toString() {
        return "APosition{" +
                "row=" + row +
                ", column=" + column +
                '}';
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
