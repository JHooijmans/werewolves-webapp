package nl.sogyo.weerwolven.domain;


import org.junit.*;
import nl.sogyo.weerwolven.domain.*;
import java.util.*;

public class WeerwolvenTest {

    private String[] playerNames;

    @Before
    public void setup() { playerNames = new String[] {"Abel", "Bob", "Cynthia", "Dirk", "Evelien", "Fanny"}; }

//    @After
//    public void tearDown() { playerNames = null;}

    @Test
    public void TestTheSetupNameList() {
        Assert.assertNotNull("The setup doesn't actually trigger, playerNames is empty!", playerNames);
    }

    @Test
    public void InitializationWorksWhenProvidedWithArrayOfPlayerNames() {
        Game game = new Game(playerNames);
        Assert.assertFalse("The arraylist of objects created is empty!",game.gameState.isEmpty());
    }

    @Test
    public void GameStateArrayListShouldContainSameNumberOfObjectsAsNumberOfNamesGiven() {
        Game game = new Game(playerNames);
        Assert.assertEquals("There are either more or less objects being created than players entered!", game.gameState.size(), playerNames.length);
    }

//    @Test
//    public void InputNamesAreAssignedToRoleObjects() {
//        Game game = new Game(playerNames);
//        playerNames.
//        for (int i=0; i<game.gameState.size(); i++) {
//            game.gameState.get(0).name
//
//        }
//    }
//
//    @Test
//    public void OrderOfNamesInputIsRandomized() {
//        Game game = new Game(playerNames);
//        game.gameState.get(0).name
//    }

}
