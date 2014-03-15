/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cazeriapatos;

/**
 *
 * @author usuario
 */
public class Tree implements FieldItem {

    private Position pos;
    private char type;

    public Tree(HuntField campo) {
        type = 'T';
        pos = new Position (((int)(Math.random()*(campo.getYLength()))),
                ((int)(Math.random()*(campo.getXLength()))));
        while (!campo.setItem(this, pos)){
             pos = new Position (((int)Math.random()*campo.getYLength()),
                ((int)Math.random()*campo.getXLength()));
        }  
    }

    @Override
    public boolean fired(Position pos) {
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
