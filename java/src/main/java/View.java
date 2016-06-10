/**
 * Generic View interface.
 */
interface View {

    void setDelegate(PresenterDelegate delegate);
    void showWelcome();
    void showSetupForNumPlayers(int numPlayers);

}
