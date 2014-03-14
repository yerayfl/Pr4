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

    private String id;
    private Position pos;
    private char type;

    public Tree(String id, Position pos) {
        this.id = id;
        this.pos = pos;
        type = 'T';
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
