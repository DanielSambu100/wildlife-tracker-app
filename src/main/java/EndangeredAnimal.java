public class EndangeredAnimal {
    private String endangeredName;
    private int animalId;
//class instantiation
    public EndangeredAnimal(String endangeredName, int animalId) {
        this.endangeredName = endangeredName;
        this.animalId = animalId;
    }
//    getters and setters

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
}
