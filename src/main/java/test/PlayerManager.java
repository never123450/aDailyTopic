package test;

public interface PlayerManager {
    void addPlayer(Player player);

    Player getPlayer(String username);

    void broadcast(String message);
}
