import java.util.ArrayList;

public class Burger {
    protected String name;
    protected boolean alive;
    protected int votes;

    public Burger() {}

    public Burger(String[] playerNames, int[] nrOfRoles, ArrayList<Object> gameState) {
        int counter = nrOfRoles[0]+nrOfRoles[1];
        this.name = playerNames[counter];
        this.alive = true;
        this.votes = 0;

        nrOfRoles[0] = nrOfRoles[0]-1;

        if (nrOfRoles[0] == 0 && nrOfRoles[1] != 0) {
            gameState.add(new Weerwolf(playerNames, nrOfRoles, gameState));
        } else { gameState.add(new Burger(playerNames, nrOfRoles, gameState)); }
    }


    public void Vote() {

    }

    private String getName() {
        return name;
    }

}
