import java.util.ArrayList;

public class Weerwolf extends Burger {


    public Weerwolf(String[] playerNames, int[] nrOfRoles, ArrayList<Object> gameState) {
        int counter = nrOfRoles[0] + nrOfRoles[1];
        this.name = playerNames[counter];
        this.alive = true;
        this.votes = 0;

        nrOfRoles[1] = nrOfRoles[1] - 1;

        if (nrOfRoles[0] == 0 && nrOfRoles[1] != 0) {
            gameState.add(new Weerwolf(playerNames, nrOfRoles, gameState));

        }
    }

    public void NightVote() {

    }


}
