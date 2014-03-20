package cazeriapatos;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HuntField {

    private int fila;
    private int columna;
    private FieldItem campo[][];

    public HuntField(int fil, int column) {

        fila = fil;
        columna = column;
        campo = new FieldItem[fila][columna];
    }

    public int getYLength() {
        return fila;
    }

    public int getXLength() {
        return columna;
    }

    synchronized public boolean setItem(FieldItem elem, Position pos) {
        if ((pos.getX() < fila) && (pos.getY() < columna) && (pos.getX() >= 0) && (pos.getY() >= 0) && (campo[pos.getX()][pos.getY()]) == null) {
            for (int i = 0; i < fila; i++) {
                for (int z = 0; z < columna; z++) {
                    if (campo[i][z] == elem) {
                        return false;
                    }
                }
            }
            campo[pos.getX()][pos.getY()] = elem;
            return true;
        }
        return false;
    }

    synchronized public boolean shot(Position pos) {

        if ((pos.getY() >= columna) || (pos.getX() >= fila) || (pos.getX() < 0)
                || (pos.getY() < 0) || (campo[pos.getX()][pos.getY()]) == null || (campo[pos.getX()][pos.getY()].getType()) == 'T') {
            return false;
        }
        if ((campo[pos.getX()][pos.getY()]).fired(pos)) {

            this.ponernull(pos);
            return true;
        }
        return false;

    }

    synchronized public void ponernull(Position pos) {
        campo[pos.getX()][pos.getY()] = null;
    }

    synchronized public boolean removeItem(FieldItem item, Position pos) {
        if (item.getPos().equals(pos)) {
            this.ponernull(pos);
            return true;
        }
        return false;
    }

    synchronized public char getItemType(Position pos) {
        if ((pos.getY() >= columna) || (pos.getX() >= fila) || (campo[pos.getX()][pos.getY()]) == null) {
            return ' ';
        }
        return campo[pos.getX()][pos.getY()].getType();
    }

    synchronized public boolean moveItem(FieldItem item, Position actual, Position nueva) {
        if ((actual.getY() >= columna) || (actual.getX() >= fila) || (campo[actual.getX()][actual.getY()]) == null
                || item != campo[actual.getX()][actual.getY()]) {
            return false;
        }
        if ((nueva.getY() >= columna) || (nueva.getY() < 0) || (nueva.getX() < 0) || (nueva.getX() >= fila)) {
            return false;
        }
        if ((campo[nueva.getX()][nueva.getY()]) != null) {
            try {
                wait(5);
            } catch (InterruptedException ex) {

            }
        }
        campo[nueva.getX()][nueva.getY()] = item;
        campo[actual.getX()][actual.getY()] = null;
        item.setPos(nueva);
        return true;
    }

    synchronized public int getNumberOfItems(char type) {
        int contador = 0;
        for (int i = 0; i < fila; i++) {
            for (int z = 0; z < columna; z++) {
                if (campo[i][z] != null && campo[i][z].getType() == type) {
                    contador++;
                }
            }
        }
        return contador;
    }

    @Override
    synchronized public String toString() {
        String devolver = "";
        for (int i = 0; i < fila; i++) {
            for (int z = 0; z < columna; z++) {
                if (campo[i][z] != null) {
                    devolver += (campo[i][z].getType());
                }
                devolver += " ";
            }
            devolver += '\n';
        }
        return devolver;
    }
}
