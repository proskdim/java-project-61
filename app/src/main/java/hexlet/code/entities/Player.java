package hexlet.code.entities;

public class Player {
    private String name;
    private Boolean hasWon;

    public String getName() {
        return name;
    }

    public boolean hasWon() {
        return hasWon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWon(boolean result) {
        this.hasWon = result;
    }
}
