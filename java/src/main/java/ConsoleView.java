import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * View that displays things to the console.
 */
class ConsoleView implements View {

    private PresenterDelegate mDelegate;

    private List<String> mPlayerNames;

    @Override
    public void setDelegate(PresenterDelegate delegate) {
        mDelegate = delegate;
    }

    @Override
    public void showWelcome() {
        println("Welcome to Deathmatch!");
        println();
        mDelegate.onContinueToSetup();
    }

    @Override
    public void showSetupForPlayerNumber(int playerNumber) {
        String username = getStringGivenPrompt("Player " + playerNumber + ", enter your username: ");
        log("Name: " + username);

        mDelegate.onAddPlayerWithUsername(username);
    }

    @Override
    public void setPlayerNames(List<String> playerNames) {
        mPlayerNames = playerNames;
    }

    @Override
    public void showGameBegin() {
        println();
        println("It's " + getMatchupTextFromPlayerNames(mPlayerNames) + "!");
        println("Let the game begin.");
    }

    // --- Helpers

    private static void println() {
        println("");
    }

    private static void println(String output) {
        System.out.println(output);
    }

    private static void log(String output) {
        println(output);
    }

    private static String getStringGivenPrompt(String prompt) {
        System.out.println(prompt);

        // TODO: Use more robust way of reading input
        try {
            byte[] bytes = new byte[1];
            int bytesRead = System.in.read(bytes);
            if (bytesRead <= 0) {
                return null;
            }
            return String.valueOf(bytes[0]);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @return A string representing the matchup, e.g. "PlayerOne vs. PlayerTwo".
     */
    private static String getMatchupTextFromPlayerNames(List<String> playerNames) {
        if (playerNames == null || playerNames.size() == 0) {
            return "";
        }

        String matchupText = "";
        for (String playerName : playerNames) {
            if (!matchupText.isEmpty()) {
                matchupText += " vs. ";
            }

            matchupText += playerName;
        }

        return matchupText;
    }

}
