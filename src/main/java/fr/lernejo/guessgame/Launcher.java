package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args){
        boolean isNum;
        boolean taille;
        if (args.length >0) taille = true;
        else taille = false;

        if(taille) {
            try {
                long value = Long.parseLong(args[1]);
                isNum = true;
            } catch (NumberFormatException e) {
                isNum = false;
            }
            catch(ArrayIndexOutOfBoundsException e){
                isNum = false;
            }
            if (args[0].equals("-interactive")) {
                Player humanplayer = new HumanPlayer();
                Simulation simulation = new Simulation(humanplayer);
                simulation.initialize(new SecureRandom().nextInt(100));
                simulation.loopUntilPlayerSucceed(Long.MAX_VALUE);
            } else if (args[0].equals("-auto") && (isNum)) {
                Player computerplayer = new ComputerPlayer();
                Simulation simulation = new Simulation(computerplayer);
                simulation.initialize(Long.parseLong(args[1]));
                simulation.loopUntilPlayerSucceed(1000);
            }
        }
        else{
            Player humanplayer = new HumanPlayer();
            Simulation simulation = new Simulation(humanplayer);
            simulation.initialize(new SecureRandom().nextInt(100));
            simulation.loopUntilPlayerSucceed(Long.MAX_VALUE);

            Player computerplayer = new ComputerPlayer();
            simulation = new Simulation(computerplayer);
            simulation.initialize(Long.parseLong(args[1]));
            simulation.loopUntilPlayerSucceed(1000);
        }
    }
}
