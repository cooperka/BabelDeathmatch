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
        System.out.println("Welcome to Deathmatch!");
        mDelegate.onContinueToSetup();
    }

    @Override
    public void showSetupForNumPlayers(int numPlayers) {
        for (int i = 0; i < numPlayers; i++) {
            System.out.println("Player " + (i + 1) + ", enter your username: ");
        }
    }

}
