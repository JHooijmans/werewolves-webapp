package nl.sogyo.weerwolven.domain;

import java.util.ArrayList;
import java.util.Arrays;

public class Burger extends Role {

    public Burger(String[] playerNames, int[] nrOfRoles, ArrayList<Role> gameState) {
        int counter = nrOfRoles[0]+nrOfRoles[1];
        this.name = playerNames[counter-1];
        this.alive = true;
        this.votes = 0;

        nrOfRoles[0] = nrOfRoles[0]-1;

        if (nrOfRoles[0] == 0 && nrOfRoles[1] != 0) {
            gameState.add(new Weerwolf(playerNames, nrOfRoles, gameState));
        } else { gameState.add(new Burger(playerNames, nrOfRoles, gameState)); }
    }

}
