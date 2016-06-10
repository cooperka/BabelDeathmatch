/**
 * Generic View interface.
 */
interface View {

    void setDelegate(PresenterDelegate delegate);

    void showWelcome();
    void showSetupForPlayerNumber(int playerNumber);

}
