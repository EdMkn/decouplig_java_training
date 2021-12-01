package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;
import java.util.Scanner;

public class HumanPlayer implements Player {

    private final Logger logger = LoggerFactory.getLogger("player");

    @Override
    public long askNextGuess() {
        Scanner input = new Scanner(System.in);
        System.out.println("Entrez un nombre: ");

        long nb = input.nextLong();
        return nb;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if(lowerOrGreater) System.out.println("Le nombre doit être plus grand");
        else System.out.println("Le nombre doit être plus petit");

    }


}
