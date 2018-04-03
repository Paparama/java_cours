package lesson5.figting;

import javafx.scene.control.Alert;

import java.util.ArrayList;

public class Fight {
    static ArrayList<Solder> armyRed = new ArrayList<>();
    static ArrayList<Solder> armyWhite = new ArrayList<>();
    static int move = 0;

    public static void main(String[] args) {
        create();
        while (armyRed.size() != 0 && armyWhite.size() != 0) {
            fight();
        }
        getWinner();
    }

    public static void create() {
        for (int i = 0; i < 4; i++) {
            int hp = (int) (Math.random() * 50);
            int attack = (int) (Math.random() * 20);
            String name;
            if (i % 2 == 0) {
                name = "Red" + i;
                armyRed.add(new Red(hp, name, attack));
            } else {
                name = "White" + i;
                armyWhite.add(new White(hp, name, attack));
            }
        }
    }

    public static void fight() {
        Solder solderRed = Fight.getAliveSolider(armyRed);
        Solder solderWhite = Fight.getAliveSolider(armyWhite);
        if (solderRed == null || solderWhite == null ) {
            return;
        }
        if (move % 2 == 0) {
            solderRed.attack(solderWhite);
                }
                else {
            solderWhite.attack(solderRed);
        }
        move++;
            }

    public static Solder getAliveSolider(ArrayList<Solder> army) {
        Solder solder = null;
        while (army.size() != 0) {
            solder = army.get((int) (Math.random() * army.size()));
            if (solder.isAlive()) {
                return solder;
            } else {
                army.remove(solder);
            }

        }
        return null;
    }

    public static void getWinner() {
        if (armyRed.size() > 0) {
            System.out.println("Победила красная армия");
        } else if (armyWhite.size() > 0) {
            System.out.println("Победила белая армия");
        } else {
            System.out.println("Все умерли :(");
        }
    }

}



