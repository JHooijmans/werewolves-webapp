package nl.sogyo.weerwolven.domain;

import java.util.*;
import java.util.ArrayList;



public class Game {

    protected ArrayList<Role> gameState = new ArrayList<Role>();

    public Game(String[] playerNames) {
        Random random = new Random();
        int nrOfPlayers = playerNames.length;

        //Fisher-Yates shuffle to randomize the playerNames order to avoid first name always being a Burger, for instance
        for (int i = nrOfPlayers-1; i > 0; i--) {
            int j = random.nextInt(i+1);

            String temp = playerNames[i];
            playerNames[i] = playerNames[j];
            playerNames[j] = temp;
        }

        //Setting the Weerwolf-Burger ratio, adding more Weerwolven if the playercount is above a certain level
        int[] nrOfRoles = new int[2];
        if (nrOfPlayers >= 5 && nrOfPlayers <= 8) {
            nrOfRoles[0] = nrOfPlayers-1;
            nrOfRoles[1] = 1;
        } else if (nrOfPlayers >= 9 && nrOfPlayers <= 12) {
            nrOfRoles[0] = nrOfPlayers-2;
            nrOfRoles[1] = 2;
        } else {
            nrOfRoles[0] = nrOfPlayers-3;
            nrOfRoles[1] = 3;
        }

        //Starting the constructor chain for all the player-objects (separated classes per role as they can do different things)
        gameState.add(new Burger(playerNames, nrOfRoles, gameState));

        //Shuffle to randomize the order of created roles to avoid the first object always being a Burger, for instance
        Collections.shuffle(gameState);

    }
}
