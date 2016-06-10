/**
 * Mediates between the model and view
 * to present a game of BabelDeathmatch.
 */
class Presenter {

    private View mView;
    private Game mGame;

    Presenter(View view, Game game) {
        mView = view;
        mGame = game;
    }

    void present() {
        mView.showWelcome();
    }

}
