import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EndangeredAnimalTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
//    db rule initiation
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void monster_instantiatesCorrectly_true() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Rhino", 1);
        assertEquals(true, testEndangeredAnimal instanceof EndangeredAnimal);
    }
}