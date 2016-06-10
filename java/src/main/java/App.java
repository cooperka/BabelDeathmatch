/**
 * Root entry point for BabelDeathmatch.
 */
public class App {

    public static void main(String[] args) {
        View view = new ConsoleView();
        Game game = new Game();

        Presenter presenter = new Presenter(view, game);
        presenter.present();
    }

}
