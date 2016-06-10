import java.util.List;

/**
 * Generic View interface.
 */
interface View {

    void setDelegate(PresenterDelegate delegate);
    void setPlayerNames(List<String> playerNames);

    void showWelcome();
    void showSetupForPlayerNumber(int playerNumber);
    void showGameBegin();

}
