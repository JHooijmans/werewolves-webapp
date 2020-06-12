package nl.sogyo.weerwolven.domain;

public abstract class Role {

    protected String name;
    protected boolean alive;
    protected int votes;


    public void Vote() {}

    public String getName() {
        return name;
    }
}
