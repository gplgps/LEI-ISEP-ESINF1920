
package esinf;

/**
 *
 * @author DEI-ESINF
 */
public class Labirinth {
    
    /**
     *
     * @param actual the labirinth in its actual (marked) form 
     * @param y coordinate y in the labirinth
     * @param x coordinate x in the labirinth
     * @return the marked labirinth or null if there is no way
     */
    public static int [][] check(int [][] actual, int x, int y) {
        if (x == actual.length - 1 && y == actual[x].length - 1) {
            actual[x][y] = 9;
            return actual;
        }

        //Marca a passagem
        actual[x][y] = 2;

        //Para Norte
        if (x - 1 >= 0 && actual[x - 1][y] == 1) {
            actual = check(actual, x - 1, y);
            if (actual[x - 1][y] == 9) {
                actual[x][y] = 9;
                return actual;
            }
        }

        //Para Este
        if (y + 1 < actual[x].length && actual[x][y + 1] == 1) {
            actual = check(actual, x, y + 1);
            if (actual[x][y + 1] == 9) {
                actual[x][y] = 9;
                return actual;
            }
        }

        //Para Sul
        if (x + 1 < actual.length && actual[x + 1][y] == 1) {
            actual = check(actual, x + 1, y);
            if (actual[x + 1][y] == 9) {
                actual[x][y] = 9;
                return actual;
            }
        }

        //Para Oeste
        if (y - 1 >= actual[x].length && actual[x][y - 1] == 1) {
            actual = check(actual, x, y - 1);
            if (actual[x][y - 1] == 9) {
                actual[x][y] = 9;
                return actual;
            }
        }

        if (x == 0 && y == 0 && actual[0][0] == 2){
            return null;
        }
        return actual;
    }
    
    
    
    
}
