/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cazeriapatos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class Duck extends Thread implements FieldItem {

    private Position pos;
    private boolean vivo;
    private char type;
    private HuntField campo;

    public Duck(HuntField campo) {
        this.campo = campo;
        vivo = true;
        type = 'D';
        pos = new Position(((int) (Math.random() * (campo.getYLength()))),
                ((int) (Math.random() * (campo.getXLength()))));
        while (!campo.setItem(this, pos)) {
            pos = new Position(((int) Math.random() * campo.getYLength()),
                    ((int) Math.random() * campo.getXLength()));
        }

    }

    @Override
    public void run() {
        while (vivo) {
            try {
               sleep((long) (Math.random() * 300));
            } catch (InterruptedException ex) {

            }
            Position posaux = new Position(-1, -1);
            while (false == campo.moveItem(this, pos, posaux)) {
                int rmd = (int) (Math.random() * 4);
                if (rmd == 0) {
                    posaux = new Position(pos.getX(), pos.getY() + 1);
                }
                if (rmd == 1) {
                    posaux = new Position(pos.getX() + 1, pos.getY());
                }
                if (rmd == 2) {
                    posaux = new Position(pos.getX(), pos.getY() - 1);
                }
                if (rmd == 3) {
                    posaux = new Position(pos.getX() - 1, pos.getY());
                }
            }
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

    public void matar() {
        vivo = false;
    }
}
