package test;

public class PlayerImpl implements Player {

    private final String username;
    private String message;
    private volatile boolean isOffilne;

    public PlayerImpl(String username) {
        this.username = username;
        this.isOffilne = true;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public synchronized void write(String message) {
        this.message = message;
        System.out.println(this.username + "收到消息" + message);
    }

    @Override
    public boolean isOffline() {
        return isOffilne;
    }

    @Override
    public void setOffline() {
        this.isOffilne = false;
    }
}