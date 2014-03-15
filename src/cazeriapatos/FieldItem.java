package cazeriapatos;

interface FieldItem {

    abstract public boolean fired(Position pos1); // Devuelve verdadero si murió con el disparo

    abstract public char getType();  // Devuelve el carácter que representa el tipo de objeto

    abstract public void setPos(Position pos);

    abstract public Position getPos();
}