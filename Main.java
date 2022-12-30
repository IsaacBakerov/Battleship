package battleship;

import java.util.Scanner;
import java.util.Arrays;

import static battleship.Battlefield.*;
import static battleship.Battlefield2.*;
import static battleship.Shoot.*;
import static battleship.Shoot2.*;

public class Main {
    public static boolean end = true;

    public static void main(String[] args) {
        System.out.println("Player 1, place your ships on the game field");
        runBattlefield();
        pass();
        System.out.println("Player 2, place your ships to the game field");
        runBattlefield2();

        while (end) {
            pass();
            shoot();
            pass();
            shoot2();
        }

    }

    public static void pass() {
        System.out.print("\nPress Enter and pass the move to another player\n" +
                "...");
        String pass = sc.nextLine();
    }

}
