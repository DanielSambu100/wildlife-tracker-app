import org.sql2o.Connection;

import java.util.Objects;

public class Animal {
//    encapsulation starts here, private access modifiers
    private String animalName;
    private Integer animalId;
    private int id;
//constructor generated to instantiate the animal class
    public Animal(String animalName, Integer animalId) {
        this.animalName = animalName;
        this.animalId = animalId;
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
//    gathering id-assigned outputs
    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (animalName, animalId) VALUES (:animalName, :animalId)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.animalName)
                    .addParameter(String.valueOf(animalId), this.animalId)
                    .executeUpdate()
                    .getKey();
        }
    }
//    returning animals based on their ids
public static Animal find(int id) {
    try(Connection con = DB.sql2o.open()) {
        String sql = "SELECT * FROM animals where id=:id";
        Animal animal = con.createQuery(sql)
                .addParameter("id", id)
                .executeAndFetchFirst(Animal.class);
        return animal;
    }
}
}
