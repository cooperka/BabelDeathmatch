import java.util.ArrayList;
import java.util.List;

/**
 * 'Game' model:
 * A single instance of a game of Deathmatch.
 */
class Game {

    private List<Player> players = new ArrayList<>();

    public void addPlayerWithUsername(String username) {
        players.add(new Player(username));
    }

}
