package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.security.SecureRandom;

public class ComputerPlayer implements Player{
    boolean low=false,high=false,first[]={true,true} ;

    private final Logger logger = LoggerFactory.getLogger2("computer");
    Long prevh,prevb,guess;
    @Override
    public long askNextGuess() {
        if(first[0]&&first[1]) {
            guess = new SecureRandom().nextLong(Long.MAX_VALUE);
        }
        else {
            do{
                if(!first[0] && first[1]) guess = new SecureRandom().nextLong(prevb)+prevb;
                else if(first[0] && !first[1]) guess = new SecureRandom().nextLong(prevh);
                else guess = new SecureRandom().nextLong(prevb, prevh);
            }while((low && guess<=prevb )||(high && guess>=prevh));
        }
        logger.log(" "+guess+" ");
        return guess;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if(lowerOrGreater) {
            logger.log("Le nombre doit être plus grand");
            if (first[0]) {
                this.prevb = this.guess;
                first[0] = false;

                low=true;
            }
            else if(this.guess > this.prevb) this.prevb = this.guess;

        }
        else {
            logger.log("Le nombre doit être plus petit");
            if(first[1]){
                this.prevh=this.guess;
                first[1] = false;
                high=true;
            }
            else if (this.guess < this.prevh) this.prevh=this.guess;
        }
    }
}
