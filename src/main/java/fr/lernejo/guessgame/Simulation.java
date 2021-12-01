package fr.lernejo.guessgame;


import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;


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

        long nb = player.askNextGuess();
        if (nb == numberToGuess) return true;
        else {
            if (nb < numberToGuess) {
                player.respond(true);
                logger.log("Le nombre doit être plus grand");
            }
            else {
                player.respond(false);
                logger.log("Le nombre doit être plus petit");
            }
            return false;
        }
    }

    public void loopUntilPlayerSucceed(long max) {
        long limite = 0;
        long duree = System.currentTimeMillis();
        boolean stop = this.nextRound();
        while((!stop)&&(limite < max)) {
            stop = this.nextRound();
            limite++;
        }
        duree = System.currentTimeMillis() - duree;
        if(stop) System.out.println("Le joueur a trouvé la solution avant la limite d'interaction");
        else System.out.println("Le joueur n' a pas trouvé la solution avant d'atteindre la limite d'interaction");
        System.out.println("\nNombre de secondes: "+duree);

    }
}
