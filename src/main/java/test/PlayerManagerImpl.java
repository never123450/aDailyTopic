package test;

import java.util.Map;
import java.util.concurrent.*;

public class PlayerManagerImpl implements PlayerManager {

    static Map<String, Player> players = new ConcurrentHashMap<String, Player>();

    @Override
    public synchronized void addPlayer(Player player) {
        players.put(player.getUsername(), player);
    }

    @Override
    public Player getPlayer(String username) {
        return (Player) players.get(username);
    }

    @Override
    public synchronized void broadcast(String message) {
        for (String key : players.keySet()) {
            Player player = players.get(key);
            if (player.isOffline()) {
                player.write(message);
            }
        }
    }

    public static void schedule() {
        System.out.println("sechedule");
        MyTask myTask = new MyTask();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(myTask, 0, 10, TimeUnit.SECONDS);
    }
}