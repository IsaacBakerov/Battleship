package battleship;

import java.util.Scanner;

public class Battlefield {

    public static Scanner sc = new Scanner(System.in);
    public static String[][] field1 = new String[11][11];
    public static String[][] foggyField1 = new String[11][11];
    public static String[] numbers = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    public static char[] alphabet = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};

    public  static Object[] aircraftCarrier, battleship, submarine, cruiser, destroyer;

    public static void runBattlefield() {
        createField();
        printField();
        placeAircraftCarrier();
        placeBattleship();
        placeSubmarine();
        placeCruiser();
        placeDestroyer();
    }

    public static void placeDestroyer() {
        int lengthOfShip = 2;
        System.out.println("\nEnter the coordinates of the Destroyer (2 cells):\n");
        boolean end = true;
        while (end) {
            String[] input = sc.nextLine().split(" ");

            char a1 = (char) convertValues(input)[0];
            char a2 = (char) convertValues(input)[1];
            int n1 = (int) convertValues(input)[2];
            int n2 = (int) convertValues(input)[3];
            destroyer = new Object[] {Math.min(a1, a2) - 64, Math.max(a1, a2) - 64, Math.min(n1, n2), Math.max(n1, n2)};

            end = placeOnField(a1, a2, n1, n2, lengthOfShip);
            if (end) {
                System.out.println("\nError! Wrong length of the Destroyer! Try again:\n");
            }
        }
    }

    public static void placeCruiser() {
        int lengthOfShip = 3;
        System.out.println("\nEnter the coordinates of the Cruiser (3 cells):\n");
        boolean end = true;
        while (end) {
            String[] input = sc.nextLine().split(" ");

            char a1 = (char) convertValues(input)[0];
            char a2 = (char) convertValues(input)[1];
            int n1 = (int) convertValues(input)[2];
            int n2 = (int) convertValues(input)[3];
            cruiser = new Object[] {Math.min(a1, a2) - 64, Math.max(a1, a2) - 64, Math.min(n1, n2), Math.max(n1, n2)};

            end = placeOnField(a1, a2, n1, n2, lengthOfShip);
            if (end) {
                System.out.println("\nError! Wrong length of the Cruiser! Try again:\n");
            }
        }
    }

    public static void placeSubmarine() {
        int lengthOfShip = 3;
        System.out.println("\nEnter the coordinates of the Submarine (3 cells):\n");
        boolean end = true;
        while (end) {
            String[] input = sc.nextLine().split(" ");

            char a1 = (char) convertValues(input)[0];
            char a2 = (char) convertValues(input)[1];
            int n1 = (int) convertValues(input)[2];
            int n2 = (int) convertValues(input)[3];
            submarine = new Object[] {Math.min(a1, a2) - 64, Math.max(a1, a2) - 64, Math.min(n1, n2), Math.max(n1, n2)};

            end = placeOnField(a1, a2, n1, n2, lengthOfShip);
            if (end) {
                System.out.println("\nError! Wrong length of the Submarine! Try again:\n");
            }
        }
    }

    public static void placeBattleship() {
        int lengthOfShip = 4;
        System.out.println("\nEnter the coordinates of the Battleship (4 cells):\n");
        boolean end = true;
        while (end) {
            String[] input = sc.nextLine().split(" ");

            char a1 = (char) convertValues(input)[0];
            char a2 = (char) convertValues(input)[1];
            int n1 = (int) convertValues(input)[2];
            int n2 = (int) convertValues(input)[3];
            battleship = new Object[] {Math.min(a1, a2) - 64, Math.max(a1, a2) - 64, Math.min(n1, n2), Math.max(n1, n2)};

            end = placeOnField(a1, a2, n1, n2, lengthOfShip);
            if (end) {
                System.out.println("\nError! Wrong length of the Battleship! Try again:\n");
            }
        }
    }

    public static void placeAircraftCarrier() {
        int lengthOfShip = 5;
        System.out.println("\nEnter the coordinates of the Aircraft Carrier (5 cells):\n");
        boolean end = true;
        while (end) {
            String[] input = sc.nextLine().split(" ");

            char a1 = (char) convertValues(input)[0];
            char a2 = (char) convertValues(input)[1];
            int n1 = (int) convertValues(input)[2];
            int n2 = (int) convertValues(input)[3];
            aircraftCarrier = new Object[] {Math.min(a1, a2) - 64, Math.max(a1, a2) - 64, Math.min(n1, n2), Math.max(n1, n2)};

            end = placeOnField(a1, a2, n1, n2, lengthOfShip);
            if (end) {
                System.out.println("\nError! Wrong length of the Aircraft Carrier! Try again:\n");
            }
        }
    }

    public static boolean placeVertical(int n, int c1, int c2, boolean isTrue) {
        int zero = 0;
        try {
            for (int i = c2; i <= c1; i++) {
                if (field1[i][n-1] != "O" && field1[i][n] != "O" && field1[i][n+1] != "O") {
                    zero *= 1;
                } else {
                    zero += 1;
                }
            }
            if (field1[c2-1][n] != "O" && field1[c1+1][n] != "O") {
                zero *= 1;
            } else {
                zero += 1;
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }

        if (zero == 0) {
            for (int i = c2; i <= c1; i++) {
                field1[i][n] = "O";
            }
            isTrue = false;
        } else {
            isTrue = true;
        }

        return isTrue;
    }

    public static boolean placeHorizontal(int c, int nn1, int nn2, boolean isTrue) {
        int zero = 0;
        try {
            for (int j = nn2; j <= nn1; j++) {
                if (field1[c-1][j] != "O" && field1[c][j] != "O" && field1[c+1][j] != "O") {
                    zero *= 1;
                } else {
                    zero += 1;
                }
            }
            if (field1[c][nn2-1] != "O" && field1[c][nn1+1] != "O") {
                zero *= 1;
            } else {
                zero +=1;
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }

        if (zero == 0) {
            for (int i = nn2; i <= nn1; i++) {
                field1[c][i] = "O";
            }
            isTrue = false;
        } else {
            isTrue = true;
        }

        return isTrue;
    }

    public static boolean placeOnField(char a1, char a2, int n1, int n2, int lengthOfShip) {
        boolean isTrue = false;
        if (a1 == a2) {
            if (Math.abs(n1 - n2) + 1 != lengthOfShip) {
                isTrue = true;
            } else {
                int c = (int) a1 - 64;
                int nn1 = Math.max(n1, n2);
                int nn2 = Math.min(n1, n2);

                if (!placeHorizontal(c, nn1, nn2, isTrue)) {
                    printField();
                } else {
                    isTrue = true;
                }
            }
        } else if (n1 == n2) {
            if (Math.abs(a1 - a2) + 1 != lengthOfShip) {
                isTrue = true;
            } else {
                int c1 = Math.max((int) a1 - 64, (int) a2 - 64);
                int c2 = Math.min((int) a1 - 64, (int) a2 - 64);

                if (!placeVertical(n1, c1, c2, isTrue)) {
                    printField();
                } else {
                    isTrue = true;
                }

            }
        } else {
            isTrue = true;
        }

        return isTrue;
    }

    public static Object[] convertValues(String[] input) {
        char a1 = input[0].charAt(0);
        char a2 = input[1].charAt(0);
        int n1 = 0;
        int n2 = 0;

        if (input[0].length() > 2) {
            n1 = 10;
        } else {
            n1 = input[0].charAt(1) - '0';
        }

        if (input[1].length() > 2) {
            n2 = 10;
        } else {
            n2 = input[1].charAt(1) - '0';
        }

        return new Object[] {a1, a2, n1, n2};
    }

    public static void createField() {
        char alphabet = 'A';
        for (int i = 0; i < field1.length; i++) {
            if (i == 0) {
                for (int j = 0; j < field1[i].length; j++) {
                    if (j == 0) {
                        field1[i][j] = " ";
                        foggyField1[i][j] = " ";
                    } else {
                        field1[i][j] = String.valueOf(j);
                        foggyField1[i][j] = String.valueOf(j);
                    }
                }
            } else {
                for (int j = 0; j < field1[i].length; j++) {
                    if (j == 0) {
                        field1[i][j] = String.valueOf(alphabet);
                        foggyField1[i][j] = String.valueOf(alphabet);
                        alphabet++;
                    } else {
                        field1[i][j] = "~";
                        foggyField1[i][j] = "~";
                    }
                }
            }
        }
    }

    public static void printField() {
        System.out.println();
        for (int i = 0; i < field1.length; i++) {
            for (int j = 0; j < field1[i].length; j++) {
                System.out.print(field1[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printFoggyField() {
        System.out.println();
        for (int i = 0; i < foggyField1.length; i++) {
            for (int j = 0; j < foggyField1[i].length; j++) {
                System.out.print(foggyField1[i][j] + " ");
            }
            System.out.println();
        }
    }
}
