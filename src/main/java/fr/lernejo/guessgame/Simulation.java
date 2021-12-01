package fr.lernejo.guessgame;


import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private long numberToGuess;

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        Scanner input = new Scanner(System.in);
        System.out.println("Entrez un nombre: ");

        long nb = input.nextLong();
        if (nb == numberToGuess) return true;
        else {
            if (nb < numberToGuess) logger.log("Le nombre doit être plus grand");
            else logger.log("Le nombre doit être plus petit");
            return false;
        }
    }

    public void loopUntilPlayerSucceed() {
        boolean stop = this.nextRound();
        while(!stop) {
            stop = this.nextRound();
        }
    }
}
