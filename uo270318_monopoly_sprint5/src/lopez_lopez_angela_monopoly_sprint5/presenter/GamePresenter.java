package lopez_lopez_angela_monopoly_sprint5.presenter;

/**
 * Implementations of this interface print messages about the course of the
 * game.
 */
public interface GamePresenter {
    /**
     * Shows a "Welcome to Monopoly Game." message
     */
    void gameInitialized();

    /**
     * Shows a message with the current round number
     * 
     * @param round Current round
     */
    void nextRound(int round);

    /**
     * Shows the name of the player and the name of the square he is on
     * 
     * @param playerName
     * @param square
     * @return 
     */
    void nextPlayer(String playerName, String square);

    /**
     * Shows the added value of the two dice just rolled
     * 
     * @param value the addittion of the two dice [2..12]
     */
    void diceRolled(int value);

    /**
     * Shows the name of the next square the player is going to land on after
     * the dice has been rolled along with the buying and renting prices like
     * "playerName lands on squareName, POSITION = squarePosition, OWNER =
     * ownerName, BUYING PRICE = price, RENTING PRICE = rentingPrice"
     *
     * @param playerName
     * @param squareInfo
     */
    void nextSquare(String playerName, String squareInfo);

    /**
     * Shows a message like "Player <playerName> goes bankrupt"
     * 
     * @param playerName
     */
    void playerGameOver(String playerName);

    /**
     * Shows a message like "Player <playerName> buys <squareName>"
     * 
     * @param playerName
     * @param squareName
     */
    void playerBuys(String playerName, String squareName);

    /**
     * Shows a message like "End of game. And the winner is <winnerPlayerName>."
     * 
     * @param winnerPlayerName
     */
    void gameFinished(String winnerPlayerName);

    /**
     * Shows info about the player. "Player <playerName>: His net wealth is
     * <wealth>"
     * 
     * @param playerName Nombre del jugador
     * @param wealth Dinero
     */
    void playerStatus(String playerName, double wealth);
    
    /**
     * Metodo que muestra informacion sobre errores irrecuperables.
     * @param str Mensaje
     */
    void defaultHanlder(String str);
    
    /**
     * Metodo que muestra informacion sobre errores recuperables.
     * @param str Mensaje
     */
    void userHandler(String str);
    
}
