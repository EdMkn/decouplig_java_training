package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;
import java.util.Scanner;

public class HumanPlayer implements Player {

    private final Logger logger = LoggerFactory.getLogger2("player");

    @Override
    public long askNextGuess() {
        Scanner input = new Scanner(System.in);
        logger.log("J'entre un nombre: ");

        long nb = input.nextLong();
        return nb;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if(lowerOrGreater) logger.log("Le nombre doit être plus grand");
        else logger.log("Le nombre doit être plus petit");

    }


}
