package test;

public class MyTask implements Runnable {
    @Override
    public void run() {
        for (String key : PlayerManagerImpl.players.keySet()) {
            Player player = PlayerManagerImpl.players.get(key);
            if (player.isOffline()) {
                player.setOffline();
                System.out.println(player.getUsername() + "下线");
            }
        }
    }
}