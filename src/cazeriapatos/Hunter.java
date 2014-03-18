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

    public Hunter(HuntField campo) {
       this.campo=campo;
       vivo=true;
        type = 'H';
        pos = new Position (((int)(Math.random()*(campo.getYLength()))),
                ((int)(Math.random()*(campo.getXLength()))));
        while (false==campo.setItem(this, pos)){
             pos = new Position (((int)Math.random()*campo.getYLength()),
                ((int)Math.random()*campo.getXLength()));
        }  
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
