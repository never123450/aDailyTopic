package test;

public class Test {
    public static void main(String[] args) {
        PlayerManagerImpl.schedule();
        new Thread(() -> {
            PlayerManager playerManager = new PlayerManagerImpl();
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Player player = new PlayerImpl("玩家" + i + "号");
                playerManager.addPlayer(player);
                player.write("发送消息");
                playerManager.broadcast("群发" + i);
            }
        }
        ).start();
    }
}