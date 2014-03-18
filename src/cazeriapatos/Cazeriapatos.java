/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cazeriapatos;

/**
 *
 * @author usuario
 */
public class Cazeriapatos {

    public static void printField(HuntField field) {
        System.out.print("Hunters " + field.getNumberOfItems('H')
                + " Ducks " + field.getNumberOfItems('D') + "\n");
        System.out.print(field);
    }

    public static void main(String[] args) throws InterruptedException {
        final int numberOfTrees = 10;
        final int numberOfDucks = 10;
        final int numberOfHunters = 10;
        HuntField f = new HuntField(10, 20);
        for (int i = 0; i < numberOfTrees; i++) {
            new Tree(f);
        }
        for (int i = 0; i < numberOfDucks; i++) {
            new Duck(f).start();
        }
        for (int i = 0; i < numberOfHunters; i++) {
            new Hunter(f).start();
        }
        while (f.getNumberOfItems('D') > 0) {
            Thread.sleep(200);
            printField(f);
        }
        printField(f);
    }
}
