/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cazeriapatos;

/**
 *
 * @author usuario
 */
public class Position {

    private int x;
    private int y;

    public Position(int x1, int y1) {
        this.x = x1;
        this.y = y1;
    }

    public int getX() {
        return x;
    }

    public void setX(int x1) {
        this.x = x1;
    }

    public int getY() {
        return y;
    }

    public void setY(int y1) {
        this.y = y1;
    }

    public boolean equals(Position pos) {
        if ((this.getX() == pos.getX()) && (this.getY() == pos.getY())) {
            return true;
        }
        return false;
    }
}
