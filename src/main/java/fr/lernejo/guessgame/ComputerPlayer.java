package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class ComputerPlayer implements Player{

    @Override
    public long askNextGuess() {
        return new SecureRandom().nextInt(100);
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if(lowerOrGreater) System.out.println("Le nombre doit être plus grand");
        else System.out.println("Le nombre doit être plus petit");
    }
}
