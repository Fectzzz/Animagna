public class Player {

    private String name;
    private Integer level;
    private Integer balls;

    public Player(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }


    public Integer getPrismoPod() {
        return balls;
    }

    public void setPrismoPod(Integer balls) {
        this.balls = balls;
    }

}
