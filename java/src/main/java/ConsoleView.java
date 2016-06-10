import java.io.IOException;

/**
 * View that displays things to the console.
 */
class ConsoleView implements View {

    private PresenterDelegate mDelegate;

    @Override
    public void setDelegate(PresenterDelegate delegate) {
        mDelegate = delegate;
    }

    @Override
    public void showWelcome() {
        println("Welcome to Deathmatch!");
        mDelegate.onContinueToSetup();
    }

    @Override
    public void showSetupForPlayerNumber(int playerNumber) {
        String username = getStringGivenPrompt("Player " + playerNumber + ", enter your username: ");
        log("Name: " + username);

        mDelegate.onAddPlayerWithUsername(username);
    }

    // --- Helpers

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

}
