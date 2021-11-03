package test;

public interface Player {
    String getUsername();

    void write(String message);

    boolean isOffline();

    void setOffline();
}