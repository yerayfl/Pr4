/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cazeriapatos;

/**
 *
 * @author usuario
 */
public class Duck extends Thread implements FieldItem {

    private String symbol;
    private Position pos;
    private boolean vivo;
    private char type;

    public Duck(String symbol, Position pos) {
        this.symbol = symbol;
        this.pos = pos;
        vivo = true;
        type = 'D';

    }

    @Override
    public void run() {
        while (vivo) {
        }
    }

    @Override
    public boolean fired(Position pos1) {
        if (pos1.equals(pos)) {
            vivo = false;
            return true;
        }
        return false;
    }

    @Override
    public char getType() {
        return type;
    }

    @Override
     public void setPos(Position position) {
        pos = position;

    }

    @Override
    public Position getPos() {
        return pos;
    }
}
