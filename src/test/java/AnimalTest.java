import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

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
}