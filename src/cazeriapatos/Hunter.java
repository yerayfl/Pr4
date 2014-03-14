/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cazeriapatos;

/**
 *
 * @author usuario
 */
public class Hunter extends Thread implements FieldItem {

    private int symbol;
    private Position pos;
    private boolean vivo;
    private char type;

    public Hunter(int id) {
        symbol = id;
        pos = null;
        vivo = true;
        type = 'H';
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
