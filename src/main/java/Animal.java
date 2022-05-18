import org.sql2o.Connection;

import java.util.List;
import java.util.Objects;

public class Animal {
//    encapsulation starts here, private access modifiers
    private String animalName;
    private Integer animalId;
//constructor generated to instantiate the animal class
    public Animal(String animalName, Integer animalId) {
        this.animalName = animalName;
        this.animalId = animalId;
    }
//accessors and mutators to the protected data types declared above.
    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public Integer getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Integer animalId) {
        this.animalId = animalId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(animalName, animal.animalName) && Objects.equals(animalId, animal.animalId);
    }
//overriding the default equals() method
    @Override
    public int hashCode() {
        return Objects.hash(animalName, animalId);
    }
    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (animalName, animalId) VALUES (:animalName, :animalId)";
            con.createQuery(sql)
                    .addParameter(String.valueOf(animalId), this.animalId)
                    .addParameter("animalName", this.animalName)
                    .executeUpdate();
        }
    }
//    implementing all() method to facilitate the execution of save() so that all db entries can be returned successfully
    public static List<Animal> all() {
        String sql = "SELECT * FROM animals";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Animal.class);
        }
    }
}
