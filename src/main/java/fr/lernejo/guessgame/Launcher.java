package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {
    public static void main(){
        Player humanplayer = new HumanPlayer();
        Simulation simulation = new Simulation(humanplayer);
        simulation.initialize(new SecureRandom().nextInt(100));
        simulation.loopUntilPlayerSucceed();
    }
}
