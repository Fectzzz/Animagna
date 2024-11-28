public class Creatures {

    @Override
    public String toString() {
        return name;
    }
    
    private String name;
    private Integer health;
    private Integer damage;
    private Integer level;
    private String type;

    public Creatures(String name, Integer health, Integer damage, Integer level, String type){
        this.name = name;
        this.health = health;
        this.level = level;
        this.type = type;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public void TakeDamage(Integer damage){
        this.health -= damage;
    }

    public void AddDamage(Integer damage){
        this.damage += damage;
    }

    public void AddHealth(Integer health){
        this.health += health;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

}
