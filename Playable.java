public interface Playable {
    void makeMove(int rollNum);
    void swapPlayers();
    int dice();
    int getPlayerNumber();
    int getPlayerPosition();
}
