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

    private Position pos;
    private boolean vivo;
    private char type;
    private HuntField campo;
    private int aciertos;

    public Hunter(HuntField campo) {
        this.campo = campo;
        vivo = true;
        type = 'H';
        aciertos=0;
        pos = new Position(((int) (Math.random() * (campo.getYLength()))),
                ((int) (Math.random() * (campo.getXLength()))));
        while (!campo.setItem(this, pos)) {
            pos = new Position(((int) Math.random() * campo.getYLength()),
                    ((int) Math.random() * campo.getXLength()));
        }
    }

    @Override
    public void run() {
        Position paux;
        int rmd = (int) (Math.random() * 4);
        while (vivo) {
            try {
                sleep((long) (Math.random() * 100));
            } catch (InterruptedException ex) {

            }

            switch (rmd % 4) {
                case 0:
                    paux = new Position(pos.getX() - 1, pos.getY());
                    if (campo.shot(paux)) {
                        campo.moveItem(this, pos, paux);
                        aciertos++;
                    }
                    break;

                case 1:
                    paux = new Position(pos.getX(), pos.getY() + 1);
                    if (campo.shot(paux)) {
                        campo.moveItem(this, pos, paux);
                        aciertos++;
                    }
                    break;
                case 2:
                    paux = new Position(pos.getX() + 1, pos.getY());
                    if (campo.shot(paux)) {
                        campo.moveItem(this, pos, paux);
                        aciertos++;
                    }
                    break;
                case 3:
                    paux = new Position(pos.getX(), pos.getY() - 1);
                    if (campo.shot(paux)) {
                        campo.moveItem(this, pos, paux);
                        aciertos++;
                    }
                    break;

            }
            rmd++;
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
