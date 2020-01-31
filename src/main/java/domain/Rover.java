package domain;

public class Rover {

    private int x;
    private int y;
    private String d;

    public Rover(int x, int y, String d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }

    public int getX() { return this.x; }

    public int getY() {
        return this.y;
    }

    public String getD() {
        return this.d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }
}
