import java.util.Objects;

public class EndangeredAnimal {
    private String endangeredName;
    private  int animalId;
    private int endId;
    private int age;
    private String health;

    public EndangeredAnimal(String endangeredName, int animalId, int endId, int age, String health) {
        this.endangeredName = endangeredName;
        this.animalId = animalId;
        this.endId = endId;
        this.age = age;
        this.health = health;
    }

    public String getEndangeredName() {
        return endangeredName;
    }

    public void setEndangeredName(String endangeredName) {
        this.endangeredName = endangeredName;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public int getEndId() {
        return endId;
    }

    public void setEndId(int endId) {
        this.endId = endId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EndangeredAnimal that = (EndangeredAnimal) o;
        return animalId == that.animalId && endId == that.endId && age == that.age && Objects.equals(endangeredName, that.endangeredName) && Objects.equals(health, that.health);
    }

    @Override
    public int hashCode() {
        return Objects.hash(endangeredName, animalId, endId, age, health);
    }
}
