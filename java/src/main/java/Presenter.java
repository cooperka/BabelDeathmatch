/**
 * Mediates between the model and view
 * to present a game of BabelDeathmatch.
 */
class Presenter implements PresenterDelegate {

    private View mView;
    private Game mGame;

    Presenter(View view, Game game) {
        mView = view;
        mView.setDelegate(this);

        mGame = game;
    }

    void present() {
        mView.showWelcome();
    }

    private void setupPlayers() {
        for (int i = 0; i < Game.NUM_PLAYERS; i++) {
            mView.showSetupForPlayerNumber(i + 1);
        }
    }

    private void beginGame() {
        mView.setPlayerNames(mGame.getPlayerNames());
        mView.showGameBegin();
    }

    // --- PresenterDelegate

    @Override
    public void onContinueToSetup() {
        setupPlayers();
    }

    @Override
    public void onAddPlayerWithUsername(String username) {
        mGame.addPlayerWithUsername(username);

        if (mGame.getNumPlayers() == Game.NUM_PLAYERS) {
            beginGame();
        }
    }

}
