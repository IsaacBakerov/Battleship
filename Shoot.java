package battleship;

import static battleship.Battlefield.*;
import static battleship.Battlefield2.*;
import static battleship.Main.end;

public class Shoot {
    public static int aircraftCarrierLength2 = 5;
    public static int battleshipLength2 = 4;
    public static int submarineLength2 = 3;
    public static int cruiserLength2 = 3;
    public static int destroyerLength2 = 2;
    public static int allLength2 = 17;

    public static void shoot() {
        printFoggyField2();
        System.out.println("---------------------");
        printField();
        System.out.println("\nPlayer 1, it's your turn:\n");

        int hit = 0;
        String input = sc.nextLine();
        char a = (char) convertShootValue(input)[0];
        int n = (int) convertShootValue(input)[1];
        int aIndex = a - 64;
        if ((aIndex >= 1 && aIndex <= 10) && (n >= 1 && n <= 10)) {
            hit = hit(aIndex, n);
            if (hit == 2) {
                if ((aIndex >= (int) aircraftCarrier[0] && aIndex <= (int) aircraftCarrier[1]) && (n >= (int) aircraftCarrier[2] && n <= (int) aircraftCarrier[3])) {
                    aircraftCarrierLength2--;
                    allLength2--;
                } else if ((aIndex >= (int) battleship[0] && aIndex <= (int) battleship[1]) && (n >= (int) battleship[2] && n <= (int) battleship[3])) {
                    battleshipLength2--;
                    allLength2--;
                } else if ((aIndex >= (int) submarine[0] && aIndex <= (int) submarine[1]) && (n >= (int) submarine[2] && n <= (int) submarine[3])) {
                    submarineLength2--;
                    allLength2--;
                } else if ((aIndex >= (int) cruiser[0] && aIndex <= (int) cruiser[1]) && (n >= (int) cruiser[2] && n <= (int) cruiser[3])) {
                    cruiserLength2--;
                    allLength2--;
                } else if ((aIndex >= (int) destroyer[0] && aIndex <= (int) destroyer[1]) && (n >= (int) destroyer[2] && n <= (int) destroyer[3])) {
                    destroyerLength2--;
                    allLength2--;
                }
            }
        } else {
            System.out.println("\nError! You entered the wrong coordinates! Try again:\n");
        }

        if (hit == 1 || hit == 3) {
            System.out.print("\nYou missed!");
        } else if (hit == 4) {
            System.out.print("\nYou hit a ship!");
        } else if (hit == 2) {
            if (allLength2 == 0) {
                System.out.print("\nYou sank the last ship. You won. Congratulations!");
                end = false;
            } else if (aircraftCarrierLength2 == 0) {
                System.out.print("\nYou sank a ship!");
                aircraftCarrierLength2--;
            } else if (battleshipLength2 == 0) {
                System.out.print("\nYou sank a ship!");
                battleshipLength2--;
            } else if (submarineLength2 == 0) {
                System.out.print("\nYou sank a ship!");
                submarineLength2--;
            } else if (cruiserLength2 == 0) {
                System.out.print("\nYou sank a ship!");
                cruiserLength2--;
            } else if (destroyerLength2 == 0) {
                System.out.print("\nYou sank a ship!");
                destroyerLength2--;
            } else {
                System.out.print("\nYou hit a ship!");
            }
        }
    }

    public static Object[] convertShootValue(String input) {
        char a = input.charAt(0);
        int n = 0;
        if (input.length() > 2) {
            n = (input.charAt(1) - '0') * 10 + input.charAt(2) - '0';
        } else {
            n = input.charAt(1) - '0';
        }

        return new Object[] {a, n};
    }

    public static int hit(int aIndex, int n) {
        int hit = 0;
        if (field2[aIndex][n] == "O") {
            field2[aIndex][n] = "X";
            foggyField2[aIndex][n] = "X";
            hit = 2;
        } else if (field2[aIndex][n] == "~") {
            field2[aIndex][n] = "M";
            foggyField2[aIndex][n] = "M";
            hit = 1;
        } else if (field2[aIndex][n] == "X") {
            hit = 4;
        } else if (field2[aIndex][n] == "M") {
            hit = 3;
        }

        return hit;
    }

}
