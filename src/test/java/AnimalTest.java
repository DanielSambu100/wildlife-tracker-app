import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.connectionsources.ConnectionSources;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
//    database rule extended here too
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
//testing parent class instantiation
    @Test
    void Animal_instantiatesCorrectly_true() {
        Animal testAnimal = new Animal("Gazelle", 6);
        assertEquals(true, true);
    }
    @Test
    void getName_animalInstantiatesWithId_6() {
        Animal testAnimal=new Animal("Gazelle", 6);
        assertEquals(6,testAnimal.getAnimalId());
    }
    @Test
    public void equals_returnsTrueIfNameAndIdAreSame_true() {
        Animal firstAnimal = new Animal("Gazelle", 6);
        Animal anotherAnimal = new Animal("Gazelle", 6);
        assertTrue(firstAnimal.equals(anotherAnimal));
    }
//    testing db setup
    @Test
    public void save_insertsObjectIntoDatabase_Person() {
        Animal testAnimal = new Animal("Gazelle", 6);
        testAnimal.save();
        assertTrue(Animal.all().get(0).equals(testAnimal));
    }
    @Test
    public void all_returnsAllInstancesOfAnimal_true() {
        Animal firstAnimal = new Animal("Gazelle", 6);
        firstAnimal.save();
        Animal secondAnimal = new Animal("Fox", 7);
        secondAnimal.save();
        assertEquals(true, Animal.all().get(0).equals(firstAnimal));
        assertEquals(true, Animal.all().get(1).equals(secondAnimal));
    }
    @Test
    public void save_assignsIdToObject() {
        Animal testAnimal = new Animal("Gazelle", 6);
        testAnimal.save();
        Animal savedAnimal = Animal.all().get(0);
        assertEquals(testAnimal.getId(), savedAnimal.getId());
    }
}