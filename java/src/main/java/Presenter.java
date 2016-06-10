/**
 * Mediates between the model and view
 * to present a game of BabelDeathmatch.
 */
class Presenter implements PresenterDelegate {

    private static final int NUM_PLAYERS = 2;

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

    private void showSetup() {
        for (int i = 0; i < NUM_PLAYERS; i++) {
            mView.showSetupForPlayerNumber(i + 1);
        }
    }

    // --- PresenterDelegate

    @Override
    public void onContinueToSetup() {
        showSetup();
    }

    @Override
    public void onAddPlayerWithUsername(String username) {
        mGame.addPlayerWithUsername(username);
    }

}
