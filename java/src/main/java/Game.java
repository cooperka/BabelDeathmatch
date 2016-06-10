import java.util.ArrayList;
import java.util.List;

/**
 * 'Game' model:
 * A single instance of a game of Deathmatch.
 */
class Game {

    public static final int NUM_PLAYERS = 2;

    private List<Player> mPlayers = new ArrayList<>();

    public void addPlayerWithUsername(String username) {
        mPlayers.add(new Player(username));
    }

    public List<String> getPlayerNames() {
        List<String> playerNames = new ArrayList<>(mPlayers.size());

        for (Player player : mPlayers) {
            playerNames.add(player.getUsername());
        }

        return playerNames;
    }

    public int getNumPlayers() {
        return mPlayers.size();
    }

}
