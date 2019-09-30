package dei.esinf.recursive;

public class PL1 {

    public static void main(String[] args) {
        System.out.println(sameOrderString("YES"));
        System.out.println(reverseOrderString("reddit"));
        System.out.println(isIntegerPalindrome(123454321, 123454321, 0));
        System.out.println(biggestCommonDivisor(1561654, 464134));
        int[][] labirinto = {{1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, {1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1}, {1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        printInt2DMatrix(labyrinthSolver(labirinto, 0, 0));
    }

    public static String sameOrderString(String s) {
        if (s.length() == 0) {
            return "";
        }
        return s.charAt(0) + sameOrderString(s.substring(1));
    }

    public static String reverseOrderString(String s) {
        if (s.length() == 0) {
            return "";
        }
        return reverseOrderString(s.substring(1)) + s.charAt(0);
    }

    public static boolean isIntegerPalindrome(int num, int aux, int res) {
        if (aux == 0) {
            if (num == res) {
                return true;
            }
            return false;
        }
        res = res * 10 + aux % 10;
        aux -= aux % 10;
        aux = aux / 10;
        return isIntegerPalindrome(num, aux, res);
    }

    public static int biggestCommonDivisor(int a, int b) {
        if (b > a) {
            int temp = a;
            a = b;
            b = temp;
        }
        if (a % b == 0) {
            return b;
        }
        return biggestCommonDivisor(b, a % b);
    }

    public static int[][] labyrinthSolver(int[][] labyrinth, int curXpos, int curYpos) {
        if (curXpos == labyrinth.length - 1 && curYpos == labyrinth[curXpos].length - 1) {
            labyrinth[curXpos][curYpos] = 9;
            return labyrinth;
        }

        //Marca a passagem
        labyrinth[curXpos][curYpos] = 2;

        //Para Norte
        if (curXpos - 1 >= 0 && labyrinth[curXpos - 1][curYpos] == 1) {
            labyrinth = labyrinthSolver(labyrinth, curXpos - 1, curYpos);
            if (labyrinth[curXpos - 1][curYpos] == 9) {
                labyrinth[curXpos][curYpos] = 9;
                return labyrinth;
            }
        }

        //Para Este
        if (curYpos + 1 < labyrinth[curXpos].length && labyrinth[curXpos][curYpos + 1] == 1) {
            labyrinth = labyrinthSolver(labyrinth, curXpos, curYpos + 1);
            if (labyrinth[curXpos][curYpos + 1] == 9) {
                labyrinth[curXpos][curYpos] = 9;
                return labyrinth;
            }
        }

        //Para Sul
        if (curXpos + 1 < labyrinth.length && labyrinth[curXpos + 1][curYpos] == 1) {
            labyrinth = labyrinthSolver(labyrinth, curXpos + 1, curYpos);
            if (labyrinth[curXpos + 1][curYpos] == 9) {
                labyrinth[curXpos][curYpos] = 9;
                return labyrinth;
            }
        }

        //Para Oeste
        if (curYpos - 1 >= labyrinth[curXpos].length && labyrinth[curXpos][curYpos - 1] == 1) {
            labyrinth = labyrinthSolver(labyrinth, curXpos, curYpos - 1);
            if (labyrinth[curXpos][curYpos - 1] == 9) {
                labyrinth[curXpos][curYpos] = 9;
                return labyrinth;
            }
        }
        return labyrinth;
    }

    public static void printInt2DMatrix(int[][] matrix) {
        for (int[] line : matrix) {
            for (int i : line) {
                System.out.printf(i + " ");
            }
            System.out.println(" ");
        }
    }
}

